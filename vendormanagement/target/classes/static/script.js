const apiUrl = "http://localhost:8080/api/vendors";
const vendorTable = document.querySelector("#vendorTable tbody");
const searchInput = document.getElementById("searchInput");

function fetchVendors() {
    fetch(apiUrl)
        .then(res => res.json())
        .then(data => displayVendors(data));
}

function displayVendors(vendors) {
    vendorTable.innerHTML = "";
    vendors.forEach(v => {
        const row = document.createElement("tr");
        row.innerHTML = `
      <td>${v.id}</td>
      <td>${v.name}</td>
      <td>${v.serviceType}</td>
      <td>${v.rate}</td>
      <td>
        <button class="action-btn" onclick="editVendor(${v.id})">Edit</button>
        <button class="action-btn action-delete" onclick="deleteVendor(${v.id})">Delete</button>
      </td>
    `;
        vendorTable.appendChild(row);
    });
}

document.getElementById("addForm").addEventListener("submit", function (e) {
    e.preventDefault();
    const vendor = {
        name: document.getElementById("name").value,
        serviceType: document.getElementById("serviceType").value,
        rate: parseFloat(document.getElementById("rate").value)
    };

    fetch(apiUrl, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(vendor)
    })
        .then(() => {
            fetchVendors();
            this.reset();
        });
});

function deleteVendor(id) {
    if (confirm("Delete this vendor?")) {
        fetch(`${apiUrl}/${id}`, { method: "DELETE" }).then(fetchVendors);
    }
}

function editVendor(id) {
    const name = prompt("Enter new name:");
    const serviceType = prompt("Enter new service type:");
    const rate = prompt("Enter new rate:");

    if (!name || !serviceType || !rate) return;

    const vendor = { name, serviceType, rate: parseFloat(rate) };

    fetch(`${apiUrl}/${id}`, {
        method: "PUT",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(vendor)
    }).then(fetchVendors);
}

searchInput.addEventListener("input", () => {
    const value = searchInput.value.toLowerCase();

    fetch(apiUrl)
        .then(res => res.json())
        .then(vendors => {
            const filtered = vendors.filter(v =>
                v.name.toLowerCase().includes(value) ||
                v.serviceType.toLowerCase().includes(value) ||
                v.id.toString() === value
            );
            displayVendors(filtered);
        });
});

fetchVendors();

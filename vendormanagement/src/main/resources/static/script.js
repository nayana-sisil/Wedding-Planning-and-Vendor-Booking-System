
function showAlert(message, success = true) {
    const alertBox = document.getElementById("alertBox");
    alertBox.textContent = message;
    alertBox.style.backgroundColor = success ? "#4CAF50" : "#f44336";
    alertBox.classList.remove("hidden");
    setTimeout(() => alertBox.classList.add("hidden"), 3000);
}

//

function closeModal() {
    document.getElementById("modal").classList.add("hidden");
}

//

function openModal(type) {
    const modal = document.getElementById("modal");
    const modalTitle = document.getElementById("modalTitle");
    const modalBody = document.getElementById("modalBody");
    modal.classList.remove("hidden");

    if (type === "edit") {
        modalTitle.textContent = "Edit Vendor";
        modalBody.innerHTML = `
            <input type="number" id="editId" placeholder="Vendor ID to Edit" required />
            <input type="text" id="editName" placeholder="New Name" />
            <select id="editType">
                <option value="">Select Service Type</option>
                <option value="Catering">Catering</option>
                <option value="Photography">Photography</option>
                <option value="Music">Music</option>
            </select>
            <input type="number" id="editRate" placeholder="New Rate" />
            <input type="text" id="editContact" placeholder="New Contact" />
            <input type="text" id="editDistrict" placeholder="District (Local)" />
            <input type="text" id="editCountry" placeholder="Country (External)" />
            <input type="number" id="editTravelCost" placeholder="Travel Cost (External)" />
            <button onclick="editVendor()">Update</button>
        `;
    } else if (type === "delete") {
        modalTitle.textContent = "Delete Vendor";
        modalBody.innerHTML = `
            <input type="number" id="deleteId" placeholder="Vendor ID to Delete" />
            <button onclick="deleteVendor()">Delete</button>
        `;
    } else if (type === "search") {
        modalTitle.textContent = "Search Vendor";
        modalBody.innerHTML = `
            <select id="searchField">
                <option value="id">ID</option>
                <option value="name">Name</option>
                <option value="serviceType">Service Type</option>
            </select>
            <input type="text" id="searchKeyword" placeholder="Enter search term" />
            <button onclick="searchVendor()">Search</button>
        `;
    }
}

//

function addVendor() {
    const type = document.getElementById("vendorType").value;
    if (!type) return showAlert("Please select Vendor Type", false);

    const id = parseInt(document.getElementById("id").value);
    const name = document.getElementById("name").value;
    const serviceType = document.getElementById("type").value;
    const price = parseFloat(document.getElementById("rate").value);
    const contact = document.getElementById("contact").value;
    const district = document.getElementById("district").value;
    const country = document.getElementById("country").value;
    const travelCost = parseFloat(document.getElementById("travelCost").value);

    if (id < 0 || !/^[a-zA-Z ]+$/.test(name) || ![2500, 5000, 7500, 10000].includes(price))
        return showAlert("Invalid vendor data", false);

    if (!/^\d{10}$/.test(contact) && !/^[^@\s]+@[^@\s]+\.[^@\s]+$/.test(contact))
        return showAlert("Invalid contact (must be phone or email)", false);

    let vendor = { id, name, serviceType, price, contact, vendorType: type };
    if (type === "local") {
        if (!district) return showAlert("District is required for Local Vendor", false);
        vendor.district = district;
    } else if (type === "external") {
        if (!country || isNaN(travelCost)) return showAlert("Country and Travel Cost required", false);
        vendor.country = country;
        vendor.travelCost = travelCost;
    }

    fetch("http://localhost:8080/api/vendors", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(vendor)
    })
    .then(res => res.text())
    .then(msg => {
        showAlert(msg, msg.includes("successfully"));
        document.getElementById("vendorForm").reset();
        listVendors();
    })
    .catch(() => showAlert("Error adding vendor", false));
}

//

function editVendor() {
    const id = parseInt(document.getElementById("editId").value);
    const name = document.getElementById("editName").value;
    const serviceType = document.getElementById("editType").value;
    const price = parseFloat(document.getElementById("editRate").value);
    const contact = document.getElementById("editContact").value;
    const district = document.getElementById("editDistrict").value;
    const country = document.getElementById("editCountry").value;
    const travelCost = parseFloat(document.getElementById("editTravelCost").value);

    if (isNaN(id) || id < 0 || !name || !/^[a-zA-Z ]+$/.test(name)) return showAlert("Invalid input", false);

    let vendor = { id, name, serviceType, price, contact };
    if (district) vendor.district = district;
    if (country) vendor.country = country;
    if (!isNaN(travelCost)) vendor.travelCost = travelCost;

    fetch("http://localhost:8080/api/vendors/" + id, {
        method: "PUT",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(vendor)
    })
    .then(res => res.text())
    .then(msg => {
        showAlert(msg, msg.includes("successfully"));
        closeModal();
        listVendors();
    })
    .catch(() => showAlert("Error editing vendor", false));
}

//

function deleteVendor() {
    const id = parseInt(document.getElementById("deleteId").value);
    if (isNaN(id)) return showAlert("Invalid ID", false);

    fetch("http://localhost:8080/api/vendors/" + id, { method: "DELETE" })
    .then(res => res.text())
    .then(msg => {
        showAlert(msg, msg.includes("successfully"));
        closeModal();
        listVendors();
    })
    .catch(() => showAlert("Error deleting vendor", false));
}

//

function searchVendor() {
    const field = document.getElementById("searchField").value;
    const keyword = document.getElementById("searchKeyword").value.trim().toLowerCase();

    fetch("http://localhost:8080/api/vendors")
        .then(res => res.json())
        .then(vendors => {
            let results = [];
            if (field === "id") results = vendors.filter(v => v.id.toString() === keyword);
            else if (field === "name") results = vendors.filter(v => v.name.toLowerCase().includes(keyword));
            else if (field === "serviceType") results = vendors.filter(v => v.serviceType.toLowerCase().includes(keyword));
            displayVendors(results);
            closeModal();
        })
        .catch(() => showAlert("Search failed", false));
}

//

function listVendors() {
    fetch("http://localhost:8080/api/vendors")
        .then(res => res.json())
        .then(data => displayVendors(data))
        .catch(() => showAlert("Failed to load vendors", false));
}

//

function displayVendors(vendors) {
    const list = document.getElementById("vendorList");
    list.innerHTML = "";

    if (!vendors || vendors.length === 0) {
        list.innerHTML = "<p>No vendors found.</p>";
        return;
    }

    vendors.forEach(v => {
        const card = document.createElement("div");
        let html = `
            <strong>ID:</strong> ${v.id}<br>
            <strong>Name:</strong> ${v.name}<br>
            <strong>Service:</strong> ${v.serviceType}<br>
            <strong>Price:</strong> Rs. ${v.price}<br>
            <strong>Contact:</strong> ${v.contact}
        `;
        if (v.district) html += `<br><strong>District:</strong> ${v.district}`;
        if (v.country) html += `<br><strong>Country:</strong> ${v.country}`;
        if (v.travelCost) html += `<br><strong>Travel Cost:</strong> Rs. ${v.travelCost}`;
        card.innerHTML = html + "<hr>";
        card.style.padding = "10px";
        card.style.marginBottom = "10px";
        card.style.background = "rgba(255,255,255,0.1)";
        card.style.borderRadius = "10px";
        card.style.color = "#fff";
        list.appendChild(card);
    });
}

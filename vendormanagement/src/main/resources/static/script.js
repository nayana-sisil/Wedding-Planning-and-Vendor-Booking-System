function showAlert(message, success = true) {
    const alertBox = document.getElementById('alertBox');
    alertBox.textContent = message;
    alertBox.style.background = success ? '#4CAF50' : '#ff4d4d';
    alertBox.classList.remove('hidden');
    setTimeout(() => {
        alertBox.classList.add('hidden');
    }, 3000);
}

//

function closeModal() {
    document.getElementById('modal').classList.add('hidden');
    document.getElementById('modalBody').innerHTML = '';
}

//

function openModal(action) {
    const modal = document.getElementById('modal');
    const modalTitle = document.getElementById('modalTitle');
    const modalBody = document.getElementById('modalBody');
    modal.classList.remove('hidden');

    if (action === 'edit') {
        modalTitle.innerText = 'Edit Vendor';
        modalBody.innerHTML = `
            <input type="number" id="editId" placeholder="Vendor ID" required />
            <input type="text" id="editName" placeholder="New Name" />
            <input type="text" id="editContact" placeholder="New Contact Info" />
            <input type="number" id="editRate" placeholder="New Rate (Rs)" min="5000" />
            <button onclick="submitEdit()">Save Changes</button>
        `;
    } else if (action === 'delete') {
        modalTitle.innerText = 'Delete Vendor';
        modalBody.innerHTML = `
            <input type="number" id="deleteId" placeholder="Vendor ID to delete" />
            <button onclick="submitDelete()">Delete</button>
        `;
    } else if (action === 'search') {
        modalTitle.innerText = 'Search Vendor';
        modalBody.innerHTML = `
            <select id="searchBy">
                <option value="id">Search by ID</option>
                <option value="name">Search by Name</option>
                <option value="type">Search by Type</option>
            </select>
            <input type="text" id="searchValue" placeholder="Enter search value" />
            <button onclick="submitSearch()">Search</button>
            <div id="searchResult"></div>
        `;
    }
}

//

function addVendor() {
    const id = document.getElementById("id").value.trim();
    const name = document.getElementById("name").value.trim();
    const type = document.getElementById("type").value;
    const rate = parseFloat(document.getElementById("rate").value);
    const contact = document.getElementById("contact").value.trim();

    if (!id || !name || !type || !rate || !contact || rate < 5000) {
        showAlert("Please fill all fields correctly (Rate min Rs.5000)", false);
        return;
    }

    fetch("http://localhost:8080/vendors")
        .then(res => res.json())
        .then(data => {
            const exists = data.some(v => v.id == id);
            if (exists) {
                showAlert("Vendor already exists!", false);
            } else {
                fetch("http://localhost:8080/vendors", {
                    method: "POST",
                    headers: { "Content-Type": "application/json" },
                    body: JSON.stringify({ id, name, type, rate, contact })
                }).then(res => {
                    if (res.ok) {
                        showAlert("Vendor successfully added!");
                        document.getElementById("vendorForm").reset();
                    } else {
                        showAlert("Failed to add vendor", false);
                    }
                });
            }
        });
}

//

function submitEdit() {
    const id = document.getElementById("editId").value.trim();
    const name = document.getElementById("editName").value.trim();
    const rate = document.getElementById("editRate").value.trim();
    const contact = document.getElementById("editContact").value.trim();

    fetch(`http://localhost:8080/vendors/${id}`)
        .then(res => {
            if (!res.ok) throw new Error("Vendor not found");
            return res.json();
        })
        .then(vendor => {
            vendor.name = name || vendor.name;
            vendor.rate = rate ? parseFloat(rate) : vendor.rate;
            vendor.contact = contact || vendor.contact;

            if (vendor.rate < 5000) {
                showAlert("Rate must be Rs.5000 or more", false);
                return;
            }

            return fetch("http://localhost:8080/vendors", {
                method: "PUT",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify(vendor)
            });
        })
        .then(response => {
            if (response.ok) {
                showAlert("Vendor updated!");
                closeModal();
            } else {
                showAlert("Update failed", false);
            }
        })
        .catch(() => showAlert("Vendor not found", false));
}

//

function submitDelete() {
    const id = document.getElementById("deleteId").value.trim();
    fetch(`http://localhost:8080/vendors/${id}`, { method: "DELETE" })
        .then(res => {
            if (res.ok) {
                showAlert("Vendor deleted!");
                closeModal();
            } else {
                showAlert("Vendor not found", false);
            }
        });
}

//

function submitSearch() {
    const searchBy = document.getElementById("searchBy").value;
    const searchValue = document.getElementById("searchValue").value.trim().toLowerCase();

    if (!searchValue) {
        showAlert("Enter a value to search!", false);
        return;
    }

    fetch("http://localhost:8080/vendors")
        .then(res => res.json())
        .then(data => {
            let results = [];

            if (searchBy === "id") {
                results = data.filter(v => v.id.toString() === searchValue);
            } else if (searchBy === "name") {
                results = data.filter(v => v.name.toLowerCase().includes(searchValue));
            } else if (searchBy === "type") {
                results = data.filter(v => v.type.toLowerCase().includes(searchValue));
            }

            const resultDiv = document.getElementById("searchResult");
            if (results.length > 0) {
                resultDiv.innerHTML = results.map(v => `
                    <p><strong>ID:</strong> ${v.id} | <strong>Name:</strong> ${v.name} | <strong>Contact:</strong> ${v.contact} | <strong>Rate:</strong> Rs.${v.rate} | <strong>Type:</strong> ${v.type}</p>
                `).join('');
            } else {
                resultDiv.innerHTML = `<p>No matching vendor found.</p>`;
            }
        });
}

//

function listVendors() {
    fetch("http://localhost:8080/vendors")
        .then(res => res.json())
        .then(data => {
            const listDiv = document.getElementById("vendorList");
            listDiv.innerHTML = "<h3>Vendor List</h3>";
            data.forEach(v => {
                listDiv.innerHTML += `<p>🧾 ${v.id} - ${v.name} - ${v.contact} - Rs.${v.rate} - ${v.type}</p>`;
            });
        });
}


// ✅ Utility Functions
function showAlert(message, success = true) {
    const alertBox = document.getElementById("alertBox");
    alertBox.textContent = message;
    alertBox.style.backgroundColor = success ? "#4CAF50" : "#f44336";
    alertBox.classList.remove("hidden");
    setTimeout(() => alertBox.classList.add("hidden"), 3000);
}

function openModal(type) {
    const modal = document.getElementById("modal");
    const modalTitle = document.getElementById("modalTitle");
    const modalBody = document.getElementById("modalBody");
    modal.classList.remove("hidden");

    modalBody.innerHTML = "";

    if (type === "edit") {
        modalTitle.textContent = "Edit Vendor";
        modalBody.innerHTML = `
            <input type="number" id="editId" placeholder="Vendor ID to Edit (positive only)" min="0" required />
            <input type="text" id="editName" placeholder="New Name (letters only)" required />
            <select id="editType" required>
                <option value="">Select Service Type</option>
                <option value="Catering">Catering</option>
                <option value="Photography">Photography</option>
                <option value="Music">Music</option>
            </select>
            <input type="number" id="editRate" placeholder="New Rate (2500, 5000...)" min="2500" step="2500" required />
            <input type="text" id="editContact" placeholder="New Contact (phone or email)" required />
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
            <input type="text" id="searchKeyword" placeholder="Enter value to search" />
            <button onclick="searchVendor()">Search</button>
        `;
    }
}

function closeModal() {
    document.getElementById("modal").classList.add("hidden");
}

// ✅ Validations
function validateVendor(vendor) {
    if (isNaN(vendor.id) || vendor.id < 0) return "Vendor ID must be a positive number";
    if (!/^[a-zA-Z ]+$/.test(vendor.name)) return "Name must be letters only";
    if (![2500, 5000, 7500, 10000].includes(vendor.price)) return "Rate must be 2500, 5000, 7500, or 10000";
    if (!/^\d{10}$/.test(vendor.contact) && !/^[^@\s]+@[^@\s]+\.[^@\s]+$/.test(vendor.contact))
        return "Contact must be valid phone or email";
    return null;
}

// ✅ Add Vendor
function addVendor() {
    const vendor = {
        id: parseInt(document.getElementById("id").value),
        name: document.getElementById("name").value,
        serviceType: document.getElementById("type").value,
        price: parseFloat(document.getElementById("rate").value),
        contact: document.getElementById("contact").value
    };

    const error = validateVendor(vendor);
    if (error) return showAlert(error, false);

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
        .catch(err => showAlert("Error adding vendor", false));
}

// ✅ Edit Vendor
function editVendor() {
    const vendor = {
        id: parseInt(document.getElementById("editId").value),
        name: document.getElementById("editName").value,
        serviceType: document.getElementById("editType").value,
        price: parseFloat(document.getElementById("editRate").value),
        contact: document.getElementById("editContact").value
    };

    const error = validateVendor(vendor);
    if (error) return showAlert(error, false);

    fetch("http://localhost:8080/api/vendors/" + vendor.id, {
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
        .catch(err => showAlert("Error editing vendor", false));
}

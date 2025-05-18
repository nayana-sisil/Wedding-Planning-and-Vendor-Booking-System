const API_URL = "http://localhost:8080/bookings";

const bookingForm = document.getElementById("bookingForm");
const submitButton = document.getElementById("submitButton");
const cancelEdit = document.getElementById("cancelEdit");
const bookingIdField = document.getElementById("bookingId");
const vendorId = document.getElementById("vendorId");
const weddingId = document.getElementById("weddingId");
const bookingDate = document.getElementById("bookingDate");
const serviceDate = document.getElementById("serviceDate");
const cost = document.getElementById("cost");
const status = document.getElementById("status");
const notes = document.getElementById("notes");
const bookingsTable = document.getElementById("bookingsTable");
const searchButton = document.getElementById("searchButton");
const vendorSearch = document.getElementById("vendorSearch");

let editingId = null;

function clearForm() {
  bookingIdField.value = "";
  vendorId.value = "";
  weddingId.value = "";
  bookingDate.value = "";
  serviceDate.value = "";
  cost.value = "";
  status.value = "Pending";
  notes.value = "";
  editingId = null;
  cancelEdit.classList.add("hidden");
  submitButton.innerText = "Save Booking";
}

// Load all bookings
function loadBookings() {
  axios.get(API_URL)
    .then(response => {
      renderTable(response.data);
    })
    .catch(error => console.error("Error loading bookings:", error));
}

// Render table
function renderTable(bookings) {
  bookingsTable.innerHTML = "";

  if (!bookings || bookings.length === 0) {
    bookingsTable.innerHTML = "<tr><td colspan='9'>No bookings found.</td></tr>";
    return;
  }

  bookings.forEach(booking => {
    const row = document.createElement("tr");
    row.innerHTML = `
      <td>${booking.id}</td>
      <td>${booking.vendorId}</td>
      <td>${booking.weddingId}</td>
      <td>${booking.bookingDate}</td>
      <td>${booking.serviceDate}</td>
      <td>${booking.cost}</td>
      <td>${booking.status}</td>
      <td>${booking.notes}</td>
      <td>
        <button class="action-btn" onclick="editBooking(${booking.id})">Edit</button>
        <button class="action-btn" onclick="deleteBooking(${booking.id})">Delete</button>
      </td>
    `;
    bookingsTable.appendChild(row);
  });
}

// Save booking (Create or Update)
bookingForm.addEventListener("submit", function (e) {
  e.preventDefault();

  const bookingData = {
    vendorId: vendorId.value,
    weddingId: weddingId.value,
    bookingDate: bookingDate.value,
    serviceDate: serviceDate.value,
    cost: cost.value,
    status: status.value,
    notes: notes.value
  };

  if (editingId) {
    axios.put(`${API_URL}/${editingId}`, bookingData)
      .then(() => {
        clearForm();
        loadBookings();
      })
      .catch(error => console.error("Update failed:", error));
  } else {
    axios.post(API_URL, bookingData)
      .then(() => {
        clearForm();
        loadBookings();
      })
      .catch(error => console.error("Add failed:", error));
  }
});

// Edit booking
window.editBooking = function (id) {
  axios.get(`${API_URL}/${id}`)
    .then(response => {
      const booking = response.data;
      bookingIdField.value = booking.id;
      vendorId.value = booking.vendorId;
      weddingId.value = booking.weddingId;
      bookingDate.value = booking.bookingDate;
      serviceDate.value = booking.serviceDate;
      cost.value = booking.cost;
      status.value = booking.status;
      notes.value = booking.notes;
      editingId = booking.id;
      cancelEdit.classList.remove("hidden");
      submitButton.innerText = "Update Booking";
    })
    .catch(error => console.error("Edit fetch failed:", error));
};

// Delete booking
window.deleteBooking = function (id) {
  if (confirm("Are you sure you want to delete this booking?")) {
    axios.delete(`${API_URL}/${id}`)
      .then(() => loadBookings())
      .catch(error => console.error("Delete failed:", error));
  }
};

// Search bookings by vendor ID
searchButton.addEventListener("click", () => {
  const vendorIdValue = vendorSearch.value;
  if (vendorIdValue === "") {
    loadBookings();
    return;
  }

  axios.get(`${API_URL}/vendor/${vendorIdValue}`)
    .then(response => {
      renderTable(response.data);
    })
    .catch(error => {
      console.error("Search failed:", error);
      bookingsTable.innerHTML = "<tr><td colspan='9'>No bookings found.</td></tr>";
    });
});

// Cancel edit
cancelEdit.addEventListener("click", () => {
  clearForm();
});

// Load on start
loadBookings();

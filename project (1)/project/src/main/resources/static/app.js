const API_URL = 'http://localhost:8080/bookings'; // Adjust to your backend URL

// Load all bookings on page load
document.addEventListener('DOMContentLoaded', loadBookings);

// Form submission for creating/updating bookings
document.getElementById('bookingForm').addEventListener('submit', async (e) => {
    e.preventDefault();
    const id = document.getElementById('bookingId').value;
    const booking = {
        vendorId: parseInt(document.getElementById('vendorId').value),
        weddingId: parseInt(document.getElementById('weddingId').value),
        bookingDate: document.getElementById('bookingDate').value,
        serviceDate: document.getElementById('serviceDate').value,
        cost: parseFloat(document.getElementById('cost').value),
        status: document.getElementById('status').value,
        notes: document.getElementById('notes').value
    };

    try {
        if (id) {
            // Update existing booking
            await axios.put(`${API_URL}/${id}`, booking);
            alert('Booking updated successfully');
        } else {
            // Create new booking
            await axios.post(API_URL, booking);
            alert('Booking created successfully');
        }
        resetForm();
        loadBookings();
    } catch (error) {
        console.error('Error saving booking:', error);
        alert('Error saving booking');
    }
});

// Search by vendor ID
document.getElementById('searchButton').addEventListener('click', async () => {
    const vendorId = document.getElementById('vendorSearch').value;
    if (vendorId) {
        loadBookingsByVendor(vendorId);
    } else {
        loadBookings();
    }
});

// Cancel edit
document.getElementById('cancelEdit').addEventListener('click', resetForm);

// Load all bookings
async function loadBookings() {
    try {
        const response = await axios.get(API_URL);
        displayBookings(response.data);
    } catch (error) {
        console.error('Error fetching bookings:', error);
        alert('Error fetching bookings');
    }
}

// Load bookings by vendor ID
async function loadBookingsByVendor(vendorId) {
    try {
        const response = await axios.get(`${API_URL}/vendor/${vendorId}`);
        displayBookings(response.data);
    } catch (error) {
        console.error('Error fetching bookings for vendor:', error);
        alert('No bookings found for this vendor');
    }
}

// Display bookings in table
function displayBookings(bookings) {
    const tableBody = document.getElementById('bookingsTable');
    tableBody.innerHTML = '';
    bookings.forEach(booking => {
        const row = document.createElement('tr');
        row.innerHTML = `
            <td>${booking.id}</td>
            <td>${booking.vendorId}</td>
            <td>${booking.weddingId}</td>
            <td>${booking.bookingDate}</td>
            <td>${booking.serviceDate}</td>
            <td>$${booking.cost.toFixed(2)}</td>
            <td>${booking.status}</td>
            <td>${booking.notes || ''}</td>
            <td>
                <button onclick="editBooking(${booking.id})" class="bg-yellow-500 text-white px-2 py-1 rounded hover:bg-yellow-600">Edit</button>
                <button onclick="deleteBooking(${booking.id})" class="bg-red-500 text-white px-2 py-1 rounded hover:bg-red-600">Delete</button>
            </td>
        `;
        tableBody.appendChild(row);
    });
}

// Edit booking
async function editBooking(id) {
    try {
        const response = await axios.get(`${API_URL}/${id}`);
        const booking = response.data;
        document.getElementById('bookingId').value = booking.id;
        document.getElementById('vendorId').value = booking.vendorId;
        document.getElementById('weddingId').value = booking.weddingId;
        document.getElementById('bookingDate').value = booking.bookingDate;
        document.getElementById('serviceDate').value = booking.serviceDate;
        document.getElementById('cost').value = booking.cost;
        document.getElementById('status').value = booking.status;
        document.getElementById('notes').value = booking.notes || '';
        document.getElementById('submitButton').textContent = 'Update Booking';
        document.getElement | undefined.getElementById('cancelEdit').classList.remove('hidden');
        window.scrollTo({ top: 0, behavior: 'smooth' });
    } catch (error) {
        console.error('Error fetching booking:', error);
        alert('Error fetching booking');
    }
}

// Delete booking
async function deleteBooking(id) {
    if (confirm('Are you sure you want to delete this booking?')) {
        try {
            await axios.delete(`${API_URL}/${id}`);
            alert('Booking deleted successfully');
            loadBookings();
        } catch (error) {
            console.error('Error deleting booking:', error);
            alert('Error deleting booking');
        }
    }
}

// Reset form
function resetForm() {
    document.getElementById('bookingForm').reset();
    document.getElementById('bookingId').value = '';
    document.getElementById('submitButton').textContent = 'Save Booking';
    document.getElementById('cancelEdit').classList.add('hidden');
}
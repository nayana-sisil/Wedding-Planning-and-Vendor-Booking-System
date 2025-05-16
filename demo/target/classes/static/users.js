const apiService = require('./api.js');

async function loadUsersTable() {
    try {
        const users = await apiService.getUsers();
        console.log('Fetched users:', users);
        const tableBody = document.querySelector('#usersTable tbody');
        if (!tableBody) {
            console.error('Table body not found');
            return;
        }

        if (users.length === 0) {
            tableBody.innerHTML = '<tr><td colspan="5">No users registered</td></tr>';
        } else {
            tableBody.innerHTML = users.map(user => `
                <tr>
                    <td>${user.id}</td>
                    <td>${user.username}</td>
                    <td>${user.email}</td>
                    <td>${user.role}</td>
                    <td>
                        <button class="btn edit-btn" onclick="editUser('${user.id}')">Edit</button>
                        <button class="btn delete-btn" onclick="deleteUser('${user.id}')">Delete</button>
                    </td>
                </tr>
            `).join('');
        }
    } catch (error) {
        console.error('Error loading users:', error);
        alert(`Failed to load users: ${error.message}`);
    }
}

async function editUser(userId) {
    try {
        const user = await apiService.getUserById(userId);
        const newUsername = prompt('Enter new username:', user.username);
        const newEmail = prompt('Enter new email:', user.email);
        const newPassword = prompt('Enter new password (leave blank to keep current):', '');
        const updatedUser = { ...user, username: newUsername, email: newEmail, password: newPassword || user.password };

        await apiService.updateUser(userId, updatedUser);
        alert('User updated successfully!');
        loadUsersTable();
    } catch (error) {
        alert(`Failed to update user: ${error.message}`);
    }
}

async function deleteUser(userId) {
    if (confirm('Are you sure you want to delete this user?')) {
        try {
            await apiService.deleteUser(userId);
            alert('User deleted successfully!');
            loadUsersTable();
        } catch (error) {
            alert(`Failed to delete user: ${error.message}`);
        }
    }
}

window.loadUsersTable = loadUsersTable;
window.editUser = editUser;
window.deleteUser = deleteUser;

// Load users when page loads
window.onload = loadUsersTable;
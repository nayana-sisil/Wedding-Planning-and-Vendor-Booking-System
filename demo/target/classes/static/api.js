const BASE_URL = 'http://localhost:8080/api/users';

async function registerUser(userData) {
    try {
        const response = await fetch(`${BASE_URL}/register`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(userData),
        });
        if (!response.ok) throw new Error(`HTTP error! Status: ${response.status}`);
        return await response.json();
    } catch (error) {
        console.error('Register error:', error);
        throw error;
    }
}

async function getUsers() {
    try {
        const response = await fetch(`${BASE_URL}`, {
            method: 'GET',
            headers: { 'Content-Type': 'application/json' },
        });
        if (!response.ok) throw new Error(`HTTP error! Status: ${response.status}`);
        return await response.json();
    } catch (error) {
        console.error('Get users error:', error);
        throw error;
    }
}

async function getUserById(userId) {
    try {
        const response = await fetch(`${BASE_URL}/${userId}`, {
            method: 'GET',
            headers: { 'Content-Type': 'application/json' },
        });
        if (!response.ok) throw new Error(`HTTP error! Status: ${response.status}`);
        return await response.json();
    } catch (error) {
        console.error('Get user by ID error:', error);
        throw error;
    }
}

async function updateUser(userId, userData) {
    try {
        const response = await fetch(`${BASE_URL}/${userId}`, {
            method: 'PUT',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(userData),
        });
        if (!response.ok) throw new Error(`HTTP error! Status: ${response.status}`);
        return await response.json();
    } catch (error) {
        console.error('Update user error:', error);
        throw error;
    }
}

async function deleteUser(userId) {
    try {
        const response = await fetch(`${BASE_URL}/${userId}`, {
            method: 'DELETE',
            headers: { 'Content-Type': 'application/json' },
        });
        if (!response.ok) throw new Error(`HTTP error! Status: ${response.status}`);
        return await response.json();
    } catch (error) {
        console.error('Delete user error:', error);
        throw error;
    }
}

module.exports = { registerUser, getUsers, getUserById, updateUser, deleteUser };
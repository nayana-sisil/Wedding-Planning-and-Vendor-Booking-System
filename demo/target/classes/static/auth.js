const apiService = require('./api.js');

document.addEventListener('DOMContentLoaded', () => {
    const registerForm = document.getElementById('registerForm');
    if (!registerForm) {
        console.error('Register form not found');
        return;
    }

    const userTypeSelect = document.getElementById('userType');
    userTypeSelect.addEventListener('change', (e) => {
        const isClient = e.target.value === 'client';
        document.getElementById('clientFields').style.display = isClient ? 'block' : 'none';
        document.getElementById('adminFields').style.display = isClient ? 'none' : 'block';
    });

    registerForm.addEventListener('submit', async (e) => {
        e.preventDefault();

        const userType = document.getElementById('userType').value;
        const userData = {
            username: document.getElementById('username').value,
            email: document.getElementById('email').value,
            password: document.getElementById('password').value,
            role: userType === 'client' ? 'clients' : 'admins'
        };

        if (userType === 'client') {
            userData.weddingDate = document.getElementById('weddingDate').value;
            userData.partnerName = document.getElementById('partnerName').value;
        } else {
            userData.adminLevel = document.getElementById('adminLevel').value;
        }

        try {
            const response = await apiService.registerUser(userData);
            console.log('Registration response:', response);
            if (response && response.id) {
                alert('Registration successful! Updating user list...');
                registerForm.reset(); // Clear form fields
                loadUsersTable(); // Refresh user table
            } else {
                throw new Error('Registration failed: No user ID returned');
            }
        } catch (error) {
            console.error('Registration error:', error);
            alert(`Registration failed: ${error.message || 'Server error'}`);
        }
    });
});
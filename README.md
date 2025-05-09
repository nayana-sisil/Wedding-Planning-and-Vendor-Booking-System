
:root {
  --primary-color: #6a1b9a;
  --primary-light: #9c4dcc;
  --primary-dark: #38006b;
  --secondary-color: #ffab00;
  --error-color: #d32f2f;
  --success-color: #388e3c;
  --text-color: #333;
  --light-gray: #f5f5f5;
  --medium-gray: #e0e0e0;
  --dark-gray: #757575;
  --white: #ffffff;
  --shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
  --border-radius: 8px;
}

* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
}

body {
  background-color: var(--light-gray);
  color: var(--text-color);
  line-height: 1.6;
}


.admin-container {
  display: grid;
  grid-template-columns: 250px 1fr;
  grid-template-rows: 70px 1fr;
  grid-template-areas:
    "header header"
    "sidebar content";
  min-height: 100vh;
}


.admin-header {
  grid-area: header;
  background-color: var(--primary-color);
  color: var(--white);
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 0 2rem;
  box-shadow: var(--shadow);
  z-index: 10;
}

.admin-header h1 {
  font-size: 1.5rem;
  font-weight: 500;
}

.admin-profile {
  display: flex;
  align-items: center;
  gap: 1rem;
}

#logout-btn {
  background-color: var(--primary-light);
  color: var(--white);
  border: none;
  padding: 0.5rem 1rem;
  border-radius: var(--border-radius);
  cursor: pointer;
  transition: background-color 0.3s;
}

#logout-btn:hover {
  background-color: var(--primary-dark);
}


.admin-sidebar {
  grid-area: sidebar;
  background-color: var(--white);
  box-shadow: var(--shadow);
  padding: 1.5rem 0;
}

.admin-sidebar ul {
  list-style: none;
}

.admin-sidebar li {
  margin-bottom: 0.5rem;
}

.admin-sidebar a {
  display: block;
  padding: 0.75rem 1.5rem;
  color: var(--text-color);
  text-decoration: none;
  transition: all 0.3s;
}

.admin-sidebar a:hover,
.admin-sidebar li.active a {
  background-color: var(--primary-light);
  color: var(--white);
}


.admin-content {
  grid-area: content;
  padding: 2rem;
  overflow-y: auto;
}

.content-section {
  display: none;
}

.content-section.active {
  display: block;
}

.section-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 1.5rem;
}


.stats-grid {
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(200px, 1fr));
  gap: 1.5rem;
  margin-top: 1rem;
}

.stat-card {
  background-color: var(--white);
  padding: 1.5rem;
  border-radius: var(--border-radius);
  box-shadow: var(--shadow);
  text-align: center;
}

.stat-card h3 {
  color: var(--dark-gray);
  font-size: 1rem;
  margin-bottom: 0.5rem;
}

.stat-card p {
  font-size: 2rem;
  font-weight: 600;
  color: var(--primary-color);
}


.admin-table-container {
  background-color: var(--white);
  border-radius: var(--border-radius);
  box-shadow: var(--shadow);
  overflow: hidden;
}

#admins-table {
  width: 100%;
  border-collapse: collapse;
}

#admins-table th,
#admins-table td {
  padding: 1rem;
  text-align: left;
  border-bottom: 1px solid var(--medium-gray);
}

#admins-table th {
  background-color: var(--primary-color);
  color: var(--white);
  font-weight: 500;
}

#admins-table tr:hover {
  background-color: var(--light-gray);
}


.btn {
  padding: 0.5rem 1rem;
  border-radius: var(--border-radius);
  border: none;
  cursor: pointer;
  font-size: 0.9rem;
  transition: all 0.3s;
}

.btn-primary {
  background-color: var(--primary-color);
  color: var(--white);
}

.btn-primary:hover {
  background-color: var(--primary-dark);
}

.btn-secondary {
  background-color: var(--medium-gray);
  color: var(--text-color);
}

.btn-secondary:hover {
  background-color: var(--dark-gray);
  color: var(--white);
}

.btn-danger {
  background-color: var(--error-color);
  color: var(--white);
}

.btn-danger:hover {
  background-color: #b71c1c;
}


.modal {
  display: none;
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.5);
  z-index: 100;
  justify-content: center;
  align-items: center;
}

.modal-content {
  background-color: var(--white);
  padding: 2rem;
  border-radius: var(--border-radius);
  width: 100%;
  max-width: 500px;
  position: relative;
}

.close-modal {
  position: absolute;
  top: 1rem;
  right: 1rem;
  font-size: 1.5rem;
  cursor: pointer;
}


.form-group {
  margin-bottom: 1rem;
}

.form-group label {
  display: block;
  margin-bottom: 0.5rem;
  font-weight: 500;
}

.form-group input,
.form-group select {
  width: 100%;
  padding: 0.75rem;
  border: 1px solid var(--medium-gray);
  border-radius: var(--border-radius);
}

.form-group input:focus,
.form-group select:focus {
  outline: none;
  border-color: var(--primary-color);
}


.logs-container {
  background-color: var(--white);
  border-radius: var(--border-radius);
  box-shadow: var(--shadow);
  padding: 1.5rem;
}

.log-filters {
  display: flex;
  gap: 1rem;
  margin-bottom: 1.5rem;
}

.log-filters select,
.log-filters input {
  padding: 0.5rem;
  border: 1px solid var(--medium-gray);
  border-radius: var(--border-radius);
}

.logs-list {
  max-height: 500px;
  overflow-y: auto;
}

.log-item {
  padding: 1rem;
  border-bottom: 1px solid var(--medium-gray);
}

.log-item:last-child {
  border-bottom: none;
}

.log-item .log-meta {
  display: flex;
  justify-content: space-between;
  color: var(--dark-gray);
  font-size: 0.9rem;
  margin-bottom: 0.5rem;
}


.status-badge {
  display: inline-block;
  padding: 0.25rem 0.5rem;
  border-radius: 1rem;
  font-size: 0.8rem;
  font-weight: 500;
}

.status-active {
  background-color: #e8f5e9;
  color: var(--success-color);
}

.status-inactive {
  background-color: #ffebee;
  color: var(--error-color);
}


@media (max-width: 768px) {
  .admin-container {
    grid-template-columns: 1fr;
    grid-template-areas:
      "header"
      "content";
  }

  .admin-sidebar {
    display: none;
  }

  .stats-grid {
    grid-template-columns: 1fr;
  }
}



document.addEventListener('DOMContentLoaded', function() {
   
    const sidebarLinks = document.querySelectorAll('.admin-sidebar a');
    const contentSections = document.querySelectorAll('.content-section');
    const logoutBtn = document.getElementById('logout-btn');
    const addAdminBtn = document.getElementById('add-admin-btn');
    const adminModal = document.getElementById('admin-modal');
    const closeModal = document.querySelector('.close-modal');
    const adminForm = document.getElementById('admin-form');
    const applyFiltersBtn = document.getElementById('apply-filters');

    
    let currentAdmin = null;
    let admins = [];
    let activityLogs = [];

    initDashboard();

   
    sidebarLinks.forEach(link => {
        link.addEventListener('click', function(e) {
            e.preventDefault();
            showSection(this.dataset.section);
        });
    });

    logoutBtn.addEventListener('click', logout);
    addAdminBtn.addEventListener('click', showAddAdminForm);
    closeModal.addEventListener('click', closeAdminModal);
    adminForm.addEventListener('submit', handleAdminSubmit);
    applyFiltersBtn.addEventListener('click', applyLogFilters);

   
    adminModal.addEventListener('click', function(e) {
        if (e.target === adminModal) {
            closeAdminModal();
        }
    });

    
    function initDashboard() {
        
        fetchAdmins();
        fetchActivityLogs();
        showSection('dashboard');

       
        currentAdmin = {
            id: 'admin1',
            username: 'SuperAdmin',
            email: 'admin@weddingplanner.com',
            isSuperAdmin: true
        };
        updateUI();
    }

    function fetchAdmins() {
        
        fetch('/api/admins')
            .then(response => response.json())
            .then(data => {
                admins = data;
                renderAdminsTable();
                updateStats();
            })
            .catch(error => {
                console.error('Error fetching admins:', error);
                showError('Failed to load admin data');
            });
    }

    function fetchActivityLogs() {
       
        fetch('/api/admins/logs')
            .then(response => response.json())
            .then(data => {
                activityLogs = data;
                renderActivityLogs();
                populateAdminFilter();
            })
            .catch(error => {
                console.error('Error fetching logs:', error);
                showError('Failed to load activity logs');
            });
    }

    function renderAdminsTable() {
        const tableBody = document.querySelector('#admins-table tbody');
        tableBody.innerHTML = '';

        admins.forEach(admin => {
            const row = document.createElement('tr');

            row.innerHTML = `
                <td>${admin.adminId.substring(0, 8)}...</td>
                <td>${admin.username}</td>
                <td>${admin.email}</td>
                <td>${admin.permissions.join(', ')}</td>
                <td><span class="status-badge ${admin.isActive ? 'status-active' : 'status-inactive'}">
                    ${admin.isActive ? 'Active' : 'Inactive'}
                </span></td>
                <td>
                    <button class="btn btn-secondary edit-admin" data-id="${admin.adminId}">Edit</button>
                    ${currentAdmin.isSuperAdmin ? `<button class="btn btn-danger delete-admin" data-id="${admin.adminId}">Delete</button>` : ''}
                </td>
            `;

            tableBody.appendChild(row);
        });

      
        document.querySelectorAll('.edit-admin').forEach(btn => {
            btn.addEventListener('click', () => showEditAdminForm(btn.dataset.id));
        });

        document.querySelectorAll('.delete-admin').forEach(btn => {
            btn.addEventListener('click', () => confirmDeleteAdmin(btn.dataset.id));
        });
    }

    function renderActivityLogs(filteredLogs = activityLogs) {
        const logsContainer = document.querySelector('.logs-list');
        logsContainer.innerHTML = '';

        if (filteredLogs.length === 0) {
            logsContainer.innerHTML = '<p class="no-logs">No activity logs found</p>';
            return;
        }

        filteredLogs.forEach(log => {
            const logItem = document.createElement('div');
            logItem.className = 'log-item';

            logItem.innerHTML = `
                <div class="log-meta">
                    <span>${new Date(log.timestamp).toLocaleString()}</span>
                    <span>Admin: ${log.adminId}</span>
                </div>
                <p>${log.action}</p>
            `;

            logsContainer.appendChild(logItem);
        });
    }

    function populateAdminFilter() {
        const filterSelect = document.getElementById('log-filter-admin');

       
        while (filterSelect.options.length > 1) {
            filterSelect.remove(1);
        }

       
        const adminIds = [...new Set(activityLogs.map(log => log.adminId))];

        adminIds.forEach(id => {
            const option = document.createElement('option');
            option.value = id;
            option.textContent = id.substring(0, 8) + '...';
            filterSelect.appendChild(option);
        });
    }

    function applyLogFilters() {
        const adminId = document.getElementById('log-filter-admin').value;
        const date = document.getElementById('log-filter-date').value;

        let filteredLogs = [...activityLogs];

        if (adminId) {
            filteredLogs = filteredLogs.filter(log => log.adminId === adminId);
        }

        if (date) {
            const selectedDate = new Date(date);
            filteredLogs = filteredLogs.filter(log => {
                const logDate = new Date(log.timestamp);
                return logDate.toDateString() === selectedDate.toDateString();
            });
        }

        renderActivityLogs(filteredLogs);
    }

    function showSection(sectionId) {
       
        sidebarLinks.forEach(link => {
            link.parentElement.classList.remove('active');
            if (link.dataset.section === sectionId) {
                link.parentElement.classList.add('active');
            }
        });

       
        contentSections.forEach(section => {
            section.classList.remove('active');
            if (section.id === `${sectionId}-section`) {
                section.classList.add('active');
            }
        });
    }

    function showAddAdminForm() {
        document.getElementById('modal-title').textContent = 'Add New Admin';
        document.getElementById('admin-id').value = '';
        adminForm.reset();
        adminModal.style.display = 'flex';
    }

    function showEditAdminForm(adminId) {
        const admin = admins.find(a => a.adminId === adminId);
        if (!admin) return;

        document.getElementById('modal-title').textContent = 'Edit Admin';
        document.getElementById('admin-id').value = admin.adminId;
        document.getElementById('username').value = admin.username;
        document.getElementById('email').value = admin.email;
        

        adminModal.style.display = 'flex';
    }

    function closeAdminModal() {
        adminModal.style.display = 'none';
    }

    function handleAdminSubmit(e) {
        e.preventDefault();

        const adminData = {
            adminId: document.getElementById('admin-id').value,
            username: document.getElementById('username').value,
            email: document.getElementById('email').value,
           
        };

        const isNewAdmin = !adminData.adminId;
        const url = isNewAdmin ? '/api/admins' : `/api/admins/${adminData.adminId}`;
        const method = isNewAdmin ? 'POST' : 'PUT';

        fetch(url, {
            method: method,
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(adminData)
        })
        .then(response => {
            if (!response.ok) throw new Error('Network response was not ok');
            return response.json();
        })
        .then(data => {
            closeAdminModal();
            fetchAdmins();
            showSuccess(isNewAdmin ? 'Admin created successfully' : 'Admin updated successfully');
        })
        .catch(error => {
            console.error('Error:', error);
            showError('Failed to save admin');
        });
    }

    function confirmDeleteAdmin(adminId) {
        if (!confirm('Are you sure you want to delete this admin?')) return;

        fetch(`/api/admins/${adminId}`, {
            method: 'DELETE'
        })
        .then(response => {
            if (!response.ok) throw new Error('Network response was not ok');
            fetchAdmins();
            showSuccess('Admin deleted successfully');
        })
        .catch(error => {
            console.error('Error:', error);
            showError('Failed to delete admin');
        });
    }

    function updateStats() {
        document.getElementById('total-admins').textContent = admins.length;
       
    }

    function updateUI() {
        if (currentAdmin) {
            document.getElementById('current-admin').textContent = `Welcome, ${currentAdmin.username}`;

           
            if (!currentAdmin.isSuperAdmin) {
                addAdminBtn.style.display = 'none';
            }
        }
    }

    function logout() {
       
        fetch('/api/auth/logout', { method: 'POST' })
            .then(() => {
                window.location.href = '/login.html';
            })
            .catch(error => {
                console.error('Logout failed:', error);
                window.location.href = '/login.html';
            });
    }

    function showSuccess(message) {
        
        alert(message);
    }

    function showError(message) {
       
        alert(`Error: ${message}`);
    }
});

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Wedding Planner - Admin Management</title>
    <link rel="stylesheet" href="/css/admin.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
</head>
<body>
<div class="admin-container">
    <!-- Header Section -->
    <header class="admin-header">
        <h1><i class="fas fa-user-shield"></i> Admin Dashboard</h1>
        <div class="admin-profile">
            <span id="current-admin">Loading...</span>
            <button id="logout-btn"><i class="fas fa-sign-out-alt"></i> Logout</button>
        </div>
    </header>

    <!-- Sidebar Navigation -->
    <nav class="admin-sidebar">
        <ul>
            <li class="active"><a href="#" data-section="dashboard"><i class="fas fa-tachometer-alt"></i> Dashboard</a></li>
            <li><a href="#" data-section="admins"><i class="fas fa-users-cog"></i> Manage Admins</a></li>
            <li><a href="#" data-section="logs"><i class="fas fa-clipboard-list"></i> Activity Logs</a></li>
            <li><a href="#" data-section="settings"><i class="fas fa-cog"></i> Settings</a></li>
        </ul>
    </nav>

    <!-- Main Content Area -->
    <main class="admin-content">
        <!-- Dashboard Section -->
        <section id="dashboard-section" class="content-section active">
            <h2><i class="fas fa-chart-pie"></i> System Overview</h2>
            <div class="stats-grid">
                <div class="stat-card">
                    <h3>Total Admins</h3>
                    <p id="total-admins">0</p>
                </div>
                <div class="stat-card">
                    <h3>Active Sessions</h3>
                    <p id="active-sessions">0</p>
                </div>
                <div class="stat-card">
                    <h3>Today's Activities</h3>
                    <p id="today-activities">0</p>
                </div>
                <div class="stat-card">
                    <h3>System Status</h3>
                    <p id="system-status">Online</p>
                </div>
            </div>

            <div class="quick-actions">
                <h3>Quick Actions</h3>
                <div class="action-buttons">
                    <button class="btn-primary" id="quick-add-admin"><i class="fas fa-user-plus"></i> Add Admin</button>
                    <button class="btn-secondary" id="quick-view-logs"><i class="fas fa-history"></i> View Logs</button>
                    <button class="btn-secondary" id="quick-backup"><i class="fas fa-database"></i> Backup Data</button>
                </div>
            </div>
        </section>

        <!-- Admin Management Section -->
        <section id="admins-section" class="content-section">
            <div class="section-header">
                <h2><i class="fas fa-users-cog"></i> Admin Management</h2>
                <button id="add-admin-btn" class="btn-primary"><i class="fas fa-user-plus"></i> Add Admin</button>
            </div>

            <div class="admin-controls">
                <div class="search-box">
                    <input type="text" id="admin-search" placeholder="Search admins...">
                    <button class="btn-secondary"><i class="fas fa-search"></i></button>
                </div>
                <div class="filter-options">
                    <select id="admin-status-filter">
                        <option value="all">All Statuses</option>
                        <option value="active">Active</option>
                        <option value="inactive">Inactive</option>
                    </select>
                </div>
            </div>

            <div class="admin-table-container">
                <table id="admins-table">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Username</th>
                        <th>Email</th>
                        <th>Permissions</th>
                        <th>Status</th>
                        <th>Last Active</th>
                        <th>Actions</th>
                    </tr>
                    </thead>
                    <tbody>
                    <!-- Data loaded dynamically -->
                    <tr class="loading-row">
                        <td colspan="7">Loading admin data...</td>
                    </tr>
                    </tbody>
                </table>
                <div class="table-pagination">
                    <button class="btn-secondary" disabled><i class="fas fa-chevron-left"></i></button>
                    <span>Page 1 of 1</span>
                    <button class="btn-secondary" disabled><i class="fas fa-chevron-right"></i></button>
                </div>
            </div>
        </section>

        <!-- Activity Logs Section -->
        <section id="logs-section" class="content-section">
            <div class="section-header">
                <h2><i class="fas fa-clipboard-list"></i> Activity Logs</h2>
            </div>

            <div class="logs-container">
                <div class="log-filters">
                    <div class="filter-group">
                        <label for="log-filter-admin">Filter by Admin:</label>
                        <select id="log-filter-admin">
                            <option value="">All Admins</option>
                        </select>
                    </div>
                    <div class="filter-group">
                        <label for="log-filter-date">Filter by Date:</label>
                        <input type="date" id="log-filter-date">
                    </div>
                    <div class="filter-group">
                        <label for="log-filter-action">Filter by Action:</label>
                        <select id="log-filter-action">
                            <option value="">All Actions</option>
                            <option value="create">Create</option>
                            <option value="update">Update</option>
                            <option value="delete">Delete</option>
                            <option value="login">Login</option>
                        </select>
                    </div>
                    <button id="apply-filters" class="btn-primary">Apply Filters</button>
                    <button id="reset-filters" class="btn-secondary">Reset</button>
                </div>

                <div class="logs-list">
                    <!-- Data loaded dynamically -->
                    <div class="loading-logs">
                        <i class="fas fa-spinner fa-spin"></i> Loading activity logs...
                    </div>
                </div>

                <div class="logs-pagination">
                    <button class="btn-secondary" disabled><i class="fas fa-chevron-left"></i></button>
                    <span>Page 1 of 1</span>
                    <button class="btn-secondary" disabled><i class="fas fa-chevron-right"></i></button>
                </div>
            </div>
        </section>

        <!-- Settings Section -->
        <section id="settings-section" class="content-section">
            <h2><i class="fas fa-cog"></i> System Settings</h2>
            <div class="settings-grid">
                <div class="settings-card">
                    <h3><i class="fas fa-user-lock"></i> Security Settings</h3>
                    <div class="setting-item">
                        <label>Password Policy:</label>
                        <select id="password-policy">
                            <option value="simple">Simple (6+ characters)</option>
                            <option value="medium">Medium (8+ with mix)</option>
                            <option value="complex">Complex (12+ with special chars)</option>
                        </select>
                    </div>
                    <div class="setting-item">
                        <label>Session Timeout:</label>
                        <select id="session-timeout">
                            <option value="15">15 minutes</option>
                            <option value="30">30 minutes</option>
                            <option value="60" selected>1 hour</option>
                            <option value="120">2 hours</option>
                        </select>
                    </div>
                    <button class="btn-primary">Save Security Settings</button>
                </div>

                <div class="settings-card">
                    <h3><i class="fas fa-bell"></i> Notification Settings</h3>
                    <div class="setting-item">
                        <label>
                            <input type="checkbox" id="email-notifications" checked>
                            Email Notifications
                        </label>
                    </div>
                    <div class="setting-item">
                        <label>
                            <input type="checkbox" id="activity-alerts" checked>
                            Activity Alerts
                        </label>
                    </div>
                    <div class="setting-item">
                        <label>
                            <input type="checkbox" id="error-reports">
                            Error Reports
                        </label>
                    </div>
                    <button class="btn-primary">Save Notification Settings</button>
                </div>
            </div>
        </section>
    </main>
</div>

<!-- Admin Modal -->
<div id="admin-modal" class="modal">
    <div class="modal-content">
        <span class="close-modal">&times;</span>
        <h2 id="modal-title"><i class="fas fa-user-plus"></i> Add New Admin</h2>

        <form id="admin-form">
            <input type="hidden" id="admin-id">

            <div class="form-group">
                <label for="username"><i class="fas fa-user"></i> Username</label>
                <input type="text" id="username" required placeholder="Enter username">
            </div>

            <div class="form-group">
                <label for="email"><i class="fas fa-envelope"></i> Email</label>
                <input type="email" id="email" required placeholder="Enter email">
            </div>

            <div class="form-group">
                <label for="password"><i class="fas fa-key"></i> Password</label>
                <input type="password" id="password" required placeholder="Enter password">
                <div class="password-strength">
                    <span class="strength-bar"></span>
                    <span class="strength-text">Weak</span>
                </div>
            </div>

            <div class="form-group">
                <label for="confirm-password"><i class="fas fa-key"></i> Confirm Password</label>
                <input type="password" id="confirm-password" required placeholder="Confirm password">
            </div>

            <div class="form-group">
                <label><i class="fas fa-shield-alt"></i> Permissions</label>
                <div class="permissions-grid">
                    <label><input type="checkbox" name="permissions" value="manage_users"> Manage Users</label>
                    <label><input type="checkbox" name="permissions" value="manage_content"> Manage Content</label>
                    <label><input type="checkbox" name="permissions" value="view_reports"> View Reports</label>
                    <label><input type="checkbox" name="permissions" value="system_settings"> System Settings</label>
                </div>
            </div>

            <div class="form-group">
                <label for="admin-status"><i class="fas fa-power-off"></i> Status</label>
                <select id="admin-status">
                    <option value="active">Active</option>
                    <option value="inactive">Inactive</option>
                </select>
            </div>

            <div class="form-actions">
                <button type="button" class="btn-secondary" id="cancel-admin">Cancel</button>
                <button type="submit" class="btn-primary">Save Admin</button>
            </div>
        </form>
    </div>
</div>

<!-- Confirmation Modal -->
<div id="confirm-modal" class="modal">
    <div class="modal-content confirm-modal">
        <h2 id="confirm-title"><i class="fas fa-exclamation-triangle"></i> Confirm Action</h2>
        <p id="confirm-message">Are you sure you want to perform this action?</p>
        <div class="confirm-actions">
            <button class="btn-secondary" id="confirm-cancel">Cancel</button>
            <button class="btn-danger" id="confirm-proceed">Proceed</button>
        </div>
    </div>
</div>

<!-- Loading Overlay -->
<div id="loading-overlay">
    <div class="loading-content">
        <i class="fas fa-spinner fa-spin"></i>
        <p>Processing your request...</p>
    </div>
</div>

<!-- Scripts -->
<script src="/js/admin.js"></script>
<script>
    // Font Awesome loading fallback
    if(typeof FontAwesome === 'undefined') {
        document.write('<script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/js/all.min.js"><\/script>');
    }
</script>
</body>
</html>

async function loadUsersTable() {
    const users = JSON.parse(localStorage.getItem("users")) || [];

    const tableBody = document.querySelector("#usersTable tbody");
    if (!tableBody) return;

    tableBody.innerHTML = "";

    users.forEach(user => {
        const row = document.createElement("tr");

        row.innerHTML = `
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td>${user.email}</td>
            <td>${user.role}</td>
            <td><a href="UserDetails.html?id=${user.id}" class="btn">Details</a></td>
            <td>
                <button class="btn edit-btn" onclick="editUser(${user.id})">Edit</button>
                <button class="btn delete-btn" onclick="deleteUser(${user.id})">Delete</button>
            </td>
        `;
        tableBody.appendChild(row);
    });
}

function editUser(id) {
    window.location.href = `UserDetails.html?id=${id}&edit=true`;
}

function deleteUser(id) {
    let users = JSON.parse(localStorage.getItem("users")) || [];
    if (confirm("Are you sure you want to delete this user?")) {
        users = users.filter(user => user.id !== id);
        localStorage.setItem("users", JSON.stringify(users));
        alert("User deleted.");
        location.reload();
    }
}

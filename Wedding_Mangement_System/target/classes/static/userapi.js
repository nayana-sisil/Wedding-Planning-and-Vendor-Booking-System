// Dummy for future API integration. Can simulate delay or extend logic later.

function getAllUsers() {
  return JSON.parse(localStorage.getItem("users")) || [];
}

function getUserById(id) {
  const users = getAllUsers();
  return users.find(user => user.id === id);
}

function saveUser(user) {
  const users = getAllUsers();
  const index = users.findIndex(u => u.id === user.id);
  if (index !== -1) {
    users[index] = user;
  } else {
    users.push(user);
  }
  localStorage.setItem("users", JSON.stringify(users));
}

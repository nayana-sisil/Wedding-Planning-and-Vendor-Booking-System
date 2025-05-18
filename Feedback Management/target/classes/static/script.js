const baseUrl = "/api/feedback";
const form = document.getElementById("feedbackForm");
const feedbackIdField = document.getElementById("feedbackId");
const submitButton = document.getElementById("submitButton");

form.addEventListener("submit", async function (e) {
  e.preventDefault();

  const feedback = {
    clientId: parseInt(document.getElementById("clientId").value),
    vendorId: parseInt(document.getElementById("vendorId").value),
    rating: parseInt(document.getElementById("rating").value),
    comment: document.getElementById("comment").value,
    reviewDate: document.getElementById("reviewDate").value
  };

  const id = feedbackIdField.value;

  if (id) {
    // UPDATE
    const res = await fetch(`${baseUrl}/${id}`, {
      method: "PUT",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(feedback)
    });

    if (res.ok) {
      alert("Feedback updated!");
      resetForm();
      loadFeedback();
    } else {
      alert("Update failed.");
    }
  } else {
    // CREATE
    const res = await fetch(baseUrl, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(feedback)
    });

    if (res.ok) {
      alert("Feedback added!");
      resetForm();
      loadFeedback();
    } else {
      alert("Creation failed.");
    }
  }
});

function resetForm() {
  form.reset();
  feedbackIdField.value = "";
  submitButton.textContent = "Add Feedback";
}

async function loadFeedback() {
  const res = await fetch(baseUrl);
  const feedbackList = await res.json();
  const container = document.getElementById("feedbackList");

  container.innerHTML = "";

  feedbackList.forEach(fb => {
    const div = document.createElement("div");
    div.className = "feedback-item";
    div.innerHTML = `
      <p><strong>ID:</strong> ${fb.id}</p>
      <p><strong>Client:</strong> ${fb.clientId}</p>
      <p><strong>Vendor:</strong> ${fb.vendorId}</p>
      <p><strong>Rating:</strong> ${fb.rating}</p>
      <p><strong>Comment:</strong> ${fb.comment}</p>
      <p><strong>Date:</strong> ${fb.reviewDate}</p>
      <div class="actions">
        <button onclick="editFeedback(${fb.id})">Edit</button>
        <button class="delete" onclick="deleteFeedback(${fb.id})">Delete</button>
      </div>
    `;
    container.appendChild(div);
  });
}

async function deleteFeedback(id) {
  const res = await fetch(`${baseUrl}/${id}`, {
    method: "DELETE"
  });

  if (res.ok) {
    alert("Feedback deleted.");
    loadFeedback();
  } else {
    alert("Failed to delete.");
  }
}

async function editFeedback(id) {
  const res = await fetch(`${baseUrl}/${id}`);
  if (!res.ok) {
    alert("Feedback not found");
    return;
  }

  const fb = await res.json();

  document.getElementById("feedbackId").value = fb.id;
  document.getElementById("clientId").value = fb.clientId;
  document.getElementById("vendorId").value = fb.vendorId;
  document.getElementById("rating").value = fb.rating;
  document.getElementById("comment").value = fb.comment;
  document.getElementById("reviewDate").value = fb.reviewDate;
  submitButton.textContent = "Update Feedback";
}

// Load feedback on page load
loadFeedback();

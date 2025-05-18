document.addEventListener("DOMContentLoaded", () => {
    const form = document.getElementById("supportForm");
    const list = document.getElementById("supportList");

    async function loadSupportMessages() {
        const res = await fetch("http://localhost:8080/support");
        const data = await res.json();

        list.innerHTML = "";
        data.forEach(req => {
            const item = document.createElement("div");
            item.className = "support-item";
            item.innerHTML = `
                <strong>${req.customerName}</strong>
                <em>${req.type}</em>
                <p>${req.message}</p>
            `;
            list.appendChild(item);
        });
    }

    form.addEventListener("submit", async (e) => {
        e.preventDefault();
        const name = document.getElementById("customerName").value.trim();
        const type = document.getElementById("type").value;
        const message = document.getElementById("message").value.trim();

        if (!name || !type || !message) {
            alert("All fields are required.");
            return;
        }

        await fetch("http://localhost:8080/support", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({
                customerName: name,  // ✅ match Java field
                type,
                message
            })
        });

        form.reset();
        loadSupportMessages(); // Refresh list
    });

    loadSupportMessages();
});

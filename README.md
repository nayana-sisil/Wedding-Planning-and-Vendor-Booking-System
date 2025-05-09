{
    --primary-color: #ff6b6b;
    --secondary-color: #ff8e8e;
    --dark-color: #333;
    --light-color: #f8f9fa;
    --gray-color: #6c757d;
    --success-color: #28a745;
}

* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
}

body {
    background-color: #f5f5f5;
    color: var(--dark-color);
    line-height: 1.6;
}

.container {
    max-width: 1200px;
    margin: 0 auto;
    padding: 0 20px;
}

.hidden {
    display: none !important;
}


header {
    background-color: white;
    box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
    padding: 20px 0;
    position: sticky;
    top: 0;
    z-index: 100;
}

header h1 {
    color: var(--primary-color);
    display: inline-block;
    font-size: 24px;
}

header h1 i {
    margin-right: 10px;
}

nav {
    display: inline-block;
    float: right;
}

nav ul {
    list-style: none;
}

nav ul li {
    display: inline-block;
    margin-left: 20px;
}

nav ul li a {
    text-decoration: none;
    color: var(--dark-color);
    font-weight: 500;
    transition: color 0.3s;
}

nav ul li a:hover, nav ul li a.active {
    color: var(--primary-color);
}


.btn {
    display: inline-block;
    padding: 10px 20px;
    border-radius: 5px;
    text-decoration: none;
    font-weight: 500;
    transition: all 0.3s;
    border: none;
    cursor: pointer;
}

.btn-primary {
    background-color: var(--primary-color);
    color: white;
}

.btn-primary:hover {
    background-color: var(--secondary-color);
}


.hero {
    text-align: center;
    padding: 60px 0;
    background-color: white;
    border-radius: 10px;
    margin: 30px 0;
    box-shadow: 0 5px 15px rgba(0, 0, 0, 0.05);
}

.hero h2 {
    font-size: 36px;
    margin-bottom: 15px;
    color: var(--primary-color);
}

.hero p {
    font-size: 18px;
    color: var(--gray-color);
    margin-bottom: 25px;
}


.stats {
    display: flex;
    justify-content: space-around;
    margin: 40px 0;
    flex-wrap: wrap;
}

.stat-card {
    background: white;
    padding: 30px;
    border-radius: 10px;
    text-align: center;
    width: 30%;
    min-width: 250px;
    margin: 10px;
    box-shadow: 0 5px 15px rgba(0, 0, 0, 0.05);
    transition: transform 0.3s;
}

.stat-card:hover {
    transform: translateY(-5px);
}

.stat-card i {
    font-size: 36px;
    color: var(--primary-color);
    margin-bottom: 15px;
}

.stat-card h3 {
    font-size: 32px;
    margin-bottom: 5px;
}

.stat-card p {
    color: var(--gray-color);
}

.form-group {
    margin-bottom: 20px;
}

.form-group label {
    display: block;
    margin-bottom: 8px;
    font-weight: 500;
}

.form-group input,
.form-group select,
.form-group textarea {
    width: 100%;
    padding: 12px;
    border: 1px solid #ddd;
    border-radius: 5px;
    font-size: 16px;
}

.form-group textarea {
    resize: vertical;
    min-height: 150px;
}


.rating-stars {
    margin: 15px 0;
}

.rating-stars i {
    font-size: 24px;
    color: #ddd;
    cursor: pointer;
    transition: color 0.2s;
    margin-right: 5px;
}

.rating-stars i.active,
.rating-stars i:hover {
    color: gold;
}


.filter-controls {
    display: flex;
    gap: 20px;
    margin-bottom: 30px;
    flex-wrap: wrap;
}

.filter-controls .form-group {
    flex: 1;
    min-width: 200px;
}

.review-card {
    background: white;
    padding: 25px;
    border-radius: 10px;
    margin-bottom: 20px;
    box-shadow: 0 5px 15px rgba(0, 0, 0, 0.05);
}

.review-header {
    display: flex;
    justify-content: space-between;
    margin-bottom: 15px;
    align-items: center;
}

.review-author {
    font-weight: bold;
    font-size: 18px;
}

.review-date {
    color: var(--gray-color);
    font-size: 14px;
}

.review-rating {
    color: gold;
    margin-bottom: 10px;
}

.review-category {
    display: inline-block;
    background-color: var(--light-color);
    padding: 5px 10px;
    border-radius: 20px;
    font-size: 14px;
    margin-bottom: 10px;
}

.review-text {
    margin-bottom: 15px;
    line-height: 1.7;
}


footer {
    background-color: var(--dark-color);
    color: white;
    padding: 20px 0;
    text-align: center;
    margin-top: 50px;
}


@media (max-width: 768px) {
    header {
        text-align: center;
    }

    nav {
        float: none;
        margin-top: 15px;
    }

    nav ul li {
        margin: 0 10px;
    }

    .hero h2 {
        font-size: 28px;
    }

    .stats {
        flex-direction: column;
        align-items: center;
    }

    .stat-card {
        width: 100%;
        margin-bottom: 20px;
    }

    .filter-controls {
        flex-direction: column;
        gap: 15px;
    }
}endor-Booking-System
document.addEventListener('DOMContentLoaded', function() {
    
    const homeSection = document.getElementById('home-section');
    const addReviewSection = document.getElementById('add-review-section');
    const viewReviewsSection = document.getElementById('view-reviews-section');
    const homeLink = document.getElementById('home-link');
    const addReviewLink = document.getElementById('add-review-link');
    const viewReviewsLink = document.getElementById('view-reviews-link');
    const getStartedBtn = document.getElementById('get-started-btn');
    const reviewForm = document.getElementById('review-form');
    const reviewsContainer = document.getElementById('reviews-container');
    const filterVendor = document.getElementById('filter-vendor');
    const filterCategory = document.getElementById('filter-category');

    
    function showSection(section) {
        homeSection.classList.add('hidden');
        addReviewSection.classList.add('hidden');
        viewReviewsSection.classList.add('hidden');

        section.classList.remove('hidden');

        
        homeLink.classList.remove('active');
        addReviewLink.classList.remove('active');
        viewReviewsLink.classList.remove('active');

        if (section === homeSection) {
            homeLink.classList.add('active');
        } else if (section === addReviewSection) {
            addReviewLink.classList.add('active');
        } else if (section === viewReviewsSection) {
            viewReviewsLink.classList.add('active');
            loadReviews();
        }
    }

    homeLink.addEventListener('click', (e) => {
        e.preventDefault();
        showSection(homeSection);
    });

    addReviewLink.addEventListener('click', (e) => {
        e.preventDefault();
        showSection(addReviewSection);
    });

    viewReviewsLink.addEventListener('click', (e) => {
        e.preventDefault();
        showSection(viewReviewsSection);
    });

    getStartedBtn.addEventListener('click', (e) => {
        e.preventDefault();
        showSection(addReviewSection);
    });

    
    const stars = document.querySelectorAll('.rating-stars i');
    const ratingInput = document.getElementById('rating');

    stars.forEach(star => {
        star.addEventListener('click', function() {
            const rating = parseInt(this.getAttribute('data-rating'));
            ratingInput.value = rating;

            stars.forEach((s, index) => {
                if (index < rating) {
                    s.classList.remove('far');
                    s.classList.add('fas', 'active');
                } else {
                    s.classList.remove('fas', 'active');
                    s.classList.add('far');
                }
            });
        });
    });

    // Form Submission
    reviewForm.addEventListener('submit', function(e) {
        e.preventDefault();

        if (!ratingInput.value) {
            alert('Please select a rating');
            return;
        }

        const review = {
            vendorId: document.getElementById('vendor').value,
            category: document.getElementById('category').value,
            clientName: document.getElementById('name').value,
            clientEmail: document.getElementById('email').value,
            rating: parseInt(ratingInput.value),
            comment: document.getElementById('comment').value
        };

        fetch('/wedding-feedback/api/reviews', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(review)
        })
        .then(response => response.json())
        .then(data => {
            alert('Thank you for your review!');
            reviewForm.reset();
            stars.forEach(star => {
                star.classList.remove('fas', 'active');
                star.classList.add('far');
            });
            ratingInput.value = '';
            showSection(viewReviewsSection);
        })
        .catch(error => {
            console.error('Error:', error);
            alert('There was an error submitting your review');
        });
    });

    // Load and Display Reviews
    function loadReviews() {
        fetch('/wedding-feedback/api/reviews')
            .then(response => response.json())
            .then(reviews => {
                displayReviews(reviews);
            })
            .catch(error => {
                console.error('Error loading reviews:', error);
                reviewsContainer.innerHTML = '<p>Error loading reviews. Please try again later.</p>';
            });
    }

    function displayReviews(reviews) {
        if (reviews.length === 0) {
            reviewsContainer.innerHTML = '<p>No reviews found.</p>';
            return;
        }

        let filteredReviews = [...reviews];

        // Apply filters
        if (filterVendor.value) {
            filteredReviews = filteredReviews.filter(review => review.vendorId === filterVendor.value);
        }

        if (filterCategory.value) {
            filteredReviews = filteredReviews.filter(review => review.category === filterCategory.value);
        }

        if (filteredReviews.length === 0) {
            reviewsContainer.innerHTML = '<p>No reviews match your filters.</p>';
            return;
        }

        
        filteredReviews.sort((a, b) => new Date(b.reviewDate) - new Date(a.reviewDate));

        // Display reviews
        reviewsContainer.innerHTML = '';
        filteredReviews.forEach(review => {
            const reviewDate = new Date(review.reviewDate).toLocaleDateString('en-US', {
                year: 'numeric',
                month: 'long',
                day: 'numeric'
            });

            const ratingStars = '★'.repeat(review.rating) + '☆'.repeat(5 - review.rating);

            const reviewElement = document.createElement('div');
            reviewElement.className = 'review-card';
            reviewElement.innerHTML = `
                <div class="review-header">
                    <span class="review-author">${review.clientName}</span>
                    <span class="review-date">${reviewDate}</span>
                </div>
                <div class="review-category">${review.category}</div>
                <div class="review-rating" title="${review.rating} out of 5 stars">${ratingStars}</div>
                <div class="review-text">${review.comment}</div>
            `;

            reviewsContainer.appendChild(reviewElement);
        });
    }

  
    filterVendor.addEventListener('change', loadReviews);
    filterCategory.addEventListener('change', loadReviews);

    
    showSection(homeSection);
});

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Wedding Planner Feedback</title>
    <link rel="stylesheet" href="/css/styles.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
</head>
<body>
<header>
    <div class="container">
        <h1><i class="fas fa-heart"></i> Wedding Feedback</h1>
        <nav>
            <ul>
                <li><a href="#" class="active" id="home-link">Home</a></li>
                <li><a href="#" id="add-review-link">Add Review</a></li>
                <li><a href="#" id="view-reviews-link">View Reviews</a></li>
            </ul>
        </nav>
    </div>
</header>

<main class="container">
    <!-- Home Section -->
    <section id="home-section">
        <div class="hero">
            <h2>Share Your Wedding Experience</h2>
            <p>Help other couples by sharing feedback about wedding vendors</p>
            <button id="get-started-btn" class="btn-primary">Get Started</button>
        </div>

        <div class="stats">
            <div class="stat-card">
                <i class="fas fa-star"></i>
                <h3>4.8</h3>
                <p>Average Rating</p>
            </div>
            <div class="stat-card">
                <i class="fas fa-comments"></i>
                <h3>127</h3>
                <p>Reviews</p>
            </div>
            <div class="stat-card">
                <i class="fas fa-building"></i>
                <h3>42</h3>
                <p>Vendors</p>
            </div>
        </div>
    </section>

    <!-- Add Review Section -->
    <section id="add-review-section" class="hidden">
        <h2><i class="fas fa-pen"></i> Add a Review</h2>
        <form id="review-form">
            <div class="form-group">
                <label for="vendor">Vendor</label>
                <select id="vendor" required>
                    <option value="">Select a vendor</option>
                    <option value="VEN001">Wedding Venues</option>
                    <option value="PHO002">Photographers</option>
                    <option value="CAT003">Catering Services</option>
                    <option value="FLO004">Florists</option>
                </select>
            </div>

            <div class="form-group">
                <label for="category">Category</label>
                <select id="category" required>
                    <option value="">Select a category</option>
                    <option value="Venue">Venue</option>
                    <option value="Photography">Photography</option>
                    <option value="Catering">Catering</option>
                    <option value="Florist">Florist</option>
                </select>
            </div>

            <div class="form-group">
                <label>Your Rating</label>
                <div class="rating-stars">
                    <i class="far fa-star" data-rating="1"></i>
                    <i class="far fa-star" data-rating="2"></i>
                    <i class="far fa-star" data-rating="3"></i>
                    <i class="far fa-star" data-rating="4"></i>
                    <i class="far fa-star" data-rating="5"></i>
                </div>
                <input type="hidden" id="rating" name="rating" required>
            </div>

            <div class="form-group">
                <label for="name">Your Name</label>
                <input type="text" id="name" required>
            </div>

            <div class="form-group">
                <label for="email">Your Email</label>
                <input type="email" id="email" required>
            </div>

            <div class="form-group">
                <label for="comment">Your Review</label>
                <textarea id="comment" rows="5" required></textarea>
            </div>

            <button type="submit" class="btn-primary">Submit Review</button>
        </form>
    </section>

    <!-- View Reviews Section -->
    <section id="view-reviews-section" class="hidden">
        <h2><i class="fas fa-list"></i> Vendor Reviews</h2>

        <div class="filter-controls">
            <div class="form-group">
                <label for="filter-vendor">Filter by Vendor</label>
                <select id="filter-vendor">
                    <option value="">All Vendors</option>
                    <option value="VEN001">Wedding Venues</option>
                    <option value="PHO002">Photographers</option>
                    <option value="CAT003">Catering Services</option>
                    <option value="FLO004">Florists</option>
                </select>
            </div>

            <div class="form-group">
                <label for="filter-category">Filter by Category</label>
                <select id="filter-category">
                    <option value="">All Categories</option>
                    <option value="Venue">Venue</option>
                    <option value="Photography">Photography</option>
                    <option value="Catering">Catering</option>
                    <option value="Florist">Florist</option>
                </select>
            </div>
        </div>

        <div id="reviews-container">
            <!-- Reviews will be loaded here -->
        </div>
    </section>
</main>

<footer>
    <div class="container">
        <p>&copy; 2023 Wedding Planner Feedback System</p>
    </div>
</footer>

<script src="/js/app.js"></script>
</body>
</html>

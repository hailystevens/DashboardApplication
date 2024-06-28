// static/js/scripts.js

// Variables
let userLoggedIn = false; // Use variables
const userName = "Hailybelle"; // Use variables

// If statements
if (userLoggedIn) { // Use if statements
    console.log("Welcome back, " + userName);
} else {
    console.log("Please log in to continue.");
}

// Loops
const numbers = [1, 2, 3, 4, 5]; // Use variables
for (let i = 0; i < numbers.length; i++) { // Use loops
    console.log("Number: " + numbers[i]);
}

// Collection (Array) and Functions
const dashboardItems = ["Charts", "Tables", "Graphs"]; // Use collection (Array)
function displayItems(items) { // Use functions
    items.forEach(item => {
        console.log("Dashboard item: " + item);
    });
}

displayItems(dashboardItems);

// Event Listener
document.addEventListener('DOMContentLoaded', () => { // Use events
    const signInButton = document.querySelector('.btn-custom');
    signInButton.addEventListener('click', () => {
        alert('Sign In button clicked!');
    });
});

// AJAX and JSON Example
function fetchDashboardData() { // Use functions, Use AJAX, Use JSON
    $.ajax({
        url: 'https://api.example.com/dashboard',
        method: 'GET',
        dataType: 'json', // Use JSON
        success: function (data) {
            console.log("Dashboard data: ", data);
        },
        error: function (error) {
            console.error("Error fetching dashboard data: ", error);
        }
    });
}

// Trigger AJAX request on document load
$(document).ready(function () { // Use events
    fetchDashboardData();
});

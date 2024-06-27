// static/js/scripts.js

// Variables
let userLoggedIn = false;
const userName = "Hailybelle";

// If statements
if (userLoggedIn) {
    console.log("Welcome back, " + userName);
} else {
    console.log("Please log in to continue.");
}

// Loops
const numbers = [1, 2, 3, 4, 5];
for (let i = 0; i < numbers.length; i++) {
    console.log("Number: " + numbers[i]);
}

// Collection (Array) and Functions
const dashboardItems = ["Charts", "Tables", "Graphs"];
function displayItems(items) {
    items.forEach(item => {
        console.log("Dashboard item: " + item);
    });
}
displayItems(dashboardItems);

// Event Listener
document.addEventListener('DOMContentLoaded', () => {
    const signInButton = document.querySelector('.btn-custom');
    signInButton.addEventListener('click', () => {
        alert('Sign In button clicked!');
    });
});

// AJAX and JSON Example
function fetchDashboardData() {
    $.ajax({
        url: 'https://api.example.com/dashboard',
        method: 'GET',
        dataType: 'json',
        success: function(data) {
            console.log("Dashboard data: ", data);
        },
        error: function(error) {
            console.error("Error fetching dashboard data: ", error);
        }
    });
}

// function onSubmit() {
//     console.log("on submit function called");
//     return false;
// }

// Trigger AJAX request on document load
$(document).ready(function() {
    fetchDashboardData();
});

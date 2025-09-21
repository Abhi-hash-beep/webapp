// This script redirects the user from the welcome page to the main student list.
document.addEventListener("DOMContentLoaded", function() {
    // Check if the current page is the welcome page by looking for a specific element
    if (document.querySelector('.welcome-body')) {
        setTimeout(function() {
            window.location.href = '/students';
        }, 3000); // 3000 milliseconds = 3 seconds
    }
});
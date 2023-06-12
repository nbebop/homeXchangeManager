//correct and secure logout
function logout() {
    document.getElementById('logoutForm').submit();
}
//navbar design
window.addEventListener("scroll", function (){
    var header = document.querySelector("header");
    header.classList.toggle("sticky", window.scrollY > 0);
})

// pop up windows
function openPopup(popupId) {
    var popup = document.getElementById("popup-" + popupId);
    popup.style.display = "block";
}

function closePopup(popupId) {
    var popup = document.getElementById("popup-" + popupId);
    popup.style.display = "none";
}
//validating password
function validatePassword(event) {
    event.preventDefault(); // Prevent form submission for demonstration purposes

    var password = document.getElementById("password").value;
    var passwordConf = document.getElementById("password_conf").value;

    if (password !== passwordConf) {
        alert("Passwords do not match");
        return false;
    }

    // Passwords match, proceed with form submission
    alert("Passwords match");
    document.forms[0].submit(); // Uncomment this line to submit the form
}
var navBar = document.getElementById("navBar");

function togglebtn() {
    navBar.classList.toggle("hidemenu");
}

// Close the success popup after a certain duration
setTimeout(function() {
    var popup = document.getElementById('successPopup');
    if (popup) {
        popup.style.display = 'none';
    }
}, 3000); // Adjust the duration (in milliseconds) as needed


// script.js
const ratingForm = document.getElementById('ratingForm');
const ratingInputs = ratingForm.querySelectorAll('input[name="rating"]');

ratingForm.addEventListener('submit', (e) => {
    e.preventDefault();
    const selectedRating = Array.from(ratingInputs).find(input => input.checked);
    if (selectedRating) {
        const rating = selectedRating.value;
        updateListingRating(rating);
        ratingForm.reset();
        alert('Thank you for your rating!');
    } else {
        alert('Please select a rating!');
    }
});

function updateListingRating(rating) {
    // Send an AJAX request or perform any necessary logic to update the listing rating on the server-side
    // You can use the 'rating' value to send it to the server and update the corresponding listing
    // For demonstration purposes, we'll just log the rating to the console
    console.log('Listing rating updated:', rating);
}

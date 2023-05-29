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



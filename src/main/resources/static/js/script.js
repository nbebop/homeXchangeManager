window.addEventListener("scroll", function (){
    var header = document.querySelector("header");
    header.classList.toggle("sticky", window.scrollY > 0);
})

function openPopup(popupId) {
    var popup = document.getElementById("popup-" + popupId);
    popup.style.display = "block";
}

function closePopup(popupId) {
    var popup = document.getElementById("popup-" + popupId);
    popup.style.display = "none";
}
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
    // document.forms[0].submit(); // Uncomment this line to submit the form
}
var navBar = document.getElementById("navBar");

function togglebtn() {
    navBar.classList.toggle("hidemenu");
}
/* OLD HOME SCRIPT */
/*const listing = document.querySelector('.listing');
const images = ['static/img/paris2_apartement.png', 'apartment2.jpg', 'apartment3.jpg']; // replace with your own image URLs

let currentImage = 0;
listing.querySelector('.right-arrow').addEventListener('click', () => {
    currentImage = (currentImage + 1) % images.length;
    listing.querySelector('img').src = images[currentImage];
});

listing.querySelector('.left-arrow').addEventListener('click', () => {
    currentImage = (currentImage - 1 + images.length) % images.length;
    listing.querySelector('img').src = images[currentImage];
});*/

/* OLD REGISTRATION SCRIPT */
/*
const show_pw_btn = document.querySelector('#show-passwd')
const show_pw_icon = show_pw_btn.querySelector('img')
const pw_input = document.querySelector('#password')

show_pw_btn.addEventListener('click', () => {
    pw_input.type = pw_input.type === 'password'
        ? 'text'
        : 'password'

    show_pw_icon.src = show_pw_icon.src.includes('open')
        ? 'eye_closed.svg'
        : 'eye_open.svg'
})*/

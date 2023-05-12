const listing = document.querySelector('.listing');
const images = ['static/img/paris2_apartement.png', 'apartment2.jpg', 'apartment3.jpg']; // replace with your own image URLs

let currentImage = 0;
listing.querySelector('.right-arrow').addEventListener('click', () => {
    currentImage = (currentImage + 1) % images.length;
    listing.querySelector('img').src = images[currentImage];
});

listing.querySelector('.left-arrow').addEventListener('click', () => {
    currentImage = (currentImage - 1 + images.length) % images.length;
    listing.querySelector('img').src = images[currentImage];
});

window.addEventListener("scroll", function (){
    var header = document.querySelector("header");
    header.classList.toggle("sticky", window.scrollY > 0);
})
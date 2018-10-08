var slideIndex = 1;
showDivs(slideIndex);

function plusDivs(n) {
    showDivs(slideIndex += n);
}

function showDivs(n) {
    var i;
    var x = document.getElementsByClassName("mySlides");
    if (n > x.length) {slideIndex = 1} 
    if (n < 1) {slideIndex = x.length} ;
    for (i = 0; i < x.length; i++) {
        x[i].style.display = "none"; 
    }
    x[slideIndex-1].style.display = "block"; 
}



/*var i = 0;
var images  = [];
var time = 3000;

images[0] = 'image1.jpg';
images[1] = 'image2.jpg';
images[2] = 'image3.jpg';
images[3] = 'image4.jpg';

function chanegImg(){
    document.slide.src = images[i];
    if(i < images.length - 1){
        i++;
    }else{
       i = 0; 
    }
    setTimeout("changeImg()",time);
}

window.onload = chanegImg;*/

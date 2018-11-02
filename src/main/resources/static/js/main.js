var slider_content =  document.getElementById('box');
//Contains images in an array
var image  =  ['image1','image2','image3','image4'];

var i =  image.length;

//Function for sliding 
function nextImage(){
    if(i < image.length){
        i = i + 1;
    }else{
        i = 1;
    }
    slider_content.innerHTML = "<img scr="+image[i-1]+".jpg>";
}

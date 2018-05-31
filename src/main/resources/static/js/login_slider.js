var _slider = document.querySelector(".slider ul.slides")
var _slider_btns = document.querySelectorAll(".slider ul.slider_btn li")
var _left = 0, current_pos = 0, current_slide_btn, hovered_bnt;
var hovered_image = document.querySelector(".slider .hovered_image")

var sliderval = setInterval(function(){
	
	if((current_pos % 100) == 0){
		current_slide_btn = current_pos / -100

		
		if(current_slide_btn < 7){
			_slider_btns[current_slide_btn].classList.add("active")
			if(current_slide_btn > 0){
				_slider_btns[current_slide_btn-1].classList.remove("active")
			}else{
				_slider_btns[6].classList.remove("active")
			}
			
		}else{
			console.log(_slider_btns[0])	
		}
		
	}
	
	
	if(current_pos > -700){
		current_pos -= 0.25
			
	}else{
		current_pos = 0
	}
	
	_slider.style.left = current_pos + "%"
	
	
}, 50)


for(var i=0; i<_slider_btns.length; i++){
	
	_slider_btns[i].addEventListener("mouseover", function(){	
	
		for(var j=0; j<7; j++){
			if(_slider_btns[j].classList.contains("active")){
				_slider_btns[j].classList.remove("active")
			}
		}
		
		this.classList.add("active")
				
		clearInterval(sliderval)
		
		var img = "<img src='/images/slider/slide_0"+ this.classList[0] +".jpg ' />"
		
		hovered_image.innerHTML = img
		hovered_image.classList.remove("hide_slide")
		hovered_image.classList.add("show_slide")
		
	}, false)
	
	_slider_btns[i].addEventListener("mouseout", function(){
		
		document.querySelector(".slider ul.slider_btn li.active").classList.remove("active")
		
		sliderval = setInterval(function(){
					
			if((current_pos % 100) == 0){
				current_slide_btn = current_pos / -100
				next_slide_btn = current_slide_btn + 1
				
				if(current_slide_btn < 7){
					_slider_btns[current_slide_btn].classList.add("active")
					if(current_slide_btn > 0){
						_slider_btns[current_slide_btn-1].classList.remove("active")
					}else{
						_slider_btns[6].classList.remove("active")
					}
					
				}
				
			}
			
			
			if(current_pos > -700){
				current_pos -= 0.25
					
			}else{
				current_pos = 0
			}
			
			_slider.style.left = current_pos + "%"
			
			hovered_image.classList.remove("show_slide")
			hovered_image.classList.add("hide_slide")

						
		}, 50)
		
	}, false)
}






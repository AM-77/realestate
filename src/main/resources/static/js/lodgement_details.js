
var next_btn = document.querySelector(".next")
var prev_btn = document.querySelector(".prev")
var slider = document.querySelector(".the_slider")

prev_btn.classList.add('disabled')

var next_btn_blocked = false
var prev_btn_blocked = true

var x = 0
var y = x - 20

next_btn.addEventListener("click", function(){
	
	if(!next_btn_blocked){
		
		y = x - 20
		
		nexterval = setInterval(function(){
			
			x -= 0.25
			
			slider.style.left =  x + "%"		
			
			if(x == y){
				clearInterval(nexterval)
			}
			
			if(y < 0){
				prev_btn_blocked = false
				prev_btn.classList.remove('disabled')
			}
			
			if(y == - 80){
				next_btn_blocked = true
				prev_btn_blocked = false
				next_btn.classList.add('disabled')
			}
				
			
		}, 10)
		
	}
	
}, false)


prev_btn.addEventListener("click", function(){
	
	if(!prev_btn_blocked){
		
		z = x + 20
		
		prevterval = setInterval(function(){
			
			x += 0.25
			
			slider.style.left =  x + "%"		
			
			if(x == z){
				clearInterval(prevterval)
			}
			
			if(z < 0){
				next_btn_blocked = false
				next_btn.classList.remove('disabled')
			}
			
			if(z == 0){
				next_btn_blocked = false
				prev_btn_blocked = true
				prev_btn.classList.add('disabled')
			}
				
		}, 10)
		
	}
	
}, false)
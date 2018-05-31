var vertical_nav = document.querySelector(".vertical_nav")
var toggle_menu = document.querySelector(".toggle_menu")
var main_section = document.querySelector(".main_section")

toggle_menu.addEventListener("click", function(){
	
	if(toggle_menu.classList.contains("move_right")){
		vertical_nav.classList.remove("show_big")
		vertical_nav.classList.add("hide_big")

		toggle_menu.classList.add("move_left")
		toggle_menu.classList.remove("move_right")
		
		main_section.classList.remove("small_section")
		main_section.classList.add("big_section")

	}else{
		vertical_nav.classList.remove("hide_big")
		vertical_nav.classList.add("show_big")
		
		toggle_menu.classList.add("move_right")
		toggle_menu.classList.remove("move_left")
		
		main_section.classList.add("small_section")
		main_section.classList.remove("big_section")

	}
	
}, false)

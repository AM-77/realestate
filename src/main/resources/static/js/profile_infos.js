var gear = document.querySelector(".gear")
var profile_dropdown_menu = document.querySelector(".profile_dropdown_menu")

gear.addEventListener("click", function(){
	
	if(profile_dropdown_menu.classList.contains("show")){
		profile_dropdown_menu.classList.remove("show")
		profile_dropdown_menu.classList.add("hide")
	}else{
		profile_dropdown_menu.classList.remove("hide")
		profile_dropdown_menu.classList.add("show")
	}
	
}, false)



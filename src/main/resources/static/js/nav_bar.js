var subscribe = document.querySelector(".subscribe")
var sub_menu = document.querySelector(".sub_menu")

var div = document.createElement("div");
div.classList.add("hide_notif")

var body = document.querySelector("body");


subscribe.addEventListener("click", function(){
	
	if(sub_menu.classList.contains("show")){
		sub_menu.classList.remove("show")
		sub_menu.classList.add("hide")
		
		body.removeChild(div);
		
	}else{
		sub_menu.classList.remove("hide")
		sub_menu.classList.add("show")
		
		body.appendChild(div);
	}
	
}, false)

div.addEventListener("click", function(){
	
	if(sub_menu.classList.contains("show")){
		sub_menu.classList.remove("show")
		sub_menu.classList.add("hide")
		
		body.removeChild(div);
		
	}
	
}, false)

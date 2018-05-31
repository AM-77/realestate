var notification_link = document.querySelector(".notification_link")
var notification_nbr = document.querySelector(".notification_link .notification_nbr")
var notifications = document.querySelector(".notifications")

hide = true	
once = 1


notification_link.addEventListener("click", function(){
	
	var xhr = new XMLHttpRequest()
	xhr.open("GET","http://localhost:8080/see_reports",true);
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhr.send()
	
	if(notification_nbr != null)
		notification_nbr.remove()
		
	if(hide){
		notifications.classList.remove("hide")
		notifications.classList.add("show")
		hide = false;
	}else{
		notifications.classList.remove("show")
		notifications.classList.add("hide")
		hide = true;
	}
	
})
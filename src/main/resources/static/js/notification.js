var notification_link = document.querySelector(".notification_link")
var notification_nbr = document.querySelector(".notification_link .notification_nbr")
var notifications = document.querySelector(".notifications")

var div = document.createElement("div")
div.classList.add("hide_notif")
var body = document.querySelector("body")


notification_link.addEventListener("click", function(){
	
	var xhr = new XMLHttpRequest()
	xhr.open("GET","http://localhost:8080/see_notifications",true);
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhr.send()
	
	if(notification_nbr != null)
		notification_nbr.remove()
		
	if(notifications.classList.contains("show_notifcations")){
		notifications.classList.remove("show_notifcations")
		notifications.classList.add("hide_notifcations");
		
		body.removeChild(div)
	}else{
		notifications.classList.remove("hide_notifcations")
		notifications.classList.add("show_notifcations")
		
		body.appendChild(div)
	}
	
})

div.addEventListener("click", function(){
	
	if(notifications.classList.contains("show_notifcations")){
		notifications.classList.remove("show_notifcations")
		notifications.classList.add("hide_notifcations");
		
		body.removeChild(div)
	}
	
}, false)


var see_more = document.querySelectorAll(".more")
var details

for(var i=0; i< see_more.length; i++){
	
	see_more[i].addEventListener("click", function(){
		
		details = this.nextElementSibling
		
		if(details.classList.contains("see_details")){
			
			this.innerHTML ="See details"
			
			details.classList.remove("see_details")
			details.classList.add("hide_details")
		}else{
			
			this.innerHTML ="Hide details"
				
			details.classList.remove("hide_details")
			details.classList.add("see_details")
		}
		
	}, false)
	
}

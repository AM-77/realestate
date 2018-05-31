var show_password = document.querySelectorAll(".show_password")
var x

if(show_password.length > 0){
	
	for(var i = 0; i < show_password.length ; i++){
	
		show_password[i].addEventListener("click", function(){
			
			if(this.classList.contains("fa-eye-slash")){
				
				this.classList.remove("fa-eye-slash")
				this.classList.add("fa-eye")
				
				this.parentElement.nextElementSibling.type = "text"
				
			}else{
				this.classList.remove("fa-eye")
				this.classList.add("fa-eye-slash")
				
				this.parentElement.nextElementSibling.type = "password"
					
			}
			
		}, false)
		
	}
	
}
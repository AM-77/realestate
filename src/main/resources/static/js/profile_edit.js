var button = document.querySelector("button")
var inputs = document.querySelectorAll(".infos input")
var j = 0
var edit_save = 0

button.addEventListener("click", function(event){ 
	
	if(edit_save == 0){
		
		event.preventDefault()
		
		button.innerText = "save"
		edit_save = 1	
	}
	
	
	if(inputs[0].disabled){ 
		
		for( j = 0; j < inputs.length; j++){ 
			
			inputs[j].disabled = false 
			
		} 
	} 

})
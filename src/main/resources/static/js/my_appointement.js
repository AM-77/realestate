var list_report_content = document.querySelectorAll(".report_content")
var list_report_submit = document.querySelectorAll(".report_submit")

for(var i=0; i< list_report_content.length; i++){
	
	if(list_report_content[i].value == ""){
		list_report_submit[i].disabled = true	
	}
	
	list_report_content[i].addEventListener("keyup", function(){

		if(this.value == ""){
			this.nextElementSibling.disabled = true	
		}else{
			this.nextElementSibling.disabled = false
		}
		
	})
	
}
var agent_id = document.querySelectorAll("select")

for(var j=0; j<agent_id.length; j++){
					
	agent_id[j].nextElementSibling.href = "http://localhost:8080/agent_profile/"+agent_id[j].value
			
	agent_id[j].addEventListener("change", function(){
		
		this.nextElementSibling.href = "http://localhost:8080/agent_profile/" + this.value

	}, false)
	
}
	
var agents = document.querySelector(".agents")
if(agents.firstElementChild == null)
	agents.innerHTML = "<option>No Agent is availiable</option>"
	
var xhr = new XMLHttpRequest();
	
var proposed_date = document.querySelector(".proposed_date")
var proposed_time = document.querySelector(".proposed_time")

var date = proposed_date.value
var time = proposed_time.value
var _agents

if(document.querySelector("input.proposed_date").value == "")
	document.querySelector("input.propose").disabled = true

agents.innerHTML = "<option>No Agent is availiable</option>"

proposed_date.addEventListener("change", function(){
	
	date = this.value
	console.log("time:" + time + "| date: " + date)
	xhr.open("POST","http://localhost:8080/avail_agents",true);
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhr.send("date="+ date + "&time="+ time +"&id_lodg="+ window.location.search.substring(4))
	
	xhr.onreadystatechange=function(){
		
		if (xhr.readyState==4 && xhr.status==200){	
			_avail_agents = JSON.parse(xhr.responseText)
		   
			_agents = ""
			
		   	for(var i=0; i<_avail_agents.length; i++){
				_agents +="<option value='" + _avail_agents[i].id + "'>" + _avail_agents[i].username + "</option>"
		    }
		   
			if(_agents != ""){
				agents.innerHTML = _agents
				document.querySelector("input.propose").disabled = false
			}else{
				document.querySelector("input.propose").disabled = true
				agents.innerHTML = "<option>No Agent is availiable</option>"
			}
				
		   
		}		
				
	}
	
}, false)


proposed_time.addEventListener("change", function(){
	
	time = this.value
	console.log("time:" + time + "| date: " + date)
	xhr.open("POST","http://localhost:8080/avail_agents",true);
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhr.send("date="+ date + "&time="+ time +"&id_lodg="+ window.location.search.substring(4))
	
	
	
	xhr.onreadystatechange=function(){
		
		if (xhr.readyState==4 && xhr.status==200){	
			_avail_agents = JSON.parse(xhr.responseText)
		   
			_agents = ""
			
		   	for(var i=0; i<_avail_agents.length; i++){
				_agents +="<option value='" + _avail_agents[i].id + "'>" + _avail_agents[i].username + "</option>"
		    }
		   
			if(_agents != ""){
				agents.innerHTML = _agents
				document.querySelector("input.propose").disabled = false
			}else{
				document.querySelector("input.propose").disabled = true
				agents.innerHTML = "<option>No Agent is availiable</option>"
			}
		}		
				
	}
	
	
}, false)


		
		
		
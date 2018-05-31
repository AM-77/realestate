
var xhr =new XMLHttpRequest();

var search_btn = document.querySelector("input.search-btn")
var search_result_div = document.querySelector("div.search-result")

var address = document.querySelector(".address")
var type_f1 = document.querySelector(".type_f1")
var type_f2 = document.querySelector(".type_f2")
var type_f3 = document.querySelector(".type_f3")
var type_f4 = document.querySelector(".type_f4")
var type_f5 = document.querySelector(".type_f5")
var min_price = document.querySelector(".min-price")
var max_price = document.querySelector(".max-price")
var min_surface = document.querySelector(".min-surface")
var max_surface = document.querySelector(".max-surface")
var min_floor = document.querySelector(".min-floor")
var max_floor = document.querySelector(".max-floor")

var _address, _type, _min_price, _max_price, _min_surface, _max_surface, _search_result, _lodg , _floor
var lodgement_details = document.querySelector(".lodgement_details")

search_btn.addEventListener("click", function(){
	
	lodgement_details.remove()
	
	_address = address.value
	
	if(type_f1.checked)
		_type_f1 = type_f1.value
	else
		_type_f1= "no_value"
			
			
	if(type_f2.checked)	
		_type_f2 = type_f2.value
	else
		_type_f2= "no_value"
			
			
	if(type_f3.checked)
		_type_f3 = type_f3.value
	else
		_type_f3= "no_value"
		
	if(type_f4.checked)
		_type_f4 = type_f4.value
	else
		_type_f4= "no_value"
		
	if(type_f5.checked)
		_type_f5 = type_f5.value
	else
		_type_f5= "no_value"
		
	_lodg = ""
		
	_min_price = min_price.value
	_max_price = max_price.value
	
	_min_surface = min_surface.value
	_max_surface = max_surface.value
	
	_min_floor = min_floor.value
	_max_floor = max_floor.value
	
	if(address.value == "")
		_address = "no_value"
		
	if(min_price.value == "")
		_min_price = 0
		
	if(max_price.value == "")
		_max_price.value = 1000000000
	
	if(min_surface.value == "")
		_min_surface = 0
			
	if(max_surface.value == "")
		_max_surface = 10000
		
	xhr.open("POST","http://localhost:8080/search",true);
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhr.send("address=" + _address + "&type_f1=" + _type_f1 + "&type_f2=" + _type_f2 + "&type_f3=" + _type_f3 + "&type_f4=" + _type_f4 + "&type_f5=" + _type_f5 + "&min_price=" + _min_price + "&max_price=" + _max_price + "&min_floor=" + _min_floor + "&max_floor=" + _max_floor + "&min_surface=" + _min_surface + "&max_surface=" + _max_surface)
	
	xhr.onreadystatechange=function(){
		
		if (xhr.readyState==4 && xhr.status==200){	
		   _search_result = JSON.parse(xhr.responseText)
		   
		   for(var i=0; i<_search_result.length; i++){
			   _search_result[i]
			    
			   _lodg += "<div class='lodg'> "
			   _lodg += "<div class class='pics'></div>"
			   _lodg += "<div class='infos'>"
			   _lodg += "<p class='address'>Address: "+_search_result[i].address+"</p>"
			   _lodg += "<p class='price'>Price: "+_search_result[i].price+"</p>"
			   _lodg += "<p class='type'>Type: "+_search_result[i].type+"</p>"
			   _lodg += "<p class='floor'>Floor: "+_search_result[i].floor+"</p>"
			   _lodg += "<p class='surface'>Surface: "+_search_result[i].surface+" M</p>"
			   _lodg += "<a href='/lodgement_details/"+_search_result[i].id+"'>lodgement's details</a>"
			   _lodg += "<a href='/reserve_appointement?id="+_search_result[i].id+"'>Get an appointement now</a>"
			   _lodg += "</div></div><hr>"
			   
		   }
		   
		   search_result_div.innerHTML = _lodg
		}		
				
	}
	
}, false)

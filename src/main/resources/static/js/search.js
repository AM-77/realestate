var advenced_search_btn = document.querySelector(".advenced_search_btn")
var advenced_search = document.querySelector(".advenced")

advenced_search_btn.addEventListener("click", function(){
	
	if(advenced_search.classList.contains("show")){
		advenced_search.classList.remove("show")
		advenced_search.classList.add("hide")
	}else{
		advenced_search.classList.remove("hide")
		advenced_search.classList.add("show")
		
		min_price.value = ""
		max_price.value = ""
		min_surface.value = ""
		max_surface.value = ""
		min_floor.value = ""
		max_floor.value = ""
		
	}
	
}, false)


var xhr =new XMLHttpRequest()

var search_btn = document.querySelector(".search-btn")
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

var _address, _type, _min_price, _max_price, _min_surface, _max_surface, _search_result, _lodg , _floor, x = 0, next_btn, prev_btn
var _lodgement_pics = []

search_btn.addEventListener("click", function(){
	
	
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
		_max_price = 1000000000
	
	if(min_surface.value == "")
		_min_surface = 0
			
	if(max_surface.value == "")
		_max_surface = 10000
		
	if(min_floor.value == "")
		_min_floor = 0
			
	if(max_floor.value == "")
		_max_floor = 1000
		
	xhr.open("POST","http://localhost:8080/search",true);
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhr.send("address=" + _address + "&type_f1=" + _type_f1 + "&type_f2=" + _type_f2 + "&type_f3=" + _type_f3 + "&type_f4=" + _type_f4 + "&type_f5=" + _type_f5 + "&min_price=" + _min_price + "&max_price=" + _max_price + "&min_floor=" + _min_floor + "&max_floor=" + _max_floor + "&min_surface=" + _min_surface + "&max_surface=" + _max_surface)
	
	xhr.onreadystatechange=function(){
		
		if (xhr.readyState==4 && xhr.status==200){	
		   _search_result = JSON.parse(xhr.responseText)
		   
		   _lodg = "<div class='header'><p>The search result : </p></div>"
		   
		   for(var i=0; i<_search_result.length; i++){
				     
				_lodgement_pics = _search_result[i].pics.split(',')
				_lodg += '<div class="lodg">'
				_lodg += '<a class="more_details" target="_BLANK" href="/lodgement_details/'+ _search_result[i].id +'">More details <span class="fa fa-external-link"></span></a>'	
				_lodg += ' <div class="pics"><div class="arrow arrow-left disabled"><span class="fa fa-angle-left"></span></div><div class="arrow arrow-right"><span class="fa fa-angle-right"></span></div><ul>'
								
				for(var j=0; j < 3; j++){
				   _lodg += '<li><img src="/images/lodgements/'+  _search_result[i].id  +'/'+ _lodgement_pics[j] +'"></li>'
				}
				
				_lodg += "</ul></div>" 
				_lodg += '<div class="infos">'   
				_lodg += '<p class="infos_title">Appartement\'s Informations: </p>'
				_lodg += '<p class="title address">Address: <span class="value">'+ _search_result[i].address +'</span></p>'
				_lodg += '<p class="title price">Price: <span class="value">'+ _search_result[i].price +' DA </span></p>'
				_lodg += '<p class="title type">Type: <span class="value">'+ _search_result[i].type +'</span></p>'
				_lodg += '<p class="title floor">Floor: <span class="value">' + _search_result[i].floor + '</span></p>'
				_lodg += '<p class="title surface">Surface: <span class="value">'+ _search_result[i].surface +' M<span class="sqr">2</span></span></p>'
				_lodg += '<div class="links">'
				_lodg += '<a href="/reserve_appointement?id='+ _search_result[i].id +'">reserve an appointement</a>'
				_lodg += '</div></div></div>'
				   
		   }
		   		   
		   if(_lodg == "<div class='header'><p>The search result : </p></div>"){
			   search_result_div.innerHTML = _lodg + "<div class='no_results'><p>Sorry. There is no appartement that matches the caractiristics you wanted.<br>" +
			   								 "You can add this caratiristcs to your <a href='wish_list'>wish list</a> then we will notify you when its availibale.<p></div>"
		   }else{
			   search_result_div.innerHTML = _lodg
		   }
		   
		   
		   
		   var arrows_left = document.querySelectorAll(".arrow-left")
		   var arrows_right = document.querySelectorAll(".arrow-right")
		   var pics_list = document.querySelectorAll(".pics ul")
		   
		   for(var k=0; k<pics_list.length; k++){
			   arrows_right[k].addEventListener("click", function(){
				   
				   next_btn = this	
				   prev_btn = next_btn.previousElementSibling
				   				   
				   if(next_btn.parentElement.lastElementChild.style.left == ""){
					   y = 0
			   	   }else{
					   y = parseInt(next_btn.parentElement.lastElementChild.style.left.substring(0, next_btn.parentElement.lastElementChild.style.left.indexOf("px")))
			   	   }
				   
				   x = 250;
				   
				   if(!this.classList.contains('disabled')){
					  
					   var arrows_right_interval = setInterval(function(){
						   if( x > 0 ){

							   y = y -10
							   next_btn.parentElement.lastElementChild.style.left = y + 'px'
							   
							   x -= 10
							   
							   if(prev_btn.classList.contains('disabled')){
								   prev_btn.classList.remove('disabled')
							   }
							   
							   if(y == -500){
								   next_btn.classList.add('disabled')
							   }
							   
						   }else{
							   clearInterval(arrows_right_interval)
						   }
					   }, 10)
				   }
				   
			   }, false)
			   
			   
			   
			   
			   arrows_left[k].addEventListener("click", function(){
				   
				   prev_btn = this	
				   next_btn= prev_btn.nextElementSibling
				   
				   
				   				   
				   if(prev_btn.parentElement.lastElementChild.style.left == ""){
					   y = 0
			   	   }else{
					   y = parseInt(prev_btn.parentElement.lastElementChild.style.left.substring(0, prev_btn.parentElement.lastElementChild.style.left.indexOf("px")))
			   	   }
				   
				   console.log(y)
				   x = 250;
				   
				   if(!this.classList.contains('disabled')){
					  
					   var arrows_left_interval = setInterval(function(){
						   if( x > 0 ){

							   y = y + 10
							   prev_btn.parentElement.lastElementChild.style.left = y + 'px'
							   
							   x -= 10
							   
							   
							   
							   if(next_btn.classList.contains('disabled')){
								   next_btn.classList.remove('disabled')
							   }
							   
							   if(y == 0){
								   prev_btn.classList.add('disabled')
							   }
							   
						   }else{
							   clearInterval(arrows_left_interval)
						   }
					   }, 10)
				   }
				   
			   }, false)
			   
			  
		   }
		   
		   
		   var current_pos = 0, scroll_to = 660
		   var scroll_interval = setInterval(function(){
			   if(current_pos < scroll_to){
				   current_pos += 10
				   window.scrollTo(0,current_pos)
			   }else{
				   clearInterval(scroll_interval)
			   }
			   
		   }, 7)
		   
		   
		}		
				
	}
	
}, false)




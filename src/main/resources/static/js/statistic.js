
var nbr_visitors = document.querySelector(".nbr_all_visites")
var nbr_visitors_client = document.querySelector(".nbr_client_visites")
var percent_visitors_client = document.querySelector(".percent_client_visites")
var nbr_visitors_agent = document.querySelector(".nbr_agent_visites")
var percent_visitors_agent = document.querySelector(".percent_agent_visites")
var nbr_visitors_opertors = document.querySelector(".nbr_operator_visites")
var percent_visitors_opertors = document.querySelector(".percent_operator_visites")

var xhr = new XMLHttpRequest()
xhr.open("GET","http://localhost:8080/statistcs",true);
xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
xhr.send()

xhr.onreadystatechange=function(){
	
	if (xhr.readyState==4 && xhr.status==200){	
		
		r = JSON.parse(xhr.responseText);
		console.log(r)
		
		nbr_visitors.innerHTML = r.nbr_all_website_visites
		nbr_visitors_client.innerHTML = r.nbr_client_website_visites
		percent_visitors_client.innerHTML = r.percent_client_website_visites
		nbr_visitors_agent.innerHTML = r.nbr_agent_website_visites
		percent_visitors_agent.innerHTML = r.percent_agent_website_visites
		nbr_visitors_opertors.innerHTML = r.nbr_operator_website_visites
		percent_visitors_opertors.innerHTML = r.percent_operator_website_visites
		
		console.log(r)
		
		var cl_m = r.nbr_all_visites_website_by_clients_mounths
		var ag_m = r.nbr_all_visites_website_by_agents_mounths
		var op_m = r.nbr_all_visites_website_by_operators_mounths
			
		var ctx = document.getElementById("visitors_nbr_chart")
		ctx.height = 300;
		
		var myChart = new Chart(ctx, {
		    type: 'line',
		    data: {
		        labels: ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"],
		        datasets: [{
		            label: 'Clients',
		            data: [
		            	cl_m.January, 
		            	cl_m.February,
		            	cl_m.March,
		            	cl_m.April,
		            	cl_m.May,
		            	cl_m.June,
		            	cl_m.July,
		            	cl_m.August,
		            	cl_m.September,
		            	cl_m.October,
		            	cl_m.November,
		            	cl_m.December,
		            	],
		            backgroundColor: [
		            	'rgba(0, 0, 0, 0)'
		            ],
		            borderColor: [
		            	'rgb(32, 169, 140)'
		            ],
		            borderWidth: 1
		        },
		        
		        {
		            label: 'Agents',
		            data: [
		            	ag_m.January, 
		            	ag_m.February,
		            	ag_m.March,
		            	ag_m.April,
		            	ag_m.May,
		            	ag_m.June,
		            	ag_m.July,
		            	ag_m.August,
		            	ag_m.September,
		            	ag_m.October,
		            	ag_m.November,
		            	ag_m.December,
		            	],
		            backgroundColor: [
		            	'rgba(0, 0, 0, 0)'
		            ],
		            borderColor: [
		            	'rgb(175, 30, 64)'
		            ],
		            borderWidth: 1
		        },
		        
		        {
		            label: 'Operators',
		            data: [
		            	op_m.January, 
		            	op_m.February,
		            	op_m.March,
		            	op_m.April,
		            	op_m.May,
		            	op_m.June,
		            	op_m.July,
		            	op_m.August,
		            	op_m.September,
		            	op_m.October,
		            	op_m.November,
		            	op_m.December,
		            	],
		            backgroundColor: [
		            	'rgba(0, 0, 0, 0)'
		            ],
		            borderColor: [
		            	'rgb(79, 102, 191)'
		            ],
		            borderWidth: 1
		        }
		        
		        ]
		    },
		    options: {
		    	maintainAspectRatio: false,
		        scales: {
		            yAxes: [{
		                ticks: {
		                    beginAtZero:true
		                }
		            }]
		        }
		    }
		});
		
		var ctx1 = document.getElementById("client_appointements_stats")
		ctx1.height = 200;
				
		var myChart = new Chart(ctx1, {
		    type: 'pie',
		    data: {
		        labels: [
			    	"Canceled " + (r.nbr_appointement_canceled_by_clients/r.nbr_all_appoi * 100).toFixed(2) + " %",
			    	"Confirmed " + (r.nbr_appointement_confirmed_by_clients/r.nbr_all_appoi * 100).toFixed(2) + " %",
			    	"Waiting " + (r.nbr_appointement_waiting_clients/r.nbr_all_appoi * 100).toFixed(2)+ " %",
			    	"Reported "+ (r.nbr_appointement_reported_by_clients/r.nbr_all_appoi * 100).toFixed(2) + " %"
			    	],
		        datasets: [
		        	{
		            data: [
		            		r.nbr_appointement_canceled_by_clients,
		            		r.nbr_appointement_confirmed_by_clients,
		            		r.nbr_appointement_waiting_clients,
		            		r.nbr_appointement_reported_by_clients,
		            	],
		            backgroundColor: [
		            	'rgb(249, 40, 78)',
		            	'rgb(10, 219, 187)',
		            	'rgb(255, 202, 66)',
		            	'rgb(182, 55, 203)'
		            ]
		        }
		        ]
		    },
		    options: {
		    	maintainAspectRatio: false,
		        scales: {
		            yAxes: [{
		                ticks: {
		                    beginAtZero:true
		                }
		            }]
		        }
		    }
		});
		
		
		var ctx2 = document.getElementById("agent_appointements_stats")
		ctx2.height = 200;
				
		var myChart = new Chart(ctx2, {
		    type: 'pie',
		    data: {
		        labels: [
			    	"Canceled " + (r.nbr_appointement_canceled_by_agents/r.nbr_all_appoi * 100).toFixed(2) + " %",
			    	"Confirmed " + (r.nbr_appointement_confirmed_by_agents/r.nbr_all_appoi * 100).toFixed(2) + " %",
			    	"Waiting " + (r.nbr_appointement_waiting_agents/r.nbr_all_appoi * 100).toFixed(2)+ " %",
			    	"Reported "+ (r.nbr_appointement_reported_by_agents/r.nbr_all_appoi * 100).toFixed(2) + " %"
			    	],
		        datasets: [
		        	{
		            data: [
		            		r.nbr_appointement_canceled_by_agents,
		            		r.nbr_appointement_confirmed_by_agents,
		            		r.nbr_appointement_waiting_agents,
		            		r.nbr_appointement_reported_by_agents,
		            	],
		            backgroundColor: [
		            	'rgb(249, 40, 78)',
		            	'rgb(10, 219, 187)',
		            	'rgb(255, 202, 66)',
		            	'rgb(182, 55, 203)'
		            ]
		        }
		        ]
		    },
		    options: {
		    	maintainAspectRatio: false,
		        scales: {
		            yAxes: [{
		                ticks: {
		                    beginAtZero:true
		                }
		            }]
		        }
		    }
		});
		
		var ctx3 = document.getElementById("global_appointements_stats")
		ctx3.height = 200;

		var myChart = new Chart(ctx3, {
		    type: 'bar',
		    data: {
		        labels:[
			    	"Canceled " + (r.nbr_appointement_canceled / r.nbr_all_appoi * 100).toFixed(2)   + " %",
			    	"Confirmed " + (r.nbr_appointement_confirmed / r.nbr_all_appoi * 100).toFixed(2) + " %",
			    	"Waiting " + (( r.nbr_appointement_waiting_agents + 1 ) /r.nbr_all_appoi * 100).toFixed(2) + " %",
			    	"Reported "+ (r.nbr_appointement_reported/r.nbr_all_appoi * 100).toFixed(2) + " %"
			    	],
		        datasets: [
		        	{
		            data: [
		            		r.nbr_appointement_canceled,
		            		r.nbr_appointement_confirmed,
		            		( r.nbr_appointement_waiting_agents + r.nbr_appointement_waiting_clients ),
		            		r.nbr_appointement_reported,
		            	],
		            backgroundColor: [
		            	'rgb(249, 40, 78)',
		            	'rgb(10, 219, 187)',
		            	'rgb(255, 202, 66)',
		            	'rgb(182, 55, 203)'
		            ]
		        }
		        ]
		    },
		    options: {
		    	maintainAspectRatio: false,
		        scales: {
		            yAxes: [{
		                ticks: {
		                    beginAtZero:true
		                }
		            }]
		        }
		    }
		});
		
		
		var ctx3 = document.getElementById("type_appointements_stats")
		ctx3.height = 200;

		var myChart = new Chart(ctx3, {
		    type: 'bar',
		    data: {
		        labels:[
			    	"F1 " + (r.nbr_appoi_F1 / r.nbr_all_appoi * 100).toFixed(2)   + " %",
			    	"F2 " + (r.nbr_appoi_F2 / r.nbr_all_appoi * 100).toFixed(2) + " %",
			    	"F3 " + ( r.nbr_appoi_F3 / r.nbr_all_appoi * 100).toFixed(2) + " %",
			    	"F4 "+ (r.nbr_appoi_F4 / r.nbr_all_appoi * 100).toFixed(2) + " %",
			    	"F5 "+ (r.nbr_appoi_F5 / r.nbr_all_appoi * 100).toFixed(2) + " %"
			    	],
		        datasets: [
		        	{
		            data: [
		            		r.nbr_appoi_F1,
		            		r.nbr_appoi_F2,
		            		r.nbr_appoi_F3,
		            		r.nbr_appoi_F4,
		            		r.nbr_appoi_F5,
		            	],
		            backgroundColor: [
		            	'rgb(249, 40, 78)',
		            	'rgb(10, 219, 187)',
		            	'rgb(255, 159, 7)',
		            	'rgb(182, 55, 203)',
		            	'rgb(13, 217, 255)'
		            ]
		        }
		        ]
		    },
		    options: {
		    	maintainAspectRatio: false,
		        scales: {
		            yAxes: [{
		                ticks: {
		                    beginAtZero:true
		                }
		            }]
		        }
		    }
		});
		
		
		
		var ctx3 = document.getElementById("locale_appointements_stats")
		ctx3.height = 200;

		var myChart = new Chart(ctx3, {
		    type: 'bar',
		    data: {
		        labels:[
			    	"locale 1 " + (r.nbr_appoi_locale_one / r.nbr_all_appoi * 100).toFixed(2) + " %",
			    	"locale 2 " + (r.nbr_appoi_locale_two / r.nbr_all_appoi * 100).toFixed(2) + " %",
			    	"locale 3 " + (r.nbr_appoi_locale_three / r.nbr_all_appoi * 100).toFixed(2) + " %",
			    	"locale 4 " + (r.nbr_appoi_locale_four / r.nbr_all_appoi * 100).toFixed(2) + " %",
			    	"locale 5 " + (r.nbr_appoi_locale_five / r.nbr_all_appoi * 100).toFixed(2) + " %"
			    	],
		        datasets: [
		        	{
		            data: [
		            		r.nbr_appoi_locale_one,
		            		r.nbr_appoi_locale_two,
		            		r.nbr_appoi_locale_three,
		            		r.nbr_appoi_locale_four,
		            		r.nbr_appoi_locale_five
		            	],
		            backgroundColor: [
		            	'rgb(249, 40, 78)',
		            	'rgb(10, 219, 187)',
		            	'rgb(255, 159, 7)',
		            	'rgb(182, 55, 203)',
		            	'rgb(13, 217, 255)'
		            ]
		        }
		        ]
		    },
		    options: {
		    	maintainAspectRatio: false,
		        scales: {
		            yAxes: [{
		                ticks: {
		                    beginAtZero:true
		                }
		            }]
		        }
		    }
		});
		
	}// xhr response end
	
}

//setInterval(function(){
//	xhr.open("GET","http://localhost:8080/statistcs",true);
//	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
//	xhr.send()
//
//	xhr.onreadystatechange=function(){
//		
//		if (xhr.readyState==4 && xhr.status==200){	
//			
//			r = JSON.parse(xhr.responseText);
//			console.log(r)
//			
//			nbr_visitors.innerHTML = r.nbr_all_website_visites
//			nbr_visitors_client.innerHTML = r.nbr_client_website_visites
//			percent_visitors_client.innerHTML = r.percent_client_website_visites
//			nbr_visitors_agent.innerHTML = r.nbr_agent_website_visites
//			percent_visitors_agent.innerHTML = r.percent_agent_website_visites
//			nbr_visitors_opertors.innerHTML = r.nbr_operator_website_visites
//			percent_visitors_opertors.innerHTML = r.percent_operator_website_visites
//			
//		}
//	}
//
//}, 1000)

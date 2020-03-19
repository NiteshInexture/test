var psw;
var letters =new RegExp("/[0-9]+/") ;
$(document).ready(function(){
	document.getElementById('dt').max = new Date(new Date().getTime() - new Date().getTimezoneOffset() * 60000).toISOString().split("T")[0];
	
	$("[name=reset]").click(function(){
		$("#prev-image").css("display","none");
	})
	
	$(".inputVal").keypress(function( e ){
		if( e.which === 32 ){
			return false;
		}
	});
	$('form#form1').on('submit', function(event) {
		input = $("#checkBoxValues").val();
		if(input == "")
			$("#languageknown").html("LanguageKnown is Required");
	});
});
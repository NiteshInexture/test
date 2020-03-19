var flag=false;
var psw;
$(document).ready(function(){
	document.getElementById('dt').max = new Date(new Date().getTime() - new Date().getTimezoneOffset() * 60000).toISOString().split("T")[0];
	
	$("input").keypress(function( e ){
		if( e.which === 32 ){
			return false;
		}
	});
	$("#firstname").blur(function() {
		$("#firstname").firstName();
	});
	$("[name=last_name]").blur(function() {
		$("[name=last_name]").lastName();
	});
	$("[name=psw]").blur(function() {
		$("[name=psw]").password();
	});
	
	$("[name=file_To_Upload]").change(function(){
		$("[name=file_To_Upload]").fileCheck();
	});
	
	$("[name=phone_no]").blur(function(){
		$("[name=phone_no]").phoneNo();
	});
	
	$('form#form1').on('submit', function(event) {
		$("#firstname").firstName();
		$("[name=last_name]").lastName();
		$("[name=psw]").password();
		$("[name=file_To_Upload]").fileCheck();
	});
	
	$(document).on("submit", ".address" , function() {
		var regex=new RegExp("\d{1,5}\s\w.\s(\b\w*\b\s){1,2}\w*\.");
		if(regex.test($(this.val()))){
			flag=true;			
		}else{
			flag=false;
			$(this).siblings("lable").text("address Sould Not Contain Special Character's");
		}
    });
	
	$(document).on("submit", ".citySelect" , function() {
		if($(this).val()==""){
			$(this).parent().append('<br><span class="text-danger">Select City</span>')
		}
    });
	$(document).on("submit", ".countrySelect" , function() {
		if($(this).val()==""){
			$(this).parent().append('<br><span class="text-danger">Select Country</span>')
		}
    });
	$(document).on("submit", ".stateSelect" , function() {
		if($(this).val()==""){
			$(this).parent().append('<br><span class="text-danger">Select State</span>')
		}
    });
	
	$.fn.firstName = function () {
		if($(this).val() == ""){
			flag=false
			}
		else if(onlyAlpha($(this))){
			$("#first_name").text("Enter Only AlphaBets");
			flag = false;
		}
		else{
			flag=true;
			$("#first_name").text("");
		}
	};

	$.fn.lastName = function () {
		if($(this).val() == ""){
			flag=false;
			}
		else if(onlyAlpha($(this))){
			$("#last_name").text("Enter Only Alphabets");
			flag = false;
		}
		else{
			flag=true;
			$("#last_name").text("");
		}
	};
	$.fn.password = function () {
		var regex=new RegExp("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})");
		if($(this).val() == ""){
		} else if((regex.test($(this).val()))){
			$("#psw").text("");
		} else {
			$("#psw").text("password Sould Contains 1 small Char. , 1 capital Char., 1 Numeric char....,1 special Char(@,#,$,%)	");
		}
	};
	$.fn.fileCheck = function () {
		var file = $("[name=file_To_Upload]").val();
		var ext = file.substr( file.lastIndexOf('.') +1) ;
		if(file == ""){
			 $("#file_To_Upload").text("File Is Required");
		}
		else if (ext != "png" && ext != "jpeg" && ext != "gif") {
		     $("#file_To_Upload").text("File Type must be gif,jpeg,png");
		     flag=false;			
		} else {
			 flag=true;		
			 $("#file_To_Upload").text("");
		}
	};
	function onlyAlpha(name){
		var letters = /^[A-Za-z]+$/;
		if(!(name.val().match(letters)))
			return true;
	    else
	    	return false;
	}
	function changeFlag(){
		if(flag == true){
			$("#insertData").removeAttr("disabled");
		}else{
			$("#insertData").attr('disabled', 'disabled');
		}
	}
});
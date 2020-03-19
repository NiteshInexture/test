//$("#form1").validate();

$().ready(function(){
	var FileRegExp=/(jpg|jpeg|png)$/i;
	$("#fileToUpload").change(function(e){
		if($("#file_To_Upload").text()!=""){
			$("#file_To_Upload").hide();
		}
		var ext = $(this).val().split('.').pop();
		var boolvar=FileRegExp.test(ext);
		if(!(boolvar) && $("#fileToUpload-error").length == 0){
			$("#file_To_Upload").text("File Type Must Be Jpg,Jpeg,Png");
			return false;
		}else if(!(boolvar) && $("#fileToUpload-error").length == 1 ){
			$("#fileToUpload-error").text("File Type Must Be Jpg,Jpeg,Png");
			return false;
		}
		else{
			$("#file_To_Upload").text("");
			 var fileName = e. target. files[0]. name;
		        var oFReader = new FileReader();
		        oFReader.readAsDataURL(document.getElementById("fileToUpload").files[0]);
		        oFReader.onload = function (oFREvent) {
		            document.getElementById("prev-image").src = oFREvent.target.result;
		            $("#prev-image").css("display","inline-block");
		        };
		            if(fileName == "")
		            	$("#checkNewOld").val("old");
		            else
		            	$("#checkNewOld").val("new");
			return true;
		}
	});
	
	jQuery.validator.addMethod("lettersonly", function(value, element) {
		return this.optional(element) || /^[a-z\s]+$/i.test(value);
		}, "Only alphabetical characters");
	
	jQuery.validator.addMethod("twoAlpha", function(value, element) {
		return this.optional(element) || /(.*[a-z]){2}/i.test(value);
		}, "Atleast 2 Characters");
	
	jQuery.validator.addMethod("noSpecialChar", function(value, element) {
		return this.optional(element) || /^[a-zA-Z0-9\-\/]+$/.test( value );
		}, "No Special Char Char Allow Only(-,/)");
	
	jQuery.validator.addMethod("passwordValid", function(value, element) {
		return this.optional(element) || /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[#$^+=!*()@%&]).{8,}$/g.test( value );
		}, "Atleast 1 special char, 1 small, 1 Caplital Alphabet");
	
	jQuery.validator.addMethod("validEmail", function(value, element) {
		return this.optional(element) || /^([a-zA-Z0-9_\-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{1,5}|[0-9]{1,3})(\]?)$/.test(value);
		}, "Not A Valid Email Format");
	
	jQuery.validator.addMethod("validFile", function(value, element) {
			$("#file_To_Upload").hide();
		return this.optional(element) || /\.(jpg|jpeg|png)$/i.test(value);
		}, "File Type Must Be Jpg,Jpeg,Png");
	
	jQuery.validator.addMethod("validSize", function(value, element) {
		var boolvar=false;
		if(value != null || value == ""){
			var file_size = $("#fileToUpload")[0].files[0].size;
			boolvar=false;
			if(file_size > 4194304) { boolvar=false; } else { boolvar=true;	}
		}
		return this.optional(element) || boolvar;
		}, "File Size Smaller Then 4Mb");
	
	jQuery.validator.addMethod("selectCheckbox", function(value, element) {
		var boolvar=false;
		if(value == ""){ boolvar=false; } else { boolvar=true; } return this.optional(element) || boolvar;
		}, "Select Language Known");
	
	
	 $("input[type=checkbox]").click(function(){
         var favorite = [];
         $.each($("input[type=checkbox]:checked"), function(){
             favorite.push($(this).val());
         });
         if(favorite.length > 0){
        	 $("#languageknown").text("");
         }else{
        	 $("#languageknown").text("Select Language Known");
         }
         $("#checkBoxValues").val(favorite.join(", "));
     });
	 
	$('form#form1').on('submit', function(event) {
        //Add validation rule for dynamically generated name fields
	    $('.address').each(function() {
	        $(this).rules("add", 
	            {	
	                required: true,
	                minlength : 2,
	                messages: {
	                    required: "Address is required"
	                }
	            });
	    });
	    
	    $('.countrySelect').each(function() {
	        $(this).rules("add", 
	            {
	                required: true,
	                messages: {
	                    required: "country is required"
	                }
	            });
	    });
	    
	    
	    $('.citySelect').each(function() {
	        $(this).rules("add", 
	            {
	                required: true,
	                messages: {
	                    required: "city is required"
	                }
	            });
	    });
	    $('.stateSelect').each(function() {
	        $(this).rules("add", 
	            {
	                required: true,
	                messages: {
	                    required: "state is required"
	                }
	            });
	    });
	    $("#counter").val(opType);
	    $("#delCounter").val(delArray);
	    $("#updCounter").val(updType);
	});
	
	$('#form1').validate({
		errorClass : "has-error",
		rules : {
			first_name: { 
				required : true, 
				minlength : 2,
				lettersonly: true,
				twoAlpha :true
				},
			last_name : { 
				required : true,
				minlength : 2, 
				lettersonly: true
				},
			psw : { 
				required : true,
				minlength : 8,
				maxlength : 13,
				passwordValid : true
				},
			psw_repeat : { 
				required :true,
				equalTo : "#psword"
				},
			languageKnown : {
				selectCheckbox : true
				},	
			dob : {
				required : true
			},
			file_To_Upload : {
				required : true,
				validFile : true,
				validSize : true
			},
			phone_no : {
				required : true,
				digits : true,
				minlength: 10,
				maxlength:11
			},
			email : {
				required : true,
				validEmail:true
			}
		},
		messages:{
			first_name : { 
				required : "First Name is Required", 
				minlength: "length bigger then 2 char",
					},
			last_name : { 
				required : "Last Name is Required", 
				minlength: "length bigger then 2 char",
					},
			psw : { 
				required : "password is Required" ,
				},
			psw_repeat : {
				required : "Confirm Password is Required",
				equalTo : "Confirm Password Must Be same"
				},
			dob : {
				required : "DOB is Required"
			},
			phone_no:{
				required : "Phone Number Is Required",
				digits : "Enter Only Digits"
			},
			email : {
				required : "Email Is Required",
				email : "Enter A valid Email Address"
			}
		}
	});
});
	
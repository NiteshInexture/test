//$("#form1").validate();

$().ready(function(){
	 $("input[type=checkbox]").click(function(){
         var favorite = [];
         $.each($("input[type=checkbox]:checked"), function(){
             favorite.push($(this).val());
         });
         $("#checkBoxValues").val(favorite.join(", "));
     });
	$('form#form1').on('submit', function(event) {
        //Add validation rule for dynamically generated name fields
	    $('.address').each(function() {
	        $(this).rules("add", 
	            {
	                required: true,
	                messages: {
	                	length : 10,
	                	maxlength : 200,
	                    required: "Address is required"
	                }
	            });
	    });
	    
	    $("#counter").val(opType);
	    $("#delCounter").val(delArray);
	    $("#updCounter").val(updType);
	});
	
	$('#form1').validate({
		errorClass : "text-danger",
		rules : {
			first_name: { 
				required : true, 
				minlength : 2, 
				},
			last_name : { 
				required : true,
				minlength : 2, 
				},
			address : {
				required : true,
				minlength : 5
				},
			psw : { 
				required : true,
				minlength : 8,
				},
			psw_repeat : { 
				required :true,
				equalTo : "#psword"
				},
			dob : {
				required : true
			},
			phone_no : {
				required : true,
				digits : true
			},
			email : {
				required : true,
				email : true
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
			address : {
				required : "Address is Required" ,
				minlength : "min 5 Characters"
					},
			psw : { 
				required : "password is Required" ,
				minlength : "Atleast 8 characters" , 
				},
			psw_repeat : {
				required : "Confirm Password is Required",
				equalTo : "Confirm Password Must Be same"
				},
			dob : {
				required : "DOB is Required"
			},
			file_To_Upload : {
				required : "Image Is Required"
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
	
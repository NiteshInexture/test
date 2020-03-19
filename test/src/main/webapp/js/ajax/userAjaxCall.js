var exp=/^([a-zA-Z0-9_\-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{1,5}|[0-9]{1,3})(\]?)$/;
$(document).ready(function() {
		$('#emailAddress').keyup(function(event) {
			if(exp.test($(this).val())){
				var name = $(this).val();
                $.get('CheckEmailExist', {
                        email : name
                }, function(responseText) {
                		if(responseText == "" ){
                			$("#email").text("");
                			$("#insertData").removeAttr("disabled",'true')
                		}
                		else{ 
                			$("#email").text(responseText);
                			$("#insertData").attr("disabled",'false');
                		}
                });
			}
		});
});
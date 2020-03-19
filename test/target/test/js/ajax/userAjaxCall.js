$(document).ready(function() {
        $('#emailAddress').change(function(event) {
                var name = $(this).val();
                $.get('CheckEmailExist', {
                        email : name
                }, function(responseText) {
                		if(responseText == "" )
                			$("#email").text("");
                		else 
                			$("#email").text(responseText);
                });
        });
});
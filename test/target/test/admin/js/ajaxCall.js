$(document).ready(function(){
		getData();
		$(document).on("click",".deleteData",function(){
			if(confirm('Are you sure you want to delete?')){
				var id=$(this).val();
				$.ajax({
				url : '../Delete',
				data : {
					delete : id
				},
				success : function(responseText) {
					
					getData();
				},
				error : function(responseText) {
					
					console.log("error");
				}
			});	
			}else
				return false;
		});
		function getData(){
			$("#example").DataTable().clear();
			$.ajax({
				url : '../AjaxServlet',
				success : function(responseText) {
					if(responseText!=null){
						
						var table=$("#example tbody");
						$.each(responseText,function(key,value){
							$("#example").DataTable().row.add([value['registerId'],
								value['firstName'],
								value['lastName'],
								value['email'],
								value['gender'],
								value['languageKnown'],
								value['phoneNo'],
								value['dob'],
								'<img src="data:image/jpg;base64,'+ value['base64Image'] +'" alt="no Image" width="75" height="75" class="mb-1"/>',
								'<button id="delete" class="deleteData" name="delete" value="' + value['registerId'] + '">Delete</button>',
								'<a href="../UserHome?id='+value['registerId']+'">Edit</a>'
								]).draw(true);
						});
					}
				},
				error : function(responseText) {
					console.log("error");
				}
			});	
		};
		
	});
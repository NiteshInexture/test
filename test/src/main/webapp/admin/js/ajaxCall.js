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
		$(document).on("click",".editData",function(){
				var id=$(this).val();
				$.ajax({
				url : '../Edit',
				data : {
					edit : id
				},
				success : function(responseText) {
					window.location = "../UserForm.jsp";
				},
				error : function(responseText) {
					
					console.log("error");
				}
			});	
		});
		function getData(){
			$("#example").DataTable({order:[[1,"asc"]]}).clear();
			$.ajax({
				url : '../AjaxServlet',
				success : function(responseText) {
					if(responseText!=null){
						
						var table=$("#example tbody");
						$.each(responseText,function(key,value){
							const d=new Date(value["dob"]);
							const ye = new Intl.DateTimeFormat('en', { year: 'numeric' }).format(d);
							const mo = new Intl.DateTimeFormat('en', { month: '2-digit' }).format(d);
							const da = new Intl.DateTimeFormat('en', { day: '2-digit' }).format(d);
							var val= da+ "-"+mo+ "-" +ye;
							$("#example").DataTable().row.add([
								"<input type='hidden' name='edit' value="+value['registerId']+">"+value['registerId'],
								value['firstName'] + " " + value['lastName'],
								value['email'],
								value['gender'],
								value['languageKnown'],
								value['phoneNo'],
								val,
								//value["dob"],
								'<img src="data:image/jpg;base64,'+ value['base64Image'] +'" alt="no Image" width="75" height="75" class="mb-1"/>',
								'<button id="delete" class="deleteData" name="delete" value="' + value['registerId'] + '">Delete</button>',
								'<button id="edit" class="editData" name="edit" value="' + value['registerId'] + '">edit</button>'
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
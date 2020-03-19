var opType=new Array();
var updType=new Array();
var delArray=new Array();
$(document).ready(function(){
	 
	$(document).ready( function(){
		getArray();
		delArray.length=0;
		delArray.splice(0,opType.length);
		
	    $('#addCount').click( function(){
	        add_inputs()
	    });

	    $(document).on("change", ".address" , function() {
	        if($(this).siblings("input").val()!="new"){
	        	$(this).siblings("input").val($(this).prop("name"));
	        	getArray();
	         }
	    });
	    
	    $(document).on("click", "span.fa-times" , function() {
	    	var delValue=$(this).siblings("input").val();
	    	if(delValue != "new")
	    		delArray.push(delValue);
	    	$(this).parent().parent().remove();
	        getArray();
	        if($(".address*").length <= 1){
	         	$(".fa-times").hide();
	         }
	      
	    });
	    
	    function add_inputs(){
	        var counter = parseInt($('#counter').val());
	        
	        var html = '<div class="row closeAddress"><div class="col-12"><span class="float-right fa fa-times"></span><input type="hidden" value="new" name="hiddenAddress" class="hiddenClassId"><textarea class="address" id="address_'+ counter +'" rows="2" name="address_'+ counter +'" maxlength="200" placeholder="Enter Address"></textarea></div><div class="col-12 col-sm-6 col-md-4">Country :   <select name="country_'+ counter +'" class="countrySelect"><option value="">Select Country</option>><option value="India">India</option><option value="Australia" >Australia</option><option value="America">America</option><option value="SouthAfrica">South Africa</option><option value="China">China</option></select></div><div class="col-12 col-sm-6 col-md-4">State :   <select name="state_'+ counter +'" class="stateSelect"><option value="">Select State</option><option value="Gujarat">Gujarat</option><option value="Rajasthan">Rajasthan</option><option value="Utter Pradesh">Utter Pradesh</option><option value="Delhi">Delhi</option><option value="Maharashtra">Maharashtra</option></select></div><div class="col-12 col-sm-6 col-md-4">City :  <select name="city_'+counter+'" class="citySelect"><option value="">Select City</option><option value="Surat">Surat</option><option value="Navsari">Navsari</option><option value="Bharuch">Bharuch</option><option value="Rajkot">Rajkot</option><option value="Ahmedabad">Ahmedabad</option></select></div><span class="text-danger d-block addre"  id="address"></span></div>';
		    $('#rep_address .container-fluid').append(html);
			$('#counter').val( counter + 1 );
			  if($(".address*").length > 1){
		         	$(".fa-times").show();
		         }
			getArray();
		}
	    function getArray(){
			opType.length=0;
			updType.length=0;
			opType.splice(0,opType.length);
			updType.splice(0,updType.length);
			 $.each($('.hiddenClassId'), function() {
				 if($(this).val() == "new")
				   opType.push($(this).siblings("textarea").prop("name"));
				 else if($(this).val().includes("address"))
				   updType.push($(this).siblings("textarea").prop("name"));
			});
		 }
		
	    if($(".address*").length <= 1){
	     	$(".fa-times").hide();
	     }
	});
});


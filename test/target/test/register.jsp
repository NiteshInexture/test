<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1">	
        <link rel="stylesheet" href="./css/bootstrap.min.css">
        <link rel="stylesheet" href="./fonts/font-awesome-4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="./css/style3.css" type="text/css">
	</head>
	<body>
		<div class="w-100">
		
		<form name="form1" id="form1" action="InsertUpdate" enctype="multipart/form-data" method="post" class="w-100" >
		<div class="width-100 center-div">
				<c:if test="${resultSet == null }">
	                	<span class="h1">Register</span>
	                	<p>
	                		<span class="head"> fill in this form to create an account.</span>
	                	</p>
            	</c:if>
            	<hr>
                
            <c:choose>
            	<c:when test="${resultSet != null}">
            		<c:forEach items="${resultSet}" var="row">
            		
	                <label for="first_name">
	                    <b>First Name</b>
	                    <span id="req">*</span>
	                </label>
	                <input type="hidden" name="userId" value="${row.registerId}"> 
	                <input value="${row.firstName}" type="text" maxlength="30" class="d-block" 
	                	placeholder="Enter First Name" id="firstname" name="first_name">
	                <span class="text-danger d-block" id="first_name"></span>
	                
	                <label for="last_name">
	                    <b>Last Name</b>
	                    <span id="req">*</span>
	                </label>
	                <input value="${row.lastName}" type="text" maxlength="20" 
	                	placeholder="Enter Last Name" name="last_name" onblur="" >
	                <span class="text-danger d-block" id="last_name"></span>
	
							<label for="address">
				                    <b>Address</b>
				                    <span id="req">*</span>
				                </label>
				                <div id="rep_address">
							                <div class="container-fluid">
							                	<c:set var="countAdd" value="0"/>
											<c:forEach items="${resultSetAddress}" var="rows">
												
						                    	<div class="row closeAddress">
							                		
								                		<div class="col-12">
								                			<span class="float-right fa fa-times"></span>
								                			<input type="hidden" value="${rows.addressId }" name="hiddenAddress" class="hiddenClassId">
									                  		<textarea class="address" id="address_${rows.addressId}" rows="2" name="address_${rows.addressId}" maxlength="200" placeholder="Enter Address"><c:out value="${rows.singleAddress}"/></textarea>
									                  	</div>
									                  	<div class="col-12 col-sm-6 col-md-4">
									                  		Country :   <select name="country_${rows.addressId }">
									                  		
												            	<option value="India" <c:if test="${rows.singleCountryName == 'India' }">selected</c:if>>India</option>
												            	<option value="Australia" <c:if test="${rows.singleCountryName == 'Australia' }">selected</c:if>>Australia</option>
												            	<option value="America" <c:if test="${rows.singleCountryName == 'America' }">selected</c:if>>America</option>
												            	<option value="SouthAfrica" <c:if test="${rows.singleCountryName == 'SouthAfrica' }">selected</c:if>>South Africa</option>
												            	<option value="China" <c:if test="${rows.singleCountryName == 'China' }">selected</c:if>>China</option>
												        </select>
									                  	</div>							                  	
									                  	<div class="col-12 col-sm-6 col-md-4">
									                  		State :   <select name="state_${rows.addressId }">
									                  		
									                  			<option value="Gujarat" <c:if test="${rows.singleStateName == 'Gujarat' }">selected</c:if>>Gujarat</option>
												            	<option value="Rajasthan" <c:if test="${rows.singleStateName == 'Rajasthan' }">selected</c:if>>Rajasthan</option>
												            	<option value="Utter Pradesh" <c:if test="${rows.singleStateName == 'Utter Pradesh' }">selected</c:if>>Utter Pradesh</option>
												            	<option value="Delhi" <c:if test="${rows.singleStateName == 'Delhi' }">selected</c:if>>Delhi</option>
												            	<option value="Maharashtra" <c:if test="${rows.singleStateName == 'Maharashtra' }">selected</c:if>>Maharashtra</option>
												        </select>
												        
									                  	</div>
									                  	
									                  	<div class="col-12 col-sm-6 col-md-4">
									                  		City :  <select name="city_${rows.addressId }">
									                  		
									                  			<option value="Surat" <c:if test="${rows.singleCityName == 'Surat' }">selected</c:if>>Surat</option>
												            	<option value="Navsari" <c:if test="${rows.singleCityName == 'Navsari' }">selected</c:if>>Navsari</option>
												            	<option value="Bharuch" <c:if test="${rows.singleCityName == 'Bharuch' }">selected</c:if>>Bharuch</option>
												            	<option value="Rajkot" <c:if test="${rows.singleCityName == 'Rajkot' }">selected</c:if>>Rajkot</option>
												            	<option value="Ahmedabad" <c:if test="${rows.singleCityName == 'Ahmedabad' }">selected</c:if>>Ahmedabad</option>
												        	</select>
									                  	</div>
								                  	<span class="text-danger d-block addre"  id="address"></span>
											      </div>
											      <c:set var="countAdd" value="${ countAdd + 1 }"></c:set>
							    				</c:forEach>
							                </div>
							            </div>
						              <input type="hidden" id="counter" name="counter" value="1">
						              <input type="hidden" id="delCounter" name="delCounter" value="">
						              <input type="hidden" id="updCounter" name="updCounter" value="">
								  <span id="addCount">Add more Address</span><br>
	                <label for="psw">
	                    <b>Password</b>
	                    <span id="req">*</span>
	                </label>
	                <input value="${row.password }" type="password" maxlength="13" id="psword" placeholder="Enter Password" name="psw" >
	                <span class="text-danger d-block" id="psw"></span>
	            
	                <label for="psw-repeat">
	                    <b>Repeat Password</b>
	                    <span id="req">*</span>
	                </label>
	                <input value="${row.password }" type="password" maxlength="13" placeholder="Repeat Password" name="psw_repeat" >
	                <span class="text-danger d-block" id="psw_repeat"></span>
	               
	                
	                <label for="gender">
	                    <b>Gender</b>
	                    <span id="req">*</span>
	                </label><br>
	                <div class="">
	                    <input type="radio" name="gender" value="male" <c:if test="${row.gender == 'male' }">checked</c:if>> Male
	                    <input type="radio" name="gender" value="female" <c:if test="${row.gender == 'female' }">checked</c:if>> Female
	                 </div>
	                 <span class="text-danger d-block" id="gender"></span>
	                
	                <label for="longuageKnown">
	                    <b>Language Known</b>
	                    <span id="req">*</span>
	                </label><br>
	                <div class="">
	                	<input type="hidden" name="checkBoxValues" id="checkBoxValues" value="">
	                    <input type="checkbox" name="languageKnown" value="hindi" 
	                    <c:if test="${fn:contains(row.languageKnown, 'hindi')}">checked</c:if>> Hindi
	                    <input type="checkbox" name="langaugeKnown" value="gujrati"
	                    <c:if test="${fn:contains(row.languageKnown, 'gujrati')}">checked</c:if>> Gujrati
	                    <input type="checkbox" name="langaugeKnown" value="english"
	                     <c:if test="${fn:contains(row.languageKnown, 'english')}">checked</c:if>> English
	                 </div>
	                 
	                 <span class="text-danger d-block" id="gender"></span>
	                <br>
	                
	                <label for="dob">
	                    <b>DOB</b>
	                    <span id="req">*</span>
	                </label>
                    <input class="ml-4" value="${row.dob }" type="date" id="dt" min='1950-01-01' name="dob">
                	<br>
	                 
	                 <span class="text-danger d-block" id="dob"></span>
	                
	                
	                <label for="yourimage">
	                    <b>YourImage</b>
	                    <span id="req">*</span>
	                </label>
	                <img src="data:image/jpg;base64,${row.base64Image}" alt="no Image" width="75" height="75" class="mb-1"/>
	                <img id="prev-image" alt="no Image" width="75" height="75" class="mb-1"/>
	                <input type="hidden" value="old" id="checkNewOld" name="checkNewOld">
	                <input type="file" value="${row.image }" class="ml-4" name="file_To_Upload" id="fileToUpload" accept=".jpg, .jpeg, .png"><br>
	                <span class="text-danger d-block" id="file_To_Upload"></span>
	
	                <label for="phone_no">
	                    <b>Phone No</b>
	                    <span id="req">*</span>
	                </label>
	                <input value="${row.phoneNo }" type="tel" placeholder="Enter Phone No" name="phone_no">
	                <span class="text-danger d-block" id="phone_no"></span>
	
	                <label for="email">
	                    <b>Email</b>
	                    <span id="req">*</span>
	                </label>
	                <input value="${row.email }" type="email" maxlength="30" placeholder="Enter Email" name="email" id="emailAddress">
	                <span class="text-danger d-block" id="email"></span>
	                <hr>
	                
				 </c:forEach>

				 <button type="submit" class="registerbtn registerbtn1" formaction="Update" value="Update">Update</button>
				 <button type="submit" class="registerbtn" formaction="UserHome" formmethod="get" value="Cancel">Cancel</button>

            	</c:when>
            	<c:otherwise>
  	                <label for="first_name">
	                    <b>First Name</b>
	                    <span id="req">*</span>
	                </label>
	                <input type="text" maxlength="30" class="d-block" placeholder="Enter First Name" id="firstname" name="first_name">
	                <span class="text-danger d-block" id="first_name"></span>
	                
	                <label for="last_name">
	                    <b>Last Name</b>
	                    <span id="req">*</span>
	                </label>
	                <input type="text" maxlength="20" placeholder="Enter Last Name" name="last_name" >
	                <span class="text-danger d-block" id="last_name"></span>
	
	
					<label for="address">
	                    <b>Address</b>
	                    <span id="req">*</span>
	                </label>
	                <div id="rep_address">
		                <div class="container-fluid">
		                	<input type="hidden" name="counter" id="counter" value="1">
		                	    <div class="row closeAddress">
			                		<div class="col-12">
			                			<input type="hidden" value="new" name="hiddenAddress" class="hiddenClassId">
				                  		<textarea class="address" id="address_0" rows="2" name="address_0" maxlength="200" placeholder="Enter Address"></textarea>
				                  	</div>
				                  	<div class="col-12 col-sm-6 col-md-4">
				                  		Country :   <select name="country_0" class="countrySelect">
				                  			<option value="">Select Country</option>
							            	<option value="India">India</option>
							            	<option value="Australia" >Australia</option>
							            	<option value="America">America</option>
							            	<option value="SouthAfrica">South Africa</option>
							            	<option value="China">China</option>
							        	</select>
							        </div>						                  	
				                  	<div class="col-12 col-sm-6 col-md-4">
				                  		State :   <select name="state_0" class="stateSelect">
				                  			<option value="">Select State</option>
							            	<option value="Gujarat">Gujarat</option>
							            	<option value="Rajasthan">Rajasthan</option>
							            	<option value="Utter Pradesh">Utter Pradesh</option>
							            	<option value="Delhi">Delhi</option>
							            	<option value="Maharashtra">Maharashtra</option>
							        	</select>
				                  	</div>
				                  	
				                  	<div class="col-12 col-sm-6 col-md-4">
				                  		City :  <select name="city_0" class="citySelect">
				                  			<option value="">Select City</option>
							            	<option value="Surat">Surat</option>
							            	<option value="Navsari">Navsari</option>
							            	<option value="Bharuch">Bharuch</option>
							            	<option value="Rajkot">Rajkot</option>
							            	<option value="Ahmedabad">Ahmedabad</option>
							        	</select>
				                  	</div>
			                  	<span class="text-danger d-block addre"  id="address"></span>
						      </div>
		                </div>
		            </div>
	                <span id="addCount">Add Address</span><br>
	                        
               		<label for="psw">
	                    <b>Password</b>
	                    <span id="req">*</span>
	                </label>
	                <input type="text" maxlength="13" id="psword" placeholder="Enter Password" name="psw" >
	                <span class="text-danger d-block" id="psw"></span>
	            
	                <label for="psw-repeat">
	                    <b>Repeat Password</b>
	                    <span id="req">*</span>
	                </label>
	                <input type="password" maxlength="13" placeholder="Repeat Password" name="psw_repeat" >
	                <span class="text-danger d-block" id="psw_repeat"></span>
	               
	                
	                <label for="gender">
	                    <b>Gender</b>
	                    <span id="req">*</span>
	                </label><br>
	                <div class="">
	                    <input type="radio" name="gender" value="male" checked> Male
	                    <input type="radio" name="gender" value="female"> Female
	                 </div>
	                 <span class="text-danger d-block" id="gender"></span>
	                
	                <label for="longuageKnown">
	                    <b>Language Known</b>
	                    <span id="req">*</span>
	                </label><br>
	                <div class="">
	                	<input type="hidden" name="checkBoxValues" id="checkBoxValues" value="">
	                    <input type="checkbox" name="languageKnown" value="hindi"> Hindi
	                    <input type="checkbox" name="langaugeKnown" value="gujrati"> Gujrati
	                    <input type="checkbox" name="langaugeKnown" value="english"> English
	                 </div>
	                 
	                 <span class="text-danger d-block" id="languageknown"></span>
	                <br>
	                
	                <label for="dob">
	                    <b>DOB</b>
	                    <span id="req">*</span>
	                </label>
	                    <input class="ml-4" type="date" id="dt" min='1950-01-01' name="dob">
	                <br>
	                 
	                 <span class="text-danger d-block" id="dob"></span>
	                
	                
	                <label for="yourimage">
	                    <b>YourImage</b>
	                    <span id="req">*</span>
	                </label>
	                <img alt="no Image" id="prev-image" width="75" height="75" class="mb-1"/>
	                <input type="file" class="ml-4" name="file_To_Upload"  id="fileToUpload" accept=".jpg, .jpeg, .png"><br>
	                <span class="text-danger d-block" id="file_To_Upload"></span>
	
	                <label for="phone_no">
	                    <b>Phone No</b>
	                    <span id="req">*</span>
	                </label>
	                <input type="tel" placeholder="Enter Phone No" name="phone_no">
	                <span class="text-danger d-block" id="phone_no"></span>
	
	                <label for="email">
	                    <b>Email</b>
	                    <span id="req">*</span>
	                </label>
	                <input type="email" maxlength="30" placeholder="Enter Email" name="email" id="emailAddress">
	                <span class="text-danger d-block" id="email"></span>
	                <hr>
	                <button type="submit" class="registerbtn" id="insertData" value="insert">Register</button>
        	</c:otherwise>
            </c:choose>
				            	 
				
             </div>
             <c:if test="${ resultSet == null }">
                 <div class="container signin">
		              <p>Already have an account? <a href="login.jsp">Sign in</a>.</p>
	             </div>
	         </c:if>
        </form>
    </div>
    
	<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
	<script src="js/validate.min.js"></script>
	<script src="js/validate.js"></script>
	<script src="js/RegisterAddress.js"></script>
	<script src="js/validateRegister.js"></script>
	<script src="./js/ajax/userAjaxCall.js"></script>
	</body>
</html>
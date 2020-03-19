package com.pojo;

import java.io.IOException;
import java.io.InputStream;
import java.util.Hashtable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author Wins
 *
 */
public class RegisterPojo {
	
	private static final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,})";
	private int registerId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String confirmPassword;
	private InputStream inputStream ;
	private String gender;
	private String image;
	private String languageKnown="";
	private String phoneNo;
	private String dob;
	private String role;
	private String base64Image;
	public Hashtable<String, String> errors= new Hashtable < String, String > ();
	Pattern pattern;
	Matcher matcher;
	
	
    public String getBase64Image() {
        return base64Image;
    }
 
    public void setBase64Image(String base64Image) {
        this.base64Image = base64Image;
    }
    
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}

	public RegisterPojo() {
		pattern = Pattern.compile(PASSWORD_PATTERN);
	}
	/**
	 * 
	 * @return
	 */
	public int getRegisterId() {
		return registerId;
	}
	
	/**
	 * 
	 * @param registerId
	 */
	public void setRegisterId(int registerId) {
		this.registerId = registerId;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * 
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * 
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getConfirmPassword() {
		return confirmPassword;
	}

	/**
	 * 
	 * @param confirmPassword
	 */
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	/**
	 * 
	 * @return
	 */
	public InputStream getInputStream() {
		return inputStream;
		
	}
	
	/**
	 * 
	 * @param inputStream
	 */
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	/**
	 * 
	 * @return
	 */
	public String getGender() {
		return gender;
	}
	
	/**
	 * 
	 * @param gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getLanguageKnown() {
		return languageKnown;
	}
	
	/**
	 * 
	 * @param languageKnown
	 */
	public void setLanguageKnown(String[] languageKnown) {
		if(languageKnown != null)
			for(String value : languageKnown)
				this.languageKnown = this.languageKnown + value;
	}
	
	public void setLanguageKnown(String languageKnown) {
		this.languageKnown = languageKnown;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getPhoneNo() {
		return phoneNo;
	}
	
	/**
	 * 
	 * @param phoneNo
	 */
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getDob() {
		return dob;
	}
	
	/**
	 * 
	 * @param dob
	 */
	public void setDob(String dob) {
		this.dob = dob;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getRole() {
		return role;
	}
	
	/**
	 * 
	 * @return
	 */
	public void setRole(String role) {
		this.role = role;
	}
	
	public boolean validate() {
		
		boolean allOk=true;
	    if (firstName == "" || firstName == null) {
	      errors.put("firstName","Please enter first name");
	      firstName="";
	      allOk=false;
	    }else if(!(firstName.matches("[a-zA-Z ]+"))) {
	    	 errors.put("firstName","Only Alphabets Allowed!");
		     allOk=false;
	      }
	    else if(firstName.length() < 3) {
	    	errors.put("firstName","Length Greater Then 2 charcaters!"); 
		     allOk=false;
	      }
	    
	    if (lastName == "" || lastName == null) {
	        errors.put("lastName","Please enter your last name");
	        lastName="";
	        allOk=false;
	      } else if(!(lastName.matches("[a-zA-Z ]+"))) {
		    	 errors.put("lastName","Only Alphabets Allowed!");
			     allOk=false;
	      }
	    else if(lastName.length() < 3) {
	    	errors.put("lastName","Length Greater Then 2 charcaters!"); 
		     allOk=false;
	      }
	    if (password == "" || password == null) {
	        errors.put("password","Please enter password");
	        password="";
	        allOk=false;
	      } else if(!(validate(password))) {
	    	  errors.put("password","Atleast 1 digit,1 small char,1 Capital Char,1 special Char");
		        password="";
		        allOk=false;
	      }
	    if (confirmPassword == "" || confirmPassword == null) {
	        errors.put("confirmPassword","Please enter password");
	        confirmPassword="";
	        allOk=false;
	      }else if(confirmPassword != password){
	    	errors.put("confirmPassword","Confirm Password must Be same");
	        confirmPassword="";
	        allOk=false;
	      }
	    if (gender == "" || gender == null) {
	        errors.put("gender","Please Select Gender");
	        gender="";
	        allOk=false;
	      }
	    if (languageKnown == "" || languageKnown == null) {
	        errors.put("languageKnown","Please Select LanguageKnown");
	        languageKnown="";
	        allOk=false;
	      }
	    if (dob.equals("") || dob == null) {
	        errors.put("dob","Please Enter DOB");
	        dob="";
	        allOk=false;
	      }
	    try {
			if (inputStream.available()==0) {
			    errors.put("file_To_Upload","Select File Please");
			    inputStream=null;
			    allOk=false;
			  }
		} catch (IOException e) {
			   allOk=false;
		}
	    if(phoneNo.equals("") || phoneNo == null) {
	    	errors.put("phoneNo","Phone No Required");
	        phoneNo="";
	        allOk=false;
	    }else if(!(phoneNo.matches("[a-zA-Z ]+")))
	    if(email.equals("") || email == null) {
	    	errors.put("phoneNo","Only Numeric Characters");
	    	phoneNo="";
	        allOk=false;
	    }
		return allOk;
	}
	public boolean validate(final String password){
		  
		  matcher = pattern.matcher(password);
		  return matcher.matches();
	    	    
	  }
}

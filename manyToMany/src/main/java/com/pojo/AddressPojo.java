package com.pojo;

public class AddressPojo {
	private int aid;
	private String city;
	private String state;
	
	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public boolean equals(Object obj) {
      if (obj == null) return false;
      if (!this.getClass().equals(obj.getClass())) return false;

     AddressPojo addressPojo = (AddressPojo)obj;
      if((this.aid == addressPojo.getAid()) 
    		  && (this.city.equals(addressPojo.getCity())) 
    		  && (this.state.equals(addressPojo.getState()))) {
         return true;
      }
      return false;
   }
   
   public int hashCode() {
      int tmp = 0;
      tmp = ( aid + city + state ).hashCode();
      return tmp;
   }
}


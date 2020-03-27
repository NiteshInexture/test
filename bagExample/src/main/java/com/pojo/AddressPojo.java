package com.pojo;

public class AddressPojo 
//for SortedSet
implements Comparable<AddressPojo>
//end
{
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
//for set only
//	public boolean equels(Object obj) {
//		  if (obj == null) 
//			return false;
//	      if (!this.getClass().equals(obj.getClass())) 
//	    	  return false;
//	      AddressPojo obj2 = (AddressPojo) obj;
//	      if((this.aid == obj2.getAid()) && (this.city.equals(obj2.getCity())) && (this.state.equals(obj2.getState()))){
//	         return true;
//	      }
//	      return false;
//	}
//	
//	 public int hashCode() {
//	      int tmp = 0;
//	      tmp = ( aid + city + state ).hashCode();
//	      return tmp;
//	   }
// end
	 
	 
	 //for Sorted Set
	 public int compareTo(AddressPojo that){
	      final int BEFORE = -1;
	      final int AFTER = 1;

	      if (that == null) {
	         return BEFORE;
	      }

	      Comparable thisCity = this.getCity();
	      Comparable thisState = this.getState();
	      Comparable thatCity = that.getCity();
	      Comparable thatState = that.getCity();

	      if(thisCity == null || thisState == null) {
	         return AFTER;
	      } else if(thatCity == null && thatState == null) {
	         return BEFORE;
	      } else {
	         return thisCity.compareTo(thatCity);
	      }
	   }
	 //end
}


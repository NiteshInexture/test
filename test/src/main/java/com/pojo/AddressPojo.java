package com.pojo;

import java.util.Hashtable;

/**
 * @author Wins
 *
 */
public class AddressPojo {

	public int addressId;
	public int registerId;
	public String singleAddress;
	public String singleCityName;
	public String singleStateName;
	public String singleCountryName;
	public String[] insertArray;
	public String[] deleleArray;
	public String[] updateArray;
	public int[] addressIdArray;
	public String[] address;
	public String[] cityName;
	public String[] stateName;
	public String[] countryName;
	public Hashtable<String, String> errors= new Hashtable < String, String > ();
	
	public String[] getInsertArray() {
		return insertArray;
	}

	public void setInsertArray(String[] insertArray) {
		this.insertArray = insertArray;
	}

	public String[] getDeleleArray() {
		return deleleArray;
	}

	public void setDeleleArray(String[] deleleArray) {
		this.deleleArray = deleleArray;
	}

	public String[] getUpdateArray() {
		return updateArray;
	}

	public void setUpdateArray(String[] updateArray) {
		this.updateArray = updateArray;
	}

	public AddressPojo() {
		
	}
	
	public int[] getAddressIdArray() {
		return addressIdArray;
	}
	
	public void setAddressIdArray(int[] id) {
		this.addressIdArray = id;
	}
	/**
	 * 
	 * @return
	 */
	public int getAddressId() {
		return addressId;
	}

	/**
	 * 
	 * @param addressId
	 */
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	/**
	 * 
	 * @return
	 */
	public String[] getAddress() {
		return address;
	}
	/**
	 * 
	 * @param address
	 */
	public void setAddress(String[] address) {
		this.address = address;
	}
	public void setAddress(Object[] address) {
		this.address = (String[]) address;
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
	public String[] getCityName() {
		return cityName;
	}
	/**
	 * 
	 * @param cityName
	 */
	public void setCityName(String[] cityName) {
		this.cityName = cityName;
	}
	public void setCityName(Object[] cityName) {
		this.cityName = (String[]) cityName;
	}
	/**
	 * 
	 * @return
	 */
	public String[] getStateName() {
		return stateName;
	}
	/**
	 * 
	 * @param stateName
	 */
	public void setStateName(String[] stateName) {
		this.stateName = stateName;
	}
	public void setStateName(Object[] stateName) {
		this.stateName = (String[]) stateName;
	}
	/**
	 * 
	 * @return
	 */

	public String[] getCountryName() {
		return countryName;
	}
	/**
	 * 
	 * @param countryName
	 */
	public void setCountryName(String[] countryName) {
		this.countryName = countryName;
	}
	public void setCountryName(Object[] stateName) {
		this.stateName = (String[]) stateName;
	}
	/**
	 * 
	 * @return
	 */
	public String getSingleAddress() {
		return singleAddress;
	}
	
	/**
	 * 
	 * @param singleAddress
	 */
	public void setSingleAddress(String singleAddress) {
		this.singleAddress = singleAddress;
	}
	/**
	 * 
	 * @return
	 */
	public String getSingleCityName() {
		return singleCityName;
	}
	/**
	 * 
	 * @param singleCityName
	 */
	public void setSingleCityName(String singleCityName) {
		this.singleCityName = singleCityName;
	}
	/**
	 * 
	 * @return
	 */
	public String getSingleStateName() {
		return singleStateName;
	}
	/**
	 * 
	 * @param singleStateName
	 */
	public void setSingleStateName(String singleStateName) {
		this.singleStateName = singleStateName;
	}
	/**
	 * 
	 * @return
	 */
	public String getSingleCountryName() {
		return singleCountryName;
	}
	/**
	 * 
	 * @param singleCountryName
	 */
	public void setSingleCountryName(String singleCountryName) {
		this.singleCountryName = singleCountryName;
	}
	
public boolean validate() {
		boolean allOk=true;
		for(int i=0;i<addressIdArray.length;i++) {
			System.out.println(addressIdArray[i]);
		}
		return allOk;
	}	
}
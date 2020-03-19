package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.db.DbHelper;
import com.pojo.AddressPojo;
import com.pojo.RegisterPojo;

public class ImplDaoAddress implements IntfDaoAddress{

	DbHelper helper;
	Connection con;
	ResultSet result;
	PreparedStatement preparedStatement;
	
	public ImplDaoAddress(){
		helper = DbHelper.getInstance("jdbc:mysql://localhost:","3306","root","admin");
	}
	
	@Override
	public void connect(){
		try {
			con=helper.Connect("inexdb");
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("\n Failed To Connnect DB" + e );
		}
	}
	
	@Override
	public ResultSet getAddress(RegisterPojo pojo) {
		try {
			preparedStatement = con.prepareStatement("select * from address where rid=?");
			preparedStatement.setInt(1, pojo.getRegisterId());
			result = preparedStatement.executeQuery();
			
		} catch (SQLException e) {
			System.out.println("\n Sql error" + e );
		}
		return result;
	}

	@Override
	public void deleteAddress(AddressPojo pojo) {
		try {
			preparedStatement = con.prepareStatement("delete from address where adress_id=?");
			String[] number=pojo.getDeleleArray();
			for(int i=0;i<number.length;i++) {
				preparedStatement.setInt(1,Integer.parseInt(number[i]));
				preparedStatement.executeUpdate();
			}
		} catch (SQLException e) {
			System.out.println("\n Sql error" + e );
		}
	}

	@Override
	public void UpdateAddress(AddressPojo addressPojo,RegisterPojo registerPojo) {
		try {
			preparedStatement = con.prepareStatement("update address set address=?, cityname=?, state=?, country=? where adress_id=? ");
			for(int i=0;i<addressPojo.getAddressIdArray().length;i++) {
				preparedStatement.setString(1, addressPojo.getAddress()[i]);
				preparedStatement.setString(2, addressPojo.getCityName()[i]);
				preparedStatement.setString(3, addressPojo.getStateName()[i]);
				preparedStatement.setString(4, addressPojo.getCountryName()[i]);
				preparedStatement.setInt(5, addressPojo.getAddressIdArray()[i]);
				preparedStatement.addBatch();
			}
			preparedStatement.executeBatch();
		} catch (SQLException e) {
			System.out.println("Sql Exception" + e);
		}
	}

	@Override
	public void insertAddress(AddressPojo addressPojo, RegisterPojo pojo) {
		try {
			preparedStatement = con.prepareStatement("insert into address(address,cityname,state,country,rid)values(?,?,?,?,?)");
			for(int i=0;i<addressPojo.getAddressIdArray().length;i++) {
				preparedStatement.setString(1, addressPojo.getAddress()[i]);
				preparedStatement.setString(2, addressPojo.getCityName()[i]);
				preparedStatement.setString(3, addressPojo.getStateName()[i]);
				preparedStatement.setString(4, addressPojo.getCountryName()[i]);
				preparedStatement.setInt(5, pojo.getRegisterId());
				preparedStatement.addBatch();
			}
			preparedStatement.executeBatch();
		} catch (SQLException e) {
			System.out.println("Sql Exception" + e);
		}

	}
}

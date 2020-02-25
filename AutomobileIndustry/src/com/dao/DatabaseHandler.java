package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.bean.Vehicle;
import com.util.DatabaseConnection;


public class DatabaseHandler {
	public static void create(Vehicle vehicle){
		try {
			Connection dbConnection=DatabaseConnection.createConnection();
			String query="insert into vehicle(Year,Make,Model)values(?,?,?)";
			PreparedStatement ps=dbConnection.prepareStatement(query); 
			ps.setInt(1, vehicle.getYear());
			ps.setString(2, vehicle.getMake());
			ps.setString(3, vehicle.getModel());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static List<Vehicle> getVehicles(){
		List<Vehicle> vehicleList= new ArrayList<>();
		try {
			Connection dbConnection=DatabaseConnection.createConnection();
			String query="select * from vehicle";
			PreparedStatement pst=dbConnection.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			while(rs.next()){
				Vehicle vehicle=new Vehicle();
				vehicle.setId((rs.getInt(1)));
				vehicle.setYear((rs.getInt(2)));
				vehicle.setMake(rs.getString(3));
				vehicle.setModel(rs.getString(4));
				vehicleList.add(vehicle);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	return vehicleList;	
	}
	
	public static Vehicle getVehicleById(int id){
		Vehicle vehicle=null;
		try {
			Connection dbConnection=DatabaseConnection.createConnection();
			String query="select * from vehicle where ID=?";
			PreparedStatement ps=dbConnection.prepareStatement(query);
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				vehicle=new Vehicle();
				vehicle.setId(rs.getInt("ID"));
				vehicle.setYear(rs.getInt("Year"));
				vehicle.setMake(rs.getString("Make"));
				vehicle.setModel(rs.getString("Model"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	return vehicle;
	}
	
	public static void updateVehicle(Vehicle vehicle) {
		try {
			Connection dbConnection=DatabaseConnection.createConnection();
			String query="update Vehicle set Year=?,Make=?,Model=? where ID=?";
			PreparedStatement pst=dbConnection.prepareStatement(query);
			pst.setInt(1, vehicle.getYear());
			pst.setString(2, vehicle.getMake());
			pst.setString(3, vehicle.getModel());
			pst.setInt(4, vehicle.getId());
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void delete(int id) {
		try {
			Connection dbConnection=DatabaseConnection.createConnection();
			String query="delete from vehicle where ID=?";
			PreparedStatement pst=dbConnection.prepareStatement(query);
			pst.setInt(1,id);
			pst.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

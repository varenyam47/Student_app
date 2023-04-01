package com.StudentApp.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DAOServiceimpl implements DAOService {
		private Connection con;
		private Statement stmnt;
	@Override
	public void ConnectionDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con =DriverManager.getConnection("jdbc:mysql://localhost:3306/studentlogin", "root", "Nitesh@2706");
			stmnt=con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean verifyCredentials(String email, String password) {
		try {
			ResultSet result = stmnt.executeQuery("select * from login where email= '"+email+"' and password = '"+password+"'");
			return result.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void saveReg(String name, String city, String email, String mobile) {
		try {
			stmnt.executeUpdate("insert into registrationlogin values('"+name+"','"+city+"','"+email+"','"+mobile+"')");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public ResultSet listRegistration() {
		try {
			ResultSet result = stmnt.executeQuery("select * from registrationlogin");
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void deleteByEmail(String email) {
		try {
			stmnt.executeUpdate("Delete from registrationlogin where email='"+email+"'");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateReg(String email, String mobile) {
		try {
			stmnt.executeUpdate("UPDATE registrationlogin SET mobile = '"+mobile+"' WHERE email='"+email+"'");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}

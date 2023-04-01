package com.StudentApp.model;

import java.sql.ResultSet;

public interface DAOService {
	public void ConnectionDB();
	public boolean verifyCredentials(String email, String password);
	public void saveReg(String name, String city, String email, String mobile);
	public ResultSet listRegistration();
	public void deleteByEmail(String email);
	public void updateReg(String email, String mobile);

}

package dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import pojos.Role;
import pojos.User;

public interface IUserDao {
//add a method to get selected user details
	List<User> getSelectedUsers(Role role,Date begin,Date end) throws SQLException;
	//add a method to register new user
	String registerUser(User newUser) throws SQLException;
	//add a method to update existing user details
	String updateUserDetails(int userId,String newPwd,double offsetAmount) throws SQLException;
}

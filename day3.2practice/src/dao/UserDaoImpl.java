package dao;


import java.sql.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojos.Role;
import pojos.User;
import static Utils.DBUtils.*;

public class UserDaoImpl implements IUserDao {
	// state
	private Connection cn;
	private PreparedStatement pst1, pst2, pst3;

	// def ctor
	public UserDaoImpl() throws SQLException {
		// get FIXED DB conn from DBUtils
		cn = openConnection();
		String selectSql = "select id,name,reg_amt,reg_date from users where role=? and reg_date between ? and ?";
		// pst1
		pst1 = cn.prepareStatement(selectSql);
		String insertSql = "insert into users values(default,?,?,?,?,?,?)";
		pst2 = cn.prepareStatement(insertSql);
		String updateSql = "update users set password=?,reg_amt=reg_amt+? where id=?";
		pst3=cn.prepareStatement(updateSql);
		System.out.println("user dao created !");
	}

	@Override
	public List<User> getSelectedUsers(Role role, Date begin, Date end) throws SQLException {
		// create empty AL of users
		List<User> users = new ArrayList<>();
		// set IN params
		pst1.setString(1, role.name());// role
		pst1.setDate(2, begin);
		pst1.setDate(3, end);
		// exec method : execQuery
		try (ResultSet rst = pst1.executeQuery()) {
			while (rst.next())
				users.add(new User(rst.getInt(1), rst.getString(2), rst.getDouble(3), rst.getDate(4)));
		}
		return users;
	}

	@Override
	public String registerUser(User newUser) throws SQLException {
		// set IN params : name | email | password | reg_amt | reg_date | role
		pst2.setString(1, newUser.getName());
		pst2.setString(2, newUser.getEmail());
		pst2.setString(3, newUser.getPassword());
		pst2.setDouble(4, newUser.getRegAmount());
		pst2.setDate(5, newUser.getRegDate());
		pst2.setString(6, newUser.getUserRole().name());
		// DML : public int executeUpdate() throws SqlExc
		int rowCount = pst2.executeUpdate();
		if (rowCount == 1)
			return "User details inserted .....";
		return "Insertion of user details failed !!!!!!!!!!!!!!!!!!!!!!!";
	}

	@Override
	public String updateUserDetails(int userId, String newPwd, double offsetAmount) throws SQLException {
		// set IN params
		pst3.setString(1, newPwd);
		pst3.setDouble(2, offsetAmount);
		pst3.setInt(3, userId);
		// DML : execUpdate
		int rowCount = pst3.executeUpdate();
		if (rowCount == 1)
			return "User details updated .....";
		return "Updation of user details failed !!!!!!!!!!!!!!!!!!!!!!!";

	}

	// add clean up method , to close DB resources
	public void cleanUp() throws SQLException {
		if (pst1 != null)
			pst1.close();
		if (pst2 != null)
			pst2.close();
		if (pst3 != null)
			pst3.close();
		closeConnection();

	}

}

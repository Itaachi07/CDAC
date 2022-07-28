package pojos;
//id | name    | email          | password | reg_amt | reg_date   | role

import java.sql.Date;

public class User {
	private int userId;
	private String name;
	private String email;
	private String password;
	private double regAmount;
	private Date regDate;
	private Role userRole;
	//as per POJO specs : add def ctor
	public User() {
		// TODO Auto-generated constructor stub
	}
	//parameterized ctor for selected user details
	public User(int userId, String name, double regAmount, Date regDate) {
		super();
		this.userId = userId;
		this.name = name;
		this.regAmount = regAmount;
		this.regDate = regDate;
	}
	
	public User(String name, String email, String password, double regAmount, Date regDate, Role userRole) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.regAmount = regAmount;
		this.regDate = regDate;
		this.userRole = userRole;
	}
	//setters n getters
	public int getUserId() {
		return userId;
	}
	

	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public double getRegAmount() {
		return regAmount;
	}
	public void setRegAmount(double regAmount) {
		this.regAmount = regAmount;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public Role getUserRole() {
		return userRole;
	}
	public void setUserRole(Role userRole) {
		this.userRole = userRole;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", regAmount=" + regAmount + ", regDate=" + regDate + ", userRole=" + userRole + "]";
	}
	
	
}

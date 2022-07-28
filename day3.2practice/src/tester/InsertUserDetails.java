package tester;

import java.sql.Date;
import java.util.Scanner;

import dao.UserDaoImpl;
import pojos.Role;
import pojos.User;

public class InsertUserDetails {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			// create dao instance => init phase
			UserDaoImpl userDao = new UserDaoImpl();
			// service phase => user servicing
			System.out.println(
					"Enter User i/ps : name    | email          | password | reg_amt | reg_date(yr-mon-day)   | role");
			// invoke dao's method to perform user registration
			System.out.println(userDao.registerUser(new User(sc.next(), sc.next(), sc.next(), sc.nextDouble(),
					Date.valueOf(sc.next()), Role.valueOf(sc.next().toUpperCase()))));

			// clean up dao => destroy phase (end)
			userDao.cleanUp();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

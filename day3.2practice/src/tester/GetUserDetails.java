package tester;

import java.sql.Date;
import java.util.Scanner;

import dao.UserDaoImpl;
import pojos.Role;

public class GetUserDetails {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			// create dao instance => init phase
			UserDaoImpl userDao = new UserDaoImpl();
			// service phase => user servicing
			System.out.println("Enter role , begin date n end date (yr-mon-day)");
			// invoke dao's method to perform DAL
			userDao.getSelectedUsers(Role.valueOf(sc.next().toUpperCase()), Date.valueOf(sc.next()),
					Date.valueOf(sc.next())).forEach(System.out::println);
			// clean up dao => destroy phase (end)
			userDao.cleanUp();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

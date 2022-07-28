package tester;

import java.util.Scanner;

import dao.UserDaoImpl;

public class UpdateUserDetails {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			// create dao instance => init phase
			UserDaoImpl userDao = new UserDaoImpl();
			// service phase => user servicing
			System.out.println("Enter User id , new password n offset in reg amount");
			// invoke dao's method to perform user registration
			System.out.println(userDao.updateUserDetails(sc.nextInt(), sc.next(), sc.nextDouble()));

			// clean up dao => destroy phase (end)
			userDao.cleanUp();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

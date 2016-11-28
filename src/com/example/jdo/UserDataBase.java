package com.example.jdo;

import javax.jdo.PersistenceManager;
import javax.servlet.http.HttpServlet;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;

public class UserDataBase extends HttpServlet {

	private static final long serialVersionUID = 1L;
	static DatastoreService datastore = DatastoreServiceFactory
			.getDatastoreService();

	public static boolean create(String username, String firstname,
			String lastname, String password, String phonenumber, String email) {

		boolean flag = false;
		try {
			System.out.println(username);
			System.out.println(password);
			System.out.println(phonenumber);
			System.out.println(firstname);
			PersistenceManager obj = PMF.get().getPersistenceManager();
			System.out.println("inside datastore");
			User user = new User(username, firstname, lastname, password,
					phonenumber, email);
			user.setFirstname(firstname);
			user.setLastname(lastname);
			user.setUsername(username);
			user.setPassword(password);
			user.setEmail(email);
			user.setPhonenumber(phonenumber);

			obj.makePersistent(user);

			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
			System.out.println("outside datastore");
		}
		return flag;

	}

	public static boolean loginUser(String username, String password) {
		System.out.println("coming login user" + username);

		PersistenceManager obj = PMF.get().getPersistenceManager();

		String pwd = null;
		String uname = null;
		boolean flag = false;

		try {
			User u = obj.getObjectById(User.class, username);

			uname = u.getUsername();
			pwd = u.getPassword();

			if (pwd.equalsIgnoreCase(password)
					&& uname.equalsIgnoreCase(username)) {
				flag = true;
			} else {
				flag = false;
			}
		} catch (Exception e) {
			System.out.println("Entity not found:" + e);
			flag = false;
		}

		return flag;

	}

}

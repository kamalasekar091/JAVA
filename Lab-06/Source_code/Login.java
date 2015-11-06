import javax.swing.JOptionPane;

/**
 * @author Kamalasekar
 *This program is to login into the application
 */
public class Login {
	public static void main(String[] args) {
		String name = "null";
		boolean access = false;
		String message = "welcome" + "\n", response;
		message += "enter your name";
		message += "\n" + " ";
		int count = 0;
		int pass_count = 0;
		// This loop is to get the input from the user has the user name
		do {
			do {
				name = JOptionPane.showInputDialog(message);
				// block to terminate the program if the incorrect attemppt is more than 3 times
				count = count + 1;
				if (count >= 3) {
					JOptionPane.showMessageDialog(null, "3 incorrect attempt hence terminating the program");
					System.exit(1);
				}
			} while (name == null || name == " " || !(name.equals("admin")));// hard coded the user name 
		} while (name.length() <= 0);// avoid null input

		// to convert the string to upper case and initialize the password variable
		String password;
		name = name.trim();
		name = name.toUpperCase();

		// if the user name  name is "admin" then the program proceeds to get the password
		if (name.equals("ADMIN")) {
			JOptionPane.showMessageDialog(null, "hello " + name);
			message = "enter your password";
			message += "\n" + " ";
			// conditional loop to get the password from the users
			do {
				do {
					password = JOptionPane.showInputDialog(message);
					//block to terminate the program if the password is entered incorrectly for more than 3 times
					pass_count = pass_count + 1;
					if (pass_count >= 3) {
						JOptionPane.showMessageDialog(null, "3 incorrect attempt hence terminating the program");
						System.exit(1);
					}
				} while (password == null || password == " " || !(password.equals("password")));/// hard code the password value
			} while (password.length() <= 0);// to avoid null value
			password = password.trim();
			password = password.toUpperCase();

			if (password.equals("PASSWORD")) {
				access = true;
			} else
				JOptionPane.showMessageDialog(null, "incorrect password");
		} else {
			JOptionPane.showMessageDialog(null, "incorrect login name");
		}
		//If the login attempt is success then the program access the main,java program
		if (access == true) {
			try {
				JOptionPane.showMessageDialog(null, "Login_sucessfull");
				Menu m = new Menu();
				System.exit(1);
			} catch (Exception e) {
				System.out.println(e);
			}
		}// end of if 
	}// end main
}// end class

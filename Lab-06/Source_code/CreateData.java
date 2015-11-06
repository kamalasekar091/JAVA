import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 * 
 * @author Kamalasekar This class is used to write the payroll in the text file
 */

public class CreateData {

	/**
	 * This method opens the file and writes the file
	 */
	static void Write() {
		JOptionPane.showMessageDialog(null, "This program writes payroll data", "Welcome", JOptionPane.PLAIN_MESSAGE);
		int repeat = 1;
		String answer = null;
		do {
		
		try {
			// Decelaration of string
			String firstLine = null,firstname=null,secondname=null, secondLine = null, thirdLine = null, number = "";
			String checkString = null;
			// object created to accss the file
			File check = new File("payroll.txt");
			FileWriter file;
			double thirdLineCheck = 0;
			int SecondLneCheck = 0;
			// if loop to check weather the file is in existing if not it will
			// create the new file
			// if the file exists the data will be appended in the file
			if (check.exists())
				// allows appending of data to file
				file = new FileWriter("payroll.txt", true);
			else
				file = new FileWriter("payroll.txt");
			// creating object to write in the file
			BufferedWriter buffer = new BufferedWriter(file);
			int size = 0, count = 1;
			/**
			 * This block is used to get how many records. The value can only be
			 * integers.
			 */
			while (number == null || number.equals(""))
				number = JOptionPane.showInputDialog("how many records?");

			// to catch the nullpointer exception
			try {
				size = Integer.parseInt(number);
			} catch (NumberFormatException e) {
				System.out.println("The Number of recors can only be Integers");
				System.exit(0);

			}

			do {

				/**
				 * This unit is to get the name only characters are permitted in
				 * this unit
				 */
				do {
					firstname=JOptionPane.showInputDialog("Enter First name");
					secondname=JOptionPane.showInputDialog("Enter Second name(if u dont have a second name enter your first name here)");
					
					//firstLine = JOptionPane.showInputDialog("Enter name");
					if (firstname == null ||secondname == null ) {
						System.out
						.println("You have terminated the operation, Please re-run the program to enter the value");
						System.exit(0);
					}
				} while (firstname.length() < 0 || firstname.equals("") || !firstname.matches("[A-Za-z]+")||secondname.length() < 0 || secondname.equals("") || !secondname.matches("[A-Za-z]+"));// to
				// avoid
				// null
				// values
           firstLine=firstname+" "+secondname;
				/**
				 * This unit is to enter the number of hours
				 */
				do {
					secondLine = JOptionPane.showInputDialog("Enter hours");

					// To avoid null value
					if (secondLine == null) {
						System.out
						.println("You have terminated the operation, Please re-run the program to enter the value");
						System.exit(0);
					}
					// To void number format exception
					try {
						SecondLneCheck = Integer.parseInt(secondLine);
					} catch (NumberFormatException e) {
						System.out.println("The Number of hours can only be Integers");
						System.exit(0);

					}
				} while (secondLine.length() < 0 || secondLine.matches("[A-Za-z]+") || SecondLneCheck < 0);

				/**
				 * This Unit is to get the wages per hour Only decimal and
				 * integer are allowed in this unit
				 */
				do {
					thirdLine = JOptionPane.showInputDialog("Enter wage");
					// To avoid null value
					if (thirdLine == null) {
						System.out
						.println("You have terminated the operation, Please re-run the program to enter the value");
						System.exit(0);
					}
					// To catch the number format exception
					try {
						thirdLineCheck = Double.parseDouble(thirdLine);
					} catch (NumberFormatException e) {
						System.out.println("The Wages can be only number");
						System.exit(0);

					}
				} while (thirdLine.length() < 0);// To avoid empty value
				// writes the name in the file
				buffer.write(firstLine);
				buffer.newLine();
				// /writes the number of hours in the file
				buffer.write(secondLine);
				buffer.newLine();
				// Writes the cost per hour
				buffer.write(thirdLine);
				buffer.newLine();
				count++;

			} while (count <= size);// end of the while for file input

			// To close the file which has been open to write
			buffer.close();

			// swing box to display the data has been processed
			JOptionPane.showMessageDialog(null, "data processed", "Result", JOptionPane.PLAIN_MESSAGE);

		}// end of the write method

		catch (IOException e) {
			System.out.println(e);
		}// end of the class
		do {

			// This is an Input which gives an option to continue the
			// program or exit the program
			answer = JOptionPane.showInputDialog("write payroll data?\n" + "enter 1 to continue or 0 to exit");

			// try catch to avoid number format exception
			try {
				repeat = Integer.parseInt(answer);

			} catch (NumberFormatException e) {
				System.out.println("The Input can be only Integers");
				System.exit(0);
			}

			// Condition to avoid null pointer exception
			if (answer == null) {
				System.out
				.println("You have terminated the operation,The data entered have been stored in the text file");
				System.exit(0);
			}
		
		} while (answer.length() < 0 || repeat < 0 || repeat > 1);// while
		// which
		// avoids
		// other
		// value
		// than
		// 0 and
		// 1

	} while (repeat == 1);

	}
}

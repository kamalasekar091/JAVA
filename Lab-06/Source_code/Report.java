import java.io.*;
import java.text.DecimalFormat;

import javax.swing.JOptionPane;

/**
 * 
 * @author Kamalasekar This class is to report data on a persons payroll
 */
public class Report {
	public Report() {

		String input;
		// code here the logic to create a report for the user
		DecimalFormat twoDecimal = new DecimalFormat("$0.00");

		try {
			// Initlization and declaration of variable
			String[] firstLine_Over = new String[100], secondLine_over = new String[100], thirdLine_over = new String[100], fourthLine_over = new String[100], fifthLine_over = new String[100];

			double hours_over[] = new double[100], wages_over[] = new double[100];

			double gross[] = new double[100];
			double extra[] = new double[100];
			boolean check_name = true;
			int count = 0;

			// This is to assign the value to the parameters
			int index;
			for (index = 0; index < 100; index++) {
				firstLine_Over[index] = "";
				secondLine_over[index] = "";
				thirdLine_over[index] = "";
				fourthLine_over[index] = "";
				fifthLine_over[index] = "";
				hours_over[index] = 0.0;
				wages_over[index] = 0.0;
				gross[index] = 0.0;
				extra[index] = 0.0;
			}
			// string decelaration to get the input
			String firstName;
			String secondName;
			// j_option to get the first name
			do {
				firstName = ((String) JOptionPane.showInputDialog("Enter the First name"));
			} while (firstName.length() <= 0 || firstName == null || firstName == " " || !firstName.matches("[A-Za-z]+"));
			// j_option to get the second name
			do {
				secondName = ((String) JOptionPane.showInputDialog("Enter the Last name"));
			} while (secondName.length() <= 0 || secondName == null || secondName == " " || !secondName.matches("[A-Za-z]+"));

			// extracting the first character from first name and appending it
			// to the second nae
			char Filename_1 = firstName.charAt(0);
			String FileName = Filename_1 + secondName + ".txt";
			// input serves to compare with the read data
			input = firstName + " " + secondName;
			// this is to create a file method foe the Filename
			FileReader file_over = new FileReader("overtime.txt");
			BufferedReader buffer_over = new BufferedReader(file_over);
			index = 0;
			String line;
			// While loop to read the value of the file
			while ((line = buffer_over.readLine()) != null) {
				firstLine_Over[index] = line;
				secondLine_over[index] = buffer_over.readLine();
				thirdLine_over[index] = buffer_over.readLine();
				fourthLine_over[index] = buffer_over.readLine();
				fifthLine_over[index] = buffer_over.readLine();

				hours_over[index] = Double.parseDouble(secondLine_over[index]);
				wages_over[index] = Double.parseDouble(thirdLine_over[index]);
				gross[index] = Double.parseDouble(fourthLine_over[index]);
				extra[index] = Double.parseDouble(fifthLine_over[index]);

				// If loop to chek for the given character of the file
				if (firstLine_Over[index].equals(input)) {
					FileWriter file_write_over;
					file_write_over = new FileWriter(FileName);
					BufferedWriter buffer_write_over = new BufferedWriter(file_write_over);
					count = count + 1;
					if (count > 1) {
						break;
					}

					buffer_write_over.newLine();
					buffer_write_over.write("******************************************************");
					buffer_write_over.newLine();
					buffer_write_over.write("------------------Payroll Report----------------------");
					buffer_write_over.newLine();
					buffer_write_over.write("******************************************************");
					buffer_write_over.newLine();
					buffer_write_over.write("		Name        :" + firstLine_Over[index]);
					buffer_write_over.newLine();
					// /writes the number of hours in the file
					buffer_write_over.write("		Hours       :" + secondLine_over[index]);
					buffer_write_over.newLine();
					// Writes the cost per hour
					buffer_write_over.write("		Wages       :" + twoDecimal.format(wages_over[index]));
					buffer_write_over.newLine();
					buffer_write_over.write("		Gross Pay   :" + twoDecimal.format(gross[index]));
					buffer_write_over.newLine();
					// Writes the cost per hour
					buffer_write_over.write("		Overtime pay:" + twoDecimal.format(extra[index]));
					buffer_write_over.newLine();
					buffer_write_over.write("******************************************************");
					check_name = true;
					buffer_write_over.close();// to close the file created
					break;

				}

				else {
					check_name = false;

				}

			}

			buffer_over.close();// to close the file overtime

			if (check_name == false) {
				JOptionPane.showMessageDialog(null, "The entered name is not in the list", "Error!!",
						JOptionPane.PLAIN_MESSAGE);
			}
		} catch (IOException e) {
			System.out.println(e);
		}

	}

}

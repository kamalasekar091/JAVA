import java.text.DecimalFormat;
import java.io.BufferedWriter;
import javax.swing.JOptionPane;

import java.io.*;
/**
 * 
 * @author Kamalasekar
 *This class is to read the data from the file 
 *and project it as a pop up display
 */
public class ReadData { 
	public ReadData() {
		//to display the double toa formated decimal value
		DecimalFormat twoDecimal = new DecimalFormat("$0.00");
		try {
			//declaration of the required variable and try and catch implementation to avoid unsure value
			String[] firstLine = new String[100], secondLine = new String[100], thirdLine = new String[100];
			Double[] fourthLine = new Double[100];

			double hours[] = new double[100], wages[] = new double[100];

			//This loop is to help us in assigning the default value for the array 
			int index;
			for (index = 0; index < 100; index++) {
				firstLine[index] = "";
				secondLine[index] = "";
				thirdLine[index] = "";
				fourthLine[index] = 0.00;
				hours[index] = 0.0;
				wages[index] = 0.0;
			}
			//File reader to access the file pay roll 
			FileReader file = new FileReader("payroll.txt");
			BufferedReader buffer = new BufferedReader(file);

			index = 0;
			String line;
			// This file is created to save the overtime data
			File check = new File("overtime.txt");
			FileWriter file_write;
			//check to perform if the file is present or not
			if (check.exists()) {
				// allows appending of data to file
				file_write = new FileWriter("overtime.txt", true);
			} else {
				file_write = new FileWriter("overtime.txt");
			}
			// buffer writer obbject to write the overtime data in the overtime file
			BufferedWriter buffer_write = new BufferedWriter(file_write);
			//This loop is to check for the value till tthe last line of the program
			while ((line = buffer.readLine()) != null) {
				firstLine[index] = line;
				secondLine[index] = buffer.readLine();
				thirdLine[index] = buffer.readLine();

				hours[index] = Double.parseDouble(secondLine[index]);
				wages[index] = Double.parseDouble(thirdLine[index]);
				// if statement to figure out the overtime data
				//if the working hours is more the pay increases 1.5 times for each and every more than one hour
				if (hours[index] > 40) {
					double newwages;
					double newhours;
					newwages = 1.5 * (wages[index]);
					newhours = hours[index] - 40;
					fourthLine[index] = newwages * newhours + 40 * wages[index];

				} else {
					fourthLine[index] = hours[index] * wages[index];
				}// end of if 

				// this j_option is to display the calculated and read data from the file payroll.txt
				JOptionPane.showMessageDialog(
						null,
						"Name   : " + firstLine[index] + "\n" + "Hours   : " + hours[index] + "\n" + "Wages : "
								+ twoDecimal.format(wages[index]) + "\n" + "Gross Pay :"
								+ twoDecimal.format(fourthLine[index]), "Result", JOptionPane.PLAIN_MESSAGE);

				String fourthLinevalue = Double.toString(fourthLine[index]);
				double overtimetemp = fourthLine[index] - (hours[index] * wages[index]);
				String overtime = Double.toString(overtimetemp);

				buffer_write.write(firstLine[index]);
				buffer_write.newLine();
				buffer_write.write(secondLine[index]);
				buffer_write.newLine();
				buffer_write.write(thirdLine[index]);
				buffer_write.newLine();
				buffer_write.write(fourthLinevalue);
				buffer_write.newLine();
				buffer_write.write(overtime);
				buffer_write.newLine();
				index++;

			}
			buffer.close();// to close the payroll
			buffer_write.close();// to close the overtime file
			System.exit(0);
		}

		catch (IOException e) {
			System.out.println(e);
		}
	}
}

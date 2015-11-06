import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;

import javax.swing.JOptionPane;
import javax.swing.text.StyledEditorKit.BoldAction;

/**
 * @author Kamalasekar
 *This program is to summarize the sub total of the overtime pay
 */
public class Summary {

	{
		DecimalFormat twoDecimal = new DecimalFormat("$0.00");
		try {
			// declaring the variable 
			String[] firstLine_Over = new String[100], secondLine_over = new String[100], thirdLine_over = new String[100], fourthLine_over = new String[100], fifthLine_over = new String[100];

			double hours_over[] = new double[100], wages_over[] = new double[100];

			double gross[] = new double[100];
			double extra[] = new double[100];
			double sum_a_f = 0.0;
			double sum_g_l = 0.0;

			//Initializing the variable with the for loop
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

			// file reader object to read the file overtime.txt
			FileReader file_over = new FileReader("overtime.txt");
			BufferedReader buffer_over = new BufferedReader(file_over);
			index = 0;
			String line;
			File check = new File("overtime.txt");
			// check for he fiel exist or not 
			FileWriter file_write;
			if (check.exists()) {
				// allows appending of data to file
				file_write = new FileWriter("overtime.txt", true);
			} else {
				file_write = new FileWriter("overtime.txt");
			}

			int count = 0, count_2 = 0, count_3 = 0;
			//while loop to read the data in the file till the last line

			while ((line = buffer_over.readLine()) != null) {
				firstLine_Over[index] = line;
				String check_name = firstLine_Over[index];

				char check_char = check_name.charAt(0);

				secondLine_over[index] = buffer_over.readLine();
				thirdLine_over[index] = buffer_over.readLine();
				fourthLine_over[index] = buffer_over.readLine();
				fifthLine_over[index] = buffer_over.readLine();

				hours_over[index] = Double.parseDouble(secondLine_over[index]);
				wages_over[index] = Double.parseDouble(thirdLine_over[index]);
				gross[index] = Double.parseDouble(fourthLine_over[index]);
				extra[index] = Double.parseDouble(fifthLine_over[index]);
				// if loop to filter the value with first name starting with character A|B|C|D|E|F

				if (check_char == 'A' || check_char == 'B' || check_char == 'C' || check_char == 'D'
						|| check_char == 'E' || check_char == 'F') {

					sum_a_f += extra[index];
				}
				// if loop to filter the value with first name starting with character G|H|I|J|K|L
				else if (check_char == 'G' || check_char == 'H' || check_char == 'I' || check_char == 'J'
						|| check_char == 'K' || check_char == 'L') {
					sum_g_l += extra[index];

				}// end of while

			}//end of try
			//J_Option to display the value of sub total in the A through F 
			JOptionPane.showMessageDialog(null, "Subtotal:-" + twoDecimal.format(sum_a_f),
					"The sum of overpay paid for peopel with firts name starting with A-F", JOptionPane.PLAIN_MESSAGE);
			//J_Option to display the value of sub total in the G through L 
			JOptionPane.showMessageDialog(null, "Subtotal:-" + twoDecimal.format(sum_g_l),
					"The sum of overpay paid for peopel with firts name starting with G-L", JOptionPane.PLAIN_MESSAGE);
			//J_Option to display the value of sub total in the A through L 
			JOptionPane.showMessageDialog(null, "Subtotal for A through F         :-" + twoDecimal.format(sum_a_f)
					+ "\n" + "Subtotal for G through L         :-" + twoDecimal.format(sum_g_l) + "\n"
					+ "The total sum between A through L:-" + twoDecimal.format((sum_g_l + sum_a_f)), "Total sum",
					JOptionPane.PLAIN_MESSAGE);

			//to close the file overtime.txt
			buffer_over.close();
		} catch (IOException e) {
			System.out.println(e);
		}//end of catch
	}// end of method

}//end of class

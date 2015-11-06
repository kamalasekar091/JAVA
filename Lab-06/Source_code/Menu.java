import javax.swing.JOptionPane;

/**
 * 
 * @author Kamalasekar
 *This program is to provide the menu input for the user
 *other parts of the program like create, read, report and exit can be assessed from this file
 */
public class Menu {
	public Menu() {
		//This is the message that will appear on the screen on the J-Option pop_up
		String message = "welcome" + "\n", response;

		message += "\n" + "enter...";
		message += "\n" + "  1 to enter payroll data";
		message += "\n" + "  2 to view payroll data";
		message += "\n" + "  3 to generate report by employee";
		message += "\n" + "  4 Summary of overtime";
		message += "\n" + "  5 to exit" + "\n" + " ";

		char answer = 'Y';

		do {
             //try to handle the exception
			try {

				response = JOptionPane.showInputDialog(message);

				int choice = Integer.parseInt(response);

				switch (choice) {
				// this case is to fire the Create data class
				case 1:
					CreateData cd = new CreateData();
					cd.Write();
					answer = 'N';
					System.exit(1);
					break;
					// this case is to fire the read data class
				case 2:
					ReadData rd = new ReadData();

					answer = 'N';
					System.exit(1);
					break;
					//this case is to fire the report class
				case 3:
					Report rpt = new Report();

					answer = 'N';
					System.exit(1);
					break;
					//this case to fire teh summary class
				case 4:
					Summary su = new Summary();
					answer = 'N';
					System.exit(1);
					// this case is to exit the class
				case 5:
					answer = 'N';
					System.exit(1);
					break;
					//this block is to check the correct input has been entered or not
				default: {
					answer = 'Y';
					choice = 0;
					JOptionPane.showMessageDialog(null, "enter a number: 1 - 4");
				}
				}// end switch
			}// end try
			// this catch is used to track the number format exception
			//This exception will be handled first 
			catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "The Value should only be numbers", "Error!!",
						JOptionPane.PLAIN_MESSAGE);
				
			} catch (Exception e) {
				System.out.println(e);
			}
		} while (answer == 'Y' || answer == 'y');//end of while

	}// end of class

}// end class

package ie.lyit.tester;
//import the menu class
import ie.lyit.flight.Menu;
import ie.lyit.serialize.EmployeeSerializer;

public class EmployeeSerializerTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Opening new File(Read)
		EmployeeSerializer employeeSerializer = new EmployeeSerializer();
		//read the file
		employeeSerializer.deSerialiseEmployees();
		/////////////////////////////////////////////////////////////////////////////////
		//Must first check if the ArrayList contains any Employee Objects
		//if it does, the employee number must be incremented to the next available slot
		//calling the method in the EmployeeSerializer class
		if(employeeSerializer.checkThatEmployeeArrayListIsCurrentlyEmpty()==false) {
			int lastEmployeeNumber = employeeSerializer.getTheNewEmployeeNumberNextSlot();
			employeeSerializer.incrementNumber(lastEmployeeNumber);
		}
		//creating new menu from Menu Class
		//tackle a user entering bad input
		Menu menu = new Menu();
		do {
			menu.display(); //display Menu
			try {
				menu.readOption(); //Read user input
				//do not allow negative numbers
				if(menu.getOption() <= 0) {
					System.out.println("Please enter a option between 1 and 6");
				}

				switch(menu.getOption()) {
				case 1:employeeSerializer.add();
				break;
				case 2:employeeSerializer.list();
				break;
				case 3:employeeSerializer.view();
				break;
				case 4:employeeSerializer.edit();
				break;
				case 5:employeeSerializer.delete();
				break;
				case 6:default:break;
				}
				//If the user enters a letter catch the exception
			}catch(Exception e) {
				System.out.println("Not a valid number; Please enter a number: ");
			}
		}while(menu.getOption() != 6);

		//Close file and save
		employeeSerializer.serialiseEmployees();
	}
}


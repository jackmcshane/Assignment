package ie.lyit.flight;

import java.util.Scanner;
public class Menu {
	private int option;

	public Menu() {
	option=0; //Option variable initialised
}

	//Display options to user
public void display() {
	System.out.println("\t1 Add");
	System.out.println("\t2 List");
	System.out.println("\t3 View");
	System.out.println("\t4 Edit");
	System.out.println("\t5 Delete");
	System.out.println("\t6 Quit");
}
//Read there chosen option
public void readOption(){
	Scanner kbInt = new Scanner(System.in);
	System.out.println("Enter a Option [1-6]: ");
	option = kbInt.nextInt();
}
public int getOption() {
	return option;
}
}

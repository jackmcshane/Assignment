package ie.lyit.serialize;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import ie.lyit.flight.Employee;

public class EmployeeSerializer {
	private ArrayList<Employee> employees;
	/////filename
	private final String FILENAME = "Employees.ser"; 

	//Employee Serializer  constructor (Creates an arraylist of employee objects)
	public EmployeeSerializer(){

		employees = new ArrayList<Employee>();
	}
	//Add an employee to a file
	public void add()
	{	//Create an Employee object
		Employee Employee = new Employee();
		//Read contents the inputed by the user
		Employee.read();
		//Add Employee to a file
		employees.add(Employee);
	}



	//List the employees already in file
	//if none exist, state this to user
	public void list()
	{
		try {
			for(Employee tmpEmployee : employees)
				System.out.println(tmpEmployee);
		}
		catch(Exception NoSuchElementException ) {
			System.out.println("No employees in list");
		}
		finally {
			System.out.println("Please select a new option or quit");
		}
	}



	//Method to publish the newly added objects (Original language to bytes)
	//if a file cannot be written to, a try-catch will catch this exception.
	public void serialiseEmployees() 
	{
		try {
			FileOutputStream fileStream = new FileOutputStream(FILENAME);
			ObjectOutputStream os = new ObjectOutputStream(fileStream);
			os.writeObject(employees);
			os.close();
		}
		catch(FileNotFoundException fNFE) {
			System.out.print("Cannot create file");
		}
		catch(IOException ioE) 
		{
			System.out.println(ioE.getMessage());
		}
	}
	//Read the objects from file (turns bytes to original file)
	//If a file can't be found, create a new one
	public void deSerialiseEmployees()
	{
		try{
			FileInputStream fileStream = new FileInputStream(FILENAME);

			ObjectInputStream is = new ObjectInputStream(fileStream);

			employees = (ArrayList<Employee>)is.readObject();

			is.close();

		}
		catch(FileNotFoundException fNFE) {
			System.out.println("Cannot find file. A new file will be created, please select an option to continue: ");
		}
		catch(IOException ioE) 
		{
			System.out.println(ioE.getMessage());
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	//Check if there is anything the ArrayList in the situation that a user selects a
	//employee number that doesn't exist
	public boolean checkThatEmployeeArrayListIsCurrentlyEmpty() {
		return employees.isEmpty();
	}
	
	//Once file is deserialised, this method will be called to ensure
	//that the next number available to be written to.(size of ArrayList checked).
	public int getTheNewEmployeeNumberNextSlot() {
		return employees.get(employees.size()-1).getNumber();
	}


	//methods//////////////////////////////////////////
	//View an employee by employee number
	//if none available to the user, repeat this to user.
	public Employee view() {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Enter Employee number: ");
		int employeeNum = keyboard.nextInt();
		//The employee number is static number of 1000
		//no employees should be stored or selected 
		//with a number less than 1000
		if(employeeNum < 1000) {
			System.out.println("Not a valid Employee, please enter a new choice. ");
		}
		for(Employee tmpEmployee: employees) {
			//static number starting off is 1000 so can't search lower
			if(tmpEmployee.getNumber()== employeeNum) {
				System.out.println(tmpEmployee);
			}
				//else
					//System.out.println("No Employee exists with this number");
				try {
					return tmpEmployee;
				}
				catch(Exception e) {
					System.out.println("No employees to view");
				}
				finally {
					System.out.println("Please Select another option or 6 to quit");
				}
			
		}
		return null;
	}

	//Delete an employee by employee number
	public void delete() {
		Employee temporEmployee = view();
		try {
		if(temporEmployee != null)
			employees.remove(temporEmployee);
		}catch(Exception e) {
			System.out.println("No employees exist with that number");
		}
	}

	//Edit by employee number that is entered
	public void edit() {

		Employee temporEmployee = view();
		//try {

			if (temporEmployee != null) {
				int index = employees.indexOf(temporEmployee);

				temporEmployee.read();
				employees.set(index, temporEmployee);

			}
			//Attempts
		//} catch (Exception e) {
			// call the empty method
			//System.out.println("No employees by that number!");
		//}

	}
	
	//setting the employee to the last number and
	//once file opened, next number incremented
	//the nextNumber is incremented to number++
	public void incrementNumber(int number) {
		Employee.nextNumber=++number;
		
	}

}

package ie.lyit.flight;

import java.io.Serializable;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Employee extends Person implements Payable, Serializable { //must extend serializable object class as multiple interface can be implemented 
	private Date startDate;
	//private Date dateOfBirth;
	private double salary;
	private int number;
	public static int nextNumber = 1000;
	private final double MAX_SALARY = 150000;
	
	public Employee()
	{
		super();
		startDate = new Date();
		salary = 0.0;
		number = nextNumber++;
	}
	public Employee(String t, String fn, String sn, int d, int m, int y, Date startDate, double salary) 
	{
		super(t, fn, sn, d, m, y);
		this.startDate = startDate;
		this.salary = salary;
	}

		
	
	@Override
	public double calculateWage(double taxPercentage) {
		// TODO Auto-generated method stub
		double wage = salary/12;
		wage -= (wage* (taxPercentage/100));
		return wage;
	}

	@Override
	public double incrementSalary(double incrementAmount) {
		// TODO Auto-generated method stub
		salary += incrementAmount;
		if(salary > MAX_SALARY)	
			salary = MAX_SALARY;
		
		return salary;
	
	}
	
	public Date getStartDate()
	{
			return startDate;
	}
	public double getSalary()
	{
			return salary;
	}
	public int getNumber()
	{
			return number;
	}
	
	//Setters
	public void setStartDate(Date startdate1)
	{
			this.startDate = startdate1;
	}
	public void setSalary(double salary1)
	{
			this.salary = salary1;
	}

	//toString method
	@Override
	public String toString(){
	 
		return number + " " + super.toString() + " "  + startDate + " €" + salary; 
	}
	//Equals Method(can leave for subclass)
	@Override
	public boolean equals(Object obj) {
    Employee nObject;
		if (obj instanceof Employee)
			nObject = (Employee)obj;
		else
			return false;
		return  (this.number == nObject.number);
				
	}
	public void read() {
		//this number is set from 1000 onwards, so it cannot be changed as its static
		//Here, the textfields are configured and allow inputs from the user
		JTextField empNumber = new JTextField();
		empNumber.setText("" + this.getNumber());
		JTextField title1 = new JTextField();
		JTextField firstname2 = new JTextField();
		JTextField surname3 = new JTextField();

		//JTextField txtName = new JTextField();
		//txtName.requestFocus();
		JTextField salary = new JTextField();
		JTextField startDate = new JTextField();
		JTextField jtDay = new JTextField();
		JTextField jtMonth = new JTextField();
		JTextField jtYear = new JTextField();
		JTextField dateOfBirth = new JTextField();

		
		//what to display to describe the fields
		//Characteristics of the Employee
		Object[] message = {
				"Employee Number:", empNumber,
				"Title:", title1,
				"First Name", firstname2,
				"Surname", surname3,
	    		"Start Date:", startDate,
	    		"Date of Birth:", dateOfBirth,
				"Salary:", salary,
		};
		//Display the interface to the user
		int choice = JOptionPane.showConfirmDialog(null, message, "Enter Employee details", JOptionPane.OK_CANCEL_OPTION);
		//If the user selects ok, the following will be stored according to there methods.
		if (choice == JOptionPane.OK_OPTION){
			
			//Get User input for specified criteria (this will save these into the appropriate methods to the file)
			//Read the user input for the title, firstname and lastname.
			Name name = new Name(title1.getText(), firstname2.getText(), surname3.getText());
			//set this name 
			this.setName(name);
			//read the inputed salary
			this.setSalary(Double.parseDouble(salary.getText()));
			/////////////////////////////////////needs attention
			//Start Date+date of birth
			//To get these, the had to be cast and written as a substring,
			//outlining the characters between the / (12/12/1998) e.g 0-2 not including 2
			//The cast was used because errors were flagged as it had be casted as date is int
			//while the JTextbox takes a string.
			//Birthdate
			Date birthday = new Date(Integer.parseInt(dateOfBirth.getText().substring(0, 2)), Integer.parseInt(dateOfBirth.getText().substring(3, 5)), Integer.parseInt(dateOfBirth.getText().substring(6))); //date
			//Date of commencement of job
			Date jobStart = new Date(Integer.parseInt(startDate.getText().substring(0, 2)), Integer.parseInt(startDate.getText().substring(3, 5)), Integer.parseInt(startDate.getText().substring(6))); //date1
			//set them using the methods of the class
			this.setDateOfBirth(birthday);
			this.setStartDate(jobStart);
		}   
	}
}


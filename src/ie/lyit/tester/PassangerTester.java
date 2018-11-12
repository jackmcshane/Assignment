package ie.lyit.tester;


import ie.lyit.flight.Passanger;

class PassangerTester{
   public static void main(String[] args){
	   // Create a Passenger object called passengerA
		Passanger passengerA = new Passanger();
							
		// display passengerA's details on screen
		System.out.println(passengerA);
					
		// set passengerA's details
		passengerA.getName().setTitle("Mr");
		passengerA.getName().setFirstName("Homer");
		passengerA.getName().setSurname("Simpson");		
		passengerA.getDateOfBirth().setDay(25);
		passengerA.getDateOfBirth().setMonth(10);
		passengerA.getDateOfBirth().setYear(1965);		
		passengerA.setNoBags(6);				
		passengerA.setPriorityBoarding(false);				
							
		// display passengerA's details on screen
		System.out.println(passengerA);
					
	   // Create a Passenger object called passengerB with initial values
		Passanger passengerB = new Passanger("Ms", "Lisa", "Simpson", 20, 12, 1992, 1, true);
							
		// display passengerB's details on screen
		System.out.println(passengerB);
							
		// change passengerB's firstName to "Lisa-Marie"
		passengerB.getName().setFirstName("Lisa-Marie");
					
		// display passengerB's details on screen
		System.out.println(passengerB);
					
	   // check if passengerA is the same as passengerB
		if(passengerA.equals(passengerB))
		   System.out.println(passengerA + " is the same passenger as " + passengerB);
		else
		   System.out.println(passengerA + " is not the same passenger as " + passengerB);
					
		// check if passengerA is female
		if(passengerA.getName().isFemale())		// OR	if(personA.isFemale()==true)
		   System.out.println(passengerA + " is female.");			
		else
		   System.out.println(passengerA + " is male.");	
   }
}
						
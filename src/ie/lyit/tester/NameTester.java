package ie.lyit.tester;
import ie.lyit.flight.*;
public class NameTester {

	public static void main(String[] args) {
		
		Name person1 = new Name();
		person1.setTitle("Mr");
		person1.setFirstName("Gerry");
		person1.setSurname("Adams");
		//print form toString
		System.out.println(person1);
		
		Name person2 = new Name();
		person2.setTitle("Mr");
		person2.setFirstName("Ian");
		person2.setSurname("Paisley");
		//print form toString
		System.out.println(person2);
		
		if(person1.equals(person2))
			System.out.println(person1 + " same as " + person2);
		else
			System.out.println(person1 + " not same as " + person2);

		
		
		

	}

}

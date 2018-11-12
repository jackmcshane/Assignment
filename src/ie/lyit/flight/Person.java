package ie.lyit.flight;

import java.io.Serializable;

public abstract class Person implements Serializable { //abstract class

	protected Name name;
	protected Date dateOfBirth;
	
//Name n1 = new Name();
public Person()
	{
	
		name = new Name();			//Composition
		dateOfBirth = new Date();	//Composition
	
	}



public Person(String t, String fn, String sn, int d, int m, int y) 
	{
	
		name = new Name(t, fn, sn);
		dateOfBirth = new Date(d, m, y);
	}



//toString method
@Override
public String toString(){
 
	return name + " " + dateOfBirth; 
}
//Equals Method(can leave for subclass)
//@Override
//public boolean equals(Object obj) {
//	Person nObject;
//	if (obj instanceof Person)
//		nObject = (Person)obj;
//	else
//		return false;
//	return this.name.equals(nObject.name)
//			&& this.dateOfBirth.equals(nObject.dateOfBirth);
//			
//}

//Getter and setters
public Name getName()
{
	return name;
}
public Date getDateOfBirth()
{
	return dateOfBirth;
}

public void setName(Name namein)
{
	name = namein;
}
public void setDateOfBirth(Date dateOfBirthin)
{
	dateOfBirth = dateOfBirthin;
}









}

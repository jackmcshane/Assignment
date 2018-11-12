package ie.lyit.flight;

import java.io.Serializable;
//the name classed is used for the parameters
//of title. first name and last name
public class Name implements Serializable{
	private String firstName;
	private String title;
	private String surname;
//Name n1 = new Name();
public Name(){
	
	firstName = null;
	surname = null;
	title = null;
	
}

public Name(String t, String fN, String sN) {
	
	this.firstName = fN;
	this.title= t;
	this.surname = sN;
}
//toString method
@Override
public String toString(){
   
	return title + " " + firstName + " " + surname; 
 }
//Equals Method
@Override
public boolean equals(Object obj) {
	Name nObject;
	if (obj instanceof Name)
		nObject = (Name)obj;
	else
		return false;
	return this.title.equals(nObject.title)
			&& this.firstName.equals(nObject.firstName)
			&& this.surname.equals(nObject.surname);
}

//getters/////////////////////
public String getFirstName()
{
	return firstName;
}
public String getTitle()
{
	return title;
}
public String getSurname()
{
	return surname;
}
//setters/////////////////////
//e.g n1.setTitle("mrs")
public void setFirstName(String firstName)
{
	this.firstName = firstName;
}
public void setTitle(String title)
{
	this.title = title;
}
public void setSurname(String surname)
{
	this.surname = surname;
}

//Comparison
public boolean isFemale() {
	if(title.equalsIgnoreCase("Miss")||
	   title.equalsIgnoreCase("Ms")||
	   title.equalsIgnoreCase("Mrs"))
		return true;
	else 
		return false;
 }

}

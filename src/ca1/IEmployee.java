package ca1;

public interface IEmployee {
	 
	 String getFirstName();
	 String getLastName();
	 String getEmail();
	 String getSMS();
	 							/*	N.B. Mistake I made earlier was that in the main "people" arraylist, if I define type IEmployee
	 							* 	(in order to allow mix of employee types), I can ONLY [safely] call methods which are common
	 							* 	to ALL guest types and which are required as per the Interface specification!
	 							* 	
	 							* 	Though, if I need a workaround and KNOW I'm expecting a Contractor guest from the list,
	 							* 	I can cheat and cast that object from IEmployee to Contractor, to access a contractor-specific 
	 							* 	method. Thats really bad practice though.
	 							*/ 
}

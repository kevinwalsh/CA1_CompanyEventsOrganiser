package ca1;

import java.util.Date;

public class Contractor extends EmployeeBase {

	Date dob;
	String company;
	String contact;
	
	public Contractor(String first,String last,String email, String mob, Date dob, String company, String contact){
		super(first,last,email,mob);
		this.dob = dob;
		this.company=company;
		this.contact=contact;
		
	}
}

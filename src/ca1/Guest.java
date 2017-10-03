package ca1;

public class Guest extends EmployeeBase{

	String company;
	String contact;
	
	public Guest(String first,String last,String email, String mob, String company, String contact){
		super(first,last,email,mob);
		this.company=company;
		this.contact=contact;
	}
	
}

package ca1;

import java.util.Date;

public class GenEmp extends EmployeeBase {
	Date dob;
	int salary;
	String jobtitle;
	
	public GenEmp(String first,String last,String email, String mob, Date dob, int salary, String jobtitle){
		super(first,last,email,mob);
		this.dob = dob;
		this.salary=salary;
		this.jobtitle=jobtitle;	
	}
	
}

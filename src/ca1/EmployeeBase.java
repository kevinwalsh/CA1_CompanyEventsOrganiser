package ca1;

public class EmployeeBase implements IEmployee{
					//	Base class, to reduce code duplication & group common features.
					//	for purposes of simplification, a "Guest" is a valid extension.
					//		(obviously would have to be changed IF we gave EmployeeBase functionality related to internal operations)

	protected String first;
	protected String last;				// private/protected fields, plus getters & setters to help control external access/modification.
	protected String email;					//no verification or validation done here, but is good practice
	protected String mob;
	
	public EmployeeBase(String first, String last, String email, String mob){
		this.first=first;
		this.last=last;
		this.email=email;
		this.mob=mob;
		
	}

	public String getFirstName() {
		return this.first;
	}
	public String getLastName() {
		return this.last;
	}
	
	@Override
	public String getEmail() {
		return this.email;
	}

	@Override
	public String getSMS() {
		return this.mob;
	}
	
}

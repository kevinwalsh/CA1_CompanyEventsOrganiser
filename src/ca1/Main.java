package ca1;

import java.util.ArrayList;
import java.util.Date;

public class Main {
		/*	---------------------------------------------------------------------------------------------------
		 * 	4 MAIN STAGES OF APPLICATION:
		 * 		(0)		initialise req'd variables like our SMSService and empty "people" arraylist, for later use
		 * 		(1) addEmployees() - Initial sample data setup/"import" for later access and use. (A db is overkill for this application).
		 * 				->	Create 2 of each type, even though we arent going to add them all.
		 * 		(2)	makeEvent() - set up an event object, which requires an administrator/ owner employee, and a communication service.
		 * 		(3) populateEvent() - add users to event. (this is currently badly designed- Employee isnt "choosing" to sign up,
		 * 							but rather theyre just being added to event list.
		 * 		(4) changeCommService() - demonstrating effective DIP - switch commService from email to SMS; my Event doesnt care
		 * 							or behave differently and continues to work.
		 * 		(5) runEvent() - shows that once event is finished, it will send out a thankyou message to all attendees.
		 *	---------------------------------------------------------------------------------------------------
		 * */

	static ArrayList<IEmployee> people;
	static ICommService emailservice;
	static ICommService smsservice;

	public static void main(String[] args) {
		people= new ArrayList<IEmployee>();
		emailservice= new Email();
		smsservice = new SMS();
		
		addEmployees();
		//PrintEmpNames();
		Events e1=makeEvent(emailservice,people.get(2));	//simple way! (yep working)
		populateEvent(e1);
		changeCommService(e1,smsservice);		//changing to SMS instead of email
		runEvent(e1);
	}
	
	private static void addEmployees(){
		addEmpBase();
		addGenEmp();
		addGuest();
		addContractor();
	}
	
	private static void addEmpBase(){
		people.add(new EmployeeBase("Tom","Clarke", "tdawg@gmail.com", "123456"));
		people.add(new EmployeeBase("Podge","Pearse", "peepee@gmail.com", "643735"));
	}

	private static void addGenEmp(){
		Date mydate= new Date (1/1/2000);
		//warnings are just telling me Date is deprecated, and should be replaced with Calendar
		mydate.setDate(1/1/2000);	
		people.add(new GenEmp("general","emp", "genemp1@gmail.com", "23567", mydate, 27000, "general"));
		mydate.setYear(1990);
		people.add(new GenEmp("gen2","emp2", "ge2@gmail.com", "72347", mydate, 18000, "assT general"));
	}
	
	private static void addGuest(){
		people.add(new Guest("rod","flanders", "rod@gmail.com", "123456", "flancrest Ltd", "ned F"));
		people.add(new Guest("todd","flanders", "todd@gmail.com", "123456","flancrest ltd","ned F"));	
	}
	
	private static void addContractor(){
		Date mydate= new Date (2/2/1988);	
		people.add(new Contractor("joey","jojo", "jojo@gmail.com", "123456", mydate, "mycompany", "mycontact"));
		mydate.setDate(3/3/1967);
		people.add(new Contractor("chanandler","bong", "chandz@gmail.com", "123456", mydate, "company2","contact2"));
	}
	
	private static void printEmpNames(){
		for(IEmployee person: people) {
			System.out.print("Employee Name: ");
			System.out.println(person.getFirstName());
		}
	}
	
	private static Events makeEvent(ICommService s,IEmployee emp){	
				Events e= new Events (s,emp);
				return e;
	}	
	
	private static void populateEvent(Events e){
		//this is generic, adds every 2nd of my sample employees to event, for ProofOfConcept
			for(int person=0;person<people.size();person+=2){
				e.addAttendee(people.get(person));		//hopefully adds every 2nd person
			}
		}
	
	private static void changeCommService(Events e, ICommService s){
		e.setService(s); 	//switch to new comms protocol (SMS here)
	}
	
	private static void runEvent(Events e){
		e.finishEvent();	//ie event starts, finishes, emails attendees
	}
	
	
}

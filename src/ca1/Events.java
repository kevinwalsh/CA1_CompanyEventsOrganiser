package ca1;

import java.util.ArrayList;

public class Events {			/* Use plural, so as to avoid issues or confusion with System class java.awt.Event
										(Even though its technically allowed since I dont use that system class!)   */ 
	
	IEmployee admin;		//admin user/ event creator. (I might be getting too complex here!	recall KISS and YAGNI principles!)

	ArrayList<IEmployee> attendees;
	ICommService s;
	
	public Events(ICommService service, IEmployee creator){
		admin=creator;		//person who set up event. This will be the "from" var in the post-event thankyou messages
		attendees = new ArrayList<IEmployee>();
		s=service;		//my method of communication; SMS, email, smoke signal, etc
	}
	
	public void addAttendee(IEmployee e){
		attendees.add(e);
		confirmAttendee(e);
	}
	
	public void confirmAttendee (IEmployee e){
		s.sendMessage(admin, e, "This message is to confirm you're registered for this event");
	}
	
	public void setService(ICommService service){
		this.s=service;				/* (SRP violation)- this probably isnt the job of Events to set/change
									* the service it uses, BUT a getter/setter is simple & harmless enough for now.
									*/ 
	}
	
	public void finishEvent() {		/*cant think of any better name;
									*basically email everyone a thankyou when event ends
									*/	
		String msg= "Hey everyone, thanks for attending this event. We hope you all had a great time!";
				
		for(IEmployee i:attendees){
			s.sendMessage(admin, i, msg);
		}
	}
	
	
}

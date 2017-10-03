package ca1;

public interface ICommService {

	public void sendMessage(String from, String to, String string);
					//actual internal messaging functionality; in real world we would call msg API
	
	public void sendMessage(IEmployee from, IEmployee to, String string);
		// generic/ highlevel method; internally includes getters to probe attendee details 
}

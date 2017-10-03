package ca1;

public class Email implements ICommService {

	
	public void sendMessage(String from, String to, String msg)	{
			//in realworld system, this would implement actual email functionality/ protocols
		System.out.print("EMAIL TRANSCRIPT FROM "+from+" TO "+to+" : ");
		System.out.println(msg);
	}

	@Override
	public void sendMessage(IEmployee from, IEmployee to, String msg) {		
		sendMessage(from.getEmail(),to.getEmail(),msg);	
	}
										/* high-level/ initial prep function. this gathers the relevant contact details
										 * from the employees (in this case SMS), because other classes shouldnt have
										 * to worry about this.	In future versions, this should probably be in an
										 * SMSPrep class, to adhere militantly to S.R.P.
										 */
	
}

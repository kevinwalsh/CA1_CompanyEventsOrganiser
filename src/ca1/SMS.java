package ca1;

public class SMS implements ICommService {

	@Override
	public void sendMessage(String from, String to, String msg) {
		System.out.print("SMS FROM "+from+" TO "+to+" : ");			//	"header", sender and reciever info
		System.out.println(msg);									// message content
	}

	@Override
	public void sendMessage(IEmployee from, IEmployee to, String msg) {				
		sendMessage(from.getSMS(),to.getSMS(),msg);									
													/* high-level/ initial prep function. this gathers the relevant contact details
													 * from the employees (in this case SMS), because other classes shouldnt have
													 * to worry about this.	In future versions, this should probably be in an
													 * SMSPrep class, to adhere militantly to S.R.P.
													 */
	}

}

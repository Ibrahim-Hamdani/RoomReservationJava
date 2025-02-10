
public class Objects_Rooms {

	int SerialNoOfRoom;
	String KindOfRoom;
	double Room_Cost;
	boolean IncludedBalcony;
	boolean IncludedLounge;
	String EMail;
	
	Objects_Rooms(int serialNoOfRoom, String kindOfRoom, double room_Cost, boolean includedBalcony, boolean includedLounge, String eMail ){
		SerialNoOfRoom = serialNoOfRoom;
		KindOfRoom = kindOfRoom;
		Room_Cost = room_Cost;
		IncludedBalcony = includedBalcony;
		IncludedLounge = includedLounge;
		EMail = eMail;
	}
	public int takeSerialNoOfRoom() {
		return SerialNoOfRoom;	
	}
	public String takeKindOfRoom() {
		return KindOfRoom;
	}
	public double takeRoom_Cost () {
		return Room_Cost;
	}
	public boolean takeInfoOfBalcony() {
		return IncludedBalcony;
	}
	public boolean takeInfoOfLounge() {
		return IncludedLounge;
	}
	public String takeEmail() {
		return EMail;
	}
	public void askForEmail(String eMail) {
		EMail = eMail;
	}
	}


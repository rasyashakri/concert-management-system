public class Seat {

	//Attribute
	private String seatID;
	private char seatType; //R - Regular, P - Premium, V - VIP
	private double seatPrice; //Regular - RM250, Premium - RM430, VIP - RM870,
	private char seatStatus; //A - Available, B - Booked

	//Normal Constructor
	public Seat(String seatID, char seatType, double seatPrice, char seatStatus)
	{
		this.seatID = seatID;
		this.seatType = seatType;
		this.seatPrice = seatPrice;
		this.seatStatus = seatStatus;
	}

	//Setter Method
	public void setSeatID(String seatID) {
		this.seatID = seatID;
	}

	 public void setSeatType(char seatType) {
		this.seatType = seatType;
	}

	 public void setSeatPrice(double seatPrice) {
		this.seatPrice = seatPrice;
	}

	 public void setSeatStatus(char seatStatus) {
		this.seatStatus = seatStatus;
	}

	//Getter Method
    public String getSeatID() {return seatID;}
    public char getSeatType() {return seatType;}
    public double getSeatPrice() {return seatPrice;}
    public char getSeatStatus() {return seatStatus;}

    //Printer method
	public void displaySeat() {
		System.out.print("\nSeat ID: " + seatID);
		System.out.print(" Seat Type (R - Regular, P - Premium, V - VIP): " + seatType);
		System.out.print(" Price:RM " + seatPrice);
		System.out.print(" Status (A - Available, B - Booked): " + seatStatus);
	}
}


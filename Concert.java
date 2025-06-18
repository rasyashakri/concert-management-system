//INDSUTRY: ENTERTAIMENT
public class Concert {

	//Attributes
	private String ticketID;
	private String ICnum;
	private String custName;
	private String custEmail;
	private String custTelNo;
	private String concertName;
	private String artist;
	private String venue;
	private String concertTime;
	private String concertDate;

	//Normal Constructor
	public Concert (String ticketID, String ICnum, String custName, String custEmail,
	String custTelNo, String concertName,  String artist, String venue, String concertDate,  String concertTime)
	{
		this.ticketID = ticketID;
		this.ICnum = ICnum;
		this.custName = custName;
		this.custEmail = custEmail;
		this.custTelNo = custTelNo;
		this.concertName = concertName;
		this.artist = artist;
		this.venue = venue;
		this.concertDate = concertDate;
		this.concertTime = concertTime;
	}

	//Setter Method
	public void setTicketID(String ticketID) {
		this.ticketID = ticketID;
	}

	public void setICnum(String ICnum) {
		this.ICnum = ICnum;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}

	public void setCustTelNo(String custTelNo) {
		this.custTelNo = custTelNo;
	}

	public void setConcertName(String concertName) {
		this.concertName = concertName;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public void setConcertDate(String concertDate) {
		this.concertDate = concertDate;
	}

	public void setConcertTime(String concertTime) {
		this.concertTime = concertTime;
	}


	//Getter Method
	public String getTicketID()	{return ticketID;}
	public String getICnum() {return ICnum;}
	public String getCustName() {return custName;}
	public String getCustEmail() {return custEmail;}
	public String getCustTelNo() {return custTelNo;}
	public String getConcertName() {return concertName;}
	public String getArtist() {return artist;}
	public String getVenue() {return venue;}
	public String getConcertDate() {return concertDate;}
	public String getConcertTime() {return concertTime;}


    //Printer Method
    public String toString()
    {
	 String info = "\nTicket ID: " + ticketID + "\nIC Number: " + ICnum +  "\nCustomer's Name: " + custName
	 + "\nEmail: " + custEmail + "\nTelephone Number: "+ custTelNo + "\nConcert Name: " + concertName
	 + "\nArtist: " + artist + "\nVenue: " + venue + "\nDate: " + concertDate + "\nTime: " + concertTime ;

	 return info;
    }
}

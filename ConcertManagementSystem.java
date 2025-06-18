
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
import java.io.IOException;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.util.Collections;


public class ConcertManagementSystem {
	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);

		//INDUSTRY: ENTERTAIMENT
		//Linked List declaration
		LinkedList<Concert> concertList = new LinkedList<Concert>();
		LinkedList<Seat> seatList = new LinkedList<Seat>();

		File fi = new File("Input.txt");
		FileReader fr = new FileReader(fi);
		BufferedReader br = new BufferedReader(fr);

		int index  = 0;
		String s  = br.readLine();

		while (s != null) {

			StringTokenizer st = new StringTokenizer(s, ";");

			String id = st.nextToken();
			String icNum = st.nextToken();
			String custName = st.nextToken();
			String telNo = st.nextToken();
			String custEmail = st.nextToken();
			String concertName = st.nextToken();
			String artist = st.nextToken();
			String venue = st.nextToken();
			String concertDate= st.nextToken();
			String concertTime = st.nextToken();
			String seatID = st.nextToken();
			char seatType = st.nextToken().charAt(0);
			double seatPrice = Double.parseDouble(st.nextToken());
			char seatStatus = st.nextToken().charAt(0);

			Concert conc = new Concert(id, icNum, custName, custEmail, telNo, concertName,
			artist, venue, concertDate, concertTime);
			//INSERTION - adding object conc to concertList
			concertList.addLast(conc);

			Seat custSeat = new Seat(seatID, seatType, seatPrice, seatStatus);
			//INSERTION - adding object custSeat to seatList
			seatList.addLast(custSeat);

			index++;
			s = br.readLine();
		 }

		 br.close();

		 // Entry point of the System
		 System.out.println("\nWelcome to Concert Management System!");

		 int choice = 0;
		 while(choice != 6)
		 {
			 System.out.println("\n----------------------------------------------------------------------------------");
			 System.out.println("\nMain Menu\n");
			 System.out.println("1. Search for a Concert Information");
			 System.out.println("2. Sort Concert Information");
			 System.out.println("3. Update Concert Information");
			 System.out.println("4. Remove a Concert Record");
			 System.out.println("5. Display All Concert Details");
			 System.out.println("6. Exit the System");
			 System.out.print("\nPlease enter your choice: ");

			 choice = Integer.parseInt(sc.nextLine());


			//(i)SEARCHING - Sabilah
            if(choice == 1)
            {
                int search = 0;
                while (search != 3)
                {
                    System.out.println("\n----------------------------------------------------------------------------------");
                    System.out.println("\n\nSearching System");
                    System.out.println("1. Search Concert by Ticket ID");
                    System.out.println("2. Search Seat by Seat ID");
                    System.out.println("3. Exit");
                    System.out.print("\nPlease enter your choice: ");
                    search = Integer.parseInt(sc.nextLine());

                    // Traverse through the concertList to find the concert information by Ticket ID
                    Concert concert = concertList.getHead();
                    if(search == 1)
                    {
                        System.out.print("\nEnter Ticket ID: ");
                        String searchTicketID = sc.nextLine();

                        // to check if we found the concert
                        boolean found = false;
                        while(concert != null)
                        {
                            // If the current concert matches the given Ticket ID
                            if(concert.getTicketID().equals(searchTicketID))
                            {
                                found = true;
                                // Print the concert information
                                System.out.println("\nConcert Information Found:\n");
                                System.out.println("Ticket ID: " + concert.getTicketID());
                                System.out.println("Customer Name: " + concert.getCustName());
                                System.out.println("Email: " + concert.getCustEmail());
                                System.out.println("Phone: " + concert.getCustTelNo());
                                System.out.println("Concert Name: " + concert.getConcertName());
                                System.out.println("Artist: " + concert.getArtist());
                                System.out.println("Venue: " + concert.getVenue());
                                System.out.println("Date: " + concert.getConcertDate());
                                System.out.println("Time: " + concert.getConcertTime());
                                break;
                            }
                            concert = concertList.getNext();
						}

                        // If no concert was found with the given Ticket ID
                        if (!found)
                        {
                            System.out.println("No concert found with Ticket ID: " + searchTicketID);
                        }
					}


                    // TSearch Seat Information
                    else if(search == 2)
                    {
                        System.out.println("\n----------------------------------------------------------------------------------");
                        System.out.println("\nSearch Seat Information by Seat ID");

                        System.out.print("\nEnter Seat ID: ");
                        String searchSeatID = sc.nextLine();

                        boolean found = false;

                        // Traverse through the SeatList to find the Seat information by Seat ID
                        Seat seat = seatList.getHead();
                        while(seat != null)
                        {
                            if(seat.getSeatID().equals(searchSeatID))
                            {
                                found = true;
                                System.out.println("\nSeat Information Found:\n");
                                System.out.println("Seat ID: " + seat.getSeatID());
                                System.out.println("Seat Type (R - Regular, P - Premium, V - VIP): " + seat.getSeatType());
                                System.out.println("seat Price: " + seat.getSeatPrice());
                                System.out.println("Seat Status (A - Available, B - Booked): " + seat.getSeatStatus());
                                break;
                            }
                            seat = seatList.getNext();
                        }
                        // If no concert was found with the given Ticket ID
                        if (!found)
                        {
                            System.out.println("No seat found with seat ID: " + searchSeatID);
                        }
                    }
				}
			}

			//(ii)SORTING
			else if(choice == 2)
			{
				 int sort = 0;
				 while(sort != 3)
				 {
                	 System.out.println("\n----------------------------------------------------------------------------------");
					 System.out.println("\n\nSorting System");
					 System.out.println("1. Sort Seat according to Price");
					 System.out.println("2. Sort Ticket ID according to Venue");
					 System.out.println("3. Exit");
					 System.out.print("\nPlease enter your choice: ");

			 		sort = Integer.parseInt(sc.nextLine());

					//Display sorted seats according to their prices
					if(sort == 1)
					{
						sortSeats(seatList);
						Seat current = seatList.getHead();
						System.out.println("\nSeat Prices Sorted:");
						while (current != null)
						{
							System.out.println("Seat ID: " + current.getSeatID() + "  Seat Price:RM " + current.getSeatPrice());
							current = seatList.getNext();
						}
					}

					//Display sorted Ticket Details according to venue
					else if(sort == 2)
					{
						sortConcertsByVenue(concertList);
						Concert concert = concertList.getHead();
						System.out.println("\nSorted Concert based on Venue:");
						while (concert != null)
						{
							System.out.println("Ticket ID: " + concert.getTicketID() + "  Venue: " + concert.getVenue() + "  Artist: " + concert.getArtist());
							concert = concertList.getNext();
						}
					}
				}
			}

			//(iii)UPDATE
			else if (choice  == 3)
			{
			System.out.println("\n----------------------------------------------------------------------------------");
			System.out.println("\nUpdate Customer Information & Seat Information");

			System.out.print("\nEnter Customer IC: ");
			String icNum = sc.nextLine();
			System.out.println("  ");

			Concert current1 = concertList.getHead();
			Seat current2 = seatList.getHead();
			boolean found = false; //to check if the customer's ic exist

			while (current1 != null && current2 != null) {

				if (current1.getICnum().equals(icNum)) {
					found = true; //(Rasya) If ic exist
					System.out.print("Do you want to update Customer Information(A) or Seat Information(B)?\n ");
					System.out.print("\n*********************************************************************");
					char option = sc.nextLine().charAt(0);

					if (option == 'A' || option == 'a') {
						System.out.println("Current Customer Information: ");
						System.out.println("Name: " + current1.getCustName());
						System.out.println("Email: " + current1.getCustEmail());
						System.out.println("Phone: " + current1.getCustTelNo());

						// Update customer name
						System.out.print("Enter new customer name (or press Enter to keep unchanged): ");
						String newName = sc.nextLine();
						if (!newName.isEmpty()) {
							current1.setCustName(newName);
						}

						// Update customer email
						System.out.print("Enter new email (or press Enter to keep unchanged): ");
						String newEmail = sc.nextLine();
						if (!newEmail.isEmpty()) {
							current1.setCustEmail(newEmail);
						}

						// Update customer phone number
						System.out.print("Enter new phone number (or press Enter to keep unchanged): ");
						String newPhone = sc.nextLine();
						if (!newPhone.isEmpty()) {
							current1.setCustTelNo(newPhone);
						}

						System.out.println("Customer information updated successfully.");

					} else if (option == 'B' || option == 'b') {
						System.out.println("Current Seat Information: ");
						System.out.println("Seat ID: " + current2.getSeatID());
						System.out.println("Seat Type: " + current2.getSeatType());
						System.out.println("Seat Price(RM): " + current2.getSeatPrice());
						System.out.println("Seat Status: " + current2.getSeatStatus());

						// Update seat ID
						System.out.print("Enter new seat ID (or press Enter to keep unchanged): ");
						String newSeatID = sc.nextLine();
						if (!newSeatID.isEmpty()) {
							current2.setSeatID(newSeatID);
					 	}

						 // Update Seat Type
						 System.out.print("Enter the new Seat Type (R/P/V) (or press Enter to keep unchanged): ");
						 String newTypeInput = sc.nextLine();

						 if (!newTypeInput.isEmpty()) {  // If input is not empty
								if (newTypeInput.length() == 1) {
								 char newType = newTypeInput.charAt(0);
									current2.setSeatType(newType);
									System.out.println("Seat type updated successfully.");
							} else {
								System.out.println("Invalid input. Please enter exactly one character.");
							}
						}

						// Update seat price
						System.out.print("Enter new seat price (RM) (or press Enter to keep unchanged): ");
						String newPriceInput = sc.nextLine();
						if (!newPriceInput.isEmpty()) {
							try {
								double newPrice = Double.parseDouble(newPriceInput); // Parse input to double
								current2.setSeatPrice(newPrice);
								System.out.println("Seat price updated successfully.");
							} catch (NumberFormatException e) {
								System.out.println("Invalid input. Please enter a valid numeric value.");
							}
						}

						// Update seat status
						System.out.print("Enter new seat status (A/B) (or press Enter to keep unchanged): ");
						String newStatusInput = sc.nextLine();

							if (!newStatusInput.isEmpty()) {  // If input is not empty
								if (newStatusInput.length() == 1) {
									char newStatus = newStatusInput.charAt(0);
									current2.setSeatStatus(newStatus);
									System.out.println("Seat status updated successfully.");
								} else {
									System.out.println("Invalid input. Please enter exactly one character.");
								}
							}
						}
					}

					// Move to the next node
					current1 = concertList.getNext();
					current2 = seatList.getNext();
				}

				// If customer ic does not exist
				if (!found) {
					System.out.println("Customer with IC " + icNum + " not found.");
				}
			}

			 //(iv)REMOVAL
			 else if (choice == 4)
			 {
				 // Declare Temporary List
                 LinkedList<Concert> tempList = new LinkedList<Concert>();

                 System.out.println("\n----------------------------------------------------------------------------------");
                 System.out.print("\nEnter the Ticket ID to remove: ");
                 String ticketID = sc.nextLine();

                 boolean found = false;

                 // Traversing the concertList
                 Concert current = concertList.getHead();

                 while (current != null) {
                    if (current.getTicketID().equals(ticketID)) {
                        found = true;
                        tempList.addLast(current);
                        concertList.removeFirst();
                    }
                    current = concertList.getNext();
                }
                System.out.println("Booking with Ticket ID " + ticketID + " has been removed.");

				// If ticket ID does not exist
                if (!found) {
                    System.out.println("Booking with Ticket ID " + ticketID + " not found.");
                }

				// Display The Remaining Tickets
                System.out.println("Do you want to view the remaining tickets? (Y - Yes/ N - No)");
                char view = sc.nextLine().charAt(0);
                if (view == 'Y' || view == 'y')
                {
                    Concert data = concertList.getHead();
                    int x = 1;
                    while (data != null)
                    {
                        System.out.println("\n\nConcert List : " + "[ " + (x) + " ] ");
                        System.out.println(data.toString());

                        data = concertList.getNext();
                        x++;
                    }
				}
			 }

			 //(v)TRAVERSING - Display ALL concert in the list.
			 else if (choice == 5)
			 {
				 Concert current = concertList.getHead();
				 int i = 1;
				 while (current != null)
				 {
					 System.out.println("\n\nConcert List : " + "[ " + (i) + " ] ");
					 System.out.println(current.toString());

					 current = concertList.getNext();
					 i++;
		 		}
			}
		}
	} // End of main method

	// Bubble Sort to sort seats according to their price
	public static void sortSeats(LinkedList<Seat> seatList) {
		int n = seatList.getSize();

		for (int i = 0; i < n - 1; i++) {
			Node<Seat> current = seatList.head;
			Node<Seat> next = current.next;

			for (int j = 0; j < n - 1 - i; j++) {
				if (current.data.getSeatPrice() > next.data.getSeatPrice()) {

					Seat temp = current.data;
					current.data = next.data;
					next.data = temp;
				}
				current = next;
				next = next.next;
			}
		}
	}

	// Bubble Sort by Venue
    public static void sortConcertsByVenue(LinkedList<Concert> concertList) {
        int n = concertList.getSize();

        for (int i = 0; i < n - 1; i++) {
            Node<Concert> current = concertList.head;
            Node<Concert> next = current.next;

            for (int j = 0; j < n - 1 - i; j++) {

                if (current.data.getVenue().compareTo(next.data.getVenue()) > 0) {

                    Concert temp = current.data;
                    current.data = next.data;
                    next.data = temp;
                }

                current = next;
                next = next.next;
            }
        }
    }
} //End of Program


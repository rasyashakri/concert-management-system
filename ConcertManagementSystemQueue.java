import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
import java.io.IOException;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.util.Collections;

public class ConcertManagementSystemQueue {
	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);

		//INDUSTRY: ENTERTAIMENT
		//Queue declaration
		Queue<Concert> concertQ = new Queue<Concert>();
		Queue<Seat> seatQ = new Queue<Seat>();


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

			Concert conc = new Concert(id, icNum, custName, custEmail, telNo,
			concertName, artist, venue, concertDate, concertTime);
			//INSERTION - adding object conc to concertList
			concertQ.enqueue(conc);

			Seat custSeat = new Seat(seatID, seatType, seatPrice, seatStatus);
			//INSERTION - adding object custSeat to seatList
			seatQ.enqueue(custSeat);

			index++;
			s = br.readLine();
		 }

		 br.close();

		 System.out.println("Welcome to Concert Management System!");

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

					//Search Concert Information by Ticket ID
                    if(search == 1)
                    {
                        System.out.print("\nEnter Ticket ID: ");
                        String searchTicketID = sc.nextLine();

                        boolean found = false;
                        Queue<Concert> tempQueue = new Queue<Concert>();

                        while(!concertQ.isEmpty())
                        {
                            Concert concert = concertQ.dequeue();
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
                            }
                            tempQueue.enqueue(concert);
                        }

                        if (!found)
                        {
                            System.out.println("No concert found with Ticket ID: " + searchTicketID);
                        }
                        //Restore the original queues
                        while(!tempQueue.isEmpty())
                        {
                            concertQ.enqueue(tempQueue.dequeue());
                        }
                    }

                    //Search Seat Information by Ticket ID
                    else if(search == 2)
                    {
                        System.out.println("\n----------------------------------------------------------------------------------");
                        System.out.println("\nSearch Seat Information by Seat ID");

                        System.out.print("\nEnter Seat ID: ");
                        String searchSeatID = sc.nextLine();

                        boolean found = false;

                        Queue<Seat> tempQueue = new Queue<Seat>();
                        while(!seatQ.isEmpty())
                        {
                            Seat seat = seatQ.dequeue();
                            if(seat.getSeatID().equals(searchSeatID))
                            {
                                found = true;
                                System.out.println("\nSeat Information Found:\n");
                                System.out.println("Seat ID: " + seat.getSeatID());
                                System.out.println("Seat Type (R - Regular, P - Premium, V - VIP): " + seat.getSeatType());
                                System.out.println("seat Price: " + seat.getSeatPrice());
                                System.out.println("Seat Status (A - Available, B - Booked): " + seat.getSeatStatus());
                            }
                            tempQueue.enqueue(seat);
                        }

                        if (!found)
                        {
                            System.out.println("No seat found with seat ID: " + searchSeatID);
                        }
                        //Restore the original queues
                        while (!tempQueue.isEmpty())
                        {
                            seatQ.enqueue(tempQueue.dequeue());
                        }
                    }
                }
			 }

			//(ii)SORTING - Rasya
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
					if(sort == 1)
					{
						//Call and display sorted seat price
						sortSeatPrice(seatQ);
						System.out.println("\nSeat Prices Sorted:");
						while (!seatQ.isEmpty()) {
							Seat current = seatQ.dequeue();
							System.out.println("Seat ID: " + current.getSeatID() + "  Seat Price: RM " + current.getSeatPrice());
						}
					}

					else if(sort == 2)
					{
						//Call and display sorted concert based on venue
						sortConcertByVenue(concertQ);
						System.out.println("\nSorted Concert based on Venue:");
						while (!concertQ.isEmpty()) {
							Concert concert = concertQ.dequeue();
							System.out.println("Ticket ID: " + concert.getTicketID() + "  Venue: " + concert.getVenue() + "  Artist: " + concert.getArtist());
						}
					}
				}
			}


			 //(iii)UPDATE - Hanna
			 else if (choice  == 3)
			 {

				 System.out.println("\n----------------------------------------------------------------------------------");
				 System.out.println("\nUpdate Customer Information & Seat Information");

				 System.out.print("\nEnter Customer IC: ");
				 String icNum = sc.nextLine();
				 System.out.println("  ");

				 Queue<Concert> tempConcertQ = new Queue<>();
				 Queue<Seat> tempSeatQ = new Queue<>();

				 boolean found = false;

				 // Traverse through the queues
				 while (!concertQ.isEmpty() && !seatQ.isEmpty()) {
					 Concert current1 = concertQ.dequeue();
					 Seat current2 = seatQ.dequeue();

					 if (current1.getICnum().equals(icNum)) {
					 	 found = true;

						 System.out.print("Do you want to update Customer Information(A) or Seat Information(B)?\n ");
						 System.out.print("\n*********************************************************************");
						 char option = sc.nextLine().charAt(0);

						 if (option == 'A' || option == 'a') {
						 	 System.out.println("Current Customer Information: ");
							 System.out.println("Name: " + current1.getCustName());
							 System.out.println("Email: " + current1.getCustEmail());
							 System.out.println("Phone: " + current1.getCustTelNo());

							 // Update customer details
							 System.out.print("Enter new customer name (or press Enter to keep unchanged): ");
							 String newName = sc.nextLine();
							 if (!newName.isEmpty()) {
							 	 current1.setCustName(newName);
							 }

							 System.out.print("Enter new email (or press Enter to keep unchanged): ");
							 String newEmail = sc.nextLine();
							 if (!newEmail.isEmpty()) {
								 current1.setCustEmail(newEmail);
							 }

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

							 // Update seat details
							 System.out.print("Enter new seat ID (or press Enter to keep unchanged): ");
							 String newSeatID = sc.nextLine();
							 if (!newSeatID.isEmpty()) {
								 current2.setSeatID(newSeatID);
							 }

							 System.out.print("Enter new Seat Type (R/P/V) (or press Enter to keep unchanged): ");
							 String newTypeInput = sc.nextLine();
							 if (!newTypeInput.isEmpty() && newTypeInput.length() == 1) {
								 current2.setSeatType(newTypeInput.charAt(0));
							 }

							 System.out.print("Enter new seat price (RM) (or press Enter to keep unchanged): ");
							 String newPriceInput = sc.nextLine();
							 if (!newPriceInput.isEmpty()) {
								 try {
									 current2.setSeatPrice(Double.parseDouble(newPriceInput));
								 } catch (NumberFormatException e) {
									 System.out.println("Invalid input. Please enter a valid numeric value.");
								 }
							 }

							 System.out.print("Enter new seat status (A/B) (or press Enter to keep unchanged): ");
							 String newStatusInput = sc.nextLine();
							 if (!newStatusInput.isEmpty() && newStatusInput.length() == 1) {
								 current2.setSeatStatus(newStatusInput.charAt(0));
							 }

							 System.out.println("Seat information updated successfully.");
						 }
					 }
					// Add the updated elements back to the temporary queues
					tempConcertQ.enqueue(current1);
					tempSeatQ.enqueue(current2);
				}

				// Restore the original queues
				while (!tempConcertQ.isEmpty()) {
					concertQ.enqueue(tempConcertQ.dequeue());
				}

				while (!tempSeatQ.isEmpty()) {
					seatQ.enqueue(tempSeatQ.dequeue());
				}

				if (!found) {
					System.out.println("Customer with IC " + icNum + " not found.");
				}
			}

			 //(iv)REMOVAL - Fatin
			 else if (choice == 4)
			 {
				System.out.println("\n----------------------------------------------------------------------------------");
				System.out.print("\nEnter the Ticket ID to remove: ");
				String ticketID = sc.nextLine().trim();

				boolean found = false;

				// Temporary queue to hold remaining concerts
				 Queue<Concert> tempQueue = new Queue<>();

				 // Process the queue
				 while (!concertQ.isEmpty()) {
					Concert concert = concertQ.dequeue();

					if (concert.getTicketID().equals(ticketID)) {
						found = true;
						System.out.println("Booking with Ticket ID " + ticketID + " has been removed.");
					} else {
						tempQueue.enqueue(concert);
					}
				}

				// If ticket ID does not exist
				if (!found) {
					System.out.println("Booking with Ticket ID " + ticketID + " not found.");
				}

				// Ask the user if they want to view remaining tickets
				Queue<Concert> tempQueue2 = new Queue<>(); //Temporary Queue (2) to store the data back to concertQ

				System.out.println("Do you want to view the remaining tickets? (Y - Yes/ N - No)");
				char view = sc.nextLine().charAt(0);

				int x = 1;
				if (view == 'Y' || view == 'y') {
					while (!tempQueue.isEmpty()) {
						Concert concert = tempQueue.dequeue();
						System.out.println("\n\nConcert List : [ " + x + " ]");
						System.out.println(concert.toString());
						concertQ.enqueue(concert);  // Restore to the original queue
						x++;
					}
				}
				else
				{
					// Restore the concerts to the original queue even when user select ("No")
					while (!tempQueue.isEmpty()) {
						concertQ.enqueue(tempQueue.dequeue());
					}
				}
			}

			 //(v)TRAVERSING - Display ALL concert in the list.
			 else if (choice == 5)
			 {
				 Queue<Concert> tempQueue = new Queue<Concert>();
				 int i = 1;

				 while(!concertQ.isEmpty())
				 {
				 	Concert current = concertQ.dequeue();

					System.out.println("\n\nConcert List : " + "[ " + (i) + " ] ");
					System.out.println(current.toString());
					tempQueue.enqueue(current);
					i++;
				 }

				 while(!tempQueue.isEmpty()) {
				 	concertQ.enqueue(tempQueue.dequeue());
				 }
			 }
		 }
	 }

	//(1)Bubble Sort - SORTING SEAT BY PRICE
	public static void sortSeatPrice(Queue<Seat> seatQ) {

		int size = 0;

		// Manually calculate the size of the queue
		Queue<Seat> tempQueue = new Queue<Seat>();
		while (!seatQ.isEmpty()) {
			Seat seat = seatQ.dequeue();
			tempQueue.enqueue(seat);
			size++;
		}

		while (!tempQueue.isEmpty()) {
			seatQ.enqueue(tempQueue.dequeue());
		}

		//Sorting process start:
		Queue<Seat> sortedQueue = new Queue<Seat>();
		for (int i = 0; i < size; i++) {
			Seat highest = null;
			int n = seatQ.getSize();

			for (int j = 0; j < n; j++) {
				Seat currentSeat = seatQ.dequeue();

				if (highest == null || currentSeat.getSeatPrice() > highest.getSeatPrice()) {
					if (highest != null) {
						seatQ.enqueue(highest);  //Re-enqueue previous highest if needed
					}
					highest = currentSeat;
				} else {
					seatQ.enqueue(currentSeat);  //Re-enqueue current seat if not the highest
				}
			}
			//After processing, add the highest seat to the sortedQueue
			sortedQueue.enqueue(highest);
		}

		//Refill seatQ with sorted values
		while (!sortedQueue.isEmpty()) {
			seatQ.enqueue(sortedQueue.dequeue());
		}
	}


     //***********************************************************************************************************************************

	//(2) Bubble Sort - SORTING CONCERT BY VENUE
	public static void sortConcertByVenue(Queue<Concert> concertQ) {

		int size = 0;

		//Manually calculate the size of the queue
		Queue<Concert> tempQueue = new Queue<Concert>();
		while (!concertQ.isEmpty()) {
			Concert concert = concertQ.dequeue();
			tempQueue.enqueue(concert);
			size++;
		}

		while (!tempQueue.isEmpty()) {
			concertQ.enqueue(tempQueue.dequeue());
		}

		//Sorting process start:
		Queue<Concert> sortedQueue = new Queue<Concert>();
		for (int i = 0; i < size; i++) {
			Concert first = null;
			int n = concertQ.getSize();

			for (int j = 0; j < n; j++) {
				Concert current = concertQ.dequeue();

				if (first == null || current.getVenue().compareTo(first.getVenue()) > 0) {
					if (first != null) {
						concertQ.enqueue(first);  //Re-enqueue previous first if needed
					}
					first = current;
				} else {
					concertQ.enqueue(current);  //Re-enqueue current if not the first
				}
			}
			//After processing, add the first values to the sortedQueue
			sortedQueue.enqueue(first);
		}

		//Refill concertQ with sorted values
		while (!sortedQueue.isEmpty()) {
			concertQ.enqueue(sortedQueue.dequeue());
		}
	}
} //End of program


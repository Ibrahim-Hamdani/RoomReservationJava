import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileReader;

   public class ReservationSystemOfRooms {
	

	

	    //array to store data from this gets filled from loop in main.
	    private static ArrayList<Objects_Rooms> displayAllRooms = new ArrayList<>();

	    //main Method with input output exception
	    public static void main(String[] args) throws IOException {

	        //used to call methods later in the switch so they don't have to be static
	    	ReservationSystemOfRooms classObject = new ReservationSystemOfRooms();

	        //reads appendix A file
	        FileReader Room_File_Reading= new FileReader("rooms-1 (3).txt");

	        //scans appendix A file
	        Scanner file_Read = new Scanner(Room_File_Reading);

	        //while loop that looks at the  .rooms-1 (3).txt file and writes the data into an the array above.
	        while (file_Read.hasNextInt()) {

	            int SerialNoOfRoom = file_Read.nextInt();
	            String KindOfRoom = file_Read.next();
	            double Room_Cos = file_Read.nextDouble();
	            boolean IncludedBalcony = file_Read.nextBoolean();
	            boolean IncludedLounge = file_Read.nextBoolean();
	            String EMail = file_Read.next();

	            Objects_Rooms Room_ToAdd = new Objects_Rooms(SerialNoOfRoom,KindOfRoom ,Room_Cos , IncludedBalcony, IncludedLounge, EMail);
	            displayAllRooms.add(Room_ToAdd);

	        }

	        classObject.menu_For_Client();

	    }

	    private void menu_For_Client() throws IOException {

	        //scanner was called and it scanned so it can be used in he method
	        Scanner Scanned = new Scanner(System.in);

	        System.out.println("- - Room Booking System - -");
	        System.out.println("");
	        System.out.println("");
	        System.out.println("- - MAIN MENU - -");
	        System.out.println("1 - Reserve Room");
	        System.out.println("2 - Cancel Room");
	        System.out.println("3 - View Room Reservations.");
	        System.out.println("Q - Quit");
            System.out.println("Pick :");
            
            //scan's the users input which the switch below can then use.
	        String Client_Input_Menu = Scanned.next();


	        /* Switch used to changed between methods based on the input from menu input scanner.
	         * before exiting it will call the SaveRooms method to save updated data to file*/
	        switch (Client_Input_Menu) {
	            case "1":
	            	client_Room_Reservation ();
	                break;
	            case "2":
	            	Client_Reservation_Cancelling();
	                break;
	            case "3":
	            	viewClientRoomReservation();
	                break;
	            case "Q":
	            	System.out.println("Hope to see you soon");
	            	Saved_Rooms();
	                System.exit(0);
	                break;
	            default:
	                System.out.println("\nError please try again and enter only the number for one of the options!\n");
	                menu_For_Client();
	                break;
	        }

	    }

	    private void client_Room_Reservation () throws IOException {

	        int J;
	        int K;
	        int L;


	        Scanner Scan = new Scanner(System.in);

	        System.out.println("--Please select a room Type from the options-- \n1-Single\n2-Double\n3-Suite");

	        String ReserveIntput = Scan.next();

	        //switch takes the user input and prints the rooms that match their choice, less the rooms are booked then they wont print.
	        switch (ReserveIntput) {
	            case "1":
	                System.out.println("--Here is  the list of our available single rooms-- \n");

	                //for loop to index each line in the appendix A file
	                for (J = 0; J < 17; J++) {
	                    //finds the lines that contain the word single and don't contain an @ because if they have an @ they are booked
	                    if (displayAllRooms.get(J).takeKindOfRoom().equalsIgnoreCase("Single") && !displayAllRooms.get(J).takeEmail().contains("@")) {

	                        System.out.println("Room Number:" + (displayAllRooms.get(J).takeSerialNoOfRoom() + ", Room Type:"
	                                + (displayAllRooms.get(J).takeKindOfRoom() + ", RoomPrice:" + (displayAllRooms.get(J).takeRoom_Cost()
	                                + ", Room has balcony:" + (displayAllRooms.get(J).takeInfoOfBalcony() + ", Has Lounge:" + (displayAllRooms.get(J).takeInfoOfLounge()))))));
	                    }
	                }

	                // after the user gets a list of the type of room they wanted it asks them to enter the number of that room.
	                System.out.println("\n--Please enter room number you would like to book--");
	                int no_Of_Input1 = Scan.nextInt();

	                // after they choose the room number they enter their email address.
	                System.out.println("\nPlease Enter your email address to complete booking");
	                String Client_Email_1 = Scan.next();

	                /* set's the email from "free" to the users email to show the room is booked.
	                 * for the room number they chose. the for loop indexes each line same as above to find
	                 * the room number*/
	                for (J = 0; J < 17; J++) {
	                    if (displayAllRooms.get(J).takeSerialNoOfRoom() == no_Of_Input1) {

	                    	displayAllRooms.get(J).askForEmail(Client_Email_1);

	                    }

	                }

	                Saved_Rooms();

	                break;
	            case "2":
	                //each case works the same way as explained in case 1 comments.
	                System.out.println("--Here is  the list of our available Double rooms-- \n");

	                for (K = 0; K < 17; K++) {
	                    if (displayAllRooms.get(K).takeKindOfRoom().equalsIgnoreCase("Double") && !displayAllRooms.get(K).takeEmail().contains("@")) {

	                        System.out.println("Room Number:" + (displayAllRooms.get(K).takeSerialNoOfRoom() + ", Room Type:"
	                                + (displayAllRooms.get(K).takeKindOfRoom() + ", RoomPrice:" + (displayAllRooms.get(K).takeRoom_Cost()
	                                + ", Room has balcony:" + (displayAllRooms.get(K).takeInfoOfBalcony() + ", Has Lounge:" + (displayAllRooms.get(K).takeInfoOfLounge()))))));


	                    }
	                }

	                System.out.println("\n--Please enter room number you would like to book--");
	                int no_Of_Input2 = Scan.nextInt();

	                System.out.println("\nPlease Enter your email address to complete booking");
	                String Client_Email_2 = Scan.next();

	                for (K = 0; K < 17; K++) {
	                    if (displayAllRooms.get(K).takeSerialNoOfRoom() == no_Of_Input2) {

	                    	displayAllRooms.get(K).askForEmail(Client_Email_2);

	                    }

	                }

	                Saved_Rooms();

	                break;

	            case "3":
	                System.out.println("--Here is  the list of our available suite rooms-- \n");

	                for (L = 0; L < 17; L++) {
	                    if (displayAllRooms.get(L).takeKindOfRoom().equalsIgnoreCase("Suite") && !displayAllRooms.get(L).takeEmail().contains("@")) {

	                        System.out.println("Room Number:" + (displayAllRooms.get(L).takeSerialNoOfRoom() + ", Room Type:"
	                                + (displayAllRooms.get(L).takeKindOfRoom() + ", RoomPrice:" + (displayAllRooms.get(L).takeRoom_Cost()
	                                + ", Room has balcony:" + (displayAllRooms.get(L).takeInfoOfBalcony() + ", Has Lounge:" + (displayAllRooms.get(L).takeInfoOfLounge()))))));
	                    }
	                }

	                System.out.println("\n--Please enter room number you would like to book--");
	                int no_Of_Input3    = Scan.nextInt();

	                System.out.println("\nPlease Enter your email address to complete booking");
	                String UserEmail3 = Scan.next();

	                for (K = 0; K < 17; K++) {
	                    if (displayAllRooms.get(K).takeSerialNoOfRoom() == no_Of_Input3) {

	                    	displayAllRooms.get(K).askForEmail(UserEmail3);

	                    }

	                }

	                Saved_Rooms();

	                break;

	            // default to start user main menu again if no matches are found.
	            default:
	                System.out.println("\nSorry you either entered the number wrong or no available rooms found." +
	                        "\nplease try again. only enter the number of your option or try a different room Type.\n");
	                menu_For_Client();
	                break;
	        }

	        //confirms room booking to the user
	        System.out.println("\nThanks your room is now booked\n");

	        //call the User menu method to give recurring options menu
	        menu_For_Client();

	    }


	    private void Client_Reservation_Cancelling () throws IOException {

	        boolean cancelled = false;

	        Scanner Scanned = new Scanner(System.in);

	        System.out.println("\n--To cancel Please enter the room number you booked--");

	        int No_Cancellation = Scanned.nextInt();

	        System.out.println("\n--Now please enter the email address you booked with--");

	        /* user can enter the email address they booked with and the system will look for their email
	         * so it can cancel there booking*/
	        String Input_Cancellation = Scanned.next();

	        /* if anything matches the users input of their email address then it will remove there email
	        address and replace it with free */
	        for (int G= 0; G < 17; G++) {
	            if (displayAllRooms.get(G).takeEmail().equalsIgnoreCase(Input_Cancellation) && displayAllRooms.get(G).takeSerialNoOfRoom() == No_Cancellation) {

	            	displayAllRooms.get(G).askForEmail("Free");

	                //confirms the room is cancelled
	                System.out.println("\nThanks. Your room has now been canceled");

	                cancelled = true;

	                //if the users input doesn't match anything it will give the error below and the user can try again
	            }

	        }

	        if (!cancelled) {
	            System.out.println("\nSorry we couldn't find your booking please try again and make sure you have entered the correct details.");
	        }

	        
	        Saved_Rooms();
	        menu_For_Client();

	    }


	    private void viewClientRoomReservation() throws IOException {

	        FileReader Room_File_Reading = new FileReader("rooms-1 (3).txt");

	        Scanner file_Read = new Scanner(Room_File_Reading);

	        System.out.println("\n-- Room Reservation Info -- ");

	        //while loop reads appendix A file and prints each line to show all the info in the file
	        while (file_Read.hasNextInt()) {

	        	int SerialNoOfRoom = file_Read.nextInt();
	            String KindOfRoom = file_Read.next();
	            double Room_Cos = file_Read.nextDouble();
	            boolean IncludedBalcony = file_Read.nextBoolean();
	            boolean IncludedLounge = file_Read.nextBoolean();
	            String EMail = file_Read.next();

	            Objects_Rooms Room_ToAdd = new Objects_Rooms(SerialNoOfRoom, KindOfRoom, Room_Cos, IncludedBalcony, IncludedLounge, EMail);
	            displayAllRooms.add(Room_ToAdd);

	          /* if Statement so the system prints out "booked" if the room is booked as booked rooms would contain
	           an email address and therefore contain a @ symbol  */
	            if (EMail.contains("@"))
	                EMail = "Booked";


	            System.out.println("Room number " + SerialNoOfRoom + ", Type:" + KindOfRoom + ", Has Balcony:" + IncludedBalcony + " ,Has Lounge:" + IncludedLounge + " is " + EMail);

	        }

	        //recurring option menu
	        menu_For_Client();

	    }

	    private void Saved_Rooms() throws IOException {

	       
	        PrintWriter FileWrite = new PrintWriter("rooms-1 (3).txt");
	       //file writer to write the data in the array to the appendix A file
	        
	        for (int T = 0; T < 17; T++) {
	        	// The Shown above for loop so that it index each line of the file of rooms
	           
	            FileWrite.println(displayAllRooms.get(T).takeSerialNoOfRoom() + " " + displayAllRooms.get(T).takeKindOfRoom()
	                    + " " + displayAllRooms.get(T).takeRoom_Cost() + " " + displayAllRooms.get(T).takeInfoOfBalcony() +
	                    " " + displayAllRooms.get(T).takeInfoOfLounge() + " " + displayAllRooms.get(T).takeEmail());
	            //above writes data from array to each line of the file of rooms.
	        }

	       
	        FileWrite.close();
	    }
	}


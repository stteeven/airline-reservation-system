import java.time.LocalDate;
import java.util.ArrayList;

/**
 * This class handles both the scheduling of specific flights and booking of passenger tickets. It  will keep running until someone explicitly quits the entire program. 
 * @author Steven Gong
 * Assignment HW05
 * Email: stevengo@usc.edu
 */
public class AirlineReservationSystem {
	
	// Initialize instance variables
	private ArrayList<Flight> myFlights;
	private String operatorMenu;
	private String passengerMenu;
	private IO helper;
	
	// Constructor(s)
	public AirlineReservationSystem(String operatorMenu, String passengerMenu) {
		this.myFlights = new ArrayList<Flight>();
		this.operatorMenu = operatorMenu;
		this.passengerMenu = passengerMenu;
		this.helper = new IO();
	}
	
	// Run the operator menu
	public void runOperatorCode() {

		// Get operator's menu choice
		boolean keepGoing = true;
		while (keepGoing) {
			// Print operator menu
			System.out.println(this.operatorMenu);
			// Get operator's menu choice
			int opChoice = helper.inputIntInRange("> ", -1, 5);
			// Add a flight
			if (opChoice == 1) {
				// Get operator's flight inputs
				String inputCityFrom = helper.inputLine("Origination city: ");
				String inputStateFrom = helper.inputLine("Origination state: ");
				String inputCityTo = helper.inputLine("Destination city: ");
				String inputStateTo = helper.inputLine("Destination state: ");
				String inputFlightNum = helper.inputLine("Flight number: ");
				// Display airlines and get airline
				Airline inputAirline = helper.getAirline();
				int inputNumRows = helper.inputIntInRange("Number of rows on the flight: ", 0, 35);
				// Create flight destination and origin locations based on user input
				Location from = new Location(inputCityFrom, inputStateFrom);
				Location to = new Location(inputCityTo, inputStateTo);
				Flight newFlight = new Flight(from, to, inputFlightNum, inputAirline, 0, inputNumRows);
				// Add new flight to the list
				myFlights.add(newFlight);
			}
			// Print seat map
			else if (opChoice == 2) {
				// Print out flight list to choose from 
				getMyFlights();
				// Get operator's  flight choice
				int flightChoice = helper.inputIntInRange("> ", 0, myFlights.size() - 1);
				// Print seat map for given flight
				myFlights.get(flightChoice).printSeatMap();
			}
			// Show all flights
			else if (opChoice == 3) {
				// Print out flight list
				getMyFlights();
			}
			// Load fake data
			else if (opChoice == 4) {
				loadFakeData();
			}
			// Print passenger list
			else if (opChoice == 5) {
				// Print out flight list to choose from 
				getMyFlights();
				// Get operator's  flight choice
				int flightChoice = helper.inputIntInRange("> ", 0, myFlights.size() - 1);
				// Print out the passengers on the flight
				System.out.println("***********************************************************************************************");
				for (Passenger p : myFlights.get(flightChoice).getPassengerList()) {
					System.out.println(p);
				}
				System.out.println("***********************************************************************************************\r\n");
			}
			// Exit operator menu
			else {
				keepGoing = false;
				break;
			}
		}	
	}
	
	// Run the passenger menu
	public void runPassengerCode() {
//		loadFakeData(); TODO: uncomment if you have not yet loaded fake data in the operator menu
		// Get user's information
		String inputName = helper.inputLine("Please enter person's name: ");
		int inputBirthYear = helper.inputIntInRange("Please enter year of birth: ", 1900, 2002);
		int inputBirthMonth = helper.inputIntInRange("Please enter month of birth: ", 1, 12);
		int inputBirthDay = helper.inputIntInRange("Please enter day of birth: ", 1, 31);
		// Create a new person profile based off the entered information
		Person person = new Person(inputName, inputBirthYear, inputBirthMonth, inputBirthDay);
		// Initiate while loop to keep passenger menu running
		boolean keepGoing = true;
		while (keepGoing) {
			// Print menu 
			System.out.println(this.passengerMenu);
			int passChoice = helper.inputIntInRange("> ", -1, 3);
			// Run the different menu options based on user input
			// Purchase seat
			if (passChoice == 1) {
				System.out.print("Current Passenger logged in as: " + person.getName() + "\r\n");
				// Print out flight list to choose from 
				getMyFlights();
				// Get passenger's flight choice
				int flightChoice = helper.inputIntInRange("> ", 0, myFlights.size() - 1);
				// Get the flight details
				String flightNum = myFlights.get(flightChoice).getFlightNum();
				Location flyFrom = myFlights.get(flightChoice).getFrom();
				Location flyTo = myFlights.get(flightChoice).getTo();
				BoardingType boardingType = BoardingType.GENERAL;
				// Create new passenger
				Passenger passenger = new Passenger(person, flightNum, boardingType);
				// Purchase a passenger ticket
				myFlights.get(flightChoice).purchaseTicket(passenger);
				System.out.println("Successfully purchased ticket.");
				// Add the passenger to the flight
				myFlights.get(flightChoice).addPassenger(passenger);

			}
			// Find reservation
			else if (passChoice == 2) {
				System.out.print("Current Passenger logged in as: " + person.getName() + "\r\n");
				getMyFlights();
				// Get passenger's flight choice
				int flightChoice = helper.inputIntInRange("> ", 0, myFlights.size() - 1);
				// Return flight reservation
				System.out.println("***********************************************************************************************");
				System.out.println("Found reservation: " + myFlights.get(flightChoice).getPassenger(person));
				System.out.println("\n***********************************************************************************************\r\n");
			}
			// Print boarding pass
			else if (passChoice == 3) {
				System.out.print("Current Passenger logged in as: " + person.getName() + "\r\n");
				getMyFlights();
				// Get passenger's flight choice
				int flightChoice = helper.inputIntInRange("> ", 0, myFlights.size() - 1);
				// Get the passenger's boarding pass if the user is a passenger on their chosen flight
				if (myFlights.get(flightChoice).getPassenger(person) != null) {
					System.out.println(myFlights.get(flightChoice).getPassenger(person).printBoardingPass(myFlights.get(flightChoice)));
					
				}
				else {
					System.out.println("Boarding pass not found.");
				}
			}
			// Exit passenger menu
			else if (passChoice == -1) {
				keepGoing = false;
				break;
			}
		}	
	}
	
	// Load fake data
	private void loadFakeData() {
		// Create some locations
		Location l1 = new Location("Paris", "France"); 
		Location l2 = new Location("Los Angeles" , "CA");
		Location l3 = new Location("Portland", "Oregon");
		Location l4 = new Location("Rome", "Italy");
		Location l5 = new Location("Washington", "DC");
		// Create some flights
		Flight f1 = new Flight(l1, l2, "UA1234", Airline.UNITED, 0, 20);
		Flight f2 = new Flight(l3, l2, "SW5533", Airline.SOUTHWEST, 0, 20);
		Flight f3 = new Flight(l4, l2, "AA5234", Airline.AMERICAN, 0, 20);
		Flight f4 = new Flight(l5, l2, "JB2343", Airline.JETBLUE, 0, 20);
		// Add flights to flight Arraylist
		this.myFlights.add(f1);
		this.myFlights.add(f2);
		this.myFlights.add(f3);
		this.myFlights.add(f4);
		// Create some passengers
		Passenger p1 = new Passenger("Thomas Trojantine", LocalDate.of(2000, 11, 1), "#UA1234", 1, "a", BoardingType.GENERAL);
		Passenger p2 = new Passenger("Thomas Thetrain", LocalDate.of(1998, 11, 1), "#UA1234", 1, "b", BoardingType.FIRST_CLASS);
		Passenger p3 = new Passenger("Harold Potting", LocalDate.of(2000, 12, 1), "#UA1234", 1, "c", BoardingType.GENERAL);
		// Add passengers to the first flight
		myFlights.get(0).addPassenger(p1);
		myFlights.get(0).addPassenger(p2);
		myFlights.get(0).addPassenger(p3);
		// Purchase tickets for each passenger on the flight
		myFlights.get(0).purchaseTicket(p1);
		myFlights.get(0).purchaseTicket(p2);
		myFlights.get(0).purchaseTicket(p3);
	}

	/**
	 * @return the list of flights
	 */
	public void getMyFlights() {
		// Loop through the flight list 
		for (int i = 0; i < myFlights.size(); i++) {
			// set up the flights and corresponding numbers to be printed
			String s = (i) + ": " + myFlights.get(i).toString();
			//print out flight along with corresponding number
			System.out.println(s);
		}
	}

	/**
	 * @param myFlights the myFlights to set
	 */
	public void setMyFlights(ArrayList<Flight> myFlights) {
		this.myFlights = myFlights;
	}


	/**
	 * @return the operatorMenu
	 */
	public String getOperatorMenu() {
		return operatorMenu;
	}


	/**
	 * @param operatorMenu the operatorMenu to set
	 */
	public void setOperatorMenu(String operatorMenu) {
		this.operatorMenu = operatorMenu;
	}


	/**
	 * @return the passengerMenu
	 */
	public String getPassengerMenu() {
		return passengerMenu;
	}


	/**
	 * @param passengerMenu the passengerMenu to set
	 */
	public void setPassengerMenu(String passengerMenu) {
		this.passengerMenu = passengerMenu;
	}
	
	// Main - run the airline reservation system
	public static void main(String args[]) {
		// Initialize operator menu
		String operatorMenu = "1: Add Flight\r\n" + 
				"2: Print Seat Map\r\n" + 
				"3: Show All Flights\r\n" + 
				"4: Load Fake Data\r\n" + 
				"5: Print Passenger List\r\n" + 
				"-1: Exit Operator Menu.";
		// Initialize passenger menu
		String passengerMenu = "1: Purchase Seat\r\n" + 
				"2: Find Reservation\r\n" + 
				"3: Print Boarding Pass\r\n" + 
				"-1: Exit Passenger Menu.";
		// Create an airline reservation system object
		AirlineReservationSystem ars = new AirlineReservationSystem(operatorMenu, passengerMenu);
		// While loop to keep the two menus running 
		boolean keepGoing = true;
		while (keepGoing) {
			// Ask the user to choose between the operator or passenger menu
			String menuChoice = ars.helper.inputWord("Press 'o' for operator menu and 'p' for passenger menu: ");
			// Return the menu that corresponds to the user's choice
			while (!(menuChoice.equalsIgnoreCase("o")) && !(menuChoice.equalsIgnoreCase("p"))) { // Error checking
				menuChoice = ars.helper.inputWord("Press 'o' for operator menu and 'p' for passenger menu: ");
			}
			// Run the operator code if user chooses "o"
			if (menuChoice.equalsIgnoreCase("o")) {
				ars.runOperatorCode();
			}
			// Run the passenger code if the user chooses "p"
			else {
				ars.runPassengerCode();
				}
			// Determine whether to keep running the system based on user input
			keepGoing = ars.helper.inputYesNoAsBoolean("Do you want to keep running the airline system (y/n)? ");
		}
		
	}
}

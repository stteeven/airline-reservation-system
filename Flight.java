import java.util.ArrayList;

/**
 * Flight clao
 * @author Steven Gong
 * Assignment HW05
 * Email: stevengo@usc.edu
 */
public class Flight {
	// Instance variables
	private Passenger[][] economySeatMap; // [row][column]
	private ArrayList<Passenger> passengerList;
	private int numEconomyRows;
	private Location to;
	private Location from;
	private String flightNum;
	private Airline airline;
	private int economySeatsSold;
	private int seatsTotals;
	private final int ECONOMY_SEATS_ACROSS = 6;
	private int rowCounter;
	private int colCounter;

// Constructor
public Flight(Location from, Location to, String flightNum, Airline airline, int economySeatsSold, int numEconomyRows) {
	this.to = to;
	this.from = from;
	this.flightNum = flightNum;
	this.airline = airline;
	this.numEconomyRows = numEconomyRows;
	this.economySeatsSold = economySeatsSold;
	this.seatsTotals = numEconomyRows*ECONOMY_SEATS_ACROSS;
	this.economySeatMap = new Passenger[numEconomyRows][ECONOMY_SEATS_ACROSS];
	this.passengerList = new ArrayList<Passenger>();
	}

// Purchase ticket
public void purchaseTicket(Passenger passenger) {
	if (this.economySeatsSold < this.seatsTotals) {
		// increment number of seats sold
		this.economySeatsSold++ ;
		// create a new passenger at the next open spot
		this.economySeatMap[rowCounter][colCounter] = passenger;
		// set the row and seat number of the passenger
		passenger.setRowNum(rowCounter);
		passenger.setSeatNumToStr(colCounter);
		if (colCounter < ECONOMY_SEATS_ACROSS) {
			colCounter++;
		}
		else {
			colCounter = 0;
			rowCounter++;
		}
	}		
	else {
		System.out.print("Flight is full.");
	}
}

// Print seat map
public void printSeatMap() {
	// print the column names
	System.out.println("  a b c d e f");
	// print the row numbers
	for (int i = 0 ; i < numEconomyRows; i++) {
		// align properly, accounting for single and double digits
		if (i<9) {
			System.out.print(i + 1 + "  ");
		}
		else {
			System.out.print(i + 1 + " ");
		}
		// Print out an x for filled seats and _ for empty seats
		for (int j = 0; j <ECONOMY_SEATS_ACROSS; j++) {
			if (economySeatMap[i][j] != null) {
				System.out.print("X ");
			}
			else {
				System.out.print("_ ");
			}
		}
		System.out.println();	
	}
}

// Add passenger
public void addPassenger(Passenger passenger) {
	this.passengerList.add(passenger);
}

// get passenger
public Passenger getPassenger(Person want) {
	int i = 0;
	// Loop through the passenger list
	while(i < passengerList.size()) {
		Passenger p = passengerList.get(i);
		// return the passenger if it matches the desired person
		if(p.equals(want)) {
			return p;
		}
		// continue looping otherwise
		else {
			i++;
		}
	}
	return null;
}

// GETTERS AND SETTERS 

/**
 * @return the passengerList
 */
public ArrayList<Passenger> getPassengerList() {
	return passengerList;
}

/**
 * @param passengerList the passengerList to set
 */
public void setPassengerList(ArrayList<Passenger> passengerList) {
	this.passengerList = passengerList;
}

/**
 * @return the numEconomyRows
 */
public int getNumEconomyRows() {
	return numEconomyRows;
}

/**
 * @param numEconomyRows the numEconomyRows to set
 */
public void setNumEconomyRows(int numEconomyRows) {
	this.numEconomyRows = numEconomyRows;
}

/**
 * @return the to
 */
public Location getTo() {
	return to;
}

/**
 * @param to the to to set
 */
public void setTo(Location to) {
	this.to = to;
}

/**
 * @return the from
 */
public Location getFrom() {
	return from;
}

/**
 * @param from the from to set
 */
public void setFrom(Location from) {
	this.from = from;
}

/**
 * @return the flightNum
 */
public String getFlightNum() {
	return flightNum;
}

/**
 * @param flightNum the flightNum to set
 */
public void setFlightNum(String flightNum) {
	this.flightNum = flightNum;
}

/**
 * @return the seatsTotals
 */
public int getSeatsTotals() {
	return seatsTotals;
}

/**
 * @param seatsTotals the seatsTotals to set
 */
public void setSeatsTotals(int seatsTotals) {
	this.seatsTotals = seatsTotals;
}

@Override
public String toString() {
	return airline + " Flight #" + flightNum + " from: " + from.toString() + " To: " + to.toString();
}

}
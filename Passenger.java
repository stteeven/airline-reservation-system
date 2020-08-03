import java.time.LocalDate;

/** Passenger is-a Person with a flight (or maybe just a flight num), seatNum and boardingType
 * Description
 * @author Steven Gong
 * Assignment HW05
 * Email: stevengo@usc.edu
 */
public class Passenger extends Person {
	// Initialize instance variables
	private String flightNum;
	private String seatNum;
	private int rowNum;
	private BoardingType boardingType;
//	private Person person;
	
	// Constructor(s)
	public Passenger (String name, LocalDate birthday, String flightNum, int rowNum, String seatNum, BoardingType boardingType) {
		super(name, birthday);
		this.flightNum = flightNum;
		this.rowNum = rowNum;
		this.seatNum = seatNum;
		this.boardingType = boardingType;
	}
	
	public Passenger(Person person, String flightNum, BoardingType boardingType) {
//		this.person = person;
		super(person.getName(),person.getBirthday());
		this.flightNum = flightNum;
		this.boardingType = boardingType;
		this.rowNum = rowNum;
		this.seatNum = seatNum;
	}
	
	// Print boarding pass
	public String printBoardingPass(Flight flight) {
		String boardingPass = "***********************************************************************************************\n" +
							"NAME: " + getName() +
							"\nFLIGHT " + getFlightNum() +
							"\n\n\tFLYING FROM: " + flight.getFrom() +
							"\n\tFLYING TO: " + flight.getTo() +
							"\n\nSEAT: " + getRowNum() + getSeatNum() +
							"\n\n\tBOARDING GROUP: " + getBoardingType().getPriority() +
							"\n***********************************************************************************************\n";
		return boardingPass;
	}
	
	// GETTERS AND SETTERS

	/**
	 * @return the name
	 */
	public String getName() {
		return super.getName();
	}

	/**
	 * @return the birthday
	 */
	public LocalDate getBirthday() {
		return super.getBirthday();
	}
	
	/**
	 * @return the rowNum
	 */
	public int getRowNum() {
		return rowNum;
	}

	/**
	 * @param rowNum the rowNum to set
	 */
	public void setRowNum(int rowNum) {
		this.rowNum = rowNum +1;
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
	 * @return the seatNum
	 */
	public String getSeatNum() {
		return seatNum;
	}

	/**
	 * @param integer seat number
	 * Sets the seat number to a string
	 */
	public void setSeatNumToStr(int seatNum) {
		if (seatNum == 0) {
			this.seatNum = "a";
		}
		else if (seatNum == 1) {
			this.seatNum = "b";
		}
		else if (seatNum == 2) {
			this.seatNum = "c";
		}
		else if (seatNum == 3) {
			this.seatNum = "d";
		}
		else if (seatNum == 4) {
			this.seatNum = "e";
		}
		else if (seatNum == 5) {
			this.seatNum = "f";
		}
	}
	

	/**
	 * @return the boardingType
	 */
	public BoardingType getBoardingType() {
		return boardingType;
	}

	/**
	 * @param boardingType the boardingType to set
	 */
	public void setBoardingType(BoardingType boardingType) {
		this.boardingType = boardingType;
	}
	
	// equals method that compares passengers
	public boolean equals(Passenger other) {
		boolean same = this.getName().equalsIgnoreCase(other.getName())
				&& this.getBirthday().equals(other.getBirthday());
		return same;
	}
	
	@Override
	public String toString() {
		return this.getName() + "  " + this.getRowNum() + this.getSeatNum() + "  " + this.getBoardingType();
	}
	
	
	
}

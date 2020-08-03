
/** 
 * class data type that combines city name with state or country name. 
 * @author Steven Gong
 * Assignment HW05
 * Email: stevengo@usc.edu
 */
public class Location {
	// Create instance variable
	String region;
	String city;
	
	// Constructor 
	public Location(String city, String region) {
		this.city = city;
		this.region = region;
	}
	
	/**
	 * @return the region
	 */
	public String getRegion() {
		return region;
	}

	/**
	 * @param region the region to set
	 */
	public void setRegion(String region) {
		this.region = region;
	}



	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}



	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	// equals method that compares locations
	public boolean equals(Location other) {
		boolean same = this.city.equalsIgnoreCase(other.city)
				&& this.region.equalsIgnoreCase(other.region);
		return same;
	}

	@Override
	public String toString() {
		return city + ", " + region;
	}
	
	
	
}

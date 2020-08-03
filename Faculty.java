import java.time.LocalDate;
/**
 * Description
 * @author Steven Gong
 * Assignment Details
 * Email: stevengo@usc.edu
 */
public class Faculty extends Person{

	private String officeLocation;

	/**
	 * @param name
	 * @param birthday
	 * @param officeLocation
	 */
	public Faculty(String name, LocalDate birthday, String officeLocation) {
		super(name, birthday);
		this.officeLocation = officeLocation;
	}
	
	
	public Faculty(String name, int year, int month, int day, String officeLocation) {
		this(name, LocalDate.of(year,  month, day), officeLocation);
	}
	
	
//	public Faculty(String name, LocalDate birthday, String officeLocation) {
//		
//	}
}

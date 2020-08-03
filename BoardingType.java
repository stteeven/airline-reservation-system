
/**
 * BoardingType represents types of passengers with an associated priority
 * @author Steven Gong
 * Assignment HW05
 * Email: stevengo@usc.edu
 */
public enum BoardingType {
	DISABLED (1),
	MILITARY (1),
	FIRST_CLASS (2),
	FAMILIES_WITH_SMALL_CHILDREN (3),
	HIGH_STATUS (4),
	LOW_STATUS (5),
	GENERAL (6);
	
	private int priority;
	
	private BoardingType(int num) {
		priority = num;
	}
	
	/**
	 * @return the priority
	 */
	public int getPriority() {
		return priority;
	}

	
}

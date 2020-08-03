import java.time.*;

/**
 * This class represents a Person as someone with a name and birthday
 * @author Steven Gong
 * Assignment HW05
 * Email: stevengo@usc.edu
 */
public class Person {
	private String name;
	private LocalDate birthday;
	
	public Person() {
	}
	
	public Person(String name, LocalDate birthday) {
		this.name = name;
		this.birthday = birthday;
	}
	
	public Person(String name, int year, int month, int day) {
		this(name, LocalDate.of(year, month, day));
	}
	
	public Person(String name, int year, Month month, int day) {
		this(name, LocalDate.of(year, month, day));
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the birthday
	 */
	public LocalDate getBirthday() {
		return birthday;
	}

	/**
	 * @param birthday the birthday to set
	 */
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", birthday=" + birthday + "]";
	}
	
	// equals method
	public boolean equals(Person other) {
		boolean same = this.name.equalsIgnoreCase(other.name)
				&& this.birthday.equals(other.birthday);
		return same;
	}
	
	
}


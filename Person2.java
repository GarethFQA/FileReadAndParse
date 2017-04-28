import java.util.ArrayList;

public class Person2 {
	String name;
	String dob;
	String occupation;
	int salary;
	ArrayList<Animal> pets = new ArrayList<Animal>();
	
	
	public Person2(String name, String dob, String occupation, int salary)
	{
		this.name = name;
		this.dob = dob;
		this.occupation = occupation;
		this.salary = salary;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDob() {
		return dob;
	}


	public void setDob(String dob) {
		this.dob = dob;
	}


	public String getOccupation() {
		return occupation;
	}


	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}


	public int getSalary() {
		return salary;
	}


	public void setSalary(int salary) {
		this.salary = salary;
	}


	public void addPet(Animal pet) {
		this.pets.add(pet);
	}

	public String toString()
	{
		return this.name + " was born " + this.dob + " and works as " + this.occupation + " earning a salary of £" + this.salary;
	}


	public ArrayList<Animal> getPets() {
		return pets;
	}


}


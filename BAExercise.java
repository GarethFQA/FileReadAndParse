import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class BAExercise {
		
	ArrayList<Person2> people = new ArrayList<Person2>();
	ArrayList<Animal> creatures = new ArrayList<Animal>();
	
	public BAExercise(String filename)
	{
		String fullFile = "";
		
		try(BufferedReader br = new BufferedReader(new FileReader(filename))) {
			
			String line = br.readLine();
    		fullFile += line;
    		line = br.readLine();
		    while (line != null) 
		    {

	    		if (!line.equals("%") && !line.equals("&") ) 
			    {		    		fullFile += "~" + line;
		    		line = br.readLine();
		    		System.out.println(fullFile);
			    }
	    		else
	    		{
		    		fullFile += line;
		    		line = br.readLine();
		    		fullFile += line;
		    		line = br.readLine();
		    		System.out.println(fullFile);
	    		}


		    }
		    
		}catch (IOException e) 
		{
			System.out.println("uhoh!");
			e.printStackTrace();

		}
		String[] sepObjects = fullFile.split("&");
		String[] sepPeople = sepObjects[0].split("%");
		String[] sepAnimals = sepObjects[1].split("%");
		
		for (int i = 0; i < sepPeople.length; i++)
		{

			String[] sepPerson = sepPeople[i].split("~");
			for (int j = 0; j < sepPerson.length; j++)
			{
				System.out.println(sepPerson[j]);
			}
			addPerson2(sepPerson[0], sepPerson[1], sepPerson[2], Integer.parseInt(sepPerson[3].replaceAll("£", "")));
			System.out.println("Person added");
		}
		
		for (int i = 0; i < sepAnimals.length; i++)
		{

			String[] sepCreature = sepAnimals[i].split("~");
			for (int j = 0; j < sepCreature.length; j++)
			{
				System.out.println(sepCreature[j]);
			}
			addAnimal(sepCreature[0], sepCreature[1]);
			System.out.println("Animal added");
		}
		
	}
	
	public void addPerson2(String name, String dob, String occupation, int salary)
	{
		Person2 tempPerson = new Person2(name, dob, occupation, salary);
		this.people.add(tempPerson);
	}
	
	public void addAnimal(String name, String species)
	{
		Animal tempAnimal = new Animal(name, species);
		this.creatures.add(tempAnimal);
	}
	
	public void addSpeciesToPerson(String personName, String animalSpecies)
	{
		
		Iterator<Person2> iterator = this.people.iterator();
		while(iterator.hasNext())
		{
			Person2 currentPerson = iterator.next();
			if (currentPerson.getName().equals(personName))
			{
				Iterator<Animal> iterator2 = this.creatures.iterator();
				while(iterator2.hasNext())
				{
					Animal currentAnimal = iterator2.next();
					if (currentAnimal.getSpecies().equals(animalSpecies))
					{
						currentPerson.addPet(currentAnimal);
						System.out.println("Person " + currentPerson.toString() + " and adopts pet " + currentAnimal.toString());
					}
				}
			}
			
		}
	}
	
	public int averageOwnerSalaryBySpecies(String species)
	{
		int totalSalary = 0;
		int ownerCount = 0;
		Iterator<Person2> iterator = this.people.iterator();
		while(iterator.hasNext())
		{
			Person2 currentPerson = iterator.next();
			Iterator<Animal> iterator2 = currentPerson.getPets().iterator();
			while(iterator2.hasNext())
			{
				Animal currentAnimal = iterator2.next();
				if (currentAnimal.getSpecies().equals(species))
				{
					totalSalary += currentPerson.getSalary();
					ownerCount++;
					break;
				}
				
			}
		}
		int averageSalary = 0;
		if (ownerCount != 0)
		{
			averageSalary = totalSalary/ownerCount;
		}
		return averageSalary;
	}
	
	public ArrayList<String> ownerOccupationBySpecies(String species)
	{
		ArrayList<String> jobs = new ArrayList<String>();
		
		Iterator<Person2> iterator = this.people.iterator();
		while(iterator.hasNext())
		{
			Person2 currentPerson = iterator.next();
			Iterator<Animal> iterator2 = currentPerson.getPets().iterator();
			while(iterator2.hasNext())
			{
				Animal currentAnimal = iterator2.next();
				if (currentAnimal.getSpecies().equals(species))
				{
					jobs.add(currentPerson.getOccupation());
					break;
				}
				
			}
		}

		return jobs;
	}
	
	public String ownerOccupationBySpeciesAsString(String species)
	{
		ArrayList<String> jobs = new ArrayList<String>();
		jobs = ownerOccupationBySpecies(species);
		String jobsWords = "The owners of pets that are " + species + "s have the jobs of ";
	
		Iterator<String> iterator = jobs.iterator();
		while(iterator.hasNext())
		{
			String currentJob = iterator.next();
			jobsWords += currentJob + ", ";
			
		}
		if (!jobsWords.equals("The owners of pets that are " + species + "s have the jobs of "))
		{
			jobsWords = jobsWords.substring(0, jobsWords.length()-2);
		}
		else
		{
			jobsWords = "There are no people who have a " + species + " as a pet";
		}
		return jobsWords;
	}
	
	public ArrayList<String> speciesOwnedByOccupation(String occupation)
	{
		ArrayList<String> petTypes = new ArrayList<String>();
		
		Iterator<Person2> iterator = this.people.iterator();
		while(iterator.hasNext())
		{
			Person2 currentPerson = iterator.next();
			
			if (currentPerson.getOccupation().equals(occupation))
			{
				Iterator<Animal> iterator2 = currentPerson.getPets().iterator();
				while(iterator2.hasNext())
				{
					Animal currentPet = iterator2.next();
					if (petTypes.size() == 0)
					{
						petTypes.add(currentPet.getSpecies());
					}
					else
					{
						Iterator<String> iterator3 = petTypes.iterator();
						boolean speciesAlreadyExists = false;
						while(iterator3.hasNext())
						{
							String alreadyAddedSpecies = iterator3.next();
							if (alreadyAddedSpecies.equals(currentPet.getSpecies()))
							{
								System.out.println("Pet Type Match");
								speciesAlreadyExists = true;
							}
						}
						if (!speciesAlreadyExists)
						{
							petTypes.add(currentPet.getSpecies());
						}
					}
				}
				
			}
			else
			{
				System.out.println("Person had job " + currentPerson.getOccupation());
			}
			
		}
		
		
		return petTypes;
	}
	
	public String speciesOwnedByOccupationAsString(String occupation)
	{
		ArrayList<String> petTypes = new ArrayList<String>();
		petTypes = speciesOwnedByOccupation(occupation);
		String petsWords = "People with the job of " + occupation + " have the pets of ";
	
		Iterator<String> iterator = petTypes.iterator();
		while(iterator.hasNext())
		{
			String currentPet = iterator.next();
			petsWords += currentPet + ", ";
			
		}
		if (!petsWords.equals("People with the job of " + occupation + " have the pets of "))
		{
			petsWords = petsWords.substring(0, petsWords.length()-2);
		}
		else
		{
			petsWords = "The people with the job "+ occupation + " have no pets";
		}
		return petsWords;
	}
}





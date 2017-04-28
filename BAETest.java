
public class BAETest {
	public static void main(String args[])
	{
		BAExercise testing = new BAExercise("ExData2.txt");
		testing.addSpeciesToPerson("Gareth", "Cat");
		testing.addSpeciesToPerson("Gareth", "Dolphin");
		testing.addSpeciesToPerson("Elliott", "Cat");
		testing.addSpeciesToPerson("Elliott", "Tortoise");
		System.out.println("A cat owner's average salary is £" + testing.averageOwnerSalaryBySpecies("Cat")); 
		System.out.println(testing.ownerOccupationBySpeciesAsString("Cheese"));
		System.out.println(testing.ownerOccupationBySpeciesAsString("Cat"));
		System.out.println(testing.speciesOwnedByOccupationAsString("Cat"));
		System.out.println(testing.speciesOwnedByOccupationAsString("Cat Sitter"));
		System.out.println(testing.speciesOwnedByOccupationAsString("Trainer"));
		
	}

}

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Reader
{
	public ArrayList<Food> getFoods()
	{
		File file = new File("food.txt");
		Scanner reader = null;
		try 
		{
			reader = new Scanner(file);
		} 
		catch (FileNotFoundException e)
		{
			System.err.println("ERROR: \"food.txt\" could not be read!");
			e.printStackTrace();
		}
		ArrayList<Food> foods = new ArrayList<>();
		while (reader.hasNext()) 
		{
			String foodline = reader.nextLine();
			String[] temp = foodline.split("\t");
		    Food food = new Food(Integer.parseInt(temp[0]), temp[1], Integer.parseInt(temp[2]));
			foods.add(food);
		}
		reader.close();
		return foods;
	}
	
	public ArrayList<Sport> getSports()
	{
		File file = new File("sport.txt");
		Scanner reader = null;
		try 
		{
			reader = new Scanner(file);
		} 
		catch (FileNotFoundException e)
		{
			System.err.println("ERROR: \"sport.txt\" could not be read!");
			e.printStackTrace();
		}
		ArrayList<Sport> sports = new ArrayList<>();
		while (reader.hasNext()) 
		{
			String sportline = reader.nextLine();
			String[] temp = sportline.split("\t");
		    Sport sport = new Sport(Integer.parseInt(temp[0]), temp[1], Integer.parseInt(temp[2]));
			sports.add(sport);
		}
		reader.close();
		return sports;
	}
	
	public ArrayList<Person> getPeople()
	{
		File file = new File("people.txt");
		Scanner reader = null;
		try 
		{
			reader = new Scanner(file);
		} 
		catch (FileNotFoundException e)
		{
			System.err.println("ERROR: \"people.txt\" could not be read!");
			e.printStackTrace();
		}
		ArrayList<Person> people = new ArrayList<>();
		while (reader.hasNext()) 
		{
			String personline = reader.nextLine();
			String[] temp = personline.split("\t");
		    Person person = new Person(Integer.parseInt(temp[0]), temp[1], temp[2],
		    						   Integer.parseInt(temp[3]),Integer.parseInt(temp[4]),
		    						   Integer.parseInt(temp[5]));
			people.add(person);
		}
		reader.close();
		return people;
	}
	public ArrayList<String> getCommands(String filename)
	{
		File file = new File(filename);
		Scanner reader = null;
		try 
		{
			reader = new Scanner(file);
		} 
		catch (FileNotFoundException e)
		{
			System.err.println("ERROR: \"command.txt\" could not be read!");
			e.printStackTrace();
		}
		ArrayList<String> commands = new ArrayList<>();
		while (reader.hasNext()) 
		{
			String commandline = reader.nextLine();
			commands.add(commandline);
		}
		reader.close();
		return commands;
	}
}
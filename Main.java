import java.io.IOException;
import java.util.ArrayList;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		
		Reader reader = new Reader();
		ArrayList<Person> people = reader.getPeople();
		ArrayList<Food> foods = reader.getFoods();
		ArrayList<Sport> sports = reader.getSports();
		Command commands = new Command(reader.getCommands(args[0]));
		commands.doCommands(people, foods, sports);

	}

}
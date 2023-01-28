import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Command 
{
	private ArrayList<String> commands;
	
	Command(ArrayList<String> commands)
	{
		this.commands = commands;
	}
	
	public void doCommands(ArrayList<Person> people, ArrayList<Food> foods, ArrayList<Sport> sports) throws IOException
	{
		FileWriter writer = null;
		try 
		{
			writer = new FileWriter("monitoring.txt");
		} 
		catch (IOException e) 
		{
			System.err.println("ERROR: Can not write there!");
			e.printStackTrace();
		}
		
		ArrayList<Person> toList = new ArrayList<>();
		ArrayList<Person> toWarn = new ArrayList<>();
		
		for (int i = 0; i < this.commands.size(); i++)
		{
			if (this.commands.get(i).startsWith("print("))
			{
				int tempID = Integer.parseInt(this.commands.get(i).substring(6,this.commands.get(i).length()-1));
				for (int j = 0; j < people.size(); j++)
				{
					if (people.get(j).getID() == tempID)
					{
						writer.write(people.get(j).toString()+"\n");
					}
				}
			}
			else if (this.commands.get(i).startsWith("printL"))
			{
				for (int j = 0; j < toList.size(); j++)
				{
					if (i == this.commands.size()-1 && j == toList.size()-1)
					{
						writer.write(toList.get(j).toString());
					}
					else
					{
						writer.write(toList.get(j).toString()+"\n");
					}
				}
			}
			else if (this.commands.get(i).startsWith("printW"))
			{
				for (int j = 0; j < toList.size(); j++)
				{
					if (Integer.parseInt(toList.get(j).getResult()) > 0)
					{
						toWarn.add(toList.get(j));
					}
				}
				if (toWarn.size() == 0)
				{
					writer.write("there\tis\tno\tsuch\tperson\n");
				}
				else
				{
					for (int k = 0; k < toWarn.size(); k++)
					{
						writer.write(toWarn.get(k).toString()+"\n");
					}
				}
			}
			else
			{
				String[] temp = this.commands.get(i).split("\t");
				for (int j = 0; j < people.size(); j++)
				{
					if (people.get(j).getID() == Integer.parseInt(temp[0]))
					{
						if (!toList.contains(people.get(j)))
						{
							toList.add(people.get(j));
						}
						if (temp[1].startsWith("1"))
						{
							for (int k = 0; k < foods.size(); k++)
							{
								if (foods.get(k).getID() == Integer.parseInt(temp[1]))
								{
									people.get(j).setCalorietaken(Integer.parseInt(temp[2])*foods.get(k).getCalorie());
									writer.write(String.valueOf(people.get(j).getID()) + "\thas\ttaken\t"
											     + String.valueOf(Integer.parseInt(temp[2])*foods.get(k).getCalorie())
												 + "kcal\tfrom\t" + foods.get(k).getName()+"\n");
								}
							}
						}
						else
						{
							for (int k = 0; k < sports.size(); k++)
							{
								if (sports.get(k).getID() == Integer.parseInt(temp[1]))
								{
									people.get(j).setCalorieburned((Integer.parseInt(temp[2])/60)*sports.get(k).getCalorie());
									writer.write(String.valueOf(people.get(j).getID()) + "\thas\tburned\t"
											     + String.valueOf((Integer.parseInt(temp[2])/60)*sports.get(k).getCalorie())
											     + "kcal\tthanks\tto\t" + sports.get(k).getName()+"\n");
								}
							}
						}
					}
				}
			}
		    if(i != this.commands.size()-1)
		    {
		    	writer.write("***************\n");
		    }
		}
		writer.close();
	}
	
	public ArrayList<String> getCommands()
	{
		return this.commands;
	}
}
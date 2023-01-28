
public class Food 
{
	private int id;
	private String name;
	private int calorie;
	
	Food(int id, String name, int calorie)
	{
		this.id = id;
		this.name = name;
		this.calorie = calorie;
	}
	
	public int getID()
	{
		return this.id;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public int getCalorie()
	{
		return this.calorie;
	}
	
}
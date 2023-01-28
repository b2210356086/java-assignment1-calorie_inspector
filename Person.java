
public class Person 
{
	private int id;
	private String name;
	private String gender;
	private int weight;
	private int height;
	private int birthdate;
	private int calorieneeded;
	private int calorietaken;
	private int calorieburned;
	private int result;
	
	Person(int id, String name, String gender, int weight, int height, int birthdate)
	{
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.weight = weight;
		this.height = height;
		this.birthdate = birthdate;
		this.calorieburned = 0;
		this.calorietaken = 0;
		this.result = 0;
		if (gender.equals("male"))
		{
			this.calorieneeded = (int)Math.round(66 + 13.75*weight + 5*height - 6.8*(2022-birthdate));
		}
		else
		{
			this.calorieneeded = (int)Math.round(665 + 9.6*weight + 1.7*height - 4.7*(2022-birthdate));
		}
	}
	
	public int getID()
	{
		return this.id;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public String getGender()
	{
		return this.gender;
	}
	
	public int getWeight()
	{
		return this.weight;
	}
	
	public int getHeight()
	{
		return this.height;
	}
	
	public int getBirthdate()
	{
		return this.birthdate;
	}
	
	public int getCalorieneeded()
	{
		return this.calorieneeded;
	}
	
	public int getCalorietaken()
	{
		return this.calorietaken;
	}
	
	public int getCalorieburned()
	{
		return this.calorieburned;
	}
	
	public String getResult()
	{
		this.result = this.calorietaken - this.calorieburned - this.calorieneeded;
		if (this.result > 0)
		{
			return "+" + String.valueOf(Math.round(this.result));
		}
		else
		{
			return String.valueOf(Math.round(this.result));
		}
	}
	
	public void setCalorietaken(int calorietaken)
	{
		this.calorietaken += calorietaken;
	}
	
	public void setCalorieburned(int calorieburned)
	{
		this.calorieburned += calorieburned;
	}
	
	@Override
	public String toString()
	{
		return this.name + "\t" + String.valueOf(2022 - this.birthdate) + "\t" + this.calorieneeded
			   + "kcal\t" + this.calorietaken + "kcal\t" + this.calorieburned + "kcal\t" 
			   + this.getResult() +"kcal";
	}
}
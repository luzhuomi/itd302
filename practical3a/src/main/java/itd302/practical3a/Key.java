package itd302.practical3a;

public class Key
{
	private char name;
	
	public Key () 
	{ 
		this.name = ' ';
	}
	public Key(char n)
	{
		this.name = n;
	}
	public void press()
	{
		System.out.println("Key (" + this.name + ") is pressed." );
	}
}

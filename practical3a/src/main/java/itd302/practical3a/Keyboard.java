package itd302.practical3a;

public class Keyboard extends USBDev 
{
	private Key[] keys = { new Key('a'), new Key('b')} ; 
	
	public Keyboard() 
	{
	}
	public void press(int i) 
	{
		if (i < keys.length)
		{
			this.keys[i].press();			
		}
	} // user function
	public void connectUSB() {
	    System.out.println("Beep! I am a KB.");
	};  // user function
}
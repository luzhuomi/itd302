package itd302.practical3a;

public class Mouse extends USBDev
{

	public static class Sensor {
		public Sensor() {};
	}

	private Sensor sensor = new Sensor(); 
	public void leftClick() 
	{ 
		System.out.println("The left button is clicked.");
	};    // user function
	public void rightClick()
	{ 
		System.out.println("The right button is clicked.");
	};    // user function
	public void move() 
	{ 
		System.out.println("The mouse is moving.");
	};        // user function

	public void connectUSB() {
	    System.out.println("Beep! I am a mouse.");
	};  // user function

}
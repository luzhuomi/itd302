package itd302.practical3a;


public class Main 
{
	public static void main(String[] args)
	{
		USBDev[] usbdevs = {new Mouse(), new Keyboard() };

		for (int i = 0; i < usbdevs.length ; i++)
		{
			usbdevs[i].connectUSB();
		}
	}
}
package main;

import splash.UISplashScreen;

public class Main
{
	public static void main(String[] args) throws InterruptedException
	{
		String appTitle = "Application Title";
		String imageRoute = "/resources/example.jpg";
		int steps = 4;

		UISplashScreen.splash(appTitle, Main.class.getResource(imageRoute), steps);

		for (int i = 0; i < steps; i++)
		{
			UISplashScreen.updateBarProgress("Message " + (i + 1));
			Thread.sleep(2000);
		}

		UISplashScreen.disposeSplash();
	}
}

** UISplashScreen is a really simple, yet clean, way of providing a SplashScreen to your Java Application ** 

Since native implementation of Splash Screens come with no little shenanigans I came up with the necessity of creating a Splash Screen. This Splash Screen should be used to show the user a load progress screen while displaying a nice image such as Company logos or a presentation image.

That's what this Java class is designed for: A Swing frame combined with a little style and a really simple API for creating, updating and deleting it while we load resources and the libraries needed in the background.

# This package contains the following items:

* doc: A little document showing how to use this class and the results it provides.\n
* src/main: A Main class which can be executed to show an example of the working class.\n
* src/resources: A folder containing a Creative-Commons image.\n
* src/splash: The SplashScreen class itself.

# Usage:

* Get src/splash/UISplashScreen.java
* Execute UISplashScreen.splash(applicationName, imageToDisplay, numSteps) at the beginning of your loading process.
* Each time you want to update the info bar, call UISplashScreen.updateBarProgress(message).
* At the end of the loading process but before showing up the main frame, call UISplashScreen.disposeSplash().
* Do not call UISplashScreen.updateBarProgress more times that numSteps.
* That's all! For a complete example please refer to src/main/Main.java.
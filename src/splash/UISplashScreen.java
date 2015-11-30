package splash;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;


/**
 * UISplashScreen: Custom simple Splash Screen for Java Applications.
 * Copyright (c) Alberto Hernández Chillón (alberto.hernandez1@um.es), All rights reserved.
 * Redistributed under LGPL 3.0 license terms.
 * 
 * Class used to display a splash screen while loading the main application.
 * The splash screen given by Java is quite useless in this case since it is
 * loaded from an external file while creating the jar.
 * This way we implement our own splash screen with a progress bar on it.
 * This progress bar will display the steps loaded while the application is starting.
 * 
 * @author Alberto Hernández Chillón
 */
public class UISplashScreen extends JFrame
{
	private static final long serialVersionUID = 5689311353791498154L;

	/**
     * The maximum number of steps of loading of our application.
     */
    private static int MAX_STEPS;

    /**
     * Private instance of the splash screen. Singleton.
     */
    private static UISplashScreen instance;

    /**
     * The progress bar to be displayed in the splash screen frame showing the loading progress.
     */
    private JProgressBar progressBar;

    /**
     * Default private constructor. It will display a frame with the image given as
     * a parameter and a progress bar.
     * @param image The image to be displayed as a splash image.
     */
    /**
     * Default private constructor. It will display a frame with the image given as
     * a parameter and a progress bar.
     * @param appTitle The application title to be displayed.
     * @param image The image to be displayed as a splash image.
     */
    private UISplashScreen(String appTitle, Image image)
    {
        super();

        setLayout(new BorderLayout());
        setTitle(appTitle);

        JLabel label = new JLabel();
        label.setIcon(new ImageIcon(image));
        label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(label, BorderLayout.CENTER);

        progressBar = new JProgressBar(0, MAX_STEPS);
        progressBar.setStringPainted(true);
        add(progressBar, BorderLayout.SOUTH);

        setUndecorated(true);
        pack();
        setLocationRelativeTo(null);
    }

    /**
     * The static method used to update the progress bar one step and
     * show an explicit message telling the user the step he/she is in.
     * @param message The message to be displayed on the progress bar.
     */
    public static void updateBarProgress(String message)
    {
        if (instance.progressBar.getValue() < MAX_STEPS)
            instance.progressBar.setValue(instance.progressBar.getValue() + 1);

        instance.progressBar.setString(message);
    }

    /**
     * Main call used to create the splash screen as a singleton and load the splash image.
     * @param appTitle The application title to be displayed.
     * @param imageURL The url where the image may be found.
     * @param steps The number of steps the progress bar is divided.
     */
    public static void splash(String appTitle, URL imageURL, int steps)
    {
        if (instance == null && imageURL != null)
        {
            MAX_STEPS = steps;
            instance = new UISplashScreen(appTitle, Toolkit.getDefaultToolkit().createImage(imageURL));
            instance.setVisible(true);
        }
    }

    /**
     * Method used to dispose the splash screen once the application is done loading elements.
     */
    public static void disposeSplash()
    {
        instance.setVisible(false);
        instance.dispose();
    }
}
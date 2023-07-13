package swing_d;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Arrays;

public class Size_D_GraphicsEnvironment{

	public static GraphicsEnvironment size_instance = GraphicsEnvironment.getLocalGraphicsEnvironment();		
	public static GraphicsDevice[] size_screens = size_instance.getScreenDevices();
	
	public static double localscale = size_instance.getDefaultScreenDevice().getDefaultConfiguration().getDefaultTransform().getScaleX();
	
	public static ArrayList<String[]> fullsize_screen_all = new ArrayList<String[]>();
	
	public static int resize_screen_width = (int)(size_instance.getMaximumWindowBounds().width);
	public static int resize_screen_height = (int)(size_instance.getMaximumWindowBounds().height);

	// instance
	public Size_D_GraphicsEnvironment(){getSize();}
	

	//method
	private void getSize() {
		
		for (int i = 1; i < size_screens.length + 1 ; i++) {
		
			int screenWidth = size_screens[(i-1)].getDisplayMode().getWidth();
	    	
			int screenHeight = size_screens[(i-1)].getDisplayMode().getHeight();    	
	    	
			fullsize_screen_all.add((screenWidth + "," + screenHeight).toString().split(","));			
		}
	};// getSize end 
}

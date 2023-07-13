package swing_d;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class Window_D_Label_String extends JLabel {

	Window_D_Label_String(String txt, Font font, int x, int y, int width, int height){
		
		setFont(font);
		setText(txt);
		setSize(width,height);
		setLocation(x, y);
		
	};
	
}

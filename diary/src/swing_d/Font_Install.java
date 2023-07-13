package swing_d;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.io.File;

public class Font_Install {

	public static Font font;
	
	public Font_Install(){
		
		font = font_install();
	}
	
	public static Font font_install(){
		
		try {
			
			Font font = Font.createFont(Font.TRUETYPE_FONT, new File("src/img/omu.ttf"));
			GraphicsEnvironment fo = GraphicsEnvironment.getLocalGraphicsEnvironment();
            fo.registerFont(font);
		
            return font;
		}  
		catch (Exception e) {System.out.println(e.getMessage());}
		
			return null;
	};
	
}

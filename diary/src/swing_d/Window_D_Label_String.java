package swing_d;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Window_D_Label_String extends JLabel {

	int width;
	int height;
	String a;
	
	Window_D_Label_String(Runnable run, Color color,String a,int x,int y ,int width,int height){
				
		this.a = a;
		this.width = width;
		this.height = height;
		setVisible(true);
		setPreferredSize(new Dimension(width, height));
		setLocation(x, y);

		addMouseListener(new MouseAdapter() {public void mouseReleased(MouseEvent e) {run.run();}});
			
	};

		@Override
	    protected void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        Graphics2D graphics2d = (Graphics2D) g;

	        graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	        graphics2d.setStroke(new BasicStroke(Window_interface_D.option.btn_label_border_setStroke));
	        
	        int radius = Math.min(getWidth()-2, getHeight()-2) / 2; 
	        
	        graphics2d.setColor(Window_interface_D.option.btn_label_set_fill_color);
	        
	        graphics2d.fillRoundRect(this.width, this.height, radius * 2, radius* 2, radius, radius);
	        
	        if(Window_interface_D.option.btn_label_border_rownd) {
	        	if(Window_interface_D.option.btn_label_circle_layout) {
	        	graphics2d.setColor(Window_interface_D.option.btn_label_set_layout_color);
		        graphics2d.drawOval(this.width / 2 - radius , this.height / 2 - radius, radius * 2, radius * 2);
	        	}
	        }
	        else{
	        	if(Window_interface_D.option.btn_label_circle_layout) {
	        	graphics2d.setColor(Window_interface_D.option.btn_label_set_layout_color);
	        	graphics2d.drawRect(0, 0, width, height);
	        	}
	        
	        }
	        
	        graphics2d.setColor(Window_interface_D.option.btn_label_set_font_color);
	        graphics2d.setFont(Window_interface_All_file.font_omu.deriveFont(Window_interface_D.option.btn_label_set_font_size));
	        
            FontMetrics fontmet = graphics2d.getFontMetrics();
            int t_Width = fontmet.stringWidth(a);
            int t_Height = fontmet.getHeight();

            int x = (getWidth() - t_Width) / 2;
            int y = (getHeight() - t_Height) / 2 + fontmet.getAscent();
	        
	        graphics2d.drawString(a, x, y);
	        
	    }
		
	};
	

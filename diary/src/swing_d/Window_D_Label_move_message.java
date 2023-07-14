package swing_d;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Collections;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Window_D_Label_move_message extends JLabel {

	int width;
	int height;
	String a;
	
	Window_D_Label_move_message(Runnable run,String a,int cursor, int x,int y ,int width,int height){
				
		this.a = a;
		this.width = width;
		this.height = height;
		setVisible(true);
		setSize(width,height);
		setBackground(new Color(255,255,255));
		setPreferredSize(new Dimension(width,height));
		setLocation(x,y);
		
		setText(a);
		setHorizontalAlignment(SwingConstants.CENTER);
		
		addMouseListener(new MouseAdapter() {
		    public void mousePressed(MouseEvent e) {run.run();}
		    public void mouseEntered(MouseEvent e) {setCursor(Cursor.getPredefinedCursor(cursor));}
		    public void mouseExited(MouseEvent e)  {setCursor(Cursor.getDefaultCursor());}
		    public void mouseReleased(MouseEvent e) {}
		    
		});

		addMouseMotionListener(new MouseAdapter() {
			
		    public void mouseDragged(MouseEvent e) {}
		    
		    public void mouseReleased(MouseEvent e) {}
		});
		
		};

		@Override
	    protected void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        Graphics2D graphics2d = (Graphics2D) g;

	        graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	        graphics2d.setStroke(new BasicStroke(Window_interface_D.option.team_move_icon_setStroke));
	        
	        int radius = Math.min(getWidth()-2, getHeight()-2) / 2; 
	        
	        graphics2d.setColor(Window_interface_D.option.team_move_icon_fill_color);
	        
	        graphics2d.fillOval(this.width / 2 - radius, this.height / 2 - radius, radius * 2, radius* 2);
	        
	        if(Window_interface_D.option.team_move_icon_rownd) {
	        	if(Window_interface_D.option.team_move_icon_layout) {
	        	graphics2d.setColor(Window_interface_D.option.team_move_icon_layout_color);
		        graphics2d.drawOval(this.width / 2 - radius , this.height / 2 - radius, radius * 2, radius * 2);
	        	}
	        }
	        else{
	        	if(Window_interface_D.option.team_move_icon_layout) {
	        	graphics2d.setColor(Window_interface_D.option.team_move_icon_layout_color);
	        	graphics2d.drawRect(0, 0, width, height);
	        	}
	        
	        }
	        
	        graphics2d.setColor(Window_interface_D.option.btn_label_set_font_color);  // 폰트컬러 수정 위치 조정 필요
	        graphics2d.setFont(Window_interface_All_file.font_omu.deriveFont(Window_interface_D.option.btn_label_set_font_size)); //폰트사이즈 위치 조정 필요
	        
            FontMetrics fontmet = graphics2d.getFontMetrics();
            int t_Width = fontmet.stringWidth(a);
            int t_Height = fontmet.getHeight();

            int x = (getWidth() - t_Width) / 2;
            int y = (getHeight() - t_Height) / 2 + fontmet.getAscent();
	        
	        graphics2d.drawString(a, x, y);
	        
	    }
		
	};
	

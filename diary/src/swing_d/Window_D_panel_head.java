package swing_d;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

public class Window_D_panel_head extends JPanel {

	Color color;
	Point initialClick;
	
	int x_paint;
    int y_paint;
    int width;
    int height;
    
	Window_D_panel_head(Color color, GridBagLayout Layout,int x, int y ,int width, int height){
		
		if(Window_interface_D.option.panel_auto_resize) {
		
			this.x_paint = Window_interface_D.option.head_panel_auto_x;
			this.y_paint = Window_interface_D.option.head_panel_auto_y;		
		}
		else {
			this.x_paint = x;
			this.y_paint = y;		
		}
		
		this.width = width;
		this.height = height;	
		this.color = color;
	
		setVisible(true);
		setSize(width,height);
		setPreferredSize(new Dimension(width, height));
		
		if(Window_interface_D.option.panel_auto_resize) {
			setLocation(Window_interface_D.option.head_panel_auto_x,Window_interface_D.option.head_panel_auto_y);		
		}
		else {
			setLocation(x,y);
		}	
		
		setBackground(color);
		setLayout(Layout);
		setOpaque(false); 
		
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                initialClick = e.getPoint();
     
               
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent e) {
                int deltaX = e.getX() - initialClick.x;
                int deltaY = e.getY() - initialClick.y;

                int newX = Window_interface_D.diary_frame.getLocation().x + deltaX;
                int newY = Window_interface_D.diary_frame.getLocation().y + deltaY;
              
                Window_interface_D.diary_frame.setLocation(newX, newY);
            }
        });
		
	};
		
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2d = (Graphics2D) g.create();
        
        graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2d.setStroke(new BasicStroke(Window_interface_D.option.head_panel_border_setStroke));
        
        if(Window_interface_D.option.head_panel_border_rownd) {
        	
        	graphics2d.setColor(Window_interface_D.option.head_set_fill_color);
    		graphics2d.fillRoundRect(x_paint, y_paint, Window_interface_D.main_panel_center.getWidth() - x_paint*2-1, height - y_paint *2-1 , Window_interface_D.option.head_panel_width_rownd, Window_interface_D.option.head_panel_height_rownd);
        	
        	if(Window_interface_D.option.head_panel_border_layout) {
        		graphics2d.setColor(Window_interface_D.option.head_set_layout_color); // 패널의 배경색 설정
        		graphics2d.drawRoundRect(x_paint, y_paint, Window_interface_D.main_panel_center.getWidth()- x_paint*2-1, height - y_paint *2-1 , Window_interface_D.option.head_panel_width_rownd, Window_interface_D.option.head_panel_height_rownd);
        	}
        }
        else{
        	graphics2d.setColor(Window_interface_D.option.head_set_fill_color);
            graphics2d.fillRect(x_paint, y_paint, Window_interface_D.main_panel_center.getWidth() - x_paint*2 -1, height - y_paint *2 -1);
        
        	if(Window_interface_D.option.head_panel_border_layout) {
        		graphics2d.setColor(Window_interface_D.option.head_set_layout_color); // 패널의 배경색 설정
        		graphics2d.drawRect(x_paint, y_paint,Window_interface_D.main_panel_center.getWidth() - x_paint*2 -1, height - y_paint *2 -1);
        	}
        }              
        
        graphics2d.dispose();
    }
    
}

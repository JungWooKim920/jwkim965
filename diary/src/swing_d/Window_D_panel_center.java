package swing_d;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.plaf.basic.DefaultMenuLayout;

public class Window_D_panel_center extends JPanel {

	Color color;
	int x_paint;
    int y_paint;
    int width;
    int height;		
	
	Window_D_panel_center(Color color,BorderLayout layout,int x,int y ,int width,int height){
		
		this.x_paint = x;
		this.y_paint = y;		

		this.width = width;
		this.height = height;
		this.color = color;
		
		setVisible(true);
		setLocation(x, y);		
		setLayout(layout);
		setOpaque(false); // 배경을 투명하게 설정
	};
		
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2d = (Graphics2D) g.create();
 
        graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2d.setStroke(new BasicStroke(Window_interface_D.option.main_panel_center_border_setStroke));
        
        
        addMouseListener(new MouseAdapter() {});
 
         
        if(Window_interface_D.option.main_panel_center_border_rownd) {
        	
        	graphics2d.setColor(Window_interface_D.option.main_set_center_fill_color);
            graphics2d.fillRoundRect(x_paint, y_paint, getSize().width - x_paint*2 -1, getSize().height - y_paint *2  -1, Window_interface_D.option.main_panel_center_width_rownd, Window_interface_D.option.main_panel_center_height_rownd);
        	
        	if(Window_interface_D.option.main_panel_center_border_layout){
        		graphics2d.setColor(Window_interface_D.option.main_set_center_layout_color); // 패널의 배경색 설정
        		graphics2d.drawRoundRect(x_paint, y_paint, getSize().width- x_paint*2 -1, getSize().height - y_paint *2 -1 , Window_interface_D.option.main_panel_center_width_rownd, Window_interface_D.option.main_panel_center_height_rownd);
        		
        	}
        }
        else{
        	
        	graphics2d.setColor(Window_interface_D.option.main_set_center_fill_color);
            graphics2d.fillRect(x_paint, y_paint, getSize().width, getSize().height);
        	
        	if(Window_interface_D.option.main_panel_center_border_layout){
        		graphics2d.setColor(Window_interface_D.option.main_set_center_layout_color); // 패널의 배경색 설정
        		graphics2d.drawRect(x_paint, y_paint, getSize().width, getSize().height);
        	}
        }              
        
        
        graphics2d.dispose();
    }
    
}

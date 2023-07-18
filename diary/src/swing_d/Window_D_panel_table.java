package swing_d;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class Window_D_panel_table extends JPanel {

	int x_paint;
    int y_paint;
    int width;
    int height;
	
	Window_D_panel_table(int x,int y ,int width,int height){
		
		if(Window_interface_D.option.panel_auto_resize) {
			
			this.x_paint = Window_interface_D.option.table_panel_auto_x;
			this.y_paint = Window_interface_D.option.table_panel_auto_y;		
		}
		else {
			this.x_paint = x;
			this.y_paint = y;		
		}

		setSize(width,height);
		
		this.width = width;
		this.height = height;
		setVisible(true);
		setPreferredSize(new Dimension(width,height));
		
		if(Window_interface_D.option.panel_auto_resize) {
			setLocation(Window_interface_D.option.table_panel_auto_x,Window_interface_D.option.table_panel_auto_y);		
		}
		else {
			setLocation(x,y);
		}
		
		setLayout(null);
		setOpaque(false); // 배경을 투명하게 설정
	};
		
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    
        Graphics2D graphics2d = (Graphics2D) g.create();
         
        graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2d.setStroke(new BasicStroke(Window_interface_D.option.table_panel_border_setStroke));
        
        if(Window_interface_D.option.table_panel_border_rownd) {
        	graphics2d.setColor(Window_interface_D.option.table_set_fill_color);
            graphics2d.fillRoundRect(x_paint, y_paint, 
            		Window_interface_D.main_panel_center.getWidth()- x_paint*2 - Window_interface_D.option.isPanel(Window_interface_D.main_panel_center,BorderLayout.WEST) -Window_interface_D.option.isPanel(Window_interface_D.main_panel_center,BorderLayout.EAST) + Window_interface_D.option.GetPanel(Window_interface_D.main_panel_center,BorderLayout.EAST)-1
            		, Window_interface_D.main_panel_center.getHeight() - y_paint *2 - Window_interface_D.option.head_panel_x - Window_interface_D.option.head_panel_height
            		, Window_interface_D.option.table_panel_width_rownd,Window_interface_D.option.table_panel_height_rownd);
        	
        	if(Window_interface_D.option.table_panel_border_layout) {
        		graphics2d.setColor(Window_interface_D.option.table_set_layout_color); // 패널의 배경색 설정
        		graphics2d.drawRoundRect(x_paint, y_paint,
        				Window_interface_D.main_panel_center.getWidth()- x_paint*2 - Window_interface_D.option.isPanel(Window_interface_D.main_panel_center,BorderLayout.WEST) -Window_interface_D.option.isPanel(Window_interface_D.main_panel_center,BorderLayout.EAST) + Window_interface_D.option.GetPanel(Window_interface_D.main_panel_center,BorderLayout.EAST) -1
        				,Window_interface_D.main_panel_center.getHeight() - y_paint *2 - Window_interface_D.option.head_panel_x - Window_interface_D.option.head_panel_height,
        				Window_interface_D.option.table_panel_width_rownd, Window_interface_D.option.table_panel_height_rownd);
        	}
        }
        else{
        	graphics2d.setColor(Window_interface_D.option.table_set_fill_color);
            graphics2d.fillRect(x_paint, y_paint,
            		Window_interface_D.main_panel_center.getWidth()- x_paint*2 - Window_interface_D.option.isPanel(Window_interface_D.main_panel_center,BorderLayout.WEST) -Window_interface_D.option.isPanel(Window_interface_D.main_panel_center,BorderLayout.EAST)+ Window_interface_D.option.GetPanel(Window_interface_D.main_panel_center,BorderLayout.EAST) -1
            		, Window_interface_D.main_panel_center.getHeight() - y_paint *2 - Window_interface_D.option.head_panel_x - Window_interface_D.option.head_panel_height);
        	
        	if(Window_interface_D.option.table_panel_border_layout) {
        		graphics2d.setColor(Window_interface_D.option.table_set_layout_color); // 패널의 배경색 설정
        		graphics2d.drawRect(x_paint, y_paint, 
        				Window_interface_D.main_panel_center.getWidth()- x_paint*2 - Window_interface_D.option.isPanel(Window_interface_D.main_panel_center,BorderLayout.WEST) -Window_interface_D.option.isPanel(Window_interface_D.main_panel_center,BorderLayout.EAST) + Window_interface_D.option.GetPanel(Window_interface_D.main_panel_center,BorderLayout.EAST) -1
        				, Window_interface_D.main_panel_center.getHeight() - y_paint *2 - Window_interface_D.option.head_panel_x - Window_interface_D.option.head_panel_height);
        	}
        }              
        /*+ Window_interface_D.diary_message.getX()-2*/
        
        graphics2d.dispose();
    }
    
}

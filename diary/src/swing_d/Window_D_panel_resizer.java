package swing_d;

import java.awt.AWTEvent;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

public class Window_D_panel_resizer extends JPanel {

	Color color;
	int cursor;
	
	Window_D_panel_resizer(Runnable run ,Color color,int cursor,int x,int y ,int width,int height){
	
		this.cursor = cursor;
		this.color = color;
		
		setVisible(true);
		setSize(width,height);
		setPreferredSize(new Dimension(width, height));
		setLocation(x, y);		
		setLayout(null);
		setOpaque(false); 
		
	
		addMouseListener(new MouseAdapter() {
		    public void mousePressed(MouseEvent e) {
		    	
		    	Window_interface_D.resize[0] = Window_interface_D.main_panel.getWidth();
		    	Window_interface_D.resize[1] = Window_interface_D.main_panel.getHeight();
		    	
		    }
		    public void mouseEntered(MouseEvent e) {setCursor(Cursor.getPredefinedCursor(cursor));}
		    public void mouseExited(MouseEvent e)  {setCursor(Cursor.getDefaultCursor());}
		    public void mouseReleased(MouseEvent e) {Window_interface_D.resize_relayout_();}
		    
		});

		addMouseMotionListener(new MouseAdapter() {
		    public void mouseDragged(MouseEvent e) {
		    	
		    	Window_interface_D.resize[2] = e.getPoint().x;
		    	Window_interface_D.resize[3] = e.getPoint().y;
		    	run.run();

		    }
		    
		    public void mouseReleased(MouseEvent e) {Window_interface_D.resize_relayout_();}
		});
		
	}
		

	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2d = (Graphics2D) g.create();
        
        graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        // 라운드 모양 그리기
        int x = 0;
        int y = 0;
        int width = getWidth();
        int height = getHeight();
        
        if(Window_interface_D.option.resize_line_visible) {
        
        	graphics2d.setColor(Color.black); // 패널의 배경색 설정
        	
        	graphics2d.drawRoundRect(x, y, width, height, 30, 30);
        
        	graphics2d.setColor(this.color);
        
        	graphics2d.fillRoundRect(x, y, width, height, 30, 30);
		}
        graphics2d.dispose();
    }    

}


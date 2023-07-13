package swing_d;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class Window_D_panel extends JPanel {

	Color color;
	Window_D_panel(Color color,int x,int y ,int width,int height){
		
		this.color = color;
		setVisible(true);
		setSize(width,height);
		setLocation(x, y);		
		setLayout(null);
		setOpaque(false); // 배경을 투명하게 설정
	};
		
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
        
        graphics2d.setColor(Color.black); // 패널의 배경색 설정
        
        graphics2d.drawRoundRect(x, y, width, height, 30, 30);
        
        graphics2d.setColor(this.color);
        
        graphics2d.fillRoundRect(x, y, width, height, 30, 30);
        
        
        graphics2d.dispose();
    }
    
}

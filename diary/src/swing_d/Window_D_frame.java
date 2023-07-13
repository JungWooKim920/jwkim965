package swing_d;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class Window_D_frame extends JFrame{

	public Window_D_frame(){
		
		if(Window_interface_D.option.mainframe_auto_size) {
			
			setSize(Window_interface_D.size.resize_screen_width,Window_interface_D.size.resize_screen_height);
			setPreferredSize(new Dimension(Window_interface_D.size.resize_screen_width,Window_interface_D.size.resize_screen_height));
		}
		else 
		{	
			setSize(900,815);	
		}
		//화면을 프로젝트 화면과 맞춤
		getContentPane().setLayout(null);
				
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 타이틀바 x 버튼을 누르면 프로그램이 종료되도록 실행
		getContentPane().setLayout(null);
		//레이아웃을 앱솔루트로 설정함
		getContentPane().setBackground(new Color(255,255,255,0));
		setUndecorated(true);

		setBackground(new Color(0,0,0,0));
	}
}

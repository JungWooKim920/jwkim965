package swing_d;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

public interface Window_interface_D {

	Init option = new Init();
		
	public static Size_D_GraphicsEnvironment size  			= new Size_D_GraphicsEnvironment();
	
	public static Window_D_frame diary_frame 				= new Window_D_frame();
	
	public static Window_D_panel_main main_panel 			= new Window_D_panel_main(new Color(255,255,255,0),new BorderLayout(option.main_panel_border_layout_x, option.main_panel_border_layout_y),	option.main_panel_x, option.main_panel_y, size.resize_screen_width, size.resize_screen_height);
	
	public static Window_D_panel_resizer resizer_top 		= new Window_D_panel_resizer(new Runnable() {@Override public void run() {}},new Color(255,0,0,255),0,0,0,size.resize_screen_width,2);
	public static Window_D_panel_resizer resizer_left 		= new Window_D_panel_resizer(new Runnable() {@Override public void run() {}},new Color(255,0,0,255),0,0,0,2,size.resize_screen_height);
	public static Window_D_panel_resizer resizer_right 		= new Window_D_panel_resizer(new Runnable() {@Override public void run() {resize_right();	}},new Color(255,0,0,255),11,0,0,2,size.resize_screen_height);
	public static Window_D_panel_resizer resizer_down 		= new Window_D_panel_resizer(new Runnable() {@Override public void run() {resize_down();	}},new Color(255,0,0,255),8,0,0,size.resize_screen_width,2);
	
	int[] resize = new int[4];
	
	public static void resize_right() {main_panel.setSize(resize[0] + resize[2],  resize[1]);};
	public static void resize_down() {main_panel.setSize(resize[0],resize[1] + resize[3]);};
	
	public static Window_D_panel_center main_panel_center	= new Window_D_panel_center(new Color(255,255,255,0),new BorderLayout(option.main_panel_center_border_layout_x,option.main_panel_center_border_layout_y),	option.main_panel_center_x, option.main_panel_center_y, size.resize_screen_width, size.resize_screen_height);
	
	public static void panel_Add(){
		
		diary_frame.getContentPane().add(main_panel);

		main_panel.add(resizer_top,BorderLayout.NORTH);
		main_panel.add(resizer_right,BorderLayout.EAST);
		main_panel.add(resizer_left,BorderLayout.WEST);
		main_panel.add(resizer_down,BorderLayout.SOUTH);
		main_panel.add(main_panel_center,BorderLayout.CENTER);
	
	}
	
	GridBagLayout GL_head 	 = new GridBagLayout();
	GridBagLayout GL_team	 = new GridBagLayout();
	

	public static Window_D_panel_head diary_head 			= new Window_D_panel_head(option.GL_head(GL_head),   option.head_panel_x, option.head_panel_y, size.resize_screen_width, option.head_panel_height);
	
	/*window header*/
	public static Window_D_Label_Circle btn_x	 			= new Window_D_Label_Circle(new Runnable() {@Override public void run() {exit();}},new Color(255,255,255,0),"X", 0, 0, 32, 32);
	public static Window_D_Label_Circle btn_ㅁ	 			= new Window_D_Label_Circle(new Runnable() {@Override public void run() {max();}},new Color(255,255,255,0),"ㅁ",  0, 0, 32, 32);
	public static Window_D_Label_Circle btn_ㅡ	 			= new Window_D_Label_Circle(new Runnable() {@Override public void run() {hide();}},new Color(255,255,255,0),"ㅡ", 0, 0, 32, 32);
	
	GridBagConstraints head_GL_Label1 = new GridBagConstraints();
	GridBagConstraints head_GL_Label2 = new GridBagConstraints();
	GridBagConstraints head_GL_Label3 = new GridBagConstraints();
	GridBagConstraints head_GL_Label4 = new GridBagConstraints();
	
	public static Window_D_Label_move_team btn_move_team	= new Window_D_Label_move_team(new Runnable() {@Override public void run() {team_hide();}},"=", 12, 0, 0, 32, 32);
	public static Window_D_Label_move_message btn_move_message	= new Window_D_Label_move_message(new Runnable() {@Override public void run() {message_hide();}},"-", 12, 0, 0, 32, 32);

	public static void head_Add(){
	
		main_panel_center.add(diary_head,BorderLayout.NORTH);
		diary_head.add(btn_x, option.GL_label(head_GL_Label1, 8, 0, 0, 0, 0, 0));  //TOP, LEFT , DOWN ,RIGHT
		diary_head.add(btn_ㅁ, option.GL_label(head_GL_Label2, 7, 0, 0, 0, 0, 0));
		diary_head.add(btn_ㅡ, option.GL_label(head_GL_Label3, 6, 0, 0, 0, 0, 0));
				
		diary_head.add(btn_move_team, option.GL_label(head_GL_Label1, 1, 0, 0, 0, 0, 0));  //TOP, LEFT , DOWN ,RIGHT
		diary_head.add(btn_move_message, option.GL_label(head_GL_Label3, 2, 0, 0, 0, 0, 0));
	}

	public static Window_D_panel_table diary_table	 		= new Window_D_panel_table(option.table_panel_x, option.other_panel_margin,main_panel.getPreferredSize().width - option.table_panel_size - (option.table_panel_x_margin *2-3)  ,  size.resize_screen_height-option.other_panel_height);	
	
	public static void table_Add(){
		main_panel_center.add(diary_table,BorderLayout.CENTER);
		
	diary_table.add(new CalendarMain());
	}
	
	public static Window_D_panel_team diary_team 			= new Window_D_panel_team(option.GL_team(GL_team),option.team_panel_x, option.other_panel_margin, option.team_panel_size_fix, size.resize_screen_height-option.other_panel_height);
	
	public static void team_Add(){main_panel_center.add(diary_team,BorderLayout.WEST);}
	
	public static void team_hide() {
		
		System.out.println(option.GetPanel(main_panel_center,BorderLayout.EAST));
		
		if (option.hasPanel(main_panel_center,BorderLayout.WEST)) {
			main_panel_center.remove(diary_team);
		}
		else {
			main_panel_center.add(diary_team,BorderLayout.WEST);
		}
		main_panel_center.validate();
		main_panel_center.repaint();
		
	}
	
	
	public static Window_D_panel_message diary_message		= new Window_D_panel_message(option.message_panel_x, option.other_panel_margin, option.message_panel_size_fix, size.resize_screen_height-option.other_panel_height);
	
	public static void message_Add(){main_panel_center.add(diary_message,BorderLayout.EAST);}
	
	public static void message_hide() {
		
		if (option.hasPanel(main_panel_center,BorderLayout.EAST)) {
			main_panel_center.remove(diary_message);
		}
		else {
			main_panel_center.add(diary_message,BorderLayout.EAST);
		}
		main_panel_center.validate();
		main_panel_center.repaint();


	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	int a = 1;
	
	int[] aa = new int[1]; 
	
	ArrayList<JPanel> 패널배치 = new ArrayList();
	
	public static void panel_team_visible() {
		main_panel.revalidate();
		main_panel.revalidate();
		diary_team.revalidate();
		diary_table.revalidate();
	}

	public static void exit() {System.exit(0);};
	
		
	public static void max() {
		
		
		if(	diary_frame.getHeight() == size.resize_screen_height) {
			
			diary_frame.setSize(1680,800);
			main_panel.setSize(1680,800);
			main_panel.revalidate();
			
			diary_team.setPreferredSize(new Dimension(option.team_panel_size_fix,main_panel.getHeight()-option.other_panel_height));
			diary_message.setPreferredSize(new Dimension(option.message_panel_size_fix,main_panel.getHeight()-option.other_panel_height));
			diary_table.setPreferredSize(new Dimension(main_panel.getSize().width - option.table_panel_size - (option.table_panel_x_margin)  ,main_panel.getHeight()-option.other_panel_height));
			
			
			diary_frame.setExtendedState(diary_frame.NORMAL);

			
			diary_frame.repaint();
		}
		else {

			diary_frame.setExtendedState(diary_frame.MAXIMIZED_BOTH);
		
			diary_frame.setSize(size.resize_screen_width,size.resize_screen_height);
			main_panel.setSize(size.resize_screen_width,size.resize_screen_height);
			main_panel.revalidate();
			
			diary_team.setPreferredSize(new Dimension(option.team_panel_size_fix,main_panel.getHeight()-option.other_panel_height));
			diary_message.setPreferredSize(new Dimension(option.message_panel_size_fix,main_panel.getHeight()-option.other_panel_height));
			diary_table.setPreferredSize(new Dimension(main_panel.getSize().width - option.table_panel_size - (option.table_panel_x_margin)  ,main_panel.getHeight()-option.other_panel_height));
			
			diary_frame.repaint();
		}
	}
	

	public static void resize_relayout_() {
		
		main_panel.revalidate();
		diary_frame.revalidate();
		diary_head.revalidate();
		
		diary_frame.setSize(main_panel.getSize());	
	
		if(btn_x.getLocation().x < 0) {btn_x.setVisible(false);}
		else {btn_x.setVisible(true);}
		if(btn_ㅁ.getLocation().x < 0) {btn_ㅁ.setVisible(false);}
		else {btn_ㅁ.setVisible(true);}
		if(btn_ㅡ.getLocation().x < 0) {btn_ㅡ.setVisible(false);}
		else {btn_ㅡ.setVisible(true);}
		
		diary_team.setPreferredSize(new Dimension(option.team_panel_size_fix,main_panel.getHeight()-option.other_panel_height));
		diary_message.setPreferredSize(new Dimension(option.message_panel_size_fix,main_panel.getHeight()-option.other_panel_height));
		diary_table.setPreferredSize(new Dimension(main_panel.getSize().width - option.table_panel_size - (option.table_panel_x_margin)  ,main_panel.getHeight()-option.other_panel_height));
		
		diary_frame.repaint();
	};
	
	public static void 패널기본배치() {
		
		Window_interface_D.main_panel_center.setLayout(new BorderLayout(0, 0));
    	
		Window_interface_D.main_panel_center.removeAll();
    	
		Window_interface_D.main_panel_center.add(Window_interface_D.diary_head, BorderLayout.NORTH);
    	Window_interface_D.main_panel_center.add(Window_interface_D.diary_team, BorderLayout.WEST);
    	Window_interface_D.main_panel_center.add(Window_interface_D.diary_table, BorderLayout.CENTER);
    	Window_interface_D.main_panel_center.add(Window_interface_D.diary_message, BorderLayout.EAST);
    	
    	Window_interface_D.main_panel_center.revalidate();
    	Window_interface_D.main_panel_center.repaint();
		
	}
	
	public static void hide() {diary_frame.setExtendedState(diary_frame.ICONIFIED);}
	

    //Window_interface_D.main_panel.revalidate();
}

package swing_d;

import java.awt.EventQueue;
import java.awt.Font;

public class Main_D {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {public void run() {
				
			
			try {
				Window_interface_D.message_Add();
				Window_interface_D.team_Add();
				Window_interface_D.table_Add();
				Window_interface_D.head_Add();
				Window_interface_D.panel_Add();
				Window_interface_D.diary_frame.setVisible(true);
				
			} 
			
			catch (Exception e) {e.getMessage();}
		
		}});  //eventqueue end
	}  // static main end
} // class main_D end

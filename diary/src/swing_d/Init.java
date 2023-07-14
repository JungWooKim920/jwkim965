package swing_d;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.util.Collections;

public class Init {
	
	public int main_panel_border_layout_x = 5;
	public int main_panel_border_layout_y = 5;
	public int main_panel_x = 0;  
	public int main_panel_y = 0; 
	public boolean main_panel_border_layout = true;
	public boolean main_panel_border_rownd = true;
	public float main_panel_border_setStroke = 2.0f;
	public int main_panel_width_rownd  = 10;
	public int main_panel_height_rownd  = 10;	
	public Color main_set_layout_color = new Color(120,180,180,0);
	public Color main_set_fill_color = new Color(120,180,180,0);	
	
	public int main_panel_center_border_layout_x = 0;
	public int main_panel_center_border_layout_y = 0;
	public int main_panel_center_x = 0;  
	public int main_panel_center_y = 0;
	public boolean main_panel_center_border_layout = true;	
	public boolean main_panel_center_border_rownd = false;
	public float main_panel_center_border_setStroke = 1.0f;
	public int main_panel_center_width_rownd  = 10;
	public int main_panel_center_height_rownd  = 10;
	public Color main_set_center_layout_color = new Color(80,180,180,180);
	public Color main_set_center_fill_color = new Color(120,180,180,180);	

	/*헤드패널은 그리드 레이아웃임*/
	public int head_panel_height = 60; //헤드의 높이를 정하는 옵션임
	public int head_panel_x = 5;
	public int head_panel_y = 5;
	public boolean head_panel_border_layout = false;
	public boolean head_panel_border_rownd = true;
	public float head_panel_border_setStroke = 1.0f;
	public int head_panel_width_rownd  = 10;
	public int head_panel_height_rownd  = 10;
	public Color head_set_layout_color = new Color(0,0,0,255);
	public Color head_set_fill_color = new Color(245,255,255,255);	
	
	/*헤드 패널에 추가되는 끄기, 숨기기, 사이즈 조절 기능임*/
	
	public boolean btn_label_circle_layout = true; 
	public boolean btn_label_border_rownd = true;
	public Color btn_label_set_layout_color = new Color(180,255,255,255);
	public Color btn_label_set_fill_color = new Color(120,255,255,180);	
	public Color btn_label_set_font_color = new Color(0,0,0,255);	
	public float btn_label_border_setStroke = 1.0f;
	public float btn_label_set_font_size = 24f;	
	
	/*헤드의 레이아웃 기능임*/
	public GridBagLayout GL_head(GridBagLayout GL) {
		
		GL.columnWidths = new int[]{head_panel_x * 2,32,32,40,50,50,32,32,32,head_panel_x * 3};
		GL.rowHeights = new int[]{60};
		GL.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.5, 0.5, 0.0, 0.0, 0.0, 0.0};
		GL.rowWeights = new double[]{Double.MIN_VALUE};
		return GL;
	} 
	
	public int table_panel_x = 5;
	public boolean table_panel_border_layout = true;
	public boolean table_panel_border_rownd = true;
	public float table_panel_border_setStroke = 1.0f;
	public int table_panel_width_rownd  = 10;
	public int table_panel_height_rownd  = 10;
	public Color table_set_layout_color = new Color(0,0,0,255);
	public Color table_set_fill_color = new Color(200,200,200,200);	
	
	public int team_panel_x = 5;
	public int team_panel_size_fix = 200;
	public boolean team_panel_border_layout = true;
	public boolean team_panel_border_rownd = true;
	public float team_panel_border_setStroke = 1.0f;
	public int team_panel_width_rownd  = 10;
	public int team_panel_height_rownd  = 10;
	public Color team_set_layout_color = new Color(0,0,0,255);
	public Color team_set_fill_color = new Color(255,255,255,255);
	
	public int message_panel_x = 5;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public int table_panel_x_margin = message_panel_x + message_panel_x;//team_panel_x + 
	
	
	
	
	
	
	
	public int other_panel_margin = 0;
	public int other_panel_height = head_panel_height - other_panel_margin;
	public int other_border_layout_width = 5;
	public int other_border_layout_height = 0;
	
	
	public int message_panel_size_fix = 200;
	public int table_panel_size = team_panel_size_fix + message_panel_size_fix;
	
	public boolean resize_line_visible = false;
	public boolean mainframe_auto_size = true;
	
	
	public boolean head_move_icon_layout = false;
	public boolean head_move_icon_rownd = true;
	public Color head_move_icon_color = new Color(180,255,255,180);	

	
	public boolean team_move_icon_layout = false;
	public boolean team_move_icon_rownd = true;
	public Color team_move_icon_fill_color = new Color(120,255,255,210);	
	public Color team_move_icon_layout_color = new Color(0,0,0,180);	
	public float team_move_icon_setStroke = 2.0f;
	
	public boolean message_panel_border_layout = true;
	public boolean message_panel_border_rownd = true;
	public float message_panel_border_setStroke = 1.0f;
	public int message_panel_width_rownd  = 10;
	public int message_panel_height_rownd  = 10;
	public Color message_set_layout_color = new Color(0,0,0,255);
	public Color message_set_fill_color = new Color(255,255,255,255);	
	
	public boolean message_move_icon_layout = false;
	public boolean message_move_icon_rownd = true;
	public Color message_move_icon_color = new Color(180,255,255,180);	
	public float message_move_icon_setStroke = 2.0f;
	
	
	public boolean table_move_icon_layout = false;
	public boolean table_move_icon_원그리기 = false;
	public boolean table_move_icon_rownd = true;
	public Color table_move_icon_color = new Color(180,255,255,180);	
	public float table_move_icon_setStroke = 2.0f;
	public int table_move_icon_width_rownd  = 10;
	public int table_move_icon_height_rownd  = 10;


	/*오토 사이즈를 사용하면 아래 사이즈로 정리됩니다.*/
	public boolean panel_auto_resize = false;
	public int main_panel_auto_x = 5;
	public int main_panel_auto_y = 5;
	public int head_panel_auto_y = 5;
	public int head_panel_auto_x = 5;
	public int team_panel_auto_x = 5;
	public int team_panel_auto_y = 5;
	public int message_panel_auto_y = 5;
	public int message_panel_auto_x = 5;
	public int table_panel_auto_x = 5;
	public int table_panel_auto_y = 5;
	
	/*아래는 아직 구상중인 화면사이즈 태그임*/
	public int[] size_option_1= {1920,1080};
	public int[] size_option_2= {1760,990};
	public int[] size_option_3= {1680,1050};
	public int[] size_option_4= {1600,900};
	public int[] size_option_5= {1366,768};
	public int[] size_option_6= {1280,1024};
	public int[] size_option_7= {1280,720};
	public int[] size_option_8= {1128,634};
	public int[] size_option_9= {1024,768};
	public int[] size_option_10= {1024,768};
	
	public GridBagConstraints GL_label(GridBagConstraints label,int grid_x, int grid_y,int insert1,int insert2,int insert3,int insert4) {
		label.insets = new Insets(insert1, insert2, insert3, insert4);
		label.gridx = grid_x;
		label.gridy = grid_y;
		return label;
	}
	
	public boolean hasPanel(Container container, String position) {
        LayoutManager layout = container.getLayout();
        
        if (layout instanceof BorderLayout) {
            BorderLayout borderLayout = (BorderLayout) layout;
            Component component = borderLayout.getLayoutComponent(container, position);
            
            return component != null;
        }
        
            return false;
	}
	
	public int isPanel(Container container, String position) {
        LayoutManager layout = container.getLayout();
        
        if (layout instanceof BorderLayout) {
            BorderLayout borderLayout = (BorderLayout) layout;
            Component component = borderLayout.getLayoutComponent(container, position);
            
            if (component == null) {return 0;}
            else {component.getWidth();}
            
            return component.getWidth();
        }
    
        
        return 0;	
	}
	
	
}

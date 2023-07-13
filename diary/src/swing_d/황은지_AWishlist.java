package swing_d;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class 황은지_AWishlist extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	
	public 황은지_AWishlist() {
		getContentPane().setLayout(null);
		
		JPanel all = new JPanel();
		all.setBackground(new Color(252, 165, 112));
		all.setToolTipText("");
		all.setBorder(new LineBorder(new Color(0, 0, 0)));
		all.setBounds(0, 0, 518, 343);
		getContentPane().add(all);
		all.setLayout(null);
		all.setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 65, 517, 280);
		all.add(panel);
		panel.setBackground(new Color(252, 165, 112));
		panel.setLayout(null);
		
		
		JPanel 내용패널_1 = new JPanel();
		내용패널_1.setBackground(new Color(253, 185, 145));
		내용패널_1.setBounds(56, 60, 410, 28);
		panel.add(내용패널_1);
		내용패널_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("name");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(34, 0, 75, 28);
		내용패널_1.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(135, 4, 233, 21);
		내용패널_1.add(textField);
		textField.setColumns(10);
		
		JPanel 내용패널_1_1 = new JPanel();
		내용패널_1_1.setBackground(new Color(253, 189, 151));
		내용패널_1_1.setBounds(56, 93, 410, 28);
		panel.add(내용패널_1_1);
		내용패널_1_1.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("price");
		lblNewLabel_1_1.setBounds(36, 0, 75, 25);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		내용패널_1_1.add(lblNewLabel_1_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(134, 2, 233, 21);
		내용패널_1_1.add(textField_2);
		
		JPanel 내용패널_1_2 = new JPanel();
		내용패널_1_2.setBackground(new Color(253, 189, 151));
		내용패널_1_2.setBounds(56, 126, 410, 28);
		panel.add(내용패널_1_2);
		내용패널_1_2.setLayout(null);
		
		JLabel lblNewLabel_1_2 = new JLabel("place");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setBounds(36, 0, 75, 28);
		내용패널_1_2.add(lblNewLabel_1_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(136, 4, 233, 21);
		내용패널_1_2.add(textField_3);
		
		JPanel 내용패널_1_2_1 = new JPanel();
		내용패널_1_2_1.setBackground(new Color(253, 218, 191));
		내용패널_1_2_1.setBounds(56, 196, 410, 74);
		panel.add(내용패널_1_2_1);
		내용패널_1_2_1.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("MEMO");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(12, 10, 57, 54);
		내용패널_1_2_1.add(lblNewLabel_4);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(81, 10, 317, 54);
		내용패널_1_2_1.add(textArea);
		
		JPanel 내용패널_1_2_2 = new JPanel();
		내용패널_1_2_2.setBackground(new Color(253, 189, 151));
		내용패널_1_2_2.setBounds(56, 164, 410, 28);
		panel.add(내용패널_1_2_2);
		내용패널_1_2_2.setLayout(null);
		
		JLabel lblNewLabel_1_3 = new JLabel("important");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setBounds(39, 0, 75, 28);
		내용패널_1_2_2.add(lblNewLabel_1_3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2"}));
		comboBox.setBounds(291, 3, 107, 23);
		내용패널_1_2_2.add(comboBox);
		
		textField_1 = new JTextField();
		textField_1.setBounds(138, 4, 141, 21);
		내용패널_1_2_2.add(textField_1);
		textField_1.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(252, 165, 112));
		panel_2.setBounds(67, 10, 380, 40);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("달력체크박스");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_2.setBounds(286, 6, 82, 30);
		panel_2.add(lblNewLabel_2);
		
		JLabel 목표일 = new JLabel("목표일");
		목표일.setHorizontalAlignment(SwingConstants.CENTER);
		목표일.setBounds(12, 11, 57, 20);
		panel_2.add(목표일);
		
		JLabel lblNewLabel_3 = new JLabel("(목표일 체크하면 날짜표시)칸");
		lblNewLabel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_3.setBackground(new Color(224, 175, 135));
		lblNewLabel_3.setBounds(81, 10, 182, 23);
		panel_2.add(lblNewLabel_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(252, 165, 112));
		panel_1.setBounds(0, 10, 517, 42);
		all.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Wish list");
		lblNewLabel.setBounds(237, 17, 47, 15);
		panel_1.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	}
	
public static void main(String[] args) {
	new 황은지_AWishlist();
}
}

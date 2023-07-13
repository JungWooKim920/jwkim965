package swing_d;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class 황은지_Accountbook extends JPanel{
	
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTable table_3;
	private JTable table_4;
	
	public 황은지_Accountbook() {
		setLayout(null);
		this.setSize(1000,1000);
		this.setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(89, 136, 145));
		panel.setBounds(12, 10, 960, 951);
		add(panel);
		panel.setLayout(null);
		
		JPanel panel1 = new JPanel();
		panel1.setBackground(new Color(102, 154, 159));
		panel1.setBounds(25, 244, 274, 630);
		panel.add(panel1);
		panel1.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(12, 22, 250, 100);
		panel1.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("금액");
		lblNewLabel_4.setBorder(new LineBorder(new Color(64, 128, 128)));
		lblNewLabel_4.setBounds(92, 10, 146, 44);
		panel_4.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("사용자 입력내용\r\n");
		lblNewLabel_4_1.setBorder(new LineBorder(new Color(64, 128, 128)));
		lblNewLabel_4_1.setBounds(12, 52, 226, 38);
		panel_4.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_2 = new JLabel("날짜");
		lblNewLabel_4_2.setBorder(new LineBorder(new Color(64, 128, 128)));
		lblNewLabel_4_2.setBounds(12, 10, 72, 44);
		panel_4.add(lblNewLabel_4_2);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(12, 132, 250, 76);
		panel1.add(panel_5);
		
		JPanel panel_5_1 = new JPanel();
		panel_5_1.setBounds(12, 218, 250, 150);
		panel1.add(panel_5_1);
		
		JPanel panel_5_1_1 = new JPanel();
		panel_5_1_1.setBounds(12, 389, 250, 209);
		panel1.add(panel_5_1_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(102, 154, 159));
		panel_2.setBounds(311, 244, 619, 626);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("달력 넣고 달력에 월별 합산 수입 지출 계산값 나오게하기.\r\n");
		lblNewLabel_3.setBackground(new Color(102, 154, 159));
		lblNewLabel_3.setBounds(12, 21, 595, 595);
		panel_2.add(lblNewLabel_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(184, 208, 211));
		panel_1.setBounds(23, 10, 907, 142);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(184, 208, 211));
		panel_6.setBounds(12, 10, 696, 122);
		panel_1.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("Account Book");
		lblNewLabel_6.setFont(new Font("Algerian", Font.BOLD, 23));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(105, 21, 276, 78);
		panel_6.add(lblNewLabel_6);
		
		JLabel lblNewLabel = new JLabel("(코무니코)  MY 가계부");
		lblNewLabel.setFont(new Font("휴먼옛체", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(419, 73, 265, 39);
		panel_6.add(lblNewLabel);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(141, 180, 184));
		panel_7.setBounds(720, 10, 175, 122);
		panel_1.add(panel_7);
		panel_7.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("위시리스트 추가하기");
		lblNewLabel_1.setForeground(new Color(0, 0, 64));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(12, 10, 151, 68);
		panel_7.add(lblNewLabel_1);
		
		JButton btnNewButton_3 = new JButton("추가하기");
		btnNewButton_3.setBounds(43, 89, 97, 23);
		panel_7.add(btnNewButton_3);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(25, 162, 905, 72);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnNewButton = new JButton("금액 숨기기");
		btnNewButton.setBounds(653, 10, 97, 23);
		panel_3.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("금액 보이기");
		btnNewButton_1.setBounds(653, 39, 97, 23);
		panel_3.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(316, 10, 320, 55);
		panel_3.add(scrollPane);
		
		table_3 = new JTable();
		table_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		table_3.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"수입", "지출", "합계"
			}
		));
		
		scrollPane.setViewportView(table_3);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 7, 172, 55);
		panel_3.add(scrollPane_1);
		
		table_4 = new JTable();
		table_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		table_4.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
			},
			new String[] {
				"저축/투자", "대출"
			}
		));
		scrollPane_1.setViewportView(table_4);
		
		JButton btnNewButton_2 = new JButton("금액 숨기기");
		btnNewButton_2.setBounds(190, 10, 97, 23);
		panel_3.add(btnNewButton_2);
		
		JButton btnNewButton_1_1 = new JButton("금액 보이기");
		btnNewButton_1_1.setBounds(190, 42, 97, 23);
		panel_3.add(btnNewButton_1_1);
		
		JButton btnNewButton_4 = new JButton("Data 조회");
		btnNewButton_4.setBounds(780, 7, 113, 55);
		panel_3.add(btnNewButton_4);
		
	}

}

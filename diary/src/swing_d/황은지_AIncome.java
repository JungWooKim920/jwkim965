package swing_d;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class 황은지_AIncome extends JFrame{
	private JTable table;
	private JTable table_1;
	public 황은지_AIncome() {
		getContentPane().setLayout(null);
		this.setSize(600,600);
		this.setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 154, 159));
		panel.setBounds(0, 0, 328, 307);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 39, 304, 41);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("가계부 정보입력");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 10, 280, 21);
		panel_1.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(12, 102, 304, 179);
		panel.add(scrollPane);
		
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcm = table_1.getColumnModel();
		for(int i = 0; i<tcm.getColumnCount();i++) {
			tcm.getColumn(i).setCellRenderer(dtcr);
		}
		
		table_1.setRowHeight(25);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{"수입", null},
				{"지출", null},
				{"저축", null},
				{"대출", null},
				{"공과금 및 기타", null},
			},
			new String[] {
				"내용", "금액"		}
		));
		table.setRowHeight(20);
		
	}
	public static void main(String[] args) {
		new 황은지_AIncome();
	}
}

package swing_d;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

	public class CalendarMain extends JPanel implements MouseListener{
		
		JPanel panel1 = new JPanel();
		CalendarBackground panel2 = new CalendarBackground("C:\\Users\\김정우\\Desktop\\Diary\\diary\\src\\img\\코무니코.png");
		JPanel panel3 = new JPanel();
		
		JLabel labelBefore = new JLabel("Before");
		
		JLabel labelAfter = new JLabel("After");
		
		
		JLabel topLabel = new JLabel("00년" + " " +  "0월");
		
		JLabel[] labels = new JLabel[49];
		String[] dayName = {"일", "월", "화", "수", "목", "금", "토"};
		
		CalendarFunction cf = new CalendarFunction();
		
		public CalendarMain() {
			setSize(600, 550);
			setLocation(90, 150);
			setLayout(new BorderLayout());
			init();
			add(panel1, BorderLayout.NORTH);
			add(panel2, BorderLayout.CENTER);
			//add(panel3, BorderLayout.WEST);
			start();
		}
		private void init() {
			
			Font font = new Font("Nanum Pen",Font.BOLD,24);
			GridBagLayout gridBagLayout = new GridBagLayout();
			panel1.setLayout(gridBagLayout);
			
			
			
			//폰트 및 텍스트 적용
			labelBefore.setFont(font);
			labelAfter.setFont(font);
			
			topLabel.setFont(new Font("Nanum Pen", Font.BOLD, 40));
			topLabel.setText(cf.getCalText());
			
			//간격 조절 초기화
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.gridx = 0;
			gbc.gridy = 0;
			gbc.anchor = GridBagConstraints.WEST;
			gbc.insets = new Insets(10, 0, 10, 10);//여백
		
			
			//거리조절및 add
			panel1.add(labelBefore, gbc);
			
			gbc.gridx = 1;
			gbc.gridy = 0;
			gbc.insets = new Insets(10, 10, 10, 100);
			panel1.add(labelAfter, gbc);
		
			gbc.gridx = 2;
			gbc.gridy = 0;
			gbc.insets = new Insets(10, 100, 10, 0);
			panel1.add(topLabel, gbc);
//			panel3.setPreferredSize(new Dimension(panel3.getPreferredSize().width + 50,
//					panel3.getPreferredSize().height));
//			panel3.setLayout(new GridBagLayout());
			
			panel2.setLayout(new GridLayout(7, 7, 5, 5));
			
			//panel2.setLocation(5, 0);
			for(int i = 0; i < labels.length; i++) {
				labels[i] = new JLabel();
				panel2. add(labels[i]);
				
				labels[i].setFont(new Font("Nanum Pen", Font.BOLD, 25));
				if(i < 7) labels[i].setText(dayName[i]);
				
				if(i%7 == 0) labels[i].setForeground(Color.red);
				if(i%7 == 6) labels[i].setForeground(Color.blue);
				
			}
			
			gbc.gridx = 0;
			gbc.gridy = 0;
//			panel3.add(panel2, gbc);
//			
//			ImageIcon imageIcon = new ImageIcon("C:\\Users\\김정우\\Desktop\\Diary\\diary\\src\\img\\코무니코.png");
//			JLabel imageLabel = new JLabel(imageIcon);
//			gbc = new GridBagConstraints();
//			gbc.gridx = 0;
//			gbc.gridy = 1;
//			panel3.add(imageLabel, gbc);
//			
//			revalidate();
			
			cf.setLabel(labels);
			cf.calSet();
			
			
			
		}
		private void start() {
			labelAfter.addMouseListener(this);
			labelBefore.addMouseListener(this);
			
		}
		
		
		@Override
		public void mouseClicked(java.awt.event.MouseEvent e) {
			int gap = 0;
			if(e.getSource() == labelAfter) {
				gap = 1;
			}else if(e.getSource() == labelBefore){
				gap = -1;
			}
			cf.allInit(gap);
			topLabel.setText(cf.getCalText());
			
		}
		@Override
		public void mousePressed(java.awt.event.MouseEvent e) {}
		@Override
		public void mouseReleased(java.awt.event.MouseEvent e) {}
		@Override
		public void mouseEntered(java.awt.event.MouseEvent e) {}
		@Override
		public void mouseExited(java.awt.event.MouseEvent e) {}
		
		
		
	}



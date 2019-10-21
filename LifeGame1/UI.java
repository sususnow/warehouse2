package LifeGame1;

import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.border.EmptyBorder;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UI extends JFrame {
	public JFrame frame1;
	public Logic[][] m_map1;
	public Graphics g1;
	
	public UI() {
		frame1 = new JFrame();
		frame1.setBounds(0,0,480,550);
		setTitle("第0次演化");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		m_map1=new Logic[30][30];
		m_map1=Map.initMap();
		Map.getNumberAroundCell(m_map1);
		
		JPanel panel = new JPanel();
		panel.setBounds(0,0,480,550);
		panel.setLayout(null);
		frame1.getContentPane().add(panel);
		frame1.setVisible(true);	
		
		JButton buttonStart=new JButton("开始游戏");
		
		buttonStart.setBounds(181, 473, 120, 30);
		panel.add(buttonStart);
		
		g1=panel.getGraphics();
		
		for(int i=0;i<30;i++)
			for(int j=0;j<30;j++)
			{
				g1.drawRect(i*15, j*15, 15, 15);   //绘制底层的格子
			}
		
		for(int i=0;i<30;i++)
			for(int j=0;j<30;j++)
			{
				if(m_map1[i][j].getStatus()==1)
				{
					g1.fillRect(i*15, j*15, 15, 15);   //填充活细胞
				}
			}
		Time t=new Time(frame1, m_map1, g1);
		/*buttonStart.addActionListener(new BSL());
	
		class BSL implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				Time t=new Time(frame1, m_map1, g1);
			}
		}*/
	}
}

package LifeGame1;

import java.awt.*;

import javax.swing.*;

public class Time 
{
	Time(JFrame f,Logic[][] map,Graphics g)
	{
		int count=0;//�ݻ��Ĵ���
		long t1=System.currentTimeMillis();
		while(true)
		{
			long t2=System.currentTimeMillis();
			
			if((t2-t1)>400)
			{
				int stable; //ƽ���ϸ���ĸ���
				t1=t2;
				f.repaint();
				
				Map.getNumberAroundCell(map);
				stable=Map.update(map);
				
				for(int i=0;i<30;i++)
					for(int j=0 ;j<30 ;j++)
					{
						if(map[i][j].getStatus()==1)
						{
							g.fillRect(i*15, j*15, 15, 15);   //����ϸ��
						}
						else
						{
							g.drawRect(i*15, j*15, 15, 15);
						}
					}
				count++;
				f.setTitle("���ǵ�"+count+"���ݻ�");
				
				if(stable==30*30) 
    			{
    				JOptionPane.showMessageDialog(f, "�ڵ�"+count+"���ݻ��ﵽƽ��", "��ʾ", JOptionPane.PLAIN_MESSAGE);
    				break;  //����ϸ��״̬���ٸı�ﵽƽ��
    			}
    			if(count>1000) 
    			{
    				JOptionPane.showMessageDialog(f, "���ݻ�"+count+"�Σ��޷��ﵽƽ��", "��ʾ", JOptionPane.PLAIN_MESSAGE); 
    				break;  
    			}

			}
		}
	}
	
}

package LifeGame1;

import java.awt.*;

import javax.swing.*;

public class Time 
{
	Time(JFrame f,Logic[][] map,Graphics g)
	{
		int count=0;//演化的次数
		long t1=System.currentTimeMillis();
		while(true)
		{
			long t2=System.currentTimeMillis();
			
			if((t2-t1)>400)
			{
				int stable; //平衡的细胞的个数
				t1=t2;
				f.repaint();
				
				Map.getNumberAroundCell(map);
				stable=Map.update(map);
				
				for(int i=0;i<30;i++)
					for(int j=0 ;j<30 ;j++)
					{
						if(map[i][j].getStatus()==1)
						{
							g.fillRect(i*15, j*15, 15, 15);   //填充活细胞
						}
						else
						{
							g.drawRect(i*15, j*15, 15, 15);
						}
					}
				count++;
				f.setTitle("这是第"+count+"次演化");
				
				if(stable==30*30) 
    			{
    				JOptionPane.showMessageDialog(f, "在第"+count+"次演化达到平衡", "提示", JOptionPane.PLAIN_MESSAGE);
    				break;  //所有细胞状态不再改变达到平衡
    			}
    			if(count>1000) 
    			{
    				JOptionPane.showMessageDialog(f, "已演化"+count+"次，无法达到平衡", "提示", JOptionPane.PLAIN_MESSAGE); 
    				break;  
    			}

			}
		}
	}
	
}

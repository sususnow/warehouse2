package LifeGame1;

import java.util.Random;

public class Map {
	final static public int x = 30;
	final static public int y = 30;

	public static Logic[][] initMap()  //��ʼ����ͼ
	{
		Logic [][]map=new Logic[x][y];
		for(int i=0 ;i<x ;i++)
		{
			for(int j=0 ;j<y ;j++)
			{
				map[i][j] = new Logic();
				//map[i][j].setStatus(1);//��ʼ����ͼϸ��״̬����������UI����������
				//Random random=new Random();
    			//map[i][j].setStatus(random.nextInt(2));
			}
		}
		map[1][1].setStatus(1);
		map[2][1].setStatus(1);
    	map[3][1].setStatus(1);
    //	map[1][1].setStatus(1);*/
		return map;
	}
	
	public static void getNumberAroundCell(Logic[][] map)
	{
		for(int i=0 ;i<x ;i++)
		{
			for(int j=0 ;j<y ;j++)
			{
				int liveNumber=0;
				if(i>0 && j>0)
					liveNumber+=map[i-1][j-1].getStatus(); //��¼��ϸ�����Ͻ�ϸ��״̬
				if(i>0)
					liveNumber+=map[i-1][j].getStatus();   //��¼��ϸ���ϱ�ϸ��״̬
				if(j>0)
					liveNumber+=map[i][j-1].getStatus();   //��¼��ϸ�����ϸ��״̬
				if(i<x-1 && j<y-1)
					liveNumber+=map[i+1][j+1].getStatus(); //��¼��ϸ�����½�ϸ��״̬
				if(i<x-1)
					liveNumber+=map[i+1][j].getStatus();   //��¼��ϸ���±�ϸ��״̬
				if(j<y-1)
					liveNumber+=map[i][j+1].getStatus();   //��¼��ϸ���ұ�ϸ��״̬
				if(i>0 && j<y-1)
					liveNumber+=map[i-1][j+1].getStatus(); //��¼��ϸ�����Ͻ�ϸ��״̬
				if(i<x-1 && j>0)
					liveNumber+=map[i+1][j-1].getStatus(); //��¼��ϸ�����½�ϸ��״̬
				
				map[i][j].setNumberAroundCell(liveNumber); //���ø�������Χ��ϸ����Ŀ
			}
		}
	}
	
	public static int update(Logic[][] map)//����֮���ж�ϸ��״̬�Ƿ�ı�
	{
		int count=0;
		for(int i=0 ;i<x ;i++)
		{
			for(int j=0 ;j<y ;j++)
			{
				int status=map[i][j].getStatus();
				map[i][j].gameRule();
				if(status==map[i][j].getStatus())
					count++;  //countӦ���ͼ�ʱ��������
			}
		}
		return count;
	}
	
	/*public static void printMap(Logic [][]map)  //��ӡ����
	{
    	for(int i=0 ;i<x ;i++) {
    		for(int j=0 ;j<y ;j++) {
    			System.out.print(map[i][j].getStatus()+" ");
    		}
    		System.out.println();
    	}
    }*/

}



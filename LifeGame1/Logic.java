package LifeGame1;

public class Logic
{
	private int Status;  //ϸ��״̬��0����ϸ����1�ǻ�ϸ��
	private int NumberAroundCell;  //ϸ����Χ��ϸ������Ŀ
	
	Logic()
	{
		Status = 0;
		NumberAroundCell = 0;
	}
	/*Logic(int g_Status , int g_NumberAroundCell)
	{
		Status = g_Status;
		NumberAroundCell = g_NumberAroundCell;
	}*/
	
	public void setStatus(int g_Status)
	{
		Status = g_Status;
	}
	public int getStatus()
	{
		return Status;
	}
	
	public void setNumberAroundCell(int g_NumberAroundCell)
	{
		NumberAroundCell = g_NumberAroundCell;
	}
	public int getNumberAroundCell()
	{
		return NumberAroundCell;
	}
	
	public void gameRule()
	{  //��Ϸ���ݵĸ��¼���Ϸ����
		if(NumberAroundCell > 3 || NumberAroundCell <2)
			this.setStatus(0);
		else if(NumberAroundCell == 3)
			this.setStatus(1);
		
	}
}
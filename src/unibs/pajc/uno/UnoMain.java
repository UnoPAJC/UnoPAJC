package unibs.pajc.uno;

import java.awt.EventQueue;

import unibs.pajc.uno.view.MainMenu;

public class UnoMain
{
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					MainMenu frame = new MainMenu();
					frame.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}
}

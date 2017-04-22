package mancala;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.Icon;


public class Board implements Icon
{
	DataModel model;
	
	public Board(DataModel model)
	{
		this.model = model;
	}

	public void paintIcon(Component c, Graphics g, int x, int y) 
	{
        Graphics2D g2 = (Graphics2D) g;

        for(int i = 0; i < 14; i++)
        {
        	
        }
        
	}

	public int getIconWidth() 
	{
		return 0;
	}

	public int getIconHeight() 
	{
		return 0;
	}
	
	
}

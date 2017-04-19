package mancala;

import java.awt.Component;
import java.awt.Graphics;

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
		
	}

	@Override
	public int getIconWidth() 
	{
		return 0;
	}

	@Override
	public int getIconHeight() 
	{
		return 0;
	}
	
	
}

package mancala;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.Icon;


public class Board 
{
	private DataModel model;
	private RectangleBoard rectBoard;
	
	enum BoardType
	{
		circular, rectangular;
	}
	
	public Board(DataModel model, BoardType board)
	{
		this.model = model;
		
		rectBoard = new RectangleBoard(model);	
	}
	
	

}

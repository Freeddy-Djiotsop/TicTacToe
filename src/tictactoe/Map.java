package tictactoe;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Map extends JPanel
{
	private static final long serialVersionUID = 1L;
	static ArrayList<Field> arrays;
	static int index;
	
	public Map() 
	{
		arrays = new ArrayList<>();
		index = 0;
		setLayout(new GridLayout(3, 3, 0, 0));
		setPreferredSize(new Dimension(300, 300));
		fillMap();
	}
	
	private void fillMap()
	{
		for(int i=0; i<9; i++)
		{
			arrays.add(i, new Field(i, 1, 10));
			add(arrays.get(i));
		}
	}

}

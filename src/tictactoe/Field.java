package tictactoe;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class Field  extends JPanel implements MouseListener
{
	private static final long serialVersionUID = 1L;
	
	private String character;
	private int x;
	private int y;
	private int id;

	public Field(int _id, int _x, int _y) 
	{
		this.id = _id;
		this.x = _x;
		this.y = _y;
		this.character = "";
		if(id%2==0) this.setBackground(Color.black);
		addMouseListener(this);
	}
	
	void setCharachter(String c)
	{
		if(this.character.equals(""))
		{
			this.character = c;
			TicTacToe.checkBoard[this.id] = this.character;
			repaint();
			TicTacToe.check();
		}
	}
	
	void reset()
	{
		this.character = "";
	}
	
	
	public void paint(Graphics c)
	{
		Graphics2D g = (Graphics2D)c;
		super.paint(g);
		if(!this.character.equals(""))
		{
			if(Map.index%2==0)
				g.setColor(Color.BLUE);
			else
				g.setColor(Color.RED);
			g.setStroke(new BasicStroke(20));
			g.setFont(new Font("Comic Sans", Font.BOLD, 80));
			g.drawString(this.character, x+20, y+70);
		}
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		
		if(Map.index<9&&!TicTacToe.win)
		{
			if(Map.arrays.get(this.id).character.equals(""))
			{
				if(Map.index%2==0)
				{
					TicTacToe.labelLeft.setText("Player: 2");
					Map.arrays.get(this.id).setCharachter("X");
				}
				else
				{
					TicTacToe.labelLeft.setText("Player: 1");
					Map.arrays.get(this.id).setCharachter("O");
				}
				Map.index++;
			}
		}
		if(Map.index>8&&!TicTacToe.win)
			TicTacToe.labelLeft.setText("Game End.");
		
	}


	@Override public void mousePressed(MouseEvent e) {}
	@Override public void mouseReleased(MouseEvent e) {}
	@Override public void mouseEntered(MouseEvent e) {}
	@Override public void mouseExited(MouseEvent e) {}

}

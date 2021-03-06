package tictactoe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TicTacToe extends JFrame
{
	private static final long serialVersionUID = 1L;
	
	private JPanel panelTop;
	private JPanel panelLeft;
	static JLabel labelLeft;
	
	private JButton newGameBtn;
	
	static String checkBoard[] = {"", "", "", "", "", "", "", "", ""};
	private static String winner;
	static boolean win;
	

	public TicTacToe()
	{
		panelTop = new JPanel();
		panelLeft = new JPanel();
		newGameBtn = new JButton("New Game");
		labelLeft = new JLabel("Player: 1");
		labelLeft.setFont(new Font("", NORMAL, 30));
		win = false;
		
		
		setTitle("Tic Tac Toe");
		newGameBtn.addActionListener(e->reset());
		
		this.setLayout(new BorderLayout());
		
		panelTop.setBackground(Color.BLUE);
		panelTop.setPreferredSize(new Dimension(50,50));
		
		panelLeft.setBackground(Color.GRAY);
		panelLeft.setPreferredSize(new Dimension(150,150));
		panelLeft.setLayout(new BorderLayout());
		panelLeft.add(newGameBtn, BorderLayout.NORTH);
		panelLeft.add(labelLeft, BorderLayout.CENTER);
		
		this.add(panelTop,BorderLayout.NORTH);
		this.add(panelLeft,BorderLayout.WEST);
		this.add(new Map());
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void reset()
	{
		for(int i=0; i<9; i++)
		{
			checkBoard[i] = "";
			Map.arrays.get(i).reset();
			Map.arrays.get(i).repaint();
		}
		Map.index = 0;
		win = false;
		winner = "";
		labelLeft.setText("Player: 1");
		
	}

	private static void won(String c)
	{
		win = true;
		winner = c;
	}
	static void check()
	{
		//Lines
		lines();
		//Splates
		column();
		//Diagonal
		diagonal();
		//Anti-Diagonal
		antidiagonal();
		
		if(win)
			labelLeft.setText("Winner: "+winner);
	}

	private static void lines() 
	{
		if(!checkBoard[0].equals("")&&checkBoard[0].equals(checkBoard[1])&&checkBoard[0].equals(checkBoard[2]))
			won(checkBoard[0]);
		else if(!checkBoard[3].equals("")&&checkBoard[3].equals(checkBoard[4])&&checkBoard[3].equals(checkBoard[5]))
			won(checkBoard[3]);
		else if(!checkBoard[6].equals("")&&checkBoard[6].equals(checkBoard[7])&&checkBoard[6].equals(checkBoard[8]))
			won(checkBoard[6]);
	}
	
	private static void column() 
	{
		if(!checkBoard[0].equals("")&&checkBoard[0].equals(checkBoard[3])&&checkBoard[0].equals(checkBoard[6]))
			won(checkBoard[0]);
		else if(!checkBoard[1].equals("")&&checkBoard[1].equals(checkBoard[4])&&checkBoard[1].equals(checkBoard[7]))
			won(checkBoard[1]);
		else if(!checkBoard[2].equals("")&&checkBoard[2].equals(checkBoard[5])&&checkBoard[2].equals(checkBoard[8]))
			won(checkBoard[2]);
	}
	
	private static void diagonal()
	{
		if(!checkBoard[0].equals("")&&checkBoard[0].equals(checkBoard[4])&&checkBoard[0].equals(checkBoard[8]))
			won(checkBoard[0]);
	}
	
	private static void antidiagonal()
	{
		if(!checkBoard[2].equals("")&&checkBoard[2].equals(checkBoard[4])&&checkBoard[2].equals(checkBoard[6]))
			won(checkBoard[2]);
	}
	
	public static void main(String[] args)
	{

		new TicTacToe();
	}

}

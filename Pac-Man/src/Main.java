import java.awt.Color;
import javax.swing.*;
//import javax.swing.JLabel;
//import javax.swing.WindowConstants;

public class Main 
{
	public static void field(JFrame frame)
	{
		frame.setSize(700,500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setLayout(null);
	}
	public static void start(JFrame frame)
	{
		JButton startButton = new JButton(new ImageIcon("images/start.png"));
		startButton.setBounds(100,300,500,115);
		frame.add(startButton);
	}
	public static void main(String args[])
	{
		JFrame frame = new JFrame("Pac-Man");
		
		//Creates the window to play on. 
		field(frame);
		
		//Creates the start button. 
		start(frame);
		
		JLabel label = new JLabel("Pac-Man");
		label.setBounds(325,10,200,200);
		label.setVisible(true);
		label.setForeground(Color.YELLOW);
		frame.add(label);
	}
}


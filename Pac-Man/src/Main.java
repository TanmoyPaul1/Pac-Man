import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class Main {
	public static void main(String args[])
	{
		JFrame frame = new JFrame("Pac-Man");
		frame.setSize(500,500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.BLACK);
		JLabel label = new JLabel("Pac-Man");
		frame.setLayout(null);
		label.setBounds(100,100,100,100);
		label.setVisible(true);
		label.setForeground(Color.YELLOW);
		frame.add(label);
	}
}


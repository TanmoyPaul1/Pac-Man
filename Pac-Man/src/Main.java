import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements ActionListener
{
	private static JFrame frame;
	private static JLabel PacManLabel, nameLabel;
	private static JTextField nameText;
	private static JButton startButton;

	public Main(){
		//Creates the window to play on. 
		frame = new JFrame("Pac-Man");
		frame.setSize(700,500);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setLayout(null);
		
		//Creates the enter name text.
		nameLabel = new JLabel("Enter your name:");
		nameLabel.setBounds(263,150,200,50);
		nameLabel.setFont(new Font("", Font.PLAIN, 20));
		nameLabel.setForeground(Color.RED);
		
		//Creates text bow to enter name in.
		nameText = new JTextField("");  
		nameText.setBounds(250,200,200,50);
		nameText.setVisible(true);
		nameText.setForeground(Color.RED);
	    
		//Creates the start button. 		
		startButton = new JButton(new ImageIcon("images/start.png"));
		startButton.setBounds(100,300,500,115);
		startButton.addActionListener(this);
		
		frame.add(nameText);
		frame.add(nameLabel);
		frame.add(startButton);
	}
	
    public void actionPerformed(ActionEvent e) {  
    	String s1 = nameText.getText();
    	if(e.getSource()==startButton){  
        	frame.remove(startButton);
        }

    }

    public static void function()
	{
				
	}
	
	public static void main(String args[])
	{
		new Main();
		
		PacManLabel = new JLabel("Pac-Man");
		PacManLabel.setBounds(193,20,400,50);
		PacManLabel.setFont(new Font("", Font.BOLD, 70));
		PacManLabel.setForeground(Color.YELLOW);
		frame.add(PacManLabel);
		
		frame.setLocationRelativeTo(null);
		frame.revalidate();
		frame.setVisible(true);

	}
}


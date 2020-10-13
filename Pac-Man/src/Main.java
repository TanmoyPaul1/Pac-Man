import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class Main
{
	public static JFrame frame = new JFrame();
	public static JPanel panel = new JPanel();
	private static JLabel PacManLabel, nameLabel, nameLabel2; 
	private static JTextField nameText; 
	private static JButton startButton = new JButton(new ImageIcon("images/start.png")); 
	
	public static void main(String args[])
	{
		makeHomePage();
		//makeMap();
	}
	
	public static void makeHomePage()
	{
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setSize(700,500);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.add(panel);
		frame.setFocusable(true);
		frame.add(panel);
		panel.setBackground(Color.BLACK);
		panel.setLayout(null);
		
		panel.add(startButton);
		startButton.setBounds(100,300,500,115); 
		
		nameLabel = new JLabel("Enter your name:"); 
		nameLabel.setBounds(263,150,200,50); 
		nameLabel.setFont(new Font("", Font.PLAIN, 20)); 
		nameLabel.setForeground(Color.RED); 
		panel.add(nameLabel);
		
		nameText = new JTextField("");
		panel.add(nameText);
		nameText.setBounds(250,200,200,20);
		 
		PacManLabel = new JLabel("Pac-Man");
		panel.add(PacManLabel);
		PacManLabel.setBounds(193,20,400,50); 
		PacManLabel.setFont(new Font("", Font.BOLD, 70)); 
		PacManLabel.setForeground(Color.YELLOW); 
		
		startButton.addActionListener(new ActionListener() 
		{ 
			public void actionPerformed(ActionEvent e) 
			{ 
				startButton.setVisible(false);  
				nameText.setVisible(false);
				nameLabel.setVisible(false);
				PacManLabel.setVisible(false);
				makeMap();
			} 
		} ); 
	}
	
	public static void makeMap()
	{
		JLabel topBorder1 = new JLabel(new ImageIcon("images/horizontalBorder.png"));
		panel.add(topBorder1);
		topBorder1.setBounds(0,45,700,10); 
		
		JLabel bottomBorder1 = new JLabel(new ImageIcon("images/horizontalBorder.png")); 
		panel.add(bottomBorder1);
		bottomBorder1.setBounds(0,400,700,10); 
		
		JLabel sideBorder1 = new JLabel(new ImageIcon("images/verticalBorder.png")); 
		panel.add(sideBorder1);
		sideBorder1.setBounds(100,45,10,365); 
		
		JLabel sideBorder2 = new JLabel(new ImageIcon("images/verticalBorder.png")); 
		panel.add(sideBorder2);
		sideBorder2.setBounds(585,45,10,365); 
		
		JLabel pacMan = new JLabel(new ImageIcon("images/PacMan.gif")); 
		panel.add(pacMan);
		pacMan.setBounds(50,100,400,365); 
		
		
		frame.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				if(arg0.getKeyCode() == KeyEvent.VK_UP)
				{
					pacMan.setBounds(pacMan.getX(),pacMan.getY() - 5,400,365); 
				}
				if(arg0.getKeyCode() == KeyEvent.VK_DOWN)
				{
					pacMan.setBounds(pacMan.getX(),pacMan.getY() + 5,400,365); 
				}
				if(arg0.getKeyCode() == KeyEvent.VK_RIGHT)
				{
					pacMan.setBounds(pacMan.getX() + 5,pacMan.getY(),400,365); 
				}
				if(arg0.getKeyCode() == KeyEvent.VK_LEFT)
				{
					pacMan.setBounds(pacMan.getX() - 5,pacMan.getY(),400,365); 
				}
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}
}


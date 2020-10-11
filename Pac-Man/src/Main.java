import java.awt.Color; 
import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*; 

public class Main 
{ 
	private static JFrame frame; 
	private static JLabel PacManLabel, nameLabel, nameLabel2; 
	private static JTextField nameText; 
	private static JButton startButton; 
	
	public static void makeStartingPage() 
	{ 
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
		
		//Creates text window to enter name in. 
		nameText = new JTextField(""); 
		nameText.setBounds(250,200,200,50); 
		nameText.setVisible(true); 
		nameText.setForeground(Color.RED); 
		
		//Creates the start button. 
		startButton = new JButton(new ImageIcon("images/start.png")); 
		startButton.setBounds(100,300,500,115); 
		
		//Creates the Pac-Man text.
		PacManLabel = new JLabel("Pac-Man"); 
		PacManLabel.setBounds(193,20,400,50); 
		PacManLabel.setFont(new Font("", Font.BOLD, 70)); 
		PacManLabel.setForeground(Color.YELLOW); 
		
		//Adds all necessary components of the starting page. 
		frame.add(nameText); 
		frame.add(nameLabel); 
		frame.add(startButton); 
		frame.add(PacManLabel); 
		frame.setLocationRelativeTo(null); 
		frame.revalidate(); 
		frame.setVisible(true); 
		startButton.addActionListener(new ActionListener() 
		{ 
			public void actionPerformed(ActionEvent e) 
			{ 
				nameText.setVisible(false); 
				nameLabel.setVisible(false); 
				startButton.setVisible(false); 
				PacManLabel.setVisible(false); 
				map();
			} 
		} ); 
	} 
	
	public static void map()
	{
		//Welcomes the user with their entered name. 
		String s1 = nameText.getText();
		nameLabel2 = new JLabel("Welcome " + s1 + "!", SwingConstants.CENTER); 
		nameLabel2.setBounds(100,5,500,50); 
		nameLabel2.setFont(new Font("", Font.PLAIN, 25)); 
		nameLabel2.setForeground(Color.RED); 
		nameLabel2.setVisible(true); 
		frame.add(nameLabel2);
		
		//Creates map borders.
		JLabel topBorder1 = new JLabel(new ImageIcon("images/horizontalBorder.png")); 
		topBorder1.setBounds(0,45,700,10); 
		topBorder1.revalidate();
		frame.add(topBorder1);
		
		JLabel bottomBorder1 = new JLabel(new ImageIcon("images/horizontalBorder.png")); 
		bottomBorder1.setBounds(0,400,700,10); 
		frame.add(bottomBorder1);
		
		JLabel sideBorder1 = new JLabel(new ImageIcon("images/verticalBorder.png")); 
		sideBorder1.setBounds(100,45,10,365); 
		frame.add(sideBorder1);
		
		JLabel sideBorder2 = new JLabel(new ImageIcon("images/verticalBorder.png")); 
		sideBorder2.setBounds(585,45,10,365); 
		frame.add(sideBorder2);
	}
	public static void main(String args[]) 
	{ 
		makeStartingPage(); 
	} 
}
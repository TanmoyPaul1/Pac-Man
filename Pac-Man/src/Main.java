import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*;
import java.util.ArrayList;

public class Main
{
	//Initializes all required objects
	public static JFrame frame = new JFrame();
	public static JPanel panel = new JPanel();
	public static JLabel PacManLabel, nameLabel; 
	public static JTextField nameText; 
	public static JButton startButton = new JButton(new ImageIcon("images/start.png")); 
	static ArrayList<Map> borders = new ArrayList<Map>();
	public static int X, Y, mode = 0;
	public static JButton easy = new JButton("There's no way you can lose this");
	public static JButton hard = new JButton("There is no way you can win this");
	public static JLabel pacman_right = new JLabel(new ImageIcon("images/pacman_right.gif")); 
	public static JLabel pacman_left = new JLabel(new ImageIcon("images/pacman_left.gif")); 
	public static JLabel pacman_up = new JLabel(new ImageIcon("images/pacman_up.gif")); 
	public static JLabel pacman_down = new JLabel(new ImageIcon("images/pacman_down.gif")); 
	public static boolean gameOver = false;
	public static JLabel topBorder1 = new JLabel(new ImageIcon("images/horizontalBorder.png"));
	public static JLabel bottomBorder1 = new JLabel(new ImageIcon("images/horizontalBorder.png")); 
	public static JLabel sideBorder1 = new JLabel(new ImageIcon("images/verticalBorder.png")); 
	public static JLabel sideBorder2 = new JLabel(new ImageIcon("images/verticalBorder.png")); 
	//public static JLabel p1, p2, p3, p4, p5 = new JLabel(new ImageIcon("images/pellet.png"));
	static ArrayList<JLabel> pellets = new ArrayList<JLabel>();

	public static void main(String args[])
	{
		makeHomePage();
	}
	
	public static void makeHomePage()
	{
		//Sets up the basic attributes of the home page
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setSize(1000,700);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.add(panel);
		//frame.setFocusable(true);
		panel.setBackground(Color.BLACK);
		panel.setLayout(null);
		
		//Adds the text prompting name input
		nameLabel = new JLabel("Enter your name and select a game mode:"); 
		nameLabel.setBounds(310,150,500,50); 
		nameLabel.setFont(new Font("", Font.PLAIN, 20)); 
		nameLabel.setForeground(Color.RED); 
		panel.add(nameLabel);
		
		panel.add(easy);
		easy.setBounds(150, 280,450,50);
		easy.setVisible(true);
		easy.setFont(new Font("", Font.PLAIN, 25));
		
		//Adds text field to input name 
		nameText = new JTextField("");
		panel.add(nameText);
		nameText.setBounds(420,200,200,30);
		 
		//Adds big Pac-Man game name
		PacManLabel = new JLabel("Pac-Man");
		panel.add(PacManLabel);
		PacManLabel.setBounds(354,20,400,60); 
		PacManLabel.setFont(new Font("", Font.BOLD, 70)); 
		PacManLabel.setForeground(Color.YELLOW); 
		
		//Added EASY mode
		panel.add(easy);
		easy.setBounds(300, 280,450,50);
		easy.setVisible(true);
		easy.setFont(new Font("", Font.PLAIN, 25));
		easy.addActionListener(new ActionListener() 
		{ 
			public void actionPerformed(ActionEvent e) 
			{ 
				mode = 0;
				easy.setVisible(false);
				hard.setVisible(false);
				panel.add(startButton);
				startButton.setBounds(270,300,500,115); 
				startButton.setVisible(true);    
			} 
		} ); 
		
		//Added HARD mode
		
		panel.add(hard);
		hard.setBounds(300, 380,450,50);
		hard.setVisible(true);
		hard.setFont(new Font("", Font.PLAIN, 25));
		hard.addActionListener(new ActionListener() 
		{ 
			public void actionPerformed(ActionEvent e) 
			{ 
				mode = 1;
				easy.setVisible(false);
				hard.setVisible(false);
				panel.add(startButton);
				startButton.setBounds(270,300,500,115); 
				startButton.setVisible(true);    
			} 
		} ); 
		
		startButton.addActionListener(new ActionListener() 
		{ 
			public void actionPerformed(ActionEvent s) 
			{ 
				startButton.setVisible(false);  
				nameText.setVisible(false);
				nameLabel.setVisible(false);
				PacManLabel.setVisible(false);
				makeMap(mode);
			} 
		} ); 
	}
	public static void makeMap(int mode)
	{
		//Outputs the Welcome name! message
		String s1 = nameText.getText();
		JOptionPane.showMessageDialog(nameText,"Welcome " + s1 + "!", "Pac-Man", 1); 
		
		// Adding maze borders with a loop using Map class objects
		for(int i = 100; i <= 1000; i+=100)
		{
			// Adding a new Map object to the ArrayList and setting to a certain width and height and location
			borders.add(new Map("images/horizontalBorder.png",0,i,100,10));
		}
		for(int i = 100; i <= 1000; i+=100)
		{
			// Adding a new Map object to the ArrayList and setting to a certain width and height and location
			borders.add(new Map("images/horizontalBorder.png",150,i,100,10));
		}
		for(int i = 100; i <= 1000; i+=100)
		{
			// Adding a new Map object to the ArrayList and setting to a certain width and height and location
			borders.add(new Map("images/horizontalBorder.png",360,i,100,10));
		}
		
		borders.add(new Map("images/horizontalBorder.png",150,0,10,600));
		borders.add(new Map("images/horizontalBorder.png",150,700,10,650));
		borders.add(new Map("images/horizontalBorder.png",300,0,10,300));
		borders.add(new Map("images/horizontalBorder.png",300,400,10,350));
		borders.add(new Map("images/horizontalBorder.png",300,850,10,350));
		borders.add(new Map("images/horizontalBorder.png",450,0,10,600));
		borders.add(new Map("images/horizontalBorder.png",450,700,10,650));
		borders.add(new Map("images/horizontalBorder.png",600,0,10,300));
		borders.add(new Map("images/horizontalBorder.png",600,400,10,350));
		borders.add(new Map("images/horizontalBorder.png",600,850,10,350));
		
		//Adding enemies in the board
		
		
		//Side Borders in the map
		
		panel.add(topBorder1);
		topBorder1.setBounds(0,0,1000,10); 
		
		
		panel.add(bottomBorder1);
		bottomBorder1.setBounds(0,653,1000,10); 
		
		
		panel.add(sideBorder1);
		sideBorder1.setBounds(0,0,10,700); 
		
		
		panel.add(sideBorder2);
		sideBorder2.setBounds(990,0,10,700); 
		
		//Adds 4 PacMans facing different directions
		pacman_right.setBounds(150, 90,400,365);
		panel.add(pacman_right); 	
		panel.add(pacman_up); 
		panel.add(pacman_left); 	
		panel.add(pacman_down);
		X = 330; 
		Y = 250;
		
		//Add pellets

		for (int i=0; i < 50; i++)
		{
		pellets.add(new JLabel("images/pellet.png"));
		}
//		p5.setBounds(20, 20, 2, 2);
//		panel.add(p5);
		
		//Add ghosts and their movements
		Enemies enemy = new Enemies();
		if (mode == 0)
			enemy.easyMode(); 
		else if (mode == 1)
			enemy.hardMode();
		
		frame.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				if(arg0.getKeyCode() == KeyEvent.VK_RIGHT && !gameOver)
				{
					pacman_right.setVisible(true);
					pacman_left.setVisible(false);
					pacman_up.setVisible(false);
					pacman_down.setVisible(false);
					
					if(X >= 948)
					{
						X = 948;
					}
					else
					{
						X += 5;
					}
					pacman_right.setBounds( X, Y, 42, 42); 
				}
				if(arg0.getKeyCode() == KeyEvent.VK_LEFT && !gameOver)
				{
					pacman_right.setVisible(false);
					pacman_left.setVisible(true);
					pacman_up.setVisible(false);
					pacman_down.setVisible(false);
					
					if(X <= 10)
					{
						X = 10;
					}
					else
					{
						X -= 5;
					}
					pacman_left.setBounds(X, Y, 42, 42); 
				}
				if(arg0.getKeyCode() == KeyEvent.VK_UP && !gameOver)
				{
					pacman_right.setVisible(false);
					pacman_left.setVisible(false);
					pacman_up.setVisible(true);
					pacman_down.setVisible(false);
					
					if(Y <= 10)
					{
						Y = 10;
					}
					else if(((Y > 118 && Y - 5 <= 158) && !(X >= 610 && X <= 660 )) || ((Y > 268 && Y - 5 <= 308) && !((X >= 310 && X <= 360) || (X >= 760 && X <= 810))) || ((Y > 455 && Y - 5 <= 455) && !((X >= 610 && X <= 660))) || ((Y > 610 && Y - 5 <= 610) && !((X >= 310 && X <= 360) || (X >= 760 && X <= 810))))
					{
						Y -= 0;
					}
					else
					{
						Y -= 5;
					}
					pacman_up.setBounds(X, Y, 42, 42); 
				}
				if(arg0.getKeyCode() == KeyEvent.VK_DOWN && !gameOver)
				{
					pacman_right.setVisible(false);
					pacman_left.setVisible(false);
					pacman_up.setVisible(false);
					pacman_down.setVisible(true);
					
					if(Y >= 611)
					{
						Y = 611;
					}
					else if(((Y < 110 && Y + 5 >= 110) && !(X >= 610 && X <= 660 )) || ((Y < 260 && Y + 5 >= 260) && !((X >= 310 && X <= 360) || (X >= 760 && X <= 810))) || ((Y < 560 && Y + 5 >= 560) && !((X >= 310 && X <= 360) || (X >= 760 && X <= 810))) || ((Y < 410 && Y + 5 >= 410) && !(X >= 610 && X <= 660)))
					{
						Y += 0;
					}
					else
					{
						Y += 5;
					}
					pacman_down.setBounds(X, Y, 42, 42); 
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

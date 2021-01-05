import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.util.Timer;
import java.util.TimerTask;

public class Enemies extends Main
{
	private static JLabel red, pink, cyan, orange;
	private static int redX=50, redY=50, pinkX=50, pinkY=400, 
				cyanX=600, cyanY=50, orangeX=600, orangeY=400;
	private static boolean shown = false;
	private static JLabel score = new JLabel("Score = 0");
	private static int score1 = 0;
	public Enemies()
    {
		red = new JLabel(new ImageIcon("images/red.gif"));
		panel.add(red);
		red.setBounds(redX, redY, 30, 42);
		red.setVisible(true);
		
		pink = new JLabel(new ImageIcon("images/pink.gif"));
		panel.add(pink);
		pink.setBounds(pinkX, pinkY, 30, 42);
		pink.setVisible(true);
		
		cyan = new JLabel(new ImageIcon("images/cyan.gif"));
		panel.add(cyan);
		cyan.setBounds(cyanX, cyanY, 30, 42);
		cyan.setVisible(true);
		
		orange = new JLabel(new ImageIcon("images/orange.gif"));
		panel.add(orange);
		orange.setBounds(orangeX, orangeY, 30, 42);
		orange.setVisible(true);	
		
		panel.add(score);
		score.setBounds(420, 600, 100, 60);
		score.setForeground(Color.YELLOW); 
		score.setVisible(true);
    }
	void easyMode()
	{
		Timer t = new Timer();  
		TimerTask tt = new TimerTask() {  
		    @Override  
		    public void run() {  
		        redX = move(redX); 			
		        redY = move(redY); 
				red.setBounds(redX, redY, 30, 42);
				pinkX = move(pinkX); 		
				pinkY = move(pinkY);
		        pink.setBounds(pinkX, pinkY, 30, 42);
		        cyanX = move(cyanX); 		
		        cyanY = move(cyanY);
		        cyan.setBounds(cyanX, cyanY, 30, 42);
		        orangeX = move(orangeX); 	
		        orangeY = move(orangeY);
		        orange.setBounds(orangeX, orangeY, 30, 42);
		    };  
		}; 
	    t.scheduleAtFixedRate( tt, 50, 100);
	}
	void hardMode()
	{
		Timer t = new Timer();  
		TimerTask tt = new TimerTask() {  
		    @Override  
		    public void run() {  
		    	 if((Math.abs(redX - X) <= 15 && Math.abs(redY - Y) <= 15) || (Math.abs(pinkX - X) <= 15 && Math.abs(pinkY - Y) <= 15) || (Math.abs(cyanX - X) <= 15 && Math.abs(cyanY - Y) <= 15) || (Math.abs(orangeX - X) <= 15 && Math.abs(orangeY - Y) <= 15))         
					{
						 gameOver = true;
						 if(!shown)
						 {
							 JOptionPane.showMessageDialog(null, "GAME OVER!");
				    		 shown = true;
				    		 PacManLabel.setVisible(false);
				    		 for(int i = 0; i < borders.size(); i++)
				    		 {
				    			 borders.get(i).border.setVisible(false);
				    		 }
				    		 for(int i = 0; i < pellets.size(); i++)
				    		 {
				    			 pellets.get(i).setVisible(false);
				    		 }
				    		 nameLabel.setVisible(true);
				    		 nameLabel.setText("Game Over");
				    		 nameLabel.setFont(new Font("", Font.PLAIN, 50)); 
				    		 nameLabel.setBounds(400,100,300,100);
				    		 score.setText("TEST");
				    		 pacman_right.setVisible(false);
							 pacman_left.setVisible(false);
							 pacman_up.setVisible(false);
							 pacman_down.setVisible(false);
							 topBorder1.setVisible(false);
							 bottomBorder1.setVisible(false);
							 sideBorder1.setVisible(false);
							 sideBorder2.setVisible(false);
						 }
					}
		    	 else
		    	 {
		        redX = hardMoveX(redX); 			
		        redY = hardMoveY(redY); 
				red.setBounds(redX, redY, 30, 42);
				pinkX = hardMoveX(pinkX); 		
				pinkY = hardMoveY(pinkY);
		        pink.setBounds(pinkX, pinkY, 30, 42);
		        cyanX = hardMoveX(cyanX); 		
		        cyanY = hardMoveY(cyanY);
		        cyan.setBounds(cyanX, cyanY, 30, 42);
		        orangeX = hardMoveX(orangeX); 	
		        orangeY = hardMoveY(orangeY);
		        orange.setBounds(orangeX, orangeY, 30, 42);
		        score1++;
		        score.setText("Score = " + score1);
		    	 }
		    };  
		}; 
	    t.scheduleAtFixedRate( tt, 50, 100);
	}
	
	int move(int coord)
	{
		return (int)  (Math.random() * (100) + 10) % 2 == 0  ?  coord - 10  :  coord + 10;
	}
	
	int hardMoveX(int coord)
	{
		if(coord < X)
		{
			return coord + 2;
		}
		else if(coord > X)
		{
			return coord - 2;
		}
		return coord;
	}
	
	int hardMoveY(int coord)
	{
		if(coord < Y)
		{
			return coord + 2;
		}
		else if(coord > Y)
		{
			return coord - 2;
		}
		return coord;
	}
}

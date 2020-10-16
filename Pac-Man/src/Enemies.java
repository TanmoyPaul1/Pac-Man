import javax.swing.ImageIcon;
import javax.swing.JLabel;

import java.util.Timer;
import java.util.TimerTask;

public class Enemies extends Main
{
	public static JLabel red, pink, cyan, orange;
	public static int redX=280, redY=200, pinkX=310, pinkY=200, 
				cyanX=340, cyanY=200, orangeX=370, orangeY=200;
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
		
		Timer t = new Timer();  
		TimerTask tt = new TimerTask() {  
		    @Override  
		    public void run() {  
		        move(red, redX, redY);
		        move(pink, pinkX, pinkY);
		        move(cyan, cyanX, cyanY);
		        move(orange, orangeX, orangeY);
		    };  
		}; 
	    t.scheduleAtFixedRate( tt, 50, 100);
	    

    }
	static void move(JLabel enemy, int startX, int startY)
	{
	    if(getRandomNumber() == 1)
	    {
	    	//startX -= 5;
	    	enemy.setBounds(startX, startY, 50, 30);
	    }
	    else if(getRandomNumber() == 2)
	    {
	    	//startX += 5;
	    	enemy.setBounds(startX, startY, 50, 30);
	    }
	    else if(getRandomNumber() == 3)
	    {
	    	//startY -= 5;
	    	enemy.setBounds(startX, startY, 50, 30);
	    }
	    else if(getRandomNumber() == 4)
	    {
	    	startY = startY + 5;
	    	enemy.setBounds(startX, startY, 50, 30);
	    }
	}
	static int getRandomNumber() {
	    return (int) ((Math.random() * (4 - 1)) + 1);
	}
}

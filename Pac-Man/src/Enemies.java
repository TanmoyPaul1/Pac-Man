import javax.swing.ImageIcon;
import javax.swing.JLabel;

import java.util.Timer;
import java.util.TimerTask;

public class Enemies extends Main
{
	private static JLabel red, pink, cyan, orange;
	private static int redX=280, redY=200, pinkX=310, pinkY=200, 
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
    }
	void start()
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
	int move(int coord)
	{
	    if( (int) ((Math.random() * (100)) + 10) % 2 == 0)
	    {
	    	return coord - 5;
	    }
	    else if( (int) ((Math.random() * (100)) + 10) % 2 == 1)
	    {
	    	return coord + 5;
	    }
	    return coord;
	}
}

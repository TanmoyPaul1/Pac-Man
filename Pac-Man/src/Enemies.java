import javax.swing.ImageIcon;
import javax.swing.JLabel;

import java.util.Timer;
import java.util.TimerTask;

public class Enemies extends Main
{
	private static JLabel red, pink, cyan, orange;
	private static int redX=50, redY=50, pinkX=50, pinkY=400, 
				cyanX=600, cyanY=50, orangeX=600, orangeY=400;
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
//	void easyMode()
//	{
//		Timer t = new Timer();  
//		TimerTask tt = new TimerTask() {  
//		    @Override  
//		    public void run() {  
//		        redX = move(redX); 			
//		        redY = move(redY); 
//				red.setBounds(redX, redY, 30, 42);
//				pinkX = move(pinkX); 		
//				pinkY = move(pinkY);
//		        pink.setBounds(pinkX, pinkY, 30, 42);
//		        cyanX = move(cyanX); 		
//		        cyanY = move(cyanY);
//		        cyan.setBounds(cyanX, cyanY, 30, 42);
//		        orangeX = move(orangeX); 	
//		        orangeY = move(orangeY);
//		        orange.setBounds(orangeX, orangeY, 30, 42);
//		    };  
//		}; 
//	    t.scheduleAtFixedRate( tt, 50, 100);
//	}
	void hardMode()
	{
		Timer t = new Timer();  
		TimerTask tt = new TimerTask() {  
		    @Override  
		    public void run() {  
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
		        
		    };  
		}; 
	    t.scheduleAtFixedRate( tt, 50, 100);
	}
	void random()
	{
		Timer t = new Timer();  
		TimerTask tt = new TimerTask() {  
		    @Override  
		    public void run() {  
		        redX = randomMove(redX); 			
		        redY = randomMove(redY); 
				red.setBounds(redX, redY, 30, 42);
				pinkX = randomMove(pinkX); 		
				pinkY = randomMove(pinkY);
		        pink.setBounds(pinkX, pinkY, 30, 42);
		        cyanX = randomMove(cyanX); 		
		        cyanY = randomMove(cyanY);
		        cyan.setBounds(cyanX, cyanY, 30, 42);
		        orangeX = randomMove(orangeX); 	
		        orangeY = randomMove(orangeY);
		        orange.setBounds(orangeX, orangeY, 30, 42);
		    };  
		}; 
	    t.scheduleAtFixedRate( tt, 50, 100);
	}
	
	int randomMove(int coord)
	{
		return (int)  (Math.random() * (100) + 10) % 2 == 0  ?  coord - 5  :  coord + 5;
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

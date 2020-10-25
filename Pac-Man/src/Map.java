import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Map extends Main {
	// Constructor for the Map class
	int x;
	int y;
	public Map(String path, int y, int x, int height, int width)
	{
		JLabel border = new JLabel(new ImageIcon(path)); 
		panel.add(border);
		border.setBounds(x, y, width, height);
		border.setVisible(true);
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
}

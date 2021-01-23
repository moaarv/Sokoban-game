package Project;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Window extends JFrame {
	public JFrame frame;
	
	public Window(){
		frame = new JFrame("Logic Puzzle Games");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setLayout(null);
	    Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
	    frame.setSize(1100,screensize.height);
	    frame.getContentPane().setBackground(Color.PINK);
	    ImageIcon icon = new ImageIcon("sokoban_icons/icon.png");
	    frame.setIconImage(icon.getImage());
	    frame.setVisible(true);
	    
	}
}

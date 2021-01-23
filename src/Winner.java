package Project;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Winner {
	
	/**
	 * Creates a pop-up frame with a text for the winner
	 */
	public Winner(){
		JFrame parent = new JFrame();
		JOptionPane.showMessageDialog(parent,
			    "Congratulations, you are a winner!",
			    "Winner Winner chicken dinner",
			    JOptionPane.PLAIN_MESSAGE);
	}
}

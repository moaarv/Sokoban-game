package Project;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public abstract class IMenu implements ActionListener{
	/**
	 * 
	 * @param takes in a parameter text that is going to be the header text.
	 * @return a JLabel with the header text on
	 * @precondition text != null
	 */
	public abstract JLabel header(String text);
	
	/**
	 * 
	 * @param name is the name or are the names of the creators
	 * @return a JLabel with the creators name on it
	 * @precondition name != null
	 * @postcondition created JLable != null
	 */
	public abstract JLabel createBy(String [] name);
	
	/**
	 * Does what is wanted when the start button is pressed
	 */
	public abstract void startButtonPressed();
	
	/**
	 * 
	 * @return a JButton that is the start button for the game
	 */
	public JButton startButton() {
		JButton start = new JButton("Start Game");
		start.addActionListener(this);
		start.setBounds(400, 300, 300, 50);
		start.setFont(new Font("Arial",Font.PLAIN,40));
		return start;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		startButtonPressed();
	}
}

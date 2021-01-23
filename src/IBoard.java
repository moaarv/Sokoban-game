package Project;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public abstract class IBoard implements ActionListener{
	/**
	 * Paints the board to the specific game
	 */
	public abstract void paint();
	
	/**
	 * Resets the board to how it was painted in the beginning
	 */
	public abstract void reset();
	
	/**
	 * creates a restart button that is used to reset the board
	 * @param sends in a restart that is a JButton 
	 * @return a created JButton with an added actionlistener
	 */
	public JButton restartButton(JButton restart) {
		restart = new JButton("Restart Game");
		restart.addActionListener(this);
		restart.setBounds(20, 20, 300, 50);
		restart.setFont(new Font("Arial",Font.PLAIN,30));
		return restart;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		reset();
		
	}

}

package Project;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public abstract class IPlayer implements KeyListener{
	/**
	 * 
	 * @param x is a coordinate for a specified place
	 * @param y is a coordinate for a specified place
	 * @param bx is a coordinate for another specified place
	 * @param byis a coordinate for another specified place
	 * @return true if it made a move
	 * @precondition bx != x, by != y
	 */
	public abstract boolean move(int x, int y, int bx, int by);
	
	/**
	 * 
	 * @return true if the player has made everything to win a game
	 */
	public abstract boolean evaluate();
	
	/**
	 * 
	 * @param x coordinate for the planned move
	 * @param y coordinate for the planned move
	 * @return true if it can make a move
	 */
	public abstract boolean checkMove(int x, int y);

	/**
	 * Does what is needed when the up-button is pressed on the keyboard
	 */
	public abstract void upButtonPressed();
	
	/**
	 * Does what is needed when the down-button is pressed on the keyboard
	 */
	public abstract void downButtonPressed();
	
	/**
	 * Does what is needed when the left-button is pressed on the keyboard
	 */
	public abstract void leftButtonPressed();
	
	/**
	 * Does what is needed when the right-button is pressed on the keyboard
	 */
	public abstract void rightButtonPressed();
	
	@Override
	public void keyPressed(KeyEvent event) {
		if (event.getKeyCode() == KeyEvent.VK_LEFT) {
			leftButtonPressed();
		}
		else if(event.getKeyCode() == KeyEvent.VK_DOWN) {
			downButtonPressed();
		}
		else if(event.getKeyCode() == KeyEvent.VK_RIGHT) {
			rightButtonPressed();
		}
		else if(event.getKeyCode() == KeyEvent.VK_UP) {
			upButtonPressed();
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent event) {
		
	}
}

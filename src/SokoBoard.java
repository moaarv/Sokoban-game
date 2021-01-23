package Project;

import java.awt.Container;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class SokoBoard extends IBoard{
	
	public int startValueX = 250;
	public int startValueY = 150;
	Window win = new Window();
	JButton restart;
	
	public SokoBoard() {
		win.frame.add(restartButton(restart));
		paint();	
	}
	/**
	 * Paints the board to the specific game
	 */
	@Override
	public void paint() {
		int x = startValueX;
		int y = startValueY;
		int box = 32;
		for(int i=0;i<400;i++) {	
			if((x == startValueX || x == startValueX+box*19)&&(y<startValueY+box*9 || y> startValueY) 
					|| (x> startValueX +12*box && x< startValueX + 15*box) && (y<startValueY + box *6 && y>startValueY )
					||(y == startValueY || y == startValueY+box*19)
					||(y == startValueY + box*9 && (x> startValueX + box*5 && x<startValueX + box*11))
					||(x == startValueX + box*10 && (y>startValueY+box*9 && y <startValueY+box*13))
					||((y==startValueY+box*11 
					|| y ==startValueY +box*13) && (x<startValueX+box*20 && x>startValueX+box*15))) {
				ImageIcon ii = new ImageIcon("sokoban_icons/wall.png");
				JLabel l = new JLabel(ii);
				l.setBounds(x, y, box, box);
				win.frame.add(l);
			}
			else if(x==startValueX + box && y == startValueY +box) {
				ImageIcon ii = new ImageIcon("sokoban_icons/player.png");
				JLabel l = new JLabel(ii);
				l.setBounds(x, y, box, box);
				win.frame.add(l);
			}
			else if((y == startValueY +box && (x==startValueX + box*15 || x == startValueX + box*18))
					||(y==startValueY+box*12 &&(x==startValueX+box*17 || x==startValueX+box*18))) {
				ImageIcon ii = new ImageIcon("sokoban_icons/blankmarked.png");
				JLabel l = new JLabel(ii);
				l.setBounds(x, y, box, box);
				win.frame.add(l);
			}
			else if((x==startValueX+box*10 && y==startValueY+box*3)||(y==startValueY+box*11 && (x==startValueX+box*6 
					|| x==startValueX+box*8))||(x==startValueX +box*5 && y ==startValueY+box*4)) {
				ImageIcon ii = new ImageIcon("sokoban_icons/crate.png");
				JLabel l = new JLabel(ii);
				l.setBounds(x, y, box, box);
				win.frame.add(l);
			}
			
			else {
				ImageIcon ii = new ImageIcon("sokoban_icons/blank.png");
				JLabel l = new JLabel(ii);
				l.setBounds(x, y, box, box);
				win.frame.add(l);
			}
			
			if(x >= startValueX+box*19) {
				x = startValueX;
				y = y +box;
			}
			else {
				x = x + box;
			}
			
		}
		win.frame.validate();
		win.frame.repaint();
		
	}
	/**
	 * Resets the board
	 */
	@Override
	public void reset() {
		win.frame.dispose();
		new SokoPlayer();
	}



}

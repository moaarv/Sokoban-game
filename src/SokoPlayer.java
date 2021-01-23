package Project;
import java.awt.Component;
import java.awt.Container;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SokoPlayer extends IPlayer {
	
	public int startX=250;
	public int startY=150;
	public int currX=282;
	public int currY=182;
	public int box=32;
	public int box1=0;
	public int box2=0;
	public int box3=0;
	public int box4=0;
	public int box1x=startX+box*5;
	public int box2x=startX+box*10;
	public int box3x=startX+box*6;
	public int box4x=startX+box*8;
	public int box1y=startY+box*4;
	public int box2y=startY+box*3;
	public int box3y=startY+box*11;
	public int box4y=startY+box*11;
	SokoBoard sb = new SokoBoard();
	JFrame sbFrame = sb.win.frame;
	Container cPane = sbFrame.getContentPane();
	JButton restart;

	public SokoPlayer() {
		cPane.addKeyListener(this);
		cPane.setFocusable(true);
	}

	@Override
	public boolean move(int x, int y, int bx, int by) {
		if((x == box1x && y == box1y)||(x==box2x && y==box2y)||(x==box3x && y==box3y)||(x==box4x && y==box4y)) {
			if(checkMove(bx,by)) {
				if((bx == box1x && by == box1y)||(bx==box2x && by==box2y)||(bx==box3x && by==box3y)||(bx==box4x && by==box4y)) {
					return false;
				}
				else {
					Component i=cPane.getComponentAt(bx, by);
					cPane.remove(i);
					JLabel l = new JLabel(new ImageIcon("sokoban_icons/crate.png"));
					l.setBounds(bx, by, box, box);
					cPane.add(l);
					if(x == box1x && y == box1y) {
						box1x=bx;
						box1y=by;
					}
					else if(x==box2x && y==box2y) {
						box2x=bx;
						box2y=by;
					}
					else if(x==box3x && y==box3y) {
						box3x=bx;
						box3y=by;
					}
					else if(x==box4x && y==box4y){
						box4x=bx;
						box4y=by;
					}
					Component k=cPane.getComponentAt(x, y);
					cPane.remove(k);
					JLabel l2 = new JLabel(new ImageIcon("sokoban_icons/player.png"));
					l2.setBounds(x, y, box, box);
					cPane.add(l2);
					cPane.validate();
					cPane.repaint();
					evaluate();
					return true;
				}
			}
			return false;
		}
		else {
			Component j=cPane.getComponentAt(x, y);
			cPane.remove(j);
			JLabel l = new JLabel(new ImageIcon("sokoban_icons/player.png"));
			l.setBounds(x, y, box, box);
			cPane.add(l);
			cPane.validate();
			cPane.repaint();
			return true;
		}
	}
	@Override
	public boolean evaluate() {
		if(box1x == startX+(box*15)&&box1y == startY+(box*1)|| box2x == startX+(box*15)&&box2y == startY+(box*1)|| box3x == startX+(box*15)&&box3y == startY+(box*1)||box4x == startX+(box*15)&&box4y == startY+(box*1)){
			box1=1;
			Component ii=cPane.getComponentAt(startX+box*15,startY+ box*1);
			cPane.remove(ii);
			JLabel le = new JLabel(new ImageIcon("sokoban_icons/cratemarked.png"));
			le.setBounds(startX+box*15, startY+box*1, box, box);
			cPane.add(le);
			cPane.validate();
			cPane.repaint();			
		}
		else{
			box1=0;
		}
		if(box1x == startX+(box*18)&&box1y == startY+(box*1)|| box2x == startX+(box*18)&&box2y == startY+(box*1)|| box3x == startX+(box*18)&&box3y == startY+(box*1)||box4x == startX+(box*18)&&box4y == startY+(box*1)){
			box2=1;
			Component ii=cPane.getComponentAt(startX+box*18,startY+ box*1);
			cPane.remove(ii);
			JLabel le = new JLabel(new ImageIcon("sokoban_icons/cratemarked.png"));
			le.setBounds(startX+box*18, startY+box*1, box, box);
			cPane.add(le);
			cPane.validate();
			cPane.repaint();	
		}
		else{
			box2=0;
		}
		if(box1x == startX+(box*17)&&box1y == startY+(box*12)|| box2x == startX+(box*17)&&box2y == startY+(box*12)|| box3x == startX+(box*17)&&box3y == startY+(box*12)||box4x == startX+(box*17)&&box4y == startY+(box*12)){
			box3=1;
			Component ii=cPane.getComponentAt(startX+box*17,startY+ box*12);
			cPane.remove(ii);
			JLabel le = new JLabel(new ImageIcon("sokoban_icons/cratemarked.png"));
			le.setBounds(startX+box*17, startY+box*12, box, box);
			cPane.add(le);
			cPane.validate();
			cPane.repaint();
		}
		else{
			box3=0;
		}
		if(box1x == startX+(box*18)&&box1y == startY+(box*12)|| box2x == startX+(box*18)&&box2y == startY+(box*12)|| box3x == startX+(box*18)&&box3y == startY+(box*12)||box4x == startX+(box*18)&&box4y == startY+(box*12)){
			box4=1;
			Component ii=cPane.getComponentAt(startX+box*18,startY+box*12);
			cPane.remove(ii);
			JLabel le = new JLabel(new ImageIcon("sokoban_icons/cratemarked.png"));
			le.setBounds(startX+box*18, startY+box*12, box, box);
			cPane.add(le);
			cPane.validate();
			cPane.repaint();
		}
		else{
			box4=0;
		}
		if(box1==1&&box2==1&&box3==1&&box4==1){
			new Winner();
			return true;
		}
		return false;
	}
	
	@Override
	public boolean checkMove(int x, int y) {
		if(x < 282) { 
			return false;
		}
		else if(x > startX+(box*18)){
			return false;
		}
		else if(y > startY+(box*18)){
			return false;
		}
		else if(y < 182){
			return false;
		}
		else if(x > startX+(box*12) && x < startX+(box*15) && y < startY+(box*6)){
			return false;			
		}
		else if(x > startX+(box*5) && x < startX+(box*11)&& y == startY+(box*9)){
			return false;			
		}
		else if(x == startX+(box*10) && y > startY+(box*9) && y < startY+(box*13) ){
			return false;			
		}
		else if(x > startX+(box*15) && y == startY+(box*13)){
			return false;
		}
		else if(x > startX+(box*15) && y == startY+(box*11)){
			return false;
		}		
		return true;		
	}


	@Override
	public void upButtonPressed() {
		if(checkMove(currX,currY-32) == true){
			if(move(currX,currY-32,currX,currY-64)==true) {
				if((currX == startX+box*15 && currY ==startY+box)||(currX == startX+box*18 && currY ==startY+box)||(currX == startX+box*17 && currY ==startY+box*12)||(currX == startX+box*18 && currY ==startY+box*12)) {
					Component i=cPane.getComponentAt(currX, currY);
					cPane.remove(i);
					JLabel l = new JLabel(new ImageIcon("sokoban_icons/blankmarked.png"));
					l.setBounds(currX, currY, box, box);
					cPane.add(l);
					currY = currY-32;
				}
				else {
					Component i=cPane.getComponentAt(currX, currY);
					cPane.remove(i);
					JLabel l = new JLabel(new ImageIcon("sokoban_icons/blank.png"));
					l.setBounds(currX, currY, box, box);
					cPane.add(l);
					currY = currY-32;
				}
			}
		}
		cPane.validate();
		cPane.repaint();
	}

	@Override
	public void downButtonPressed() {
		System.out.println("hej");
		if(checkMove(currX,currY+32) == true){
			if(move(currX,currY+32, currX,currY+64)==true) {
				if((currX == startX+box*15 && currY ==startY+box)||(currX == startX+box*18 && currY ==startY+box)||(currX == startX+box*17 && currY ==startY+box*12)||(currX == startX+box*18 && currY ==startY+box*12)) {
					Component i=cPane.getComponentAt(currX, currY);
					cPane.remove(i);
					JLabel l = new JLabel(new ImageIcon("sokoban_icons/blankmarked.png"));
					l.setBounds(currX, currY, box, box);
					cPane.add(l);
					currY = currY+32;
				}
				else {
					Component i=cPane.getComponentAt(currX, currY);
					cPane.remove(i);
					JLabel l = new JLabel(new ImageIcon("sokoban_icons/blank.png"));
					l.setBounds(currX, currY, box, box);
					cPane.add(l);
					currY = currY+32;
				}
			}
		}
		cPane.validate();
		cPane.repaint();
	}
	@Override
	public void leftButtonPressed() {
		if(checkMove(currX-32,currY) == true ){
			if(move(currX-32,currY, currX-64,currY)==true){
				if((currX == startX+box*15 && currY ==startY+box)||(currX == startX+box*18 && currY ==startY+box)||(currX == startX+box*17 && currY ==startY+box*12)||(currX == startX+box*18 && currY ==startY+box*12)) {
					Component i=cPane.getComponentAt(currX, currY);
					cPane.remove(i);
					JLabel l = new JLabel(new ImageIcon("sokoban_icons/blankmarked.png"));
					l.setBounds(currX, currY, box, box);
					cPane.add(l);
					currX = currX-32;
				}
				else {
					Component i=cPane.getComponentAt(currX, currY);
					cPane.remove(i);
					JLabel l = new JLabel(new ImageIcon("sokoban_icons/blank.png"));
					l.setBounds(currX, currY, box, box);
					cPane.add(l);
					currX = currX-32;
				}
			}
		}
		cPane.validate();
		cPane.repaint();
	}

	@Override
	public void rightButtonPressed() {
		if(checkMove(currX+32,currY) == true){
			if(move(currX+32,currY,currX+64,currY)==true) {
				if((currX == startX+box*15 && currY ==startY+box)||(currX == startX+box*18 && currY ==startY+box)||(currX == startX+box*17 && currY ==startY+box*12)||(currX == startX+box*18 && currY ==startY+box*12)) {
					Component i=cPane.getComponentAt(currX, currY);
					cPane.remove(i);
					JLabel l = new JLabel(new ImageIcon("sokoban_icons/blankmarked.png"));
					l.setBounds(currX, currY, box, box);
					cPane.add(l);
					currX = currX+32;
				}
				else {
					Component i=cPane.getComponentAt(currX, currY);
					cPane.remove(i);
					JLabel l = new JLabel(new ImageIcon("sokoban_icons/blank.png"));
					l.setBounds(currX, currY, box, box);
					cPane.add(l);
					currX = currX+32;
				}
			}
		}
		cPane.validate();
		cPane.repaint();
	}	
}

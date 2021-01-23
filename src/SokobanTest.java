package Project;

import static org.junit.Assert.*;
import org.junit.Test;

public class SokobanTest {
	SokoPlayer play = new SokoPlayer();
	int box=32;
	public int startX=250;
	public int startY=150;
			

	@Test
	public void checkMovetest() {
		assertFalse(play.checkMove(281, 183)); //checks all the limits and obstacles for the board
		assertFalse(play.checkMove(startX+(box*19), 183));
		assertFalse(play.checkMove(startX+(box*18), startY+(box*19)));
		assertFalse(play.checkMove(startX+(box*13), startY+(box*5)));
		assertFalse(play.checkMove(startX+(box*6), startY+(box*9)));
		assertFalse(play.checkMove(startX+(box*10), startY+(box*12)));
		assertFalse(play.checkMove(startX+(box*16), startY+(box*13)));
		assertFalse(play.checkMove(startX+(box*16), startY+(box*11)));
		
		assertTrue(play.checkMove(283, 183));
	}


	

}

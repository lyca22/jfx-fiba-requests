package model;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FIBARequestsTest {

	FIBARequests fib; 
	
	@BeforeEach
	void FIBASC1() throws Exception {
		fib = new FIBARequests();
	}
	
	@BeforeEach
	void FIBASC2() throws Exception {
		fib = new FIBARequests();
		Player p = new Player("Juancarie", 23, "NOCHU", 5.5, 4.3, 2.8, 7.5, 6);
		fib.addPlayer(p);
		
	}

	@Test
	void testAddPlayer() throws Exception {
		System.out.println("ddgfg");
		FIBASC1();
		Player p = new Player("Jose", 34, "MECHU", 6,3,5,8,9);
		fib.addPlayer(p);
		
		assertTrue(fib.getAverageScoreTree().getRoot().getSearchParameter()==6);
		assertTrue(fib.getAverageAssistsTree().getRoot().getSearchParameter()==3);
		assertTrue(fib.getAverageBlocksTree().getRoot().getSearchParameter()==5);
		assertTrue(fib.getAverageStealsTree().getRoot().getSearchParameter()==8);
		assertTrue(fib.getAverageBouncesTree().getRoot().getSearchParameter()==9);
		
		FIBASC2();
		Player p2 = new Player("Jose", 34, "MECHU", 6,3,5,8,9);
		fib.addPlayer(p2);
		
		assertTrue(fib.getPlayerList().size()==2);
		assertTrue(fib.getAverageScoreTree().getRoot().getRight() != null);
		assertTrue(fib.getAverageScoreTree().getRoot().getRight().getSearchParameter() == 6);
		
		assertTrue(fib.getAverageAssistsTree().getRoot().getLeft() != null);
		assertTrue(fib.getAverageBlocksTree().getRoot().getRight() != null);
		assertTrue(fib.getAverageStealsTree().getRoot().getRight() != null);
		assertTrue(fib.getAverageBouncesTree().getRoot().getRight() != null);
	}
}

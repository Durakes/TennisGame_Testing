import static org.junit.Assert.*;

import org.junit.Test;

public class TennisGameTest {
	
// Here is the format of the scores: "player1Score - player2Score"
// "love - love"
// "15 - 15"
// "30 - 30"
// "deuce"
// "15 - love", "love - 15"
// "30 - love", "love - 30"
// "40 - love", "love - 40"
// "30 - 15", "15 - 30"
// "40 - 15", "15 - 40"
// "player1 has advantage"
// "player2 has advantage"
// "player1 wins"
// "player2 wins"
	@Test
	public void testTennisGame_Start() {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Initial score incorrect", "love - love", score);		
	}

	@Test
	public void testTennisGame_Player1AndPlayer2_Tied15() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		
		game.player2Scored();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Not equal 15 to 15", "15 - 15", score);		
	}

	@Test
	public void testTennisGame_Player1AndPlayer2_Tied30() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		
		game.player2Scored();
		game.player2Scored();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Not equal 30 to 30", "30 - 30", score);		
	}

	@Test
	public void testTennisGame_Player1_15AndPlayer2_love() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Not equal 15 to love", "15 - love", score);		
	}

	@Test
	public void testTennisGame_Player1_loveAndPlayer2_15() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player2Scored();
		
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Not equal love to 15", "love - 15", score);		
	}

	@Test
	public void testTennisGame_Player1_30AndPlayer2_love() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Not equal 30 to love", "30 - love", score);		
	}

	@Test
	public void testTennisGame_Player1_loveAndPlayer2_30() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player2Scored();
		game.player2Scored();
		
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Not equal love to 30", "love - 30", score);		
	}

	@Test
	public void testTennisGame_Player1_40AndPlayer2_love() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Not equal 40 to love", "40 - love", score);		
	}

	@Test
	public void testTennisGame_Player1_loveAndPlayer2_40() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Not equal love to 40", "love - 40", score);		
	}

	@Test
	public void testTennisGame_Player1_30AndPlayer2_15() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		
		game.player2Scored();
		
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Not equal 30 to 15", "30 - 15", score);		
	}

	@Test
	public void testTennisGame_Player1_15AndPlayer2_30() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player2Scored();
		game.player2Scored();

		game.player1Scored();
		
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Not equal 15 to 30", "15 - 30", score);		
	}

	@Test
	public void testTennisGame_Player1_40AndPlayer2_15() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		game.player2Scored();
		
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Not equal 40 to 15", "40 - 15", score);		
	}

	@Test
	public void testTennisGame_Player1_15AndPlayer2_40() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();

		game.player1Scored();
		
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Not equal 15 to 40", "15 - 40", score);		
	}

	@Test
	public void testTennisGame_Player1Advantage() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();

		game.player1Scored();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Winning condition failing", "player1 has advantage", score);		
	}

	@Test
	public void testTennisGame_Player2Advantage() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();

		game.player2Scored();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Winning condition failing", "player2 has advantage", score);		
	}

	@Test
	public void testTennisGame_Player1Wins() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		game.player2Scored();
		game.player2Scored();

		game.player1Scored();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Winning condition failing", "player1 wins", score);		
	}

	@Test
	public void testTennisGame_Player2Wins() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
	
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Tie score incorrect", "player2 wins", score);		
	}
	

	@Test
	public void testTennisGame_EahcPlayerWin4Points_Score_Deuce() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		game.player1Scored();
		game.player2Scored();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Tie score incorrect", "deuce", score);		
	}
	
	@Test
	public void testTennisGame_Player1WinsPointAfterGameEnded_ResultsException() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		//Act
		// This statement should cause an exception
		assertThrows(TennisGameException.class, () -> {game.player1Scored();});
	}

	@Test
	public void testTennisGame_Player2WinsPointAfterGameEnded_ResultsException() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		//Act
		// This statement should cause an exception
		assertThrows(TennisGameException.class, () -> {game.player2Scored();});
	}		
}

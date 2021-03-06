package fr.iutval.labyrinthgame.gameIO;

import fr.iutval.labyrinthgame.GameBoard;
import fr.iutval.labyrinthgame.Tile;
import fr.iutval.labyrinthgame.Treasure;

/**
 * Represents a player input
 * @author Rachid Taghat - Dylan Fayant
 *
 */
public interface PlayerOutput
{
	/**
	 * Make something when the game board changes
	 * @param gameBoard 
	 */
	public void gameBoardUpdate(GameBoard gameBoard);
	
	/**
	 * Make something when the game is over
	 * @param playerIds 
	 * @param string
	 */
	public void gameIsOver(int playerIds);
	
	/**
	 * Make something when the player has changed
	 * @param playerId 
	 * @param freeCard 
	 * @param searchedTreasure
	 */
	public void playerHasChanged(int playerId, Tile freeCard, Treasure searchedTreasure);
}

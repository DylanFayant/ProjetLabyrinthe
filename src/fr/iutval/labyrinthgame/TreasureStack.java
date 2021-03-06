package fr.iutval.labyrinthgame;
import java.util.Arrays;

import fr.iutval.labyrinthgame.exceptions.*;
/**
 * This class represent a stack of treasures.
 * A stack of treasures put in a given order and that can be picked one by one by the top.
 * @author Rachid Taghat - Dylan Fayant
 */

public class TreasureStack {
	/**
	 * default stack size for a player.
	 */
	public final static int DEFAULT_PLAYER_STACK_SIZE = 6;
	
	/**
	 * maximum of treasures in a stack. (the common stack)
	 */
	public final static int MAX_STACK_SIZE = 24;
	
	/**
	 * treasures contained in the stack
	 */
	private Treasure[] treasures;
	
	/**
	 * stack size
	 */
	private int stackSize;
	
	/**
	 * Generates an empty stack (the common stack in the game generation)
	 */
	public TreasureStack()
	{
		this.treasures = new Treasure[TreasureStack.DEFAULT_PLAYER_STACK_SIZE];
		this.stackSize = 0;
	}
	
	/**
	* Generate a deck with a treasures list and the deck size.
	* @param treasures Treasures cards list
	*/
	public TreasureStack(Treasure[] treasures)
	{
		this.treasures = new Treasure[treasures.length];
		this.treasures = treasures;
		this.stackSize = treasures.length;
	}
	
	/**
	 * Picks a treasure and removes it from the stack.
	 * @return Treasures the next treasure in the top of the deck
	 * @throws StackIsEmptyException the deck is empty
	 */
	public Treasure pickTreasure() throws StackIsEmptyException
	{
		if(this.stackSize == 0) throw new StackIsEmptyException();
		this.stackSize--;
		return this.treasures[this.stackSize];
	}
	
	/**
	 * Adds a new treasure card to the deck
	 * @param treasure a treasure card
	 * @throws StackIsFullException the deck is full
	 */
	public void setTreasure(Treasure treasure) throws StackIsFullException
	{
		if(this.stackSize == TreasureStack.DEFAULT_PLAYER_STACK_SIZE) throw new StackIsFullException();
		this.treasures[this.stackSize] = treasure;
		this.stackSize++;
	}

	/**
	 * Shuffles the current deck
	 */
	public void shuffle()
	{
		Treasure temporaryCard;
		for(int i = 0; i < this.stackSize*10; i++)
		{
			int p1 = (int)(Math.random()*this.stackSize);
			int p2 = (int)(Math.random()*this.stackSize);
			temporaryCard = this.treasures[p1];
			this.treasures[p1] = this.treasures[p2];
			this.treasures[p2] = temporaryCard;
		}
	}
	
	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		return "Deck [treasures=" + Arrays.toString(this.treasures) + ", deckSize=" + this.stackSize + "]";
	}
}

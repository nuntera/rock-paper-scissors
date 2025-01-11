package com.mindera.mindswap;

/**
 * Represents a player in the Rock Paper Scissors game
 */
public class Player {
    // The name of the player
    private final String name;

    /**
     * Creates a new player with the specified name
     * @param name The name of the player
     */
    public Player(String name){
        this.name = name;
    }

    /**
     * Gets the name of the player
     * @return The player's name
     */
    public String getName(){
        return name;
    }
}

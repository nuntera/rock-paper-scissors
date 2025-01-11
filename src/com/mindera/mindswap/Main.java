package com.mindera.mindswap;

/**
 * Main class that starts the Rock Paper Scissors game
 */
public class Main {

    /**
     * Entry point of the application
     * Creates two players and starts a new game
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");

        Game game = new Game(player1, player2);
        game.start();
    }
}

package com.mindera.mindswap;

/**
 * Represents a Rock Paper Scissors game between two players
 */
public class Game {
    // Constants for the minimum and maximum values for move generation
    private static final int MIN = 0;
    private static final int MAX = 2;

    // Players of the game
    private final Player player1;
    private final Player player2;

    // Game statistics
    private int roundsCounter;    // Tracks current round number
    private int player1Wins;      // Number of wins for player 1
    private int player2Wins;      // Number of wins for player 2

    /**
     * Constructor initializes a new game with two players
     * @param player1 First player
     * @param player2 Second player
     */
    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        roundsCounter = 0;
        player1Wins = 0;
        player2Wins = 0;
    }

    /**
     * Starts and manages the game flow
     * Game continues until one player reaches 6 wins or 10 rounds are played
     */
    public void start() {
        System.out.println("Game is starting\n");

        // Play rounds until someone wins or max rounds reached
        while (roundsCounter < 10 && player1Wins < 6 && player2Wins < 6) {
            roundsCounter++;
            
            // Randomly decide who plays first in each round
            boolean player1First = RandomGenerator.generate(0, 1) == 0;
            Player firstPlayer = player1First ? player1 : player2;
            Player secondPlayer = player1First ? player2 : player1;
            
            // Generate random moves for both players
            int firstPlayerChoice = RandomGenerator.generate(MIN, MAX);
            int secondPlayerChoice = RandomGenerator.generate(MIN, MAX);

            // Display the moves made by each player
            System.out.println("Round " + roundsCounter);
            System.out.println(firstPlayer.getName() + " throws " + MoveType.getNameById(firstPlayerChoice));
            System.out.println(secondPlayer.getName() + " throws " + MoveType.getNameById(secondPlayerChoice));

            // Determine the winner based on who played first
            Player winner = player1First ? 
                determineRoundWinner(firstPlayerChoice, secondPlayerChoice) :
                determineRoundWinner(secondPlayerChoice, firstPlayerChoice);

            printRoundWinner(winner);
            calculateBestOfTen(winner);
            
            // Print current score after each round
            System.out.println("Score - " + player1.getName() + ": " + player1Wins + 
                             ", " + player2.getName() + ": " + player2Wins + "\n");
        }
        printsGameWinner();
    }

    /**
     * Prints the final winner of the game based on total wins
     */
    private void printsGameWinner() {
        if (player1Wins > player2Wins){
            System.out.println(player1.getName() + " wins with " + player1Wins + " victories.");
        }else System.out.println(player2.getName() + " wins with " + player2Wins + " victories.");
    }

    /**
     * Updates the win counters based on the round winner
     * If it's a tie, neither player gets a point
     * @param winner The player who won the round (null if tie)
     */
    private void calculateBestOfTen(Player winner) {
        if (winner == player1){
            player1Wins++;
        } else if (winner == player2){
            player2Wins++;
        }
    }

    /**
     * Determines the winner of a round based on Rock Paper Scissors rules
     * @param player1Choice The move chosen by player 1
     * @param player2Choice The move chosen by player 2
     * @return The winning player, or null if it's a tie
     */
    private Player determineRoundWinner(int player1Choice, int player2Choice) {
        MoveType move1 = MoveType.getById(player1Choice);
        MoveType move2 = MoveType.getById(player2Choice);
        
        // Check for tie
        if (move1 == move2) {
            return null;
        }
        
        // Determine winner based on Rock Paper Scissors rules
        switch (move1) {
            case ROCK:
                return move2 == MoveType.SCISSORS ? player1 : player2;
            case SCISSORS:
                return move2 == MoveType.PAPER ? player1 : player2;
            case PAPER:
                return move2 == MoveType.ROCK ? player1 : player2;
            default:
                return null;
        }
    }

    /**
     * Prints the result of each round
     * @param winner The player who won the round (null if tie)
     */
    private void printRoundWinner(Player winner) {
        if(winner==null){
            System.out.println("Its a tie\n");
        } else {
            System.out.println("Winner is " + winner.getName() + "\n");
        }
    }
}

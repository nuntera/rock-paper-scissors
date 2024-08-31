package com.mindera.mindswap;

public class Game {
    private static final int MIN = 0;
    private static final int MAX = 2;

    private final Player player1;
    private final Player player2;

    private int roundsCounter;
    private int player1Wins;
    private int player2Wins;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        roundsCounter = 0;
        player1Wins = 0;
        player2Wins = 0;
    }


    public void start() {
        System.out.println("Game is starting\n");

        roundsCounter++;
        while (player1Wins < 6 && player2Wins < 6 && roundsCounter < 10){
            int player1Choice = RandomGenerator.generate(MIN, MAX);
            int player2Choice = RandomGenerator.generate(MIN, MAX);

            System.out.println(player1.getName() + " throws " + MoveType.getNameById(player1Choice));
            System.out.println(player2.getName() + " throws " + MoveType.getNameById(player2Choice));

            Player winner = determineRoundWinner(player1Choice, player2Choice);

            printRoundWinner(winner);

            calculateBestOfTen(winner);
        }
        printsGameWinner();
    }


    private void printsGameWinner() {
        if (player1Wins > player2Wins){
            System.out.println(player1.getName() + " wins with " + player1Wins + " victories.");
        }else System.out.println(player2.getName() + " wins with " + player2Wins + " victories.");
    }

    private void calculateBestOfTen(Player winner) {
        if (winner == player1){
            player1Wins++;
        }else if (winner == player2){
            player2Wins++;
        }else if (winner == null){
            player1Wins++;
            player2Wins++;
        }
    }

    private Player determineRoundWinner(int player1Choice, int player2Choice) {
        if (MoveType.getById(player1Choice) == MoveType.getById(player2Choice)){
            return null;
        }
        switch (MoveType.values()[0]){
            case MoveType.ROCK:
                if (MoveType.getById(player2Choice) == MoveType.SCISSORS){
                    return player1;
                }
                return player2;
            case MoveType.SCISSORS:
                if (MoveType.getById(player2Choice) == MoveType.PAPER){
                    return player1;
                }
                return player2;
            case MoveType.PAPER:
                if (MoveType.getById(player2Choice) == MoveType.ROCK){
                    return player1;
                }
                return player2;
        }
        return null;
    }

    private void printRoundWinner(Player winner) {
        if(winner==null){
            System.out.println("Its a tie\n");
        } else {
            System.out.println("Winner is " + winner.getName() + "\n");
        }
    }
}

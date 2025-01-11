package com.mindera.mindswap;

/**
 * Enum representing the possible moves in Rock Paper Scissors game
 */
public enum MoveType {
    ROCK(0, "Rock"),
    SCISSORS(1, "Scissors"),
    PAPER(2, "Paper");

    // Each move has an ID and a name
    private final int id;
    private final String name;

    /**
     * Constructor for creating a move type
     * @param id Numeric identifier for the move
     * @param name String representation of the move
     */
    MoveType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Gets the name of a move by its ID
     * @param id The ID to look up
     * @return The name of the move, or null if not found
     */
    public static String getNameById(int id) {
        for (MoveType move : values()) {
            if (move.getId() == id) {
                return move.getName();
            }
        }
        return null;
    }

    /**
     * Gets a MoveType enum value by its ID
     * @param id The ID to look up
     * @return The MoveType, or null if not found
     */
    public static MoveType getById(int id) {
        for (MoveType move : values()) {
            if (move.getId() == id) {
                return move;
            }
        }
        return null;
    }

    /**
     * Gets the name of the move
     * @return The move's name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the ID of the move
     * @return The move's ID
     */
    public int getId() {
        return id;
    }
}

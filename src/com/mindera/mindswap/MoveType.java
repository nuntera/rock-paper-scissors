package com.mindera.mindswap;

public enum MoveType {
    ROCK(0, "Rock"),
    SCISSORS(1, "Scissors"),
    PAPER(2, "Paper");

    private final int id;
    private final String name;

    MoveType(int id, String name) {
        this.id = id;
        this.name = name;
    }


    public static String getNameById(int id) {
        for (MoveType move : values()) {
            if (move.getId() == id) {
                return move.getName();
            }
        }
        return null;
    }

    public static MoveType getById(int id) {
        for (MoveType move : values()) {
            if (move.getId() == id) {
                return move;
            }
        }
        return null;
    }


    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}

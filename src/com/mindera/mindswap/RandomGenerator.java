package com.mindera.mindswap;

/**
 * Utility class for generating random numbers
 */
public class RandomGenerator {

    /**
     * Generates a random integer between min and max (inclusive)
     * @param min The minimum value
     * @param max The maximum value
     * @return A random integer between min and max
     */
    public static int generate(int min, int max){
        return (int) (Math.random() * (max - min + 1) + min);
    }
}

package org.codingdojo.yatzy1;

import java.util.Arrays;

public class Yatzy1 {

    private static final int DICE_SIDES = 6;

    // Calculate the sum of all dice
    public static int chance(int... dice) {
        return Arrays.stream(dice).sum();
    }

    // Check for Yatzy (five of a kind)
    public static int yatzy(int... dice) {
        int[] counts = countDice(dice);
        return Arrays.stream(counts).anyMatch(count -> count == 5) ? 50 : 0;
    }

    // Calculate the score for a specific face value
    public static int scoreForValue(int value, int... dice) {
        return (int) Arrays.stream(dice).filter(die -> die == value).count() * value;
    }

    // Calculate the sum of dice showing 1
    public static int ones(int... dice) {
        return scoreForValue(1, dice);
    }

    // Calculate the sum of dice showing 2
    public static int twos(int... dice) {
        return scoreForValue(2, dice);
    }

    // Calculate the sum of dice showing 3
    public static int threes(int... dice) {
        return scoreForValue(3, dice);
    }

    // Calculate the sum of dice showing 4
    public int fours() {
        return scoreForValue(4, dice);
    }

    // Calculate the sum of dice showing 5
    public int fives() {
        return scoreForValue(5, dice);
    }

    // Calculate the sum of dice showing 6
    public int sixes() {
        return scoreForValue(6, dice);
    }

    // Calculate the score for a pair
    public static int scorePair(int... dice) {
        int[] counts = countDice(dice);
        for (int i = DICE_SIDES - 1; i >= 0; i--) {
            if (counts[i] >= 2) {
                return (i + 1) * 2;
            }
        }
        return 0;
    }

    // Calculate the score for two pairs
    public static int twoPair(int... dice) {
        int[] counts = countDice(dice);
        int pairs = 0;
        int score = 0;
        for (int i = DICE_SIDES - 1; i >= 0; i--) {
            if (counts[i] >= 2) {
                pairs++;
                score += (i + 1) * 2;
                if (pairs == 2) {
                    return score;
                }
            }
        }
        return 0;
    }

    // Calculate the score for four of a kind
    public static int fourOfAKind(int... dice) {
        int[] counts = countDice(dice);
        for (int i = 0; i < DICE_SIDES; i++) {
            if (counts[i] >= 4) {
                return (i + 1) * 4;
            }
        }
        return 0;
    }

    // Calculate the score for three of a kind
    public static int threeOfAKind(int... dice) {
        int[] counts = countDice(dice);
        for (int i = 0; i < DICE_SIDES; i++) {
            if (counts[i] >= 3) {
                return (i + 1) * 3;
            }
        }
        return 0;
    }

    // Check for small straight
    public static int smallStraight(int... dice) {
        int[] counts = countDice(dice);
        return (counts[0] == 1 && counts[1] == 1 && counts[2] == 1 && counts[3] == 1 && counts[4] == 1) ? 15 : 0;
    }

    // Check for large straight
    public static int largeStraight(int... dice) {
        int[] counts = countDice(dice);
        return (counts[1] == 1 && counts[2] == 1 && counts[3] == 1 && counts[4] == 1 && counts[5] == 1) ? 20 : 0;
    }

    // Check for full house
    public static int fullHouse(int... dice) {
        int[] counts = countDice(dice);
        boolean hasThreeOfAKind = false;
        boolean hasPair = false;
        int threeValue = 0;
        int pairValue = 0;

        for (int i = 0; i < DICE_SIDES; i++) {
            if (counts[i] == 3) {
                hasThreeOfAKind = true;
                threeValue = i + 1;
            } else if (counts[i] == 2) {
                hasPair = true;
                pairValue = i + 1;
            }
        }

        return (hasThreeOfAKind && hasPair) ? (threeValue * 3 + pairValue * 2) : 0;
    }

    // Helper method to count the occurrences of each dice face
    private static int[] countDice(int... dice) {
        int[] counts = new int[DICE_SIDES];
        for (int die : dice) {
            counts[die - 1]++;
        }
        return counts;
    }

    private int[] dice;

    public Yatzy1() {}

    public Yatzy1(int d1, int d2, int d3, int d4, int d5) {
        dice = new int[]{d1, d2, d3, d4, d5};
    }
}

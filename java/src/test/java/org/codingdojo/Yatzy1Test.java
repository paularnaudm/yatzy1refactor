package org.codingdojo;

import org.codingdojo.yatzy1.Yatzy1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class Yatzy1Test {

    private Yatzy1 yatzy1;

    @BeforeEach
    public void setUp() {
        yatzy1 = new Yatzy1();
    }

    @Test
    public void chance_scores_sum_of_all_dice() {
        assertEquals(15, Yatzy1.chance(2, 3, 4, 5, 1), "Chance score should be the sum of all dice");
        assertEquals(16, Yatzy1.chance(3, 3, 4, 5, 1), "Chance score should be the sum of all dice");
    }

    @Test
    public void yatzy_scores_50() {
        assertEquals(50, Yatzy1.yatzy(4, 4, 4, 4, 4), "Yatzy score should be 50 for all dice the same");
        assertEquals(50, Yatzy1.yatzy(6, 6, 6, 6, 6), "Yatzy score should be 50 for all dice the same");
        assertEquals(0, Yatzy1.yatzy(6, 6, 6, 6, 3), "Yatzy score should be 0 if not all dice are the same");
    }

    @ParameterizedTest
    @CsvSource({
        "1,2,3,4,5, 1",
        "1,2,1,4,5, 2",
        "6,2,2,4,5, 0",
        "1,2,1,1,1, 4"
    })
    public void test_ones(int d1, int d2, int d3, int d4, int d5, int expected) {
        assertEquals(expected, Yatzy1.ones(d1, d2, d3, d4, d5), "Score for ones should match the expected value");
    }

    @ParameterizedTest
    @CsvSource({
        "1,2,3,2,6, 4",
        "2,2,2,2,2, 10"
    })
    public void test_twos(int d1, int d2, int d3, int d4, int d5, int expected) {
        assertEquals(expected, Yatzy1.twos(d1, d2, d3, d4, d5), "Score for twos should match the expected value");
    }

    @ParameterizedTest
    @CsvSource({
        "1,2,3,2,3, 6",
        "2,3,3,3,3, 12"
    })
    public void test_threes(int d1, int d2, int d3, int d4, int d5, int expected) {
        assertEquals(expected, Yatzy1.threes(d1, d2, d3, d4, d5), "Score for threes should match the expected value");
    }

    @Test
    public void fours_test() {
        assertEquals(12, new Yatzy1(4, 4, 4, 5, 5).fours(), "Score for fours should match the expected value");
        assertEquals(8, new Yatzy1(4, 4, 5, 5, 5).fours(), "Score for fours should match the expected value");
        assertEquals(4, new Yatzy1(4, 5, 5, 5, 5).fours(), "Score for fours should match the expected value");
    }

    @Test
    public void fives_test() {
        assertEquals(10, new Yatzy1(4, 4, 4, 5, 5).fives(), "Score for fives should match the expected value");
        assertEquals(15, new Yatzy1(4, 4, 5, 5, 5).fives(), "Score for fives should match the expected value");
        assertEquals(20, new Yatzy1(4, 5, 5, 5, 5).fives(), "Score for fives should match the expected value");
    }

    @Test
    public void sixes_test() {
        assertEquals(0, new Yatzy1(4, 4, 4, 5, 5).sixes(), "Score for sixes should be 0 if no sixes are present");
        assertEquals(6, new Yatzy1(4, 4, 6, 5, 5).sixes(), "Score for sixes should match the expected value");
        assertEquals(18, new Yatzy1(6, 5, 6, 6, 5).sixes(), "Score for sixes should match the expected value");
    }

    @ParameterizedTest
    @CsvSource({
        "3,4,3,5,6, 6",
        "5,3,3,3,5, 10",
        "5,3,6,6,5, 12"
    })
    public void one_pair(int d1, int d2, int d3, int d4, int d5, int expected) {
        assertEquals(expected, Yatzy1.scorePair(d1, d2, d3, d4, d5), "Score for one pair should match the expected value");
    }

    @ParameterizedTest
    @CsvSource({
        "3,3,5,4,5, 16",
        "3,3,5,5,5, 16"
    })
    public void two_pair(int d1, int d2, int d3, int d4, int d5, int expected) {
        assertEquals(expected, Yatzy1.twoPair(d1, d2, d3, d4, d5), "Score for two pair should match the expected value");
    }

    @ParameterizedTest
    @CsvSource({
        "3,3,3,4,5, 9",
        "5,3,5,4,5, 15",
        "3,3,3,3,5, 9"
    })
    public void three_of_a_kind(int d1, int d2, int d3, int d4, int d5, int expected) {
        assertEquals(expected, Yatzy1.threeOfAKind(d1, d2, d3, d4, d5), "Score for three of a kind should match the expected value");
    }

    @ParameterizedTest
    @CsvSource({
        "3,3,3,3,5, 12",
        "5,5,5,4,5, 20",
        "3,3,3,3,3, 12"
    })
    public void four_of_a_kind(int d1, int d2, int d3, int d4, int d5, int expected) {
        assertEquals(expected, Yatzy1.fourOfAKind(d1, d2, d3, d4, d5), "Score for four of a kind should match the expected value");
    }

    @ParameterizedTest
    @CsvSource({
        "1,2,3,4,5, 15",
        "2,3,4,5,1, 15",
        "1,2,2,4,5, 0"
    })
    public void small_straight(int d1, int d2, int d3, int d4, int d5, int expected) {
        assertEquals(expected, Yatzy1.smallStraight(d1, d2, d3, d4, d5), "Score for small straight should match the expected value");
    }

    @ParameterizedTest
    @CsvSource({
        "6,2,3,4,5, 20",
        "2,3,4,5,6, 20",
        "1,2,2,4,5, 0"
    })
    public void large_straight(int d1, int d2, int d3, int d4, int d5, int expected) {
        assertEquals(expected, Yatzy1.largeStraight(d1, d2, d3, d4, d5), "Score for large straight should match the expected value");
    }

    @ParameterizedTest
    @CsvSource({
        "6,2,2,2,6, 18",
        "2,3,4,5,6, 0"
    })
    public void full_house(int d1, int d2, int d3, int d4, int d5, int expected) {
        assertEquals(expected, Yatzy1.fullHouse(d1, d2, d3, d4, d5), "Score for full house should match the expected value");
    }
}


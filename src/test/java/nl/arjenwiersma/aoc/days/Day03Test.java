package nl.arjenwiersma.aoc.days;


import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;

import nl.arjenwiersma.aoc.common.Day;
import nl.arjenwiersma.aoc.common.DayInputExternalResource;

public class Day03Test {
    @Rule
    public DayInputExternalResource input = new DayInputExternalResource(03);

    @Test
    public void part1() {
        Day<Integer> day = new Day03();
        assertEquals(Integer.valueOf(0), day.part1(input.getLines()));
    }

    @Test
    public void part2() {
        Day<Integer> day = new Day03();
        assertEquals(Integer.valueOf(0), day.part2(input.getLines()));
    }
}
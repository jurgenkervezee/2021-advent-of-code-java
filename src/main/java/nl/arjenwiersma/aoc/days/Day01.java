package nl.arjenwiersma.aoc.days;

import java.util.List;

import nl.arjenwiersma.aoc.common.Day;

public class Day01 implements Day<Integer> {

    @Override
    public Integer part1(List<String> input) {
        Integer increaseCounter = 0;
        for(int i=0; i < input.size()-1; i++){

            int a = Integer.parseInt(input.get(i));
            int b = Integer.parseInt(input.get(i+1));

            if (a < b ){
                increaseCounter++;
            }
        }
        return increaseCounter;
    }

    @Override
    public Integer part2(List<String> input) {
        Integer increaseCounter = 0;

        for(int i=0; i < input.size()-3; i++){

            int a = Integer.parseInt(input.get(i));
            int b = Integer.parseInt(input.get(i+1));
            int c = Integer.parseInt(input.get(i+2));
            int d = Integer.parseInt(input.get(i+3));

            if ((a+b+c) < (b+c+d)){
                increaseCounter++;
            }
        }
        return increaseCounter;
    }
}

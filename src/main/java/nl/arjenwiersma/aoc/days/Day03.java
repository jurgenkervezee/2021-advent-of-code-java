package nl.arjenwiersma.aoc.days;

import nl.arjenwiersma.aoc.common.Day;

import java.util.List;

public class Day03 implements Day<Integer> {
    @Override
    public Integer part1(List<String> input) {

        StringBuilder gammaRate = new StringBuilder();
        StringBuilder epsilonRate = new StringBuilder();

        for (int i=0; i < 12 ; i++){
            int dominant = calculateDominantZeroOrOne(input, i);
            int sub = Math.abs(dominant - 1);
            gammaRate.append(dominant);
            epsilonRate.append(sub);
        }
        int decimalGammaRate = Integer.parseInt(String.valueOf(gammaRate), 2);
        int decimalEpsilonRate = Integer.parseInt(String.valueOf(epsilonRate), 2);

        return decimalGammaRate*decimalEpsilonRate;
    }

    public int calculateDominantZeroOrOne(List<String> input, int charIndex) {
        int amountOfZero = 0;

        for (String i : input) {
            char chr = i.charAt(charIndex);

            String str = String.valueOf(chr);
            if (str.equals("0")) {
                amountOfZero++;
            }
        }

        if(amountOfZero>(input.size()-amountOfZero)){
            return 0;
        }else return 1;
    }

    @Override
    public Integer part2(List<String> input) {
        return null;
    }
}

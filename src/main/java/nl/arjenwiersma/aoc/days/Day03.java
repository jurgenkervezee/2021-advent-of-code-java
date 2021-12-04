package nl.arjenwiersma.aoc.days;

import nl.arjenwiersma.aoc.common.Day;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Day03 implements Day<Integer> {
    @Override
    public Integer part1(List<String> input) {

        StringBuilder gammaRate = new StringBuilder();
        StringBuilder epsilonRate = new StringBuilder();

        for (int i = 0; i < 5; i++) {
            int dominant = calculateDominantZeroOrOne(input, i, true);
            int sub = Math.abs(dominant - 1);
            gammaRate.append(dominant);
            epsilonRate.append(sub);
        }
        int decimalGammaRate = Integer.parseInt(String.valueOf(gammaRate), 2);
        int decimalEpsilonRate = Integer.parseInt(String.valueOf(epsilonRate), 2);

        return decimalGammaRate * decimalEpsilonRate;
    }


    @Override
    public Integer part2(List<String> input) {

        List<String> temp1 = new ArrayList<>(input);
        List<String> temp2 = new ArrayList<>(input);

        int oxygen =  calculateOxygenAndCo2(temp1, true);
        int co2 = calculateOxygenAndCo2(temp2, false);

        return oxygen*co2;
    }

    public int calculateDominantZeroOrOne(List<String> input, int charIndex, boolean gas) {
        int amountOfOxygen = 0;
        int amountOfCo2 = 0;
        String calculateOxygen;
        String calculateC02;

        if(gas){
            calculateOxygen = "1";
            calculateC02 = "0";
        }else {
            calculateOxygen = "0";
            calculateC02= "1";
        }

        for (String i : input) {
            char chr = i.charAt(charIndex);

            String str = String.valueOf(chr);
            if (str.equals(calculateOxygen)) {
                amountOfOxygen++;
            }else if (str.equals(calculateC02)){
                amountOfCo2++;
            }
        }

        if((calculateOxygen.equals("1")) && (amountOfOxygen==amountOfCo2)){
            return 1;
        }else if((calculateC02.equals("1")) && (amountOfOxygen==amountOfCo2)){
            return 0;
        }else if (amountOfOxygen > amountOfCo2){
            return (1);
        }else return 0;
    }


    private int calculateOxygenAndCo2(List<String> calcList, boolean dominant) {
        int gas = 0;
        for (int i = 0; i < 12; i++) {

            int dom = calculateDominantZeroOrOne(calcList, i, dominant);
            calcList = removeFromList(calcList, i, dom);

        }
        gas = Integer.parseInt(String.valueOf(calcList.get(0)), 2);
        System.out.println( "Gas: "+ gas + " " + dominant);

        return gas;
    }

    private List<String> removeFromList(List<String> list, int index, int dom) {
        String sub = String.valueOf(Math.abs(dom - 1));
        Iterator<String> i = list.iterator();

        while (i.hasNext()) {
            String s = i.next();
            if (list.size()==1){
                break;
            }

            char chr = s.charAt(index);
            String str = String.valueOf(chr);

            if (str.equals(sub)) {
                i.remove();
            }
        }
        System.out.println(list);
        return list;
        }
    }


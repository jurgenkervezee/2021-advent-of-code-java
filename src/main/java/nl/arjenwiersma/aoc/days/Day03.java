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

    public int calculateDominantZeroOrOne(List<String> input, int charIndex, boolean zeroOrOne) {
        int amountOfDom = 0;
        int amountOfSub = 0;
        String dom;

        if(zeroOrOne){
            dom = "1";
        }else dom = "0";

        for (String i : input) {
            char chr = i.charAt(charIndex);

            String str = String.valueOf(chr);
            if (str.equals(dom)) {
                amountOfDom++;
            }else {
                amountOfSub++;
            }
        }

        if( (dom.equals("1")) && (amountOfDom==amountOfSub) ){
            return 1;
        }else if((dom.equals("0")) && (amountOfDom==amountOfSub)){
            return 0;
        }else if (amountOfDom > amountOfSub){
            return Integer.parseInt(dom);
        }else return Math.abs(Integer.parseInt(dom)-1);

    }

    @Override
    public Integer part2(List<String> input) {

        List<String> temp1 = new ArrayList<>(input);
        List<String> temp2 = new ArrayList<>(input);

        int oxygen =  calculateOxygenAndCo2(temp1, false);
        int co2 = calculateOxygenAndCo2(temp2, true);

        System.out.println( "Oxygen: "+ oxygen +
                            " Co2: "+ co2 );
        return co2;
    }

    private int calculateOxygenAndCo2(List<String> calcList, boolean dominant) {
        int gas = 0;
        for (int i = 0; i < 5; i++) {

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


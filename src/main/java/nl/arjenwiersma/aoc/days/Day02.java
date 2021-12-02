package nl.arjenwiersma.aoc.days;

import nl.arjenwiersma.aoc.common.Day;

import java.util.List;

public class Day02 implements Day<Integer> {
    @Override
    public Integer part1(List<String> input) {
        int depth = 0;
        int horizontalPosition = 0;

        for (String i : input) {
            //            get text
            String t = i.replaceAll("\\d", "");

            //            get int
            String amount = i.replaceAll("[^\\d.]", "");
            int a = Integer.parseInt(amount);

            switch (t.trim()) {
                case "forward":
                    horizontalPosition = horizontalPosition + a
                    ;
                    break;
                case "down":
                    depth = depth + a;
                    break;
                case "up":
                    depth = depth - a;
                    break;
                }
            }
           return depth*horizontalPosition;
        }


    @Override
    public Integer part2(List<String> input) {
        int depth = 0;
        int horizontalPosition = 0;
        int aim = 0;
        for (String i : input) {
            //            get text
            String t = i.replaceAll("\\d", "");

            //            get int
            String amount = i.replaceAll("[^\\d.]", "");
            int a = Integer.parseInt(amount);

            switch (t.trim()) {
                case "forward":
                    horizontalPosition = horizontalPosition + a;
                    depth = depth + (aim * a);
                    ;
                    break;
                case "down":
                    aim = aim + a;
                    break;
                case "up":
                    aim = aim - a;
                    break;
            }
        }
        return depth*horizontalPosition;
    }
}

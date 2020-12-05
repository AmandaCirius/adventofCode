import jdk.internal.org.objectweb.asm.ClassReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ThirdDecember extends December {

    private final List<String> map = new ArrayList<>();
    private int numberOfTreesThreeOne = 0;
    private int numberOfTreesOneOne = 0;
    private int numberOfTreesFiveOne = 0;
    private int numberOfTreesSevenOne = 0;
    private int numberOfTreesOneTwo = 0;
    int counterThreeOne = 0;
    int counterOneOne = 0;
    int counterFiveOne = 0;
    int counterSevenOne = 0;
    int counterOneTwo = 0;

    void setUp(final String inputfile) {
        try {
            final BufferedReader reader = new BufferedReader(new InputStreamReader(ClassReader.class.getResourceAsStream(inputfile)));
            String line;
            while ((line = reader.readLine()) != null) {
                StringBuilder builder = new StringBuilder();
                builder.append(line).append(line).append(line).append(line).append(line)
                        .append(line).append(line).append(line).append(line).append(line)
                        .append(line).append(line).append(line).append(line).append(line)
                        .append(line).append(line).append(line).append(line).append(line)
                        .append(line).append(line).append(line).append(line).append(line)
                        .append(line).append(line).append(line).append(line).append(line)
                        .append(line).append(line).append(line).append(line).append(line)
                        .append(line).append(line).append(line).append(line).append(line)
                        .append(line).append(line).append(line).append(line).append(line)
                        .append(line).append(line).append(line).append(line).append(line)
                        .append(line).append(line).append(line).append(line).append(line)
                        .append(line).append(line).append(line).append(line).append(line)
                        .append(line).append(line).append(line).append(line).append(line)
                        .append(line).append(line).append(line).append(line).append(line)
                        .append(line).append(line).append(line).append(line).append(line)
                        .append(line).append(line).append(line).append(line).append(line);
                map.add(builder.toString());
            }
        } catch (IOException e) {
            System.out.println("Could not load file..");
        }
    }

    void part1() {
        map.stream().skip(1).forEach(this::walkThreeOne);
        System.out.println("You've encountered " + numberOfTreesThreeOne + " trees!");
    }

    private void walkThreeOne(String s) {
        counterThreeOne += 3;
        final char treeOrGround = s.charAt(counterThreeOne);
        if (treeOrGround == '#') {
            numberOfTreesThreeOne++;
        }
    }

    void part2() {
        map.stream().skip(1).forEach(s ->
        {
            walkOneOne(s);
            walkThreeOne(s);
            walkFiveOne(s);
            walkSevenOne(s);
        });
        for (int i = 2; i < map.size(); i += 2) {
            walkOneTwo(map.get(i));
        }

        long result = numberOfTreesThreeOne;
        result *= numberOfTreesOneOne;
        result *= numberOfTreesFiveOne;
        result *= numberOfTreesSevenOne;
        result *= numberOfTreesOneTwo;
        System.out.println("Number of trees multiplied together: " + result);
    }

    private void walkOneOne(String s) {
        counterOneOne += 1;
        final char treeOrGround = s.charAt(counterOneOne);
        if (treeOrGround == '#') {
            numberOfTreesOneOne++;
        }
    }

    private void walkFiveOne(String s) {
        counterFiveOne += 5;
        final char treeOrGround = s.charAt(counterFiveOne);
        if (treeOrGround == '#') {
            numberOfTreesFiveOne++;
        }
    }

    private void walkSevenOne(String s) {
        counterSevenOne += 7;
        final char treeOrGround = s.charAt(counterSevenOne);
        if (treeOrGround == '#') {
            numberOfTreesSevenOne++;
        }
    }

    private void walkOneTwo(String s) {
        counterOneTwo++;
        final char treeOrGround = s.charAt(counterOneTwo);
        if (treeOrGround == '#') {
            numberOfTreesOneTwo++;
        }
    }

}

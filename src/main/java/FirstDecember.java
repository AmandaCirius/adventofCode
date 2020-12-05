import jdk.internal.org.objectweb.asm.ClassReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Optional;

public class FirstDecember extends December {

    private final ArrayList<Integer> numbers = new ArrayList<>();

    void setUp(final String inputfile) {
        try {
            final BufferedReader reader = new BufferedReader(new InputStreamReader(ClassReader.class.getResourceAsStream(inputfile)));
            String line;
            while ((line = reader.readLine()) != null) {
                numbers.add(Integer.valueOf(line));
            }
        } catch (IOException e) {
            System.out.println("Could not load file..");
        }
    }

    void part1() {
        for (int i = 0; i < numbers.size(); i++) {
            final int matcher = numbers.get(i);

            final Optional<Integer> match = numbers.stream().filter(number -> number + matcher == 2020).findAny();
            if (match.isPresent()) {
                final int correct = match.get() * matcher;
                System.out.println("Match: " + match.get() + " " + matcher + " Correct answer part 1: " + correct);
                break;
            }
        }
    }

    void part2() {
        Optional<Integer> match = Optional.empty();
        for (int i = 0; i < numbers.size(); i++) {
            int iMatcher = numbers.get(i);

            for (int j = 0; j < numbers.size(); j++) {
                int jMatcher = numbers.get(j);

                match = numbers.stream().filter(number -> number + iMatcher + jMatcher == 2020).findAny();
                if (match.isPresent()) {
                    final int correct = match.get() * jMatcher * iMatcher;
                    System.out.println("Match: " + match.get() + " " + jMatcher + " " + iMatcher + " Correct answer part 2: " + correct);
                    break;
                }
            }
            if (match.isPresent()) {
                break;
            }
        }
    }
}

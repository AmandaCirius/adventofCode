import jdk.internal.org.objectweb.asm.ClassReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SeventhOfDecember extends December{
    private final List<String> stupidBagRules = new ArrayList<>();
    private final Set<String> coloredBags = new HashSet<>();

    void setUp(String inputfile) {
        coloredBags.add("shiny gold");
        try {
            final BufferedReader reader = new BufferedReader(new InputStreamReader(ClassReader.class.getResourceAsStream(inputfile)));
            String line;
            while ((line = reader.readLine()) != null) {
                stupidBagRules.add(line);
            }
        } catch (IOException e) {
            System.out.println("Could not load file..");
        }
    }

    void part1() {
        coloredBags.forEach(bag -> find(bag));
        System.out.println(coloredBags.size());
    }

    private Set<String> find(String coloredBag) {
        final Set<String> collectedBags = new HashSet<>();

        stupidBagRules.forEach(rule -> {
            if (rule.contains(coloredBag)) {
                final String[] bags = rule.split(" bag");
                final String bag = bags[0];
                collectedBags.add(bag);
             }
        });
        return collectedBags;
    }

    private void findBag(String rule) {
        final Set<String> collectedBags = new HashSet<>();

        coloredBags.forEach(coloredBag -> {
            if (rule.contains(coloredBag)) {
                final String[] bags = rule.split(" bag");
                collectedBags.add(bags[0]);
            }
        });
        coloredBags.addAll(collectedBags);
    }

    void part2() {

    }
}

import jdk.internal.org.objectweb.asm.ClassReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.valueOf;

public class SecondDecember extends December {

    private final ArrayList<Password> passwords = new ArrayList<>();

    void setUp(final String inputFile) {
        try {
            final BufferedReader reader = new BufferedReader(new InputStreamReader(ClassReader.class.getResourceAsStream(inputFile)));
            String line;
            while ((line = reader.readLine()) != null) {
                final String[] split = line.split("-");
                final int min = Integer.parseInt(split[0]);
                final String[] splitSplit = split[1].split(" ");
                final int max = Integer.parseInt(splitSplit[0]);
                final char character = splitSplit[1].charAt(0);
                final String password = splitSplit[2];
                passwords.add(new Password(min, max, character, password));
            }
        } catch (IOException e) {
            System.out.println("Could not load file..");
        }
    }

    void part1() {
        final List<Password> validPasswords = passwords.stream().filter(this::check1).collect(Collectors.toList());
        System.out.println("Number of valid passwords part 1: " + validPasswords.size());
    }

    private boolean check1(Password password) {
        if (!password.getPassword().contains(valueOf(password.getCharacter()))) {
            return false;
        }
        final char[] chars = password.getPassword().toCharArray();
        int counter = 0;
        for (char c : chars) {
            if (c == password.getCharacter()) {
                counter++;
            }
        }
        return counter >= password.getMin() && counter <= password.getMax();
    }

    void part2() {
        final List<Password> validPasswords = passwords.stream().filter(this::check2).collect(Collectors.toList());
        System.out.println("Number of valid passwords part 2: " + validPasswords.size());
    }

    private boolean check2(Password password) {
        if (!password.getPassword().contains(valueOf(password.getCharacter()))) {
            return false;
        }
        final String pass = password.getPassword();
        final char firstPosition = pass.charAt(password.getMin() - 1);
        final char secondPosition = pass.charAt(password.getMax() - 1);
        if (firstPosition == password.getCharacter()) {
            return secondPosition != password.getCharacter();
        } else {
            return secondPosition == password.getCharacter();
        }
    }
}

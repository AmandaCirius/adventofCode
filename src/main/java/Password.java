public class Password {

    private final int min;
    private final int max;
    private final char character;
    private final String password;

    public Password(int min, int max, char character, String password) {
        this.min = min;
        this.max = max;
        this.character = character;
        this.password = password;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public char getCharacter() {
        return character;
    }

    public String getPassword() {
        return password;
    }
}

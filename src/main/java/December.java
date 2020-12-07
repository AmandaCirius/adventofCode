public abstract class December {

    public void run(final String inputfile) {
        setUp(inputfile);
        part1();
        part2();
    }

    abstract void setUp(String inputFile);

    abstract void part1();

    abstract void part2();
}

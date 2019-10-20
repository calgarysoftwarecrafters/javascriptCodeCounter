public class javascriptCodeCounter {
    public static void main(String[] args) {
        javascriptCodeCounter counter = new javascriptCodeCounter();
        boolean shouldBeCounted = counter.shouldBeCounted("//");
        counter.throwExceptionIfNotEqual(false, shouldBeCounted);

        shouldBeCounted = counter.shouldBeCounted("test");
        counter.throwExceptionIfNotEqual(true, shouldBeCounted);

        System.out.println("Success");
    }

    public void throwExceptionIfNotEqual(boolean expected, boolean actual) {
        if (expected != actual) {
            throw new RuntimeException("expected = " + expected + ", actual = " + actual);
        }
    }

    public boolean shouldBeCounted(String line) {
        if (line.startsWith("//")) {
            return false;
        }
        return true;
    }

    public static int countCodeLines(String javascriptFile){
        String lines[] = javascriptFile.split("\\r?\\n");
        for(int i = 0; i < lines.length; i++){
          System.out.println(lines[i]);
        }
        return -1;
    }
}
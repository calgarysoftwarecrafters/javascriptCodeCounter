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

    /* A mock function to call from countCodeLines */
    public static boolean mockIsCodeLine(String line){
      return false;
    }

    public static int countCodeLines(String javascriptFile){
        int count = 0;
        String lines[] = javascriptFile.split("\\r?\\n");
        for(int i = 0; i < lines.length; i++){
          if(mockIsCodeLine(lines[i])){
            count++;
          }
        }
        return count;
    }
}
public class javascriptCodeCounter {
    public static void main(String[] args) {
        javascriptCodeCounter counter = new javascriptCodeCounter();
        counter.throwExceptionIfNotEqual(false, counter.shouldBeCounted("//"));
        counter.throwExceptionIfNotEqual(true, counter.shouldBeCounted("test"));
        counter.throwExceptionIfNotEqual(false, counter.shouldBeCounted("/* test */"));
        counter.throwExceptionIfNotEqual(true, counter.shouldBeCounted("test */"));
        counter.throwExceptionIfNotEqual(1, counter.countCodeLines("test"));
        System.out.println("Success");
    }

    public void throwExceptionIfNotEqual(boolean expected, boolean actual) {
        if (expected != actual) {
            throw new RuntimeException("expected = " + expected + ", actual = " + actual);
        }
    }

    public void throwExceptionIfNotEqual(int expected, int actual) {
        if (expected != actual) {
            throw new RuntimeException("expected = " + expected + ", actual = " + actual);
        }
    }

    public boolean shouldBeCounted(String line) {
        if (line.startsWith("//")) {
            return false;
        }

        if (line.contains("/*") && line.contains("*/")) {
            return false;
        }
        return true;
    }

    public int countCodeLines(String javascriptFile){
        int count = 0;
        String lines[] = javascriptFile.split("\\r?\\n");
        for(int i = 0; i < lines.length; i++){
          if(shouldBeCounted(lines[i])){
            count++;
          }
        }
        return count;
    }
}
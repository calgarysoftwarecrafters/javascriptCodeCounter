public class javascriptCodeCounter {
    public static void main(String[] args) {
        System.out.println("Hello World");
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
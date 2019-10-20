public class javascriptCodeCounter {
    public static void main(String[] args) {
        System.out.println("Hello World");
    }

    public static int countCodeLines(String javascriptFile){
        String lines[] = javascriptFile.split("\\r?\\n");
        for(int i = 0; i < lines.length; i++){
          System.out.println(lines[i]);
        }
        return -1;
    }
}
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
   public static void main(String[] args) {
      String[] lines = new String[] {"Good morning", "Good afternoon", "Good night"};

      String path = "C:\\Users\\Recepção\\Documents\\Expression\\Expression Encoder\\Screen Capture Output\\back-end\\teste.txt";
      String path2 = "C:\\Users\\Recepção\\Documents\\Expression\\Expression Encoder\\Screen Capture Output\\back-end\\teste2.txt";

      try (BufferedWriter bw = new BufferedWriter(new FileWriter(path2, true))) {
         for(String line : lines) {
            bw.write(line);
            bw.newLine();
         }
      } catch (IOException e) {
         e.printStackTrace();
      }


   }
}
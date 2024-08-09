import java.io.File;
import java.util.Scanner;

public class Program2 {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      System.out.print("Enter a file path: ");
      String strPath = sc.nextLine();
      File path = new File(strPath);
      File[] folders = path.listFiles(File::isFile);
      System.out.println("FOLDERS:");

      for(File folder : folders) {
         System.out.println(folder);
      }
      sc.close();
   }
}

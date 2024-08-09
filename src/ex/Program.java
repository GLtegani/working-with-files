package ex;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Program {
   public static void main(String[] args) {
      Locale.setDefault(Locale.US);
      Scanner sc = new Scanner(System.in);

      System.out.print("Enter file path you want to read: ");
      String strPath = sc.nextLine();

      System.out.print("What directory name do you want to create? ");
      String newArchive = sc.nextLine();
      System.out.print("What new file name do you want to create? ");
      String newFile = sc.nextLine();

      // Dividir o caminho em partes e atualizar o nome do diretório
      String[] parts = strPath.split("\\\\");
      parts[parts.length - 1] = newArchive;
      String newPath = String.join("\\", parts);

      // Criar o diretório, incluindo quaisquer diretórios pai necessários
      File directory = new File(newPath);
      if (!directory.mkdirs()) {
         System.out.println("Failed to create directory or directory already exists.");
         return;
      }

      String filePath = newPath + "\\" + newFile;

      try (
              BufferedReader readerFile = new BufferedReader(new FileReader(strPath));
              BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true));
      ) {
         String line;

         while ((line = readerFile.readLine()) != null) {
            String[] productInfo = line.split(",");
            if (productInfo.length != 3) {
               System.err.println("Invalid input format: " + line);
               continue; // Ignorar linhas com formato inválido
            }

            String name = productInfo[0].trim();
            String priceStr = productInfo[1].trim();
            String quantityStr = productInfo[2].trim();

            try {
               Double realPrice = Double.parseDouble(priceStr);
               Integer realQuantity = Integer.parseInt(quantityStr);

               Product product = new Product(name, realPrice, realQuantity);
               writer.write(product.getName() + ", " + String.format("%.2f", product.getTotalValue()));
               writer.newLine();
            } catch (NumberFormatException e) {
               System.err.println("Error parsing price or quantity: " + line);
            }
         }
      } catch (IOException e) {
         System.err.println("An error occurred while processing the files.");
         e.printStackTrace();
      }
   }
}

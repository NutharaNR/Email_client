package Email_Client;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class ReadFile {

    public static void readFile(String filePath ){

        try {
            File clientlist = new File(filePath);
            Scanner scanner = new Scanner(clientlist);
            while (scanner.hasNextLine()) {
              String data = scanner.nextLine();
              // constructing objts for each recipiennt in the clientlist
              ReceipientConstructor.constructor(data);
            }
            scanner.close();
          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }


    }
    
}

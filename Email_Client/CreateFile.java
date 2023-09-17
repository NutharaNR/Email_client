package Email_Client;

import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors


public class CreateFile{
    // this class should have only one instance

    private static CreateFile clientList;
    private String filePath;

    private CreateFile(){

        filePath ="D:\\Nuthara_N_R\\UOM\\Academic\\Sem 2\\CS1040 - Program Construction\\Practical assessments\\Email_client\\clientList.txt";

    }

    public static CreateFile createfile(){

        if(clientList==null){

            clientList= new CreateFile(); // a new create file obj will be created at every initialization of Email_Client

            try {
                File clienttxt = new File(clientList.filePath);
                clienttxt.createNewFile(); // create a file if there is no file in the given filepath , else doesn't create a file
              } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
              }

             
        }
        return clientList;

    }

    public String  getfilePath(){
        // returning the filePath of clientList.txt
        return this.filePath;

    }
    
}

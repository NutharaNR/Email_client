package Email_Client;


import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors
import java.io.BufferedWriter;// import the BufferWriter class 

public class WriteToFile {

    public static void addRecipient(String filePath , String recipient_record){
        
            try {
                FileWriter new_record = new FileWriter(filePath,true);
                BufferedWriter buffer= new BufferedWriter(new_record);
                buffer.write(recipient_record+"\n");
                buffer.close();
                System.out.println("Successfully added the new recipient.");
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        
       


    }
    
}

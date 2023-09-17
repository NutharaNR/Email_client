package Email_Client;

import java.io.*; //import io class for object serialization and deserialization
import java.time.LocalDate; // import LocalDate class
import java.time.LocalTime; //import LocalDate class
import java.time.format.DateTimeFormatter; // import DateTimeFormatter class



public class Email implements Serializable {

    private String to;
    private String from ="nnrandrahennedi.20@uom.lk";
    private String subject ;
    private String content;


    // constructor
    public Email(String to,  String subject, String content){

        this.to = to;
        this.subject =subject;
        this.content=content;

        // serialization of the obj
        this.emailSerialization();
    }

    // return sender of the given email
    public String getSender(){
        return this.from;
    }
    
    // return srecipient of the given email
    public String getRecipient(){
        return this.to;
    }

    // return subject of the given email
    public String getSubject(){
        return this.subject;
    }

    // return the content of the given email
    public String getContent(){
        return this.content;
    }



    // Email obj serializing method

    private void emailSerialization(){


        // getting the current date in the format of yyyy/mm/dd
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy_MM_dd");
        String date = formatter.format(LocalDate.now());

        // getting the time in hhmmss format
        DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm:ss");
        String time = format.format(LocalTime.now());
        time= time.replace(":","");


        // a new derectory will be created for every day
        // each email obj will be serialized under the date of sending 
        // a .ser file will be created for each email obj
        //file name:-   time_when_sending.ser


        // file path for a directory
        String filepath ="D:\\Nuthara_N_R\\UOM\\Academic\\Sem 2\\CS1040 - Program Construction\\Practical assessments\\Email_client\\Sent Emails\\"+date ;

        // creating a directory if doesn't exist
        File file_ = new File(filepath);
        file_.mkdir();

        // updating file path to serialization of obj
        // ex : "D:\\Nuthara_N_R\\UOM\\Academic\\Sem 2\\CS1040 - Program Construction\\Practical assessments\\Email_client\\Sent Emails\\2022_07_20\\152045.ser"
        filepath =filepath+"\\"+ time+".ser";

        //serialization of email obj
        try
        {   
            //Saving of object in a file

            // creating a file .ser file with the file name time_when_sending.ser
            FileOutputStream file = new FileOutputStream(filepath);
            ObjectOutputStream out = new ObjectOutputStream(file);
         
            // Method for serialization of object
            out.writeObject(this);
              
            out.close();
            file.close();
              
            System.out.println("Object has been serialized");
  
        }
          
        catch(IOException ex)
        {
            System.out.println("IOException is caught");
        }
          

    }



    // method to deserialization
    //returns an Email obj

    private static Email emailDeserialization(String objPath){

        Email email;
        // Deserialization
        try
        {   
            // Reading the object from a file
            FileInputStream file = new FileInputStream(objPath);
            ObjectInputStream in = new ObjectInputStream(file);
            //Email e ;
            // Method for deserialization of object
            
            email =(Email)in.readObject();

                
            in.close();
            file.close();
              
            System.out.println("Object has been deserialized ");
            return email;

            
        }
          
        catch(IOException ex)
        {
            System.out.println("IOException is caught");
        }
          
        catch(ClassNotFoundException ex)
        {
            System.out.println("ClassNotFoundException is caught");
        }

        return email=null;

    }



    public static void getDetails(String date){
        // calling for the obj deserialization function and returns the subject and the recipient of the emails at a given specific date

        // creating the directory path for the directory related to the given date
        String path = "D:\\Nuthara_N_R\\UOM\\Academic\\Sem 2\\CS1040 - Program Construction\\Practical assessments\\Email_client\\Sent Emails\\"+date;
        //getting the directory related to the given date
        File f= new File(path);
        //populate the array with the names of all the .ser files i.e. all the Email objts
        String [] objList = f.list();

        // deserialize each obj
        for (String name: objList ){

            String objPath = path+"\\"+name;
            // passing for deserialization
            Email email = Email.emailDeserialization(objPath);
            if (email!=null){
                // printitng the email details
                System.out.println("Recipient: "+email.getRecipient()); 
                System.out.println("Subject: " +email.getSubject());
                System.out.println();

            }
        }
    }

}

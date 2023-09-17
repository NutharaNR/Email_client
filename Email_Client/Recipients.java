package Email_Client;

import java.util.ArrayList; // import ArrayList class



public abstract class Recipients {
    // defining common attributes for all the recipients
    //name, email address

    private String name ;
    private String email;

    // static variable to store the recipients to whom a birthday greeting should be sent
    public static ArrayList<Friends> ListOfBDays = new ArrayList<Friends>();

    public Recipients(String name , String email){

        // create recipient obj
        this.name = name;
        this.email = email;
        System.out.println("Recipient is creating");
    }


    // defining methods common for all recipients

    // returning the name of the obj

    public String getname(){
        return this.name;
    } 

    // returning the email of the obj
    public String getemailaddress(){
        return this.email;
    } 

    
    
    public static ArrayList<Friends> getListOfBDays(){
        // returns the list of recipientsa to whom a birthdat greeting should be sent
        return ListOfBDays;
    }


    //method to print the list of people who has birthdays in the given date
    public static void listOfBirthdayPeople(String date){

        for(int i=0; i< ListOfBDays.size(); i++){

            String s =(ListOfBDays.get(i)).getbirthday();

            if(s.equals(date)){

                System.out.println((ListOfBDays.get(i)).getname());
            }

        }
    }
    
    
}

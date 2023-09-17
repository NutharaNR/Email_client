package Email_Client;

import java.time.LocalDate; // import LocalDate class
import java.time.format.DateTimeFormatter; // import DateTimeFormatter class



public class Birthday {

    //method to select those who have birthday today out of all the friends in the given list and call the method in relevant class to send the birthday wishes
    public static void birthdayPeople(Friends friend){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd");
        String date = formatter.format(LocalDate.now());

       

        if(((friend.getbirthday()).substring(5)).equals(date)){

            friend.sendBirthdayWishes();
        }
        
    }


  
    
}

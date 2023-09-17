package Email_Client;

public class ReceipientConstructor{

    private static int numOfRecipients=0;

    public static void constructor(String new_record){

        numOfRecipients+=1;

        String [] arr = new_record.split(" ",2);
        System.out.println(arr[0]);

        if(arr[0].equals("Official:")){

            String [] record = arr[1].split(",",3);
            // creating new recipient as a Official obj
            new Official(record[0], record[1],record[2]);
        }


        else if (arr[0].equals("Office_friend:")){


            String [] record = arr[1].split(",",4);
            // creating new recipient as a Official_friends obj
            new Officials_friends(record[0], record[1],record[2],record[3]);

        }


        else if(arr[0].equals("Personal:")){

            String [] record = arr[1].split(",",4);
            // creating new recipient as a Personal obj
            new Personal(record[0], record[1],record[2],record[3]);

        }

    }


    // function to return number of Recipient objects at the moment
    public static int getnumOfRecipients(){

        return numOfRecipients;
    }

}
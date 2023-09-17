package Email_Client;
// Index no : 200407H

//import libraries

import java.util.Scanner;

public class Email_Client {

    public static void main(String[] args) {

        // start email client
        // code to create objects for each recipient in clientList.txt

        
        // creating the clientList.txt if doesn't exist
        CreateFile clientList = CreateFile.createfile();

        //creating objects for each recipient in clientList.txt
        ReadFile.readFile(clientList.getfilePath());



        // sending birth wishes 

        // whenever new friend object is created it will be sent to the Birthday class
        // if the friends birthday is today it will send a birthday wish



        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        // taking inputs from the user
        while(!exit){
            System.out.println("Enter option type: \n"
                    + "1 - Adding a new recipient\n"
                    + "2 - Sending an email\n"
                    + "3 - Printing out all the recipients who have birthdays\n"
                    + "4 - Printing out details of all the emails sent\n"
                    + "5 - Printing out the number of recipient objects in the application");

            int option = scanner.nextInt();
            scanner.nextLine(); // to throw away the \n in the buffer of the scanner object

            switch(option){


                    case 1:
                        System.out.println("Add recipient details");
                        // input format - Official: nimal,nimal@gmail.com,ceo
                        while(!scanner.hasNext());
                        String new_recipient =" " ;
                        if (scanner.hasNext()) {

                            // get details of the recipient using a single input
                            new_recipient = scanner.nextLine();

                        }

                        // get the filePath of clientList.txt file
                        String filePath = clientList.getfilePath();
                        // store details in clientList.txt file
                        WriteToFile.addRecipient(filePath, new_recipient);
                        
                        // code to add a new recipient
                        ReceipientConstructor.constructor(new_recipient);
                        // new recipient obj will be created in one of the following forms 
                        // Official
                        // Official_friend
                        // Personal

                        break;

                        
                    case 2:
                    // sending an email

                        System.out.println("Enter the details: email, subject, content ");
                        // input format - email, subject, content
                        while(!scanner.hasNext());
                        String input =" " ;
                        if (scanner.hasNext()) {

                            // get details of the recipient using a single input
                            input = scanner.nextLine();

                        }

                        String [] arr = input.split(", ",3);
                        // creating an email obj
                        Email email = new Email(arr[0],arr[1],arr[2]);
                        //sending the email
                        emailSender.sendEmail(email);

                        break;




                    case 3:
                        System.out.println("Enter the Birthday ");
                        // input format - yyyy/MM/dd (ex: 2018/09/17)
                        while(!scanner.hasNext());
                        String birthday =" " ;
                        if (scanner.hasNext()) {

                            // get details of the recipient using a single input
                            birthday = scanner.nextLine();

                        }
                        // code to print recipients who have birthdays on the given date
                        Recipients.listOfBirthdayPeople(birthday);

                        break;




                    case 4:
                        System.out.println("Enter the date in the format, yyyy_MM_dd: ");
                        // input format - yyyy_MM_dd (ex: 2018_09_17)

                        while(!scanner.hasNext());
                        String date =" " ;
                        if (scanner.hasNext()) {

                            date = scanner.nextLine();
                        }

                        // calling methods to print the details
                        Email.getDetails(date);
                        break;




                    case 5:
                        // code to print the number of recipient objects in the application
                        System.out.println(ReceipientConstructor.getnumOfRecipients());

                        break;



            }
            System.out.println ("Want to exit the email client : Yes / No ");
            while(!scanner.hasNext());
            String next =" " ;
            if (scanner.hasNext()) {

                next = scanner.nextLine();
            }            

            if(next.equals("Yes")){
                exit = true;
            }

        }
        scanner.close();



          

      
    }
}
package Email_Client;

public class Officials_friends extends Official implements Friends  {

    // defining atrributes special for Official_friends

    private String birthday;


    public Officials_friends(String name, String email, String designation, String birthday){
        // create official_friends obj
        
        super(name, email, designation);
        this.birthday=birthday;

        // adding the object to the ListOfBDays arrayList
        ListOfBDays.add(this);
        Birthday.birthdayPeople(this);
        System.out.println("Office friend is creating");


    }
    

    // return the Birth date
    public String getbirthday(){
        return this.birthday;

   }

    public void sendBirthdayWishes(){

        // constructing the email obj
        Email email = new Email(this.getemailaddress(), "Birthday Wishes", "Wish you a Happy Birthday.\nNuthara.");

        // calling for emailsender to send the birthday wishes
        emailSender.sendEmail(email);

    }

    
    
}

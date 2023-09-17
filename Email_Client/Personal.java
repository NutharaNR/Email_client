package Email_Client;

public class Personal extends Recipients implements Friends{

    //defining aattributes special for personal objects

    private String nickName;
    private String birthday;

    public Personal(String name, String nickName , String email, String birthday){
        // create Personal obj

        super(name, email);
        this.birthday=birthday;
        this.nickName=nickName;

        // adding the object to the ListOfBDays arrayList
        ListOfBDays.add(this);
        Birthday.birthdayPeople(this);
        System.out.println("Personal is creating");

    }

    // return the Birth date
    public String getbirthday(){
        return this.birthday;

    }
    public void sendBirthdayWishes(){

        // constructing the email obj
        Email email = new Email(this.getemailaddress(), "Birthday Wishes", "Hugs and love on your birthday.\nNuthara.");

        // calling for emailsender to send the birthday wishes
        emailSender.sendEmail(email);



    }
}

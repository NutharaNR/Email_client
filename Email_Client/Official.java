package Email_Client;

public class Official extends Recipients { 
    // sub class of recipient class

    // defining attributes special for Official objects

    private String designation ;

    public Official(String name , String email, String designation){ 
        // create official objects

        super( name, email);

        this.designation=designation;
        System.out.println("Official is creating");


    }



   
}

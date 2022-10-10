package Comp.Assignment;


import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Assignment1 {
    public static boolean isValidPassword(String password) {

        // Regex to check valid password.
        String regex = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&+=])"
                + "(?=\\S+$).{8,20}$";

        // Compile the ReGex
        Pattern p = Pattern.compile(regex);

        // If the password is empty
        // return false
        if (password == null) {
            return false;
        }

        // Pattern class contains matcher() method
        // to find matching between given password
        // and regular expression.
        Matcher m = p.matcher(password);

        // Return if the password
        // matched the ReGex
        return m.matches();
    }

    public static void main(String [] args){
        Assignment1 ass = new Assignment1();

        Scanner input = new Scanner(System.in);
        String uname="";
        String pass = "";

        System.out.println("Masukkan Username");
        uname= input.nextLine();
        System.out.println("Masukkan Password");
        pass= input.nextLine();

        boolean s = ass.isValidPassword(pass);
        System.out.println(s);


        /*String regexpass1 ="(.*)(@gmail.com)(.*)";*/

/*        String password_Pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";

        Pattern pattern= password_Pattern.matches(pass);
        Pattern pattern = Pattern.compile(password_Pattern);

        Matcher matcher = pattern.matcher(pass);
        System.out.println(matcher);*/
        System.out.println("Password sesuai");
        if(pass.length()==8){
            String password = ".*Kuncinya1.*";
            String regex = "(.*)(@gmail.com)(.*)?";



            /*boolean matcher = Pattern.matches(regex, uname);*/
            boolean matchPass = Pattern.matches(password, pass);
            /*System.out.println("matchUname=" + matcher);*/
            System.out.println("matchPass=" + matchPass);
        }

    }
}

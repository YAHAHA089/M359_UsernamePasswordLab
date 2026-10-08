import java.util.Scanner;
public class UserInfoLab {
    public static void main(String[] args) {
        // Part 1
        Scanner scan = new Scanner(System.in);
        System.out.print("Please put in your first name: ");
        String firstName = scan.next();
        System.out.print("Please put in your first name: ");
        String lastName = scan.next();
        String username = generateUsername(firstName, lastName);
        System.out.println("Username: " + username);

        // Part 2
        System.out.print("Please put in your password: ");
        String password = scan.next();
        boolean isPasswordValid = validatePassword(password);

        // Part 3
        String maskedCreditCard = "";
        if (isPasswordValid) {
            System.out.println("Valid password");
            System.out.println("Please put in your credit card number:");
            String creditCardNum = scan.next();
            maskedCreditCard = maskCreditCard(creditCardNum);
        }

        // Part 4
        if (isPasswordValid && !maskedCreditCard.equals("N/A")){
            System.out.println("Final details");
            System.out.println("Username:   " + username);
            System.out.println("Credit Card: "+ maskedCreditCard);
        }
        else{
            System.out.println("Invalid card");
        }

    }

    public static String generateUsername(String firstName, String lastName) {
        String username = "";
        if(firstName.length() < 3){
            username+=firstName;
        }
        else{
            username += firstName.substring(0,3);
        }
        if(lastName.length() < 3){
            username+=lastName;
        }
        else{
            username += lastName.substring(0,3);
        }
        username = username.toLowerCase();
        return username;
    }
    public static boolean validatePassword(String password) {
        boolean x = true;
        if(password.length() >= 8){
           x = x;
        }
        else{
            System.out.println("Is less than 8 characters");
             x = false;
        }
        int y = 0;
        String allUpperCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for(int i = 0; i<password.length(); i++){
            String letter = password.substring(i,i+1);
            if(allUpperCaseLetters.indexOf(letter) > 0){
                y++;
            }
        }
        if(y>0){
            x = x;
        }
        else{
            System.out.println("Doesn't contain at least uppercase letter");;
            x = false;
        }
        if(containsDigit(password)){
            x = x;
        }
        else{
            System.out.println("Doesn't contain at least one number");;
            x = false;
        }
        return x;
    }
    public static String maskCreditCard(String creditCardNumber) {
        String maskedCard = "";
        if(creditCardNumber.length() == 16 && allDigits(creditCardNumber)){
            for(int i = 0; i < 16; i++){
                if(i%4==0){
                    maskedCard += " ";
                }
                if(i<12){
                    maskedCard += "*";
                }
                else{
                    maskedCard += creditCardNumber.charAt(i);
                }
            }
        }
        else{
           maskedCard = "N/A";
        }

        return maskedCard;
    }

    /**
     This method verifies that the string contains at least one numeric digit
     @param str The string to check
     @return true or false if a digit is present
     */
    public static boolean containsDigit(String str) {
        char[] chars = str.toCharArray();
        for (char c: chars) {
            if (Character.isDigit(c))
                return true;
        }
        return false;
    }

    /**
     * Checks if the entire String is all numerical
     * @param str The string to check
     * @return true or false if the string is ALL digits
     */
    public static boolean allDigits(String str) {
        char[] chars = str.toCharArray();
        for (char c: chars) {
            if (!Character.isDigit(c))
                return false;
        }
        return true;
    }

}

import java.util.Scanner;

public class RandomPasswordGenerator {

    static Scanner input = new Scanner(System.in);
    private static String name;
    private static int menuChoice;

    public static void UserName() {
        System.out.print("Please enter your name: ");
        name = input.next();
        System.out.println("\nHello " + name + "!");
    }

    public static void menuOptions(){
        menuChoice = 0;
        String menuOption;

        System.out.println("1. Generate a number password");
        System.out.println("2. Generate a lowercase password");
        System.out.println("3. Generate a uppercase password");
        System.out.println("4. Generate a lower & upper case password");
        System.out.println("5. Generate a full strength password (Upper, Lower, and Number)");

        switch (menuChoice){
            case 1: 
            menuOption = "\nGenerate a number password";
            break;
            case 2:
            menuOption = "Generate a lowercase password";
            break;
            case 3:
            menuOption = "Generate a uppercase password";
            break;
            case 4:
            menuOption = "Generate a lower & upper case password";
            break;
            case 5:
            menuOption = "Generate a full strength password (Upper, Lower, and Number)";
            break;
        }
        System.out.print("\nWhat password would you like? ");
        menuOption = input.next();
    }

    public static int passLength(int passwordLength) {
        int userpasswordLength;
        while(true) {
        userpasswordLength = input.nextInt();
        System.out.println("\nHow long would you like your password to be (Must be between 1-16) ");
        if (userpasswordLength > 1 && userpasswordLength < 16) {
            break;
        } 
    }
        return userpasswordLength;
    }

    public static void main(String args[]) {
        new JavaFrame();
        UserName();
        System.out.println("This is a random password generator.");
        System.out.println("You will be given a menu of options to choose from in order to generate your desired password.");
        System.out.println("You will be given 5 options to choose from.");


        System.out.print("\nAre you ready to begin?(Type Y to continue or N to exit) ");
        String begin = input.next();

        if (begin.equals("Y")){
            System.out.println("\nPlease choose from the menu provided below:");
        }else if (begin.equals("N")) {
            System.out.println("\nThank you for using my program!");
        }

        menuOptions();
        
        
    }
}

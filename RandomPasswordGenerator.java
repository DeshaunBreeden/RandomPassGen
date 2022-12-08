import java.util.Random;
import java.util.Scanner;

public class RandomPasswordGenerator {

    static PassMenu menu = new PassMenu();
    static Scanner input = new Scanner(System.in);
    static String name;
    static String capitalCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; 
    static String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
    static String specialCharacters = "!@#$";
    static String numbers = "1234567890";
    static boolean exit = false;
    static Random randomPass = new Random();
    static boolean stop = true;
    static int length;

    public static void UserName() {
        System.out.print("Please enter your name: ");
        name = input.next();
        System.out.println("\nHello " + name + "!");
    }

    public static void displayMenu() {
        menu.printMenu();
        generatePass(menuChoice());

    }

    public static int menuChoice() {
        int choice = 0;
        System.out.print("\nWhat password would you like? ");
        choice = input.nextInt();
        return choice;
    }

    public static char[] numberPass(int length) {
        System.out.print("Your password is: ");
        char[] numPass = new char[length];
        numPass[1] = numbers.charAt(randomPass.nextInt(numbers.length()));
        int i;
        for (i = 0; i < length; i++) {
            numPass[i] = numbers.charAt(randomPass.nextInt(numbers.length()));
            System.out.print(numPass[i]);
        }
        return numPass;
    }
    public static char [] lowerCasePass(int length) {
        System.out.print("Your password is: ");
        char [] lowerCasePass = new char [length];
        lowerCasePass[1] = lowerCaseLetters.charAt(randomPass.nextInt(lowerCaseLetters.length()));
        int i;
        for (i = 0; i < length; i++) {
            lowerCasePass[i] = lowerCaseLetters.charAt(randomPass.nextInt(lowerCaseLetters.length()));
            System.out.print(lowerCasePass[i]);
        }
        return lowerCasePass;
    }

    public static void generatePass(int choice) {
        switch (choice) {
            case 0:
                exit = true;
                System.out.println("Thank you for using my program!");
                break;
            case 1:
                System.out.print("How long would you like your password? (Choose 1-16) ");
                length = input.nextInt();
                numberPass(length);
                break;
                case 2: 
                System.out.print("How long would you like your password? (Choose 1-16) ");
                length = input.nextInt();
                lowerCasePass(length);
                break;
            default:
                System.out.println("Unknown Error");

        }
    }

    public static void main(String args[]) {
        UserName();
        System.out.println("This is a random password generator.");
        System.out.println(
                "You will be given a menu of options to choose from in order to generate your desired password.");
        System.out.println("You will be given 6 options to choose from.");

        System.out.print("\nAre you ready to begin?(Type Y to continue or N to exit) ");
        String begin = input.next();
            switch (begin) {
                case "Y":
                    displayMenu();
                    break;
                case "N":
                    System.out.println("\nThank you for using my program!");
                    System.out.println("Please re-run the program when you're ready!");
                    break;
                default:
                    System.out.println("You entered an unknown response.");
            }
            System.out.print("\nWould you like to generate another password? (Type Y or N) ");
            String answer = input.next();

            if (answer == "Y") {
                exit = false;
            } else {
                exit = true;
            }

    }
}

// work on uppercase & continue to work on looping entire program

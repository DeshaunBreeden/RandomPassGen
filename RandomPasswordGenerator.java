import java.util.ArrayList;
import java.util.Arrays;
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
        int choice;
        System.out.print("\nWhich password would you like? ");
        while (!input.hasNextInt()) {
            System.out.printf("Invalid input. Please try again (Choose 0-5): ");
            input.nextLine();
        }
        choice = input.nextInt();
        return choice;
    }

    public static ArrayList<Character> numberPass(int length) {
        System.out.print("Your password is: ");
        ArrayList<Character> numPass = new ArrayList<Character>();
        Arrays.asList(numbers.charAt(randomPass.nextInt(numbers.length())));
        int i;
        for (i = 0; i < length; i++) {
            numPass.add(numbers.charAt(randomPass.nextInt(numbers.length())));
            System.out.print(numPass.get(i));
        }
        return numPass;
    }

    public static ArrayList<Character> lowerCasePass(int length) {
        System.out.print("Your password is: ");
        ArrayList<Character> lowerCasePass = new ArrayList<Character>();
        Arrays.asList(lowerCaseLetters.charAt(randomPass.nextInt(lowerCaseLetters.length())));
        int i;
        for (i = 0; i < length; i++) {
            lowerCasePass.add(lowerCaseLetters.charAt(randomPass.nextInt(lowerCaseLetters.length())));
            System.out.print(lowerCasePass.get(i));
        }
        return lowerCasePass;
    }

    public static void testLength(int length) {
        if (length <= 0 || length >= 17) {
            System.out.println("\nUnknown Error");
            System.out.print("Would you like to try again? (Choose Y or N) ");
            String answer = input.next();
            if (answer.equals("Y")) {
                displayMenu();
            }
            System.out.print("\nWould you like to generate another password? (Type Y or N) ");
            answer = input.next();

            if (answer.equals("N")) {
                System.out.println("\nThank you for using my program!");
                System.exit(0);
            }
            while (answer.equals("Y")) {
                displayMenu();
                System.out.print("\nWould you like to generate another password? (Type Y or N) ");
                answer = input.next();
                switch (answer) {
                    case "Y":
                        displayMenu();
                        break;
                    case "N":
                        System.out.println("\nThank you for using my program!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("You entered an unknown response.");
                        System.out.println("Please re-run the program.");
                        System.exit(0);
                }

            }
        }
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
                testLength(length);
                numberPass(length);
                break;
            case 2:
                System.out.print("How long would you like your password? (Choose 1-16) ");
                length = input.nextInt();
                testLength(length);
                lowerCasePass(length);
                break;
            default:
                System.out.println("Unknown Error");
                System.out.println("\n Would you like to try again? (Choose Y or N) ");
                String answer = input.next();
                while (answer.equals("Y")) {
                    displayMenu();
                    System.out.print("\nWould you like to generate another password? (Type Y or N) ");
                    answer = input.next();
                }
                switch (answer) {
                    case "Y":
                        displayMenu();
                    case "N":
                        System.out.println("\nThank you for using my program!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("You entered an unknown response.");
                        System.out.println("Please re-run the program.");
                        System.exit(0);
                }

        }
    }

    public static void main(String args[]) {
        UserName();
        System.out.println("This is a random password generator.");
        System.out.println(
                "You will be given a menu of 6 options to choose from in order to generate your desired password.");

        System.out.print("\nAre you ready to begin?(Type Y to continue or N to exit) ");
        String begin = input.next();
        switch (begin) {
            case "Y":
                displayMenu();
                System.out.print("\nWould you like to generate another password? (Type Y or N) ");
                String answer = input.next();
                while (answer.equals("Y")) {
                    displayMenu();
                    System.out.print("\nWould you like to generate another password? (Type Y or N) ");
                    answer = input.next();
                }
                switch (answer) {
                    case "N":
                        System.out.println("\nThank you for using my program!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("You entered an unknown response.");
                        System.out.println("Please re-run the program.");
                        System.exit(0);
                }
        }

    }
}

// work on uppercase, try making method called try again to reduce
// repetetiveness
//fix menuchoice loop
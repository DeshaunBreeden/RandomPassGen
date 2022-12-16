import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class RandomPasswordGenerator {
    static PassMenu menu = new PassMenu();
    static Scanner input = new Scanner(System.in);
    static NClose nClose = new NClose();
    static defaultClose defaultClose = new defaultClose();
    static String name;
    static String capitalCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
    static String specialCharacters = "!@#$";
    static String numbers = "1234567890";
    static String upperLowerLetters = capitalCaseLetters + lowerCaseLetters;
    static String fullPass = capitalCaseLetters + lowerCaseLetters + specialCharacters + numbers;
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
            System.out.printf("Invalid input. Please try again(Choose 0-5): ");
            input.next();
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

    public static ArrayList<Character> upperCasePass(int length) {
        System.out.print("Your password is: ");
        ArrayList<Character> upperCasePass = new ArrayList<Character>();
        Arrays.asList(capitalCaseLetters.charAt(randomPass.nextInt(capitalCaseLetters.length())));
        int i;
        for (i = 0; i < length; i++) {
            upperCasePass.add(capitalCaseLetters.charAt(randomPass.nextInt(capitalCaseLetters.length())));
            System.out.print(upperCasePass.get(i));
        }
        return upperCasePass;
    }

    public static ArrayList<Character> upperLowerCasePass(int length) {
        System.out.print("Your password is: ");
        ArrayList<Character> upperLowerCasePass = new ArrayList<Character>();
        Arrays.asList(upperLowerLetters.charAt(randomPass.nextInt(upperLowerLetters.length())));
        int i;
        for (i = 0; i < length; i++) {
            upperLowerCasePass.add(upperLowerLetters.charAt(randomPass.nextInt(upperLowerLetters.length())));
            System.out.print(upperLowerCasePass.get(i));
        }
        return upperLowerCasePass;
    }
    public static ArrayList<Character> fullPass(int length) {
        System.out.print("Your password is: ");
        ArrayList<Character> fullstrengthpass = new ArrayList<Character>();
        Arrays.asList(fullPass.charAt(randomPass.nextInt(fullPass.length())));
        int i;
        for (i = 0; i < length; i++) {
            fullstrengthpass.add(fullPass.charAt(randomPass.nextInt(fullPass.length())));
            System.out.print(fullstrengthpass.get(i));
        }
        return fullstrengthpass;
    }

    public static int testLength(int length) {
        if (length <= 0 || length >= 17) {

            System.out.println("\nInvalid length!");
            System.out.print("Would you like to try again? (Choose Y or N) ");
            String answer = input.next();
            while (!answer.equals("Y") && !answer.equals("N")) {
                    System.out.printf("Invalid input. Please try again(Choose Y or N): ");
                    answer = input.next();
                }
            switch (answer) {
                case "Y":
                    System.out.print("Please enter a length(Choose 1-16): ");
                    while (!input.hasNextInt()) {
                        System.out.print("Invalid input. Please try again(Choose 1-16): ");
                        input.next();
                    }
                    RandomPasswordGenerator.length = input.nextInt();
                    break;
                case "N":
                    nClose.nClose();
                    break;
                default:
                    defaultClose.dClose();
            }
        }
        return length;
    }

    public static int userLength() {
        System.out.print("How long would you like your password? (Choose 1-16) ");
        while (!input.hasNextInt()) {
            System.out.print("Invalid input. Please try again(Choose 1-16): ");
            input.next();
        }
        length = input.nextInt();
        return length;
    }

    public static void generatePass(int choice) {
        switch (choice) {
            case 0:
                exit = true;
                nClose.nClose();
                break;
            case 1:
                userLength();
                testLength(length);
                numberPass(length);
                break;
            case 2:
                userLength();
                testLength(length);
                lowerCasePass(length);
                break;
            case 3:
                userLength();
                testLength(length);
                upperCasePass(length);
                break;
            case 4:
                userLength();
                testLength(length);
                upperLowerCasePass(length);
                break;
            case 5:
                userLength();
                testLength(length);
                fullPass(length);
                break;
            default:
                System.out.println("\nUnknown Error");
                System.out.print("Would you like to try again? (Choose Y or N) ");
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
                        nClose.nClose();
                        break;
                    default:
                    defaultClose.dClose();
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
        while (!begin.equals("Y") && !begin.equals("N")) {
            System.out.printf("Invalid input. Please try again(Choose Y or N): ");
            begin = input.next();
        }
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
                        nClose.nClose();
                        break;
                    default:
                        defaultClose.dClose();
                }
            case "N":
                nClose.nClose();
                break;
            default:
                defaultClose.dClose();

        }

    }
}
//
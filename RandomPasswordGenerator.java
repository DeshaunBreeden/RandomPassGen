import java.util.Scanner;

public class RandomPasswordGenerator {

    static Scanner input = new Scanner(System.in);
    static String name;

    public static void UserName() {
        System.out.print("Please enter your name: ");
        name = input.next();
        System.out.println("\nHello " + name + "!");
    }

    public static void main(String args[]) {
        UserName();

        System.out.println("This is a random password generator.");
        System.out.println("You will be given a menu of options to choose from in order to generate your desired password.");

        System.out.print("\nAre you ready to begin?(Type Y to continue) ");
        String begin = input.next();

        if (begin.equals("Y")){
            System.out.println("\nPlease choose from the menu provided below:");
        }else {
            System.out.println("Thank you for using my program!");
        }

        System.out.println("\n");
    }
}

import java.util.Scanner;

public class Group12 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String choice;

        while (true) {
            System.out.println("\n===== MAIN MENU =====\n");
            System.out.println("[A] Primary School");
            System.out.println("[B] Secondary School");
            System.out.println("[C] High School");
            System.out.println("[D] University");
            System.out.println("[E] Terminate");
            System.out.print("\nEnter your choice (A-E): ");

            choice = input.nextLine().toUpperCase();

            switch (choice) {
                case "A":
                    System.out.println("You chose option A");
                    PrimarySchool(input);
                    break;
                case "B":
                    System.out.println("You chose option B");
                    SecondarySchool(input);
                    break;
                case "C":
                    System.out.println("You chose option C");
                    HighSchool(input);
                    break;
                case "D":
                    System.out.println("You chose option D");
                    University(input);
                    break;
                case "E":
                    System.out.println("You chose option E. Session Terminated");
                    input.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // ===== Primary School Submenu ==================================================================================
    public static void PrimarySchool(Scanner input) {
        String choice;
        while (true) {
            System.out.println("\n===== PRIMARY SCHOOL MENU =====\n");
            System.out.println("[A] Age and Zodiac Sign Detection");
            System.out.println("[B] Reverse the Words");
            System.out.println("[C] Return to Main Menu");
            System.out.print("\nEnter your choice (A-C): ");

            choice = input.nextLine().toUpperCase();

            switch (choice) {
                case "A":
                    System.out.println("Age and Zodiac Sign Detection selected");
                    AgeAndZodiac();
                    break;
                case "B":
                    System.out.println("Reverse the Words selected");
                    ReverseWords();
                    break;
                case "C":
                    System.out.println("Returning to Main Menu...");
                    return;
                default:
                    System.out.println("Invalid choice, try again.");
            }
        }
    }

    public static void AgeAndZodiac()
    {

    }

    public static void ReverseWords()
    {

    }

    // ===== Secondary School Submenu ==================================================================================
    public static void SecondarySchool(Scanner input) {
        String choice;
        while (true) {
            System.out.println("\n===== SECONDARY SCHOOL MENU =====\n");
            System.out.println("[A] Prime Numbers");
            System.out.println("[B] Step-by-Step Expression Evaluation");
            System.out.println("[C] Return to Main Menu");
            System.out.print("\nEnter your choice (A-C): ");

            choice = input.nextLine().toUpperCase();

            switch (choice) {
                case "A":
                    System.out.println("Prime Numbers selected");
                    PrimeNumbers();
                    break;
                case "B":
                    System.out.println("Expression Evaluation selected");
                    ExpressionEvaluation();
                    break;
                case "C":
                    System.out.println("Returning to Main Menu...");
                    return;
                default:
                    System.out.println("Invalid choice, try again.");
            }
        }
    }

    public static void PrimeNumbers()
    {

    }

    public static void ExpressionEvaluation()
    {

    }

    // ================== High School Submenu =======================================================================
    public static void HighSchool(Scanner input) {
        String choice;
        while (true) {
            System.out.println("\n===== HIGH SCHOOL MENU =====\n");
            System.out.println("[A] Statistical Information about an Array");
            System.out.println("[B] Distance between Two Arrays");
            System.out.println("[C] Return to Main Menu");
            System.out.print("\nEnter your choice (A-C): ");

            choice = input.nextLine().toUpperCase();

            switch (choice) {
                case "A":
                    System.out.println("Statistical Information selected");
                    ArrayStatistics();
                    break;
                case "B":
                    System.out.println("Distance between Two Arrays selected");
                    ArrayDistance();
                    break;
                case "C":
                    System.out.println("Returning to Main Menu...");
                    return;
                default:
                    System.out.println("Invalid choice, try again.");
            }
        }
    }

    public static void ArrayStatistics()
    {

    }

    public static void ArrayDistance() 
    {

    }

    // ===== University Submenu =============================================================================================
    public static void University(Scanner input) {
        String choice;
        while (true) {
            System.out.println("\n===== UNIVERSITY MENU =====\n");
            System.out.println("[A] Connect Four Game");
            System.out.println("[B] Return to Main Menu");
            System.out.print("\nEnter your choice (A-B): ");

            choice = input.nextLine().toUpperCase();

            switch (choice) {
                case "A":
                    System.out.println("Connect Four Game selected");
                    ConnectFour();
                    break;
                case "B":
                    System.out.println("Returning to Main Menu...");
                    return;
                default:
                    System.out.println("Invalid choice, try again.");
            }
        }
    }

    public static void ConnectFour() 
    {

    }
}
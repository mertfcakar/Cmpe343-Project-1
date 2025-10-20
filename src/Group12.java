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
                case "A" :
                    System.out.println("You chose option A");
                    PrimarySchool();
                    break;
                case "B":
                    System.out.println("You chose option B");
                    break;
                case "C":
                    System.out.println("You chose option C");
                    break;
                case "D":
                    System.out.println("You chose option D");
                    break;
                case "E":
                    System.out.println("Session Terminated");
                    input.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    public static void PrimarySchool()
    {
        System.out.println("Option A");
    }
    public static void SecondarySchool()
    {
        System.out.println("Option B");
    }
    public static void HighSchool()
    {
        System.out.println("Option C");
    }
    public static void University()
    {
        System.out.println("Option D");
    }
}
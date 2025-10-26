import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
                    PrimeNumbers(input);
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

    public static void PrimeNumbers(Scanner input)
    {
        int n;

        while(true)
        {
            System.out.println("Enter an integer bigger than 12: ");
            if(input.hasNextInt())
            {
                n = input.nextInt();
                if(n >= 12)
                {
                    break;
                }
                else
                {
                    System.out.println("Please enter an integer bigger than 12: ");
                }
            }
            else
            {
                System.out.println("Invalid Input,Please only enter an integer: ");
                input.next();
            }
        }

        long startTime = System.nanoTime();
        List<Integer> primesEratosthenes = sieveOfEratosthenes(n);
        long endTime = System.nanoTime();
        System.out.println("\nSieve of Eratosthenes took " + (endTime - startTime) + " nanoseconds.");
        displayPrimes(primesEratosthenes);

        startTime = System.nanoTime();
        List<Integer> primesSundaram = sieveOfSundaram(n);
        endTime = System.nanoTime();
        System.out.println("\nSieve of Sundaram took " + (endTime - startTime) + " nanoseconds.");
        displayPrimes(primesSundaram);
        startTime = System.nanoTime();
        
        List<Integer> primesAtkin = sieveOfAtkin(n);
        endTime = System.nanoTime();
        System.out.println("\nSieve of Atkin took " + (endTime - startTime) + " nanoseconds.");
        displayPrimes(primesAtkin);
        
        input.nextLine();
    }

    private static void displayPrimes(List<Integer> primes)
    {
        if (primes.size() >= 5) {
            System.out.println("First 3 primes: " + primes.get(0) + ", " + primes.get(1) + ", " + primes.get(2));
            System.out.println("Last 2 primes: " + primes.get(primes.size() - 2) + ", " + primes.get(primes.size() - 1));
        } else if (!primes.isEmpty()) {
            System.out.println("Primes found: " + primes);
        } else {
            System.out.println("No primes were found.");
        }
    }

    private static List<Integer> sieveOfEratosthenes(int n) {
        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);
        for (int p = 2; p * p <= n; p++) {
            if (prime[p]) {
                for (int i = p * p; i <= n; i += p) prime[i] = false;
            }
        }
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (prime[i]) primes.add(i);
        }
        return primes;
    }

    private static List<Integer> sieveOfSundaram(int n) {
        int newN = (n - 1) / 2;
        boolean[] marked = new boolean[newN + 1];
        for (int i = 1; i <= newN; i++) {
            for (int j = i; (i + j + 2 * i * j) <= newN; j++) {
                marked[i + j + 2 * i * j] = true;
            }
        }
        List<Integer> primes = new ArrayList<>();
        if (n >= 2) primes.add(2);
        for (int i = 1; i <= newN; i++) {
            if (!marked[i]) {
                int p = 2 * i + 1;
                if (p <= n) primes.add(p);
            }
        }
        return primes;
    }

    private static List<Integer> sieveOfAtkin(int n) {
        boolean[] sieve = new boolean[n + 1];
        List<Integer> primes = new ArrayList<>();
        if (n >= 2) primes.add(2);
        if (n >= 3) primes.add(3);
        for (int x = 1; x * x <= n; x++) {
            for (int y = 1; y * y <= n; y++) {
                int num = (4 * x * x) + (y * y);
                if (num <= n && (num % 12 == 1 || num % 12 == 5)) sieve[num] ^= true;
                num = (3 * x * x) + (y * y);
                if (num <= n && num % 12 == 7) sieve[num] ^= true;
                num = (3 * x * x) - (y * y);
                if (x > y && num <= n && num % 12 == 11) sieve[num] ^= true;
            }
        }
        for (int r = 5; r * r <= n; r++) {
            if (sieve[r]) {
                for (int i = r * r; i <= n; i += r * r) sieve[i] = false;
            }
        }
        for (int a = 5; a <= n; a++) {
            if (sieve[a]) primes.add(a);
        }
        return primes;
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
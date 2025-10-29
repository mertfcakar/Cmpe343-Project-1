import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * CMPE 343 Course Project - Educational Menu System
 * 
 * This program provides an interactive educational platform with various
 * computational challenges organized by difficulty level (Primary School,
 * Secondary School, High School, and University).
 * 
 * Features include:
 * - Age and zodiac sign detection
 * - String manipulation (word reversal)
 * - Prime number generation using multiple algorithms
 * - Mathematical expression evaluation
 * - Statistical array analysis
 * - Distance calculations between arrays
 * - Connect Four game with AI
 * 
 * @author Mert Fahri Çakar
 * @author Burak Arslan
 * @author Nermin Zehra Sipahioğlu
 * @author Hüseyin Yiğit Şahin
 * @version 1.0
 * @since 2025
 */
public class Group12 {
    
    /**
     * Main entry point of the application.
     * Displays welcome message and main menu, then processes user selections
     * in a continuous loop until termination is requested.
     * 
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String choice;
        displayWelcomeMessage();

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
                    clearScreen();
                    PrimarySchool(input);
                    break;
                case "B":
                    System.out.println("You chose option B");
                    clearScreen();
                    SecondarySchool(input);
                    break;
                case "C":
                    System.out.println("You chose option C");
                    clearScreen();
                    HighSchool(input);
                    break;
                case "D":
                    System.out.println("You chose option D");
                    clearScreen();
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
    
    /**
     * Displays a styled welcome message with ASCII art and project information.
     * Uses ANSI color codes for enhanced visual presentation.
     */
    public static void displayWelcomeMessage() {
        String ANSI_RESET = "\u001B[0m";
        String ANSI_PURPLE = "\u001B[35m";
        String ANSI_YELLOW = "\u001B[33m";
        String ANSI_CYAN = "\u001B[36m";
        System.out.println(ANSI_PURPLE + "========================================================================" + ANSI_RESET);
        System.out.println(ANSI_PURPLE + "   ____ __  __ ____  _____ _____ _  _  _____ " + ANSI_RESET);
        System.out.println(ANSI_PURPLE + " / ___|  \\/  |  _ \\| ____|___ /| || ||___ / " + ANSI_RESET);
        System.out.println(ANSI_PURPLE + "| |   | |\\/| | |_) |  _|   |_ \\| || |_ |_ \\ " + ANSI_RESET);
        System.out.println(ANSI_PURPLE + "| |___| |  | |  __/| |___ ___) |__   _|__) |" + ANSI_RESET);
        System.out.println(ANSI_PURPLE + " \\____|_|  |_|_|   |_____|____/   |_||____/ " + ANSI_RESET);
        System.out.println();
        System.out.println(ANSI_YELLOW + "            Welcome to the CMPE 343 Course Project!             " + ANSI_RESET);
        System.out.println(ANSI_PURPLE + "========================================================================" + ANSI_RESET);
        System.out.println(ANSI_CYAN + "      Project by: MERT FAHRİ ÇAKAR, BURAK ARSLAN, NERMİN ZEHRA SİPAHİOĞLU,HÜSEYİN YİĞİT ŞAHİN" + ANSI_RESET);
        System.out.println();
    }

    /**
     * Clears the console screen using ANSI escape sequences.
     * Works on most Unix-like terminals and some Windows terminals.
     */
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // ===== PRIMARY SCHOOL SECTION =====
    
    /**
     * Displays the Primary School submenu and handles user selections.
     * Available options:
     * - Age and Zodiac Sign Detection
     * - Reverse the Words
     * - Return to Main Menu
     * 
     * @param input Scanner object for reading user input
     */
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
                    clearScreen();
                    System.out.println("Age and Zodiac Sign Detection selected");
                    AgeAndZodiac();
                    break;
                case "B":
                    clearScreen();
                    System.out.println("Reverse the Words selected");
                    ReverseWords();
                    break;
                case "C":
                    clearScreen();
                    System.out.println("Returning to Main Menu...");
                    return;
                default:
                    System.out.println("Invalid choice, try again.");
            }
        }
    }

    /**
     * Calculates a person's age and determines their zodiac sign based on birth date.
     * Validates user input to ensure proper date format and logical values.
     * Current date is set to October 31, 2025 for calculations.
     * 
     * Features:
     * - Precise age calculation (years, months, days)
     * - Leap year handling
     * - Date validation
     * - Zodiac sign determination
     */
    public static void AgeAndZodiac() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n=== AGE AND ZODIAC SIGN DETECTION ===");

        int currentYear = 2025;
        int currentMonth = 10;
        int currentDay = 31;

        int birthYear, birthMonth, birthDay;

        while (true) {
            try {
                System.out.print("Enter your birth year: ");
                birthYear = sc.nextInt();
                System.out.print("Enter your birth month (1-12): ");
                birthMonth = sc.nextInt();
                System.out.print("Enter your birth day (1-31): ");
                birthDay = sc.nextInt();
                sc.nextLine();

                if (!isValidDate(birthYear, birthMonth, birthDay)) {
                    System.out.println("❌ Invalid date. Please enter a valid date. Try again!\n");
                    continue;
                }

                if (birthYear > currentYear ||
                        (birthYear == currentYear && birthMonth > currentMonth) ||
                        (birthYear == currentYear && birthMonth == currentMonth && birthDay > currentDay)) {
                    System.out.println("❌ Invalid input: Birth date cannot be in the future. Try again!\n");
                    continue;
                }
                break;
            } catch (java.util.InputMismatchException e) {
                System.out.println("❌ Invalid input: Please enter numbers only. Try again!\n");
                sc.nextLine();
            }
        }

        int ageYears = currentYear - birthYear;
        int ageMonths = currentMonth - birthMonth;
        int ageDays = currentDay - birthDay;

        if (ageDays < 0) {
            ageMonths--;
            int daysInPrevMonth;
            int prevMonth = currentMonth - 1;
            if (prevMonth == 0)
                prevMonth = 12;

            if (prevMonth == 2) {
                daysInPrevMonth = isLeapYear(currentYear) ? 29 : 28;
            } else if (prevMonth == 4 || prevMonth == 6 || prevMonth == 9 || prevMonth == 11) {
                daysInPrevMonth = 30;
            } else {
                daysInPrevMonth = 31;
            }
            ageDays += daysInPrevMonth;
        }

        if (ageMonths < 0) {
            ageMonths += 12;
            ageYears--;
        }

        String zodiac = "";
        switch (birthMonth) {
            case 1:
                zodiac = (birthDay >= 20) ? "Aquarius" : "Capricorn";
                break;
            case 2:
                zodiac = (birthDay >= 19) ? "Pisces" : "Aquarius";
                break;
            case 3:
                zodiac = (birthDay >= 21) ? "Aries" : "Pisces";
                break;
            case 4:
                zodiac = (birthDay >= 20) ? "Taurus" : "Aries";
                break;
            case 5:
                zodiac = (birthDay >= 21) ? "Gemini" : "Taurus";
                break;
            case 6:
                zodiac = (birthDay >= 21) ? "Cancer" : "Gemini";
                break;
            case 7:
                zodiac = (birthDay >= 23) ? "Leo" : "Cancer";
                break;
            case 8:
                zodiac = (birthDay >= 23) ? "Virgo" : "Leo";
                break;
            case 9:
                zodiac = (birthDay >= 23) ? "Libra" : "Virgo";
                break;
            case 10:
                zodiac = (birthDay >= 23) ? "Scorpio" : "Libra";
                break;
            case 11:
                zodiac = (birthDay >= 22) ? "Sagittarius" : "Scorpio";
                break;
            case 12:
                zodiac = (birthDay >= 22) ? "Capricorn" : "Sagittarius";
                break;
        }

        System.out.printf("%nYou are %d years, %d months and %d days old.%n", ageYears, ageMonths, ageDays);
        System.out.println("Your zodiac sign is: " + zodiac);
    }

    /**
     * Determines if a given year is a leap year.
     * A leap year is divisible by 4, but not by 100, unless also divisible by 400.
     * 
     * @param year the year to check
     * @return true if the year is a leap year, false otherwise
     */
    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    /**
     * Validates a date by checking year, month, and day constraints.
     * Handles leap years and different month lengths.
     * 
     * @param year the year component
     * @param month the month component (1-12)
     * @param day the day component (1-31)
     * @return true if the date is valid, false otherwise
     */
    private static boolean isValidDate(int year, int month, int day) {
        if (year <= 0 || month < 1 || month > 12 || day < 1 || day > 31) {
            return false;
        }
        if (month == 2) {
            if (isLeapYear(year)) {
                return day <= 29;
            } else {
                return day <= 28;
            }
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            return day <= 30;
        }
        return true;
    }

    /**
     * Prompts user for a sentence and reverses each word while preserving
     * non-letter characters in their original positions.
     * Uses recursive algorithm for word reversal.
     * 
     * Example: "Hello, World!" becomes "olleH, dlroW!"
     */
    public static void ReverseWords() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n=== REVERSE THE WORDS (RECURSIVE) ===");
        System.out.print("Enter a sentence: ");
        String text = sc.nextLine();
        String result = reversePreserveNonLetters(text);
        System.out.println("Reversed sentence: " + result);
    }

    /**
     * Reverses each word in the input string while preserving positions of
     * non-letter characters.
     * 
     * @param input the string to process
     * @return string with each word reversed, non-letters preserved
     */
    private static String reversePreserveNonLetters(String input) {
        StringBuilder out = new StringBuilder();
        int i = 0;
        while (i < input.length()) {
            char c = input.charAt(i);
            if (Character.isLetter(c)) {
                int j = i;
                while (j < input.length() && Character.isLetter(input.charAt(j)))
                    j++;
                String word = input.substring(i, j);
                out.append(reverseRec(word));
                i = j;
            } else {
                out.append(c);
                i++;
            }
        }
        return out.toString();
    }

    /**
     * Recursively reverses a string.
     * Base case: strings of length 0 or 1 are returned as-is.
     * 
     * @param s the string to reverse
     * @return the reversed string
     */
    private static String reverseRec(String s) {
        if (s.length() <= 1)
            return s;
        return reverseRec(s.substring(1)) + s.charAt(0);
    }

    // ===== SECONDARY SCHOOL SECTION =====
    
    /**
     * Displays the Secondary School submenu and handles user selections.
     * Available options:
     * - Prime Numbers (using three different sieves)
     * - Step-by-Step Expression Evaluation
     * - Return to Main Menu
     * 
     * @param input Scanner object for reading user input
     */
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
                    clearScreen();
                    System.out.println("Prime Numbers selected");
                    PrimeNumbers(input);
                    break;
                case "B":
                    System.out.println("Expression Evaluation selected");
                    ExpressionEvaluation(input);
                    break;
                case "C":
                    clearScreen();
                    System.out.println("Returning to Main Menu...");
                    return;
                default:
                    System.out.println("Invalid choice, try again.");
            }
        }
    }

    /**
     * Generates prime numbers up to a given limit using three different algorithms:
     * - Sieve of Eratosthenes
     * - Sieve of Sundaram
     * - Sieve of Atkin
     * 
     * Compares execution time and displays first 3 and last 2 primes for each method.
     * 
     * @param input Scanner object for reading user input
     */
    public static void PrimeNumbers(Scanner input) {
        int n;

        while (true) {
            System.out.println("Enter an integer bigger than 12: ");
            if (input.hasNextInt()) {
                n = input.nextInt();
                if (n >= 12) {
                    break;
                } else {
                    System.out.println("Please enter an integer bigger than 12: ");
                }
            } else {
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

    /**
     * Displays the first 3 and last 2 prime numbers from a list.
     * If fewer than 5 primes exist, displays all available primes.
     * 
     * @param primes list of prime numbers to display
     */
    private static void displayPrimes(List<Integer> primes) {
        if (primes.size() >= 5) {
            System.out.println("First 3 primes: " + primes.get(0) + ", " + primes.get(1) + ", " + primes.get(2));
            System.out
                    .println("Last 2 primes: " + primes.get(primes.size() - 2) + ", " + primes.get(primes.size() - 1));
        } else if (!primes.isEmpty()) {
            System.out.println("Primes found: " + primes);
        } else {
            System.out.println("No primes were found.");
        }
    }

    /**
     * Implements the Sieve of Eratosthenes algorithm for finding prime numbers.
     * Time complexity: O(n log log n)
     * 
     * @param n the upper limit (inclusive) for prime number generation
     * @return list of all prime numbers up to n
     */
    private static List<Integer> sieveOfEratosthenes(int n) {
        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);
        for (int p = 2; p * p <= n; p++) {
            if (prime[p]) {
                for (int i = p * p; i <= n; i += p)
                    prime[i] = false;
            }
        }
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (prime[i])
                primes.add(i);
        }
        return primes;
    }

    /**
     * Implements the Sieve of Sundaram algorithm for finding prime numbers.
     * Generates odd primes efficiently by marking composites in a reduced range.
     * 
     * @param n the upper limit (inclusive) for prime number generation
     * @return list of all prime numbers up to n
     */
    private static List<Integer> sieveOfSundaram(int n) {
        int newN = (n - 1) / 2;
        boolean[] marked = new boolean[newN + 1];
        for (int i = 1; i <= newN; i++) {
            for (int j = i; (i + j + 2 * i * j) <= newN; j++) {
                marked[i + j + 2 * i * j] = true;
            }
        }
        List<Integer> primes = new ArrayList<>();
        if (n >= 2)
            primes.add(2);
        for (int i = 1; i <= newN; i++) {
            if (!marked[i]) {
                int p = 2 * i + 1;
                if (p <= n)
                    primes.add(p);
            }
        }
        return primes;
    }

    /**
     * Implements the Sieve of Atkin algorithm for finding prime numbers.
     * More complex but theoretically faster for large ranges.
     * Uses quadratic forms to identify potential primes.
     * 
     * @param n the upper limit (inclusive) for prime number generation
     * @return list of all prime numbers up to n
     */
    private static List<Integer> sieveOfAtkin(int n) {
        boolean[] sieve = new boolean[n + 1];
        List<Integer> primes = new ArrayList<>();
        if (n >= 2)
            primes.add(2);
        if (n >= 3)
            primes.add(3);
        for (int x = 1; x * x <= n; x++) {
            for (int y = 1; y * y <= n; y++) {
                int num = (4 * x * x) + (y * y);
                if (num <= n && (num % 12 == 1 || num % 12 == 5))
                    sieve[num] ^= true;
                num = (3 * x * x) + (y * y);
                if (num <= n && num % 12 == 7)
                    sieve[num] ^= true;
                num = (3 * x * x) - (y * y);
                if (x > y && num <= n && num % 12 == 11)
                    sieve[num] ^= true;
            }
        }
        for (int r = 5; r * r <= n; r++) {
            if (sieve[r]) {
                for (int i = r * r; i <= n; i += r * r)
                    sieve[i] = false;
            }
        }
        for (int a = 5; a <= n; a++) {
            if (sieve[a])
                primes.add(a);
        }
        return primes;
    }

    /**
     * Evaluates a mathematical expression step-by-step, showing each calculation.
     * Supports basic arithmetic operations: +, -, *, x (multiplication), : (division)
     * Handles parentheses and follows proper order of operations.
     * 
     * @param input Scanner object for reading user input
     */
    public static void ExpressionEvaluation(Scanner input) {
        String expression;
        while (true) {
            System.out.print("\nEnter a mathematical expression: ");
            expression = input.nextLine();
            if (isValidExpression(expression)) {
                String cleanExpression = expression.replace(" ", "");
                evaluateAndPrintStep(cleanExpression);
                break;
            } else {
                System.out.println("please, re-enter a valid expression.");
            }
        }
    }
    /**
     * A helper method to check if a character is a mathematical operator.
     * @param c The character to check.
     * @return true if the character is one of +, -, *, x, or :, false otherwise.
     */
    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == 'x' || c == ':';
    }

    /**
     * Validates a mathematical expression for correct syntax and characters.
     * Checks for balanced parentheses, valid operators, and correct operator placement.
     * 
     * @param expression the expression to validate
     * @return true if expression is valid, false otherwise
     */
    private static boolean isValidExpression(String expression) {
        String expr = expression.replace(" ", ""); // Work with a clean string with no spaces
        if (expr.isEmpty()) {
            return false;
        }

        // 1. Character Check (your original check is good)
        for (char c : expr.toCharArray()) {
            if (!Character.isDigit(c) && c != '+' && c != '-' && c != '*' && c != 'x' &&
                    c != ':' && c != '(' && c != ')') {
                return false;
            }
        }

        // 2. Parentheses Balance Check (your original check is good)
        int balance = 0;
        for (char c : expr.toCharArray()) {
            if (c == '(') balance++;
            else if (c == ')') balance--;
            if (balance < 0) return false;
        }
        if (balance != 0) return false;

        // 3. NEW: Syntax and Order Check
        // Rule: Cannot start with a high-precedence operator or a plus sign
        char firstChar = expr.charAt(0);
        if (firstChar == '*' || firstChar == 'x' || firstChar == ':' || firstChar == '+') {
            return false;
        }

        // Rule: Cannot end with any operator
        char lastChar = expr.charAt(expr.length() - 1);
        if (isOperator(lastChar)) {
            return false;
        }

        // Rule: No consecutive operators (e.g., "++", "*-", "*:")
        for (int i = 0; i < expr.length() - 1; i++) {
            char current = expr.charAt(i);
            char next = expr.charAt(i + 1);
            if (isOperator(current) && isOperator(next)) {
                return false;
            }
            // Rule: No operator right after an opening parenthesis (e.g., "(*5)")
            if (current == '(' && (next == '*' || next == 'x' || next == ':' || next == '+')) {
                return false;
            }
        }

        return true; // If all checks pass, the expression is valid
    }

    /**
     * Recursively evaluates an expression and prints each step of the calculation.
     * Handles parentheses first, then follows order of operations.
     * 
     * @param expression the expression to evaluate
     */
    private static void evaluateAndPrintStep(String expression) {
        expression = expression.replace("+-", "-").replace("--", "+");

        try {
            Integer.parseInt(expression);
            System.out.println("= " + expression);
            return;
        } catch (NumberFormatException e) {
        }

        System.out.println("= " + expression);
        String nextExpression;

        int openParenIndex = expression.lastIndexOf('(');
        if (openParenIndex != -1) {
            int closeParenIndex = expression.indexOf(')', openParenIndex);
            String subExpression = expression.substring(openParenIndex + 1, closeParenIndex);
            String subResult = performOneCalculation(subExpression);
            nextExpression = expression.substring(0, openParenIndex) + subResult
                    + expression.substring(closeParenIndex + 1);
        } else {
            nextExpression = performOneCalculation(expression);
        }
        evaluateAndPrintStep(nextExpression);
    }

    /**
     * Performs a single arithmetic calculation within an expression.
     * Prioritizes multiplication and division over addition and subtraction.
     * 
     * @param expression the expression to process
     * @return the expression with one operation calculated
     */
    private static String performOneCalculation(String expression) {
        int opIndex = -1;
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '*' || c == 'x' || c == ':') {
                opIndex = i;
                break;
            }
        }
        if (opIndex == -1) {
            for (int i = 1; i < expression.length(); i++) {
                char c = expression.charAt(i);
                if (c == '+' || c == '-') {
                    opIndex = i;
                    break;
                }
            }
        }

        if (opIndex != -1) {
            int leftStart = opIndex - 1;
            while (leftStart >= 0) {
                char c = expression.charAt(leftStart);
                if (Character.isDigit(c)) {
                    leftStart--;
                } else if (c == '-' && (leftStart == 0 || !Character.isDigit(expression.charAt(leftStart - 1)))) {
                    leftStart--;
                    break;
                } else {
                    break;
                }
            }
            leftStart++;

            int rightEnd = opIndex + 1;
            if (expression.charAt(rightEnd) == '-') {
                rightEnd++;
            }
            while (rightEnd < expression.length() && Character.isDigit(expression.charAt(rightEnd))) {
                rightEnd++;
            }

            int num1 = Integer.parseInt(expression.substring(leftStart, opIndex));
            char op = expression.charAt(opIndex);
            int num2 = Integer.parseInt(expression.substring(opIndex + 1, rightEnd));
            int result = 0;

            if (op == '*' || op == 'x') {
                result = num1 * num2;
            } else if (op == ':') {
                if (num2 == 0) {
                    System.out.println("Error: Division by zero is not allowed.");
                    return "0";
                }
                result = num1 / num2;
            } else if (op == '+') {
                result = num1 + num2;
            } else if (op == '-') {
                result = num1 - num2;
            }

            return expression.substring(0, leftStart) + result + expression.substring(rightEnd);
        }

        return expression;
    }

    // ===== HIGH SCHOOL SECTION =====
    
    /**
     * Displays the High School submenu and handles user selections.
     * Available options:
     * - Statistical Information about an Array
     * - Distance between Two Arrays
     * - Return to Main Menu
     * 
     * @param input Scanner object for reading user input
     */
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
                    clearScreen();
                    System.out.println("Statistical Information selected");
                    ArrayStatistics(input);
                    break;
                case "B":
                    clearScreen();
                    System.out.println("Distance between Two Arrays selected");
                    ArrayDistance(input);
                    break;
                case "C":
                    clearScreen();
                    System.out.println("Returning to Main Menu...");
                    return;
                default:
                    System.out.println("Invalid choice, try again.");
            }
        }
    }

    /**
     * Prompts user for an array and calculates various statistical measures:
     * - Arithmetic Mean
     * - Median
     * - Geometric Mean
     * - Harmonic Mean
     * 
     * Allows user to repeat with different arrays or return to menu.
     * 
     * @param input Scanner object for reading user input
     */
    public static void ArrayStatistics(Scanner input) {
        while (true) {
            System.out.println("--- Statistical Information about an Array ---");

            int n;
            while (true) {
                System.out.print("Enter array size (positive integer): ");
                String s = input.nextLine().trim();
                try {
                    n = Integer.parseInt(s);
                    if (n <= 0) {
                        System.out.println("Array size must be positive. Try again.");
                        continue;
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid integer (e.g., 5).");
                }
            }

            double[] arr = new double[n];
            System.out.println("Enter " + n + " elements:");
            for (int i = 0; i < n; i++) {
                while (true) {
                    System.out.print("Element " + (i + 1) + ": ");
                    String val = input.nextLine().trim();
                    try {
                        arr[i] = Double.parseDouble(val);
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a valid number.");
                    }
                }
            }

            System.out.println("Statistical Informations about your input array.");
            System.out.println("-------");
            System.out.println("Arithmetic Mean : " + arithmeticMean(arr));
            System.out.println("Median          : " + median(arr));
            System.out.println("Geometric Mean  : " + geometricMean(arr));
            System.out.println("Harmonic Mean   : " + harmonicMean(arr));

            while (true) {
                System.out.println("[A] Repeat with another array");
                System.out.println("[B] Return to High School Menu");
                System.out.print("Enter your choice (A-B): ");

                String next = input.nextLine().trim().toUpperCase();
                if (next.equals("A")) {
                    break;
                } else if (next.equals("B")) {
                    return;
                } else {
                    System.out.println("Invalid choice, please enter A or B.");
                }
            }
        }
    }

    /**
     * Calculates distances and similarity between two arrays:
     * - Manhattan Distance (L1 norm)
     * - Euclidean Distance (L2 norm)
     * - Cosine Similarity
     * 
     * Arrays must be the same size and contain values between 0 and 9.
     * 
     * @param input Scanner object for reading user input
     */
    public static void ArrayDistance(Scanner input) {
        System.out.println("--- Array Distance ---");

        int n;
        while (true) {
            System.out.print("Enter your first array's size: ");
            String s = input.nextLine().trim();
            try {
                n = Integer.parseInt(s);
                if (n <= 0) {
                    System.out.println("Array size must be positive. Try again.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer.");
            }
        }

        double[] arr1 = new double[n];
        System.out.println("Enter " + n + " elements for the first array (between 0 and 9):");

        for (int i = 0; i < n; i++) {
            while (true) {
                System.out.print("Element " + (i + 1) + ": ");
                String val = input.nextLine().trim();

                try {
                    double num = Double.parseDouble(val);

                    if (num < 0 || num > 9) {
                        System.out.println("Value must be between 0 and 9. Please try again.");
                        continue;
                    }

                    arr1[i] = num;
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid number.");
                }
            }
        }

        int k;
        while (true) {
            System.out.print("Enter your second array's size: ");
            String s = input.nextLine().trim();
            try {
                k = Integer.parseInt(s);
                if (k <= 0) {
                    System.out.println("Array size must be positive. Try again.");
                    continue;
                }
                if (k != n) {
                    System.out.println("Both arrays must have the same size for distance calculations.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer.");
            }
        }

        double[] arr2 = new double[n];
        System.out.println("Enter " + n + " elements for the second array (between 0 and 9):");

        for (int i = 0; i < n; i++) {
            while (true) {
                System.out.print("Element " + (i + 1) + ": ");
                String val = input.nextLine().trim();

                try {
                    double num = Double.parseDouble(val);

                    if (num < 0 || num > 9) {
                        System.out.println("Value must be between 0 and 9. Please try again.");
                        continue;
                    }

                    arr2[i] = num;
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid number (e.g., 3).");
                }
            }
        }

        System.out.println("Distance Informations about your input array.");
        System.out.println("-------");
        System.out.println("Manhattan Distance: " + manhattanDistance(arr1, arr2));
        System.out.println("Euclidean Distance: " + euclideanDistance(arr1, arr2));
        System.out.println("Cosine Similarity: " + cosineSimilarity(arr1, arr2));

        while (true) {
            System.out.println("[A] Repeat with another array");
            System.out.println("[B] Return to High School Menu");
            System.out.print("Enter your choice (A-B): ");

            String next = input.nextLine().trim().toUpperCase();
            if (next.equals("A")) {
                break;
            } else if (next.equals("B")) {
                return;
            } else {
                System.out.println("Invalid choice, please enter A or B.");
            }
        }
    }

    /**
     * Calculates the arithmetic mean (average) of an array.
     * Formula: sum of all elements divided by array length
     * 
     * @param a the array of numbers
     * @return the arithmetic mean
     */
    public static double arithmeticMean(double[] a) {
        double sum = 0.0;
        for (int i = 0; i < a.length; i++) {
            sum = sum + a[i];
        }
        return sum / a.length;
    }

    /**
     * Calculates the median (middle value) of an array.
     * For even-length arrays, returns average of two middle values.
     * 
     * @param a the array of numbers
     * @return the median value
     */
    public static double median(double[] a) {
        double[] copy = Arrays.copyOf(a, a.length);
        Arrays.sort(copy);
        int n = copy.length;
        if (n % 2 == 1) {
            return copy[n / 2];
        } else {
            return (copy[n / 2 - 1] + copy[n / 2]) / 2.0;
        }
    }

    /**
     * Calculates the geometric mean of an array.
     * Formula: nth root of the product of n numbers
     * Returns NaN if any element is non-positive.
     * 
     * @param a the array of numbers
     * @return the geometric mean, or NaN if undefined
     */
    public static double geometricMean(double[] a) {
        double logSum = 0.0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] <= 0) {
                System.out.println("Geometric mean undefined for non-positive values. Returning NaN.");
                return Double.NaN;
            }
            logSum = logSum + Math.log(a[i]);
        }
        return Math.exp(logSum / a.length);
    }

    /**
     * Calculates the harmonic mean of an array.
     * Formula: n divided by sum of reciprocals
     * Returns NaN if any element is zero.
     * 
     * @param a the array of numbers
     * @return the harmonic mean, or NaN if undefined
     */
    public static double harmonicMean(double[] a) {
        double sumRec = 0.0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0.0) {
                System.out.println("Harmonic mean undefined when any element is zero.");
                return Double.NaN;
            }
            sumRec = sumRec + (1.0 / a[i]);
        }
        return a.length / sumRec;
    }

    /**
     * Calculates Manhattan distance (L1 norm) between two arrays.
     * Formula: sum of absolute differences
     * 
     * @param arr1 first array
     * @param arr2 second array
     * @return the Manhattan distance
     */
    public static double manhattanDistance(double[] arr1, double[] arr2) {
        double manhattan = 0.0;
        for (int i = 0; i < arr1.length; i++) {
            manhattan += Math.abs(arr1[i] - arr2[i]);
        }
        return manhattan;
    }

    /**
     * Calculates Euclidean distance (L2 norm) between two arrays.
     * Formula: square root of sum of squared differences
     * 
     * @param arr1 first array
     * @param arr2 second array
     * @return the Euclidean distance
     */
    public static double euclideanDistance(double[] arr1, double[] arr2) {
        double euclidean = 0.0;
        for (int i = 0; i < arr1.length; i++) {
            euclidean += Math.pow(arr1[i] - arr2[i], 2);
        }
        return Math.sqrt(euclidean);
    }

    /**
     * Calculates cosine similarity between two arrays.
     * Formula: dot product divided by product of magnitudes
     * Returns 0.0 if either array is a zero vector.
     * Range: -1 to 1 (1 = identical direction, -1 = opposite direction)
     * 
     * @param arr1 first array
     * @param arr2 second array
     * @return the cosine similarity value
     */
    public static double cosineSimilarity(double[] arr1, double[] arr2) {
        double dotProduct = 0.0;
        double sum1 = 0.0;
        double sum2 = 0.0;

        for (int i = 0; i < arr1.length; i++) {
            dotProduct += arr1[i] * arr2[i];
            sum1 += Math.pow(arr1[i], 2);
            sum2 += Math.pow(arr2[i], 2);
        }

        if (sum1 == 0 || sum2 == 0) {
            System.out.println("Cosine similarity is undefined because one or both arrays are zero vectors.");
            return 0.0;
        }

        return dotProduct / (Math.sqrt(sum1) * Math.sqrt(sum2));
    }

    // ===== UNIVERSITY SECTION =====
    
    /**
     * Displays the University submenu and handles user selections.
     * Currently offers Connect Four game.
     * 
     * @param input Scanner object for reading user input
     */
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
                    clearScreen();
                    System.out.println("Launching Connect Four...");
                    ConnectFour(input);
                    break;
                case "B":
                    System.out.println("Returning to Main Menu...");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    /**
     * Connect Four Game implementation with AI opponent.
     * 
     * Game Features:
     * - Multiple board sizes: 5x4, 6x5, or 7x6
     * - Single-player mode (vs smart computer AI)
     * - Two-player mode
     * - Players can forfeit by entering 'Q'
     * 
     * Rules:
     * - Players alternate dropping discs into columns
     * - First to connect 4 discs horizontally, vertically, or diagonally wins
     * - Game ends in draw if board is full
     * 
     * @param input Scanner object for reading user input
     */
    public static void ConnectFour(Scanner input) {
        System.out.println("\n===== CONNECT FOUR =====");
        System.out.println("Select board size:");
        System.out.println("[1] 5 x 4");
        System.out.println("[2] 6 x 5");
        System.out.println("[3] 7 x 6");
        System.out.print("Enter your choice (1-3): ");
        int boardChoice = getValidInt(input, 1, 3);

        int rows = 4, cols = 5;
        if (boardChoice == 2) {
            rows = 5;
            cols = 6;
        } else if (boardChoice == 3) {
            rows = 6;
            cols = 7;
        }

        System.out.println("\nSelect Game Mode:");
        System.out.println("[1] Single Player (vs Computer)");
        System.out.println("[2] Two Players");
        System.out.print("Enter your choice (1-2): ");
        int mode = getValidInt(input, 1, 2);

        char[][] board = new char[rows][cols];
        for (char[] row : board)
            Arrays.fill(row, '.');

        char currentPlayer = 'X';
        boolean gameOver = false;

        while (!gameOver) {
            clearScreen();
            displayBoard(board);

            int col;

            if (mode == 1 && currentPlayer == 'O') {
                System.out.println("\nComputer is thinking...");
                pauseFor(1000);
                col = getSmartMove(board, 'O', 'X');
                System.out.println("Computer chooses column: " + (col + 1));
                pauseFor(800);
            } else {
                System.out.println("Player " + currentPlayer + "'s turn. (Enter column number or 'Q' to forfeit)");
                col = getPlayerMove(input, board);
                if (col == -1) {
                    System.out.println("Player " + currentPlayer + " forfeited. Game Over!");
                    break;
                }
            }

            int row = dropDisc(board, col, currentPlayer);
            if (row == -1) {
                System.out.println("Column is full! Try another one.");
                pauseFor(1000);
                continue;
            }

            if (checkWin(board, row, col, currentPlayer)) {
                clearScreen();
                displayBoard(board);
                System.out.println("Player " + currentPlayer + " WINS!");
                gameOver = true;
            } else if (isBoardFull(board)) {
                clearScreen();
                displayBoard(board);
                System.out.println("It's a DRAW!");
                gameOver = true;
            } else {
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }

            if (gameOver) {
                pauseForInput(input);
            }
        }

        System.out.println("Returning to University Menu...");
    }

    /**
     * Pauses execution and waits for user to press Enter.
     * Used to prevent screen from clearing immediately after game ends.
     * 
     * @param input Scanner object for reading user input
     */
    private static void pauseForInput(Scanner input) {
        System.out.print("\nPress Enter to continue...");
        input.nextLine();
    }

    /**
     * Creates a pause in program execution for visual effect.
     * 
     * @param ms duration of pause in milliseconds
     */
    private static void pauseFor(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Validates and reads an integer input within a specified range.
     * Continues prompting until valid input is received.
     * 
     * @param input Scanner object for reading user input
     * @param min minimum acceptable value (inclusive)
     * @param max maximum acceptable value (inclusive)
     * @return validated integer within range
     */
    private static int getValidInt(Scanner input, int min, int max) {
        int val;
        while (true) {
            if (input.hasNextInt()) {
                val = input.nextInt();
                input.nextLine();
                if (val >= min && val <= max)
                    return val;
            } else {
                input.next();
            }
            System.out.print("Invalid input, try again: ");
        }
    }

    /**
     * Displays the Connect Four game board with column numbers.
     * Empty spaces shown as '.', player discs as 'X' or 'O'.
     * 
     * @param board 2D character array representing the game board
     */
    private static void displayBoard(char[][] board) {
        System.out.println();
        for (char[] row : board) {
            for (char cell : row) {
                System.out.print(" " + cell + " ");
            }
            System.out.println();
        }
        for (int i = 0; i < board[0].length; i++) {
            System.out.print(" " + (i + 1) + " ");
        }
        System.out.println("\n");
    }

    /**
     * Drops a player's disc into the specified column.
     * Disc falls to the lowest available position due to gravity.
     * 
     * @param board the game board
     * @param col column index where disc is dropped
     * @param player character representing the player ('X' or 'O')
     * @return row index where disc landed, or -1 if column is full
     */
    private static int dropDisc(char[][] board, int col, char player) {
        for (int row = board.length - 1; row >= 0; row--) {
            if (board[row][col] == '.') {
                board[row][col] = player;
                return row;
            }
        }
        return -1;
    }

    /**
     * Handles human player input for column selection or forfeit.
     * Validates that chosen column is within valid range.
     * 
     * @param input Scanner object for reading user input
     * @param board the game board (used to determine valid column range)
     * @return column index (0-based), or -1 if player forfeits
     */
    private static int getPlayerMove(Scanner input, char[][] board) {
        while (true) {
            System.out.print("Choose a column (1-" + board[0].length + " or 'Q' to quit): ");
            String entry = input.nextLine().trim().toUpperCase();
            if (entry.equals("Q")) {
                return -1;
            }
            try {
                int col = Integer.parseInt(entry) - 1;
                if (col >= 0 && col < board[0].length)
                    return col;
            } catch (NumberFormatException e) {
            }
            System.out.println("Invalid input. Try again.");
        }
    }

    /**
     * AI strategy for selecting the best move in Connect Four.
     * 
     * Priority order:
     * 1. Win immediately if possible
     * 2. Block opponent's winning move
     * 3. Choose random valid column
     * 
     * @param board the game board
     * @param aiPlayer AI's character ('O')
     * @param humanPlayer human player's character ('X')
     * @return column index for AI's move
     */
    private static int getSmartMove(char[][] board, char aiPlayer, char humanPlayer) {
        List<Integer> validCols = new ArrayList<>();
        for (int c = 0; c < board[0].length; c++) {
            if (board[0][c] == '.')
                validCols.add(c);
        }

        for (int col : validCols) {
            int row = getDropRow(board, col);
            if (row != -1) {
                board[row][col] = aiPlayer;
                boolean win = checkWin(board, row, col, aiPlayer);
                board[row][col] = '.';
                if (win)
                    return col;
            }
        }

        for (int col : validCols) {
            int row = getDropRow(board, col);
            if (row != -1) {
                board[row][col] = humanPlayer;
                boolean win = checkWin(board, row, col, humanPlayer);
                board[row][col] = '.';
                if (win)
                    return col;
            }
        }

        return validCols.get((int) (Math.random() * validCols.size()));
    }

    /**
     * Determines which row a disc would land in if dropped in a column.
     * Simulates gravity without modifying the board.
     * 
     * @param board the game board
     * @param col column to check
     * @return row index where disc would land, or -1 if column is full
     */
    private static int getDropRow(char[][] board, int col) {
        for (int row = board.length - 1; row >= 0; row--) {
            if (board[row][col] == '.')
                return row;
        }
        return -1;
    }

    /**
     * Checks if the game board is completely filled.
     * 
     * @param board the game board
     * @return true if no empty spaces remain, false otherwise
     */
    private static boolean isBoardFull(char[][] board) {
        for (int c = 0; c < board[0].length; c++) {
            if (board[0][c] == '.')
                return false;
        }
        return true;
    }

    /**
     * Checks if the last move resulted in a win (4 connected discs).
     * Examines all four directions: vertical, horizontal, and both diagonals.
     * 
     * @param board the game board
     * @param row row of the last placed disc
     * @param col column of the last placed disc
     * @param player the player who made the move
     * @return true if player has connected 4 discs, false otherwise
     */
    private static boolean checkWin(char[][] board, int row, int col, char player) {
        int[][] directions = {
                { 1, 0 },
                { 0, 1 },
                { 1, 1 },
                { 1, -1 }
        };

        for (int[] dir : directions) {
            int count = 1;
            count += countDirection(board, row, col, dir[0], dir[1], player);
            count += countDirection(board, row, col, -dir[0], -dir[1], player);
            if (count >= 4)
                return true;
        }
        return false;
    }

    /**
     * Counts consecutive discs of the same player in a specific direction.
     * Used by checkWin to determine if 4 discs are connected.
     * 
     * @param board the game board
     * @param row starting row position
     * @param col starting column position
     * @param dr row direction increment (-1, 0, or 1)
     * @param dc column direction increment (-1, 0, or 1)
     * @param player the player character to count
     * @return number of consecutive matching discs in the direction
     */
    private static int countDirection(char[][] board, int row, int col, int dr, int dc, char player) {
        int count = 0;
        int r = row + dr, c = col + dc;
        while (r >= 0 && r < board.length && c >= 0 && c < board[0].length && board[r][c] == player) {
            count++;
            r += dr;
            c += dc;
        }
        return count;
    }
}
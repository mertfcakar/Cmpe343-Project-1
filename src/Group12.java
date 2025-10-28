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
                    clearScreen();
                    break;
                case "B":
                    System.out.println("You chose option B");
                    SecondarySchool(input);
                    clearScreen();
                    break;
                case "C":
                    System.out.println("You chose option C");
                    HighSchool(input);
                    clearScreen();
                    break;
                case "D":
                    System.out.println("You chose option D");
                    University(input);
                    clearScreen();
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

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // ===== Primary School Submenu
    // ==================================================================================
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

    public static void AgeAndZodiac() {

    }

    public static void ReverseWords() {

    }

    // ===== Secondary School Submenu
    // ==================================================================================
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
                    clearScreen();
                    break;
                case "B":
                    System.out.println("Expression Evaluation selected");
                    ExpressionEvaluation(input);
                    clearScreen();
                    break;
                case "C":
                    System.out.println("Returning to Main Menu...");
                    clearScreen();
                    return;
                default:
                    System.out.println("Invalid choice, try again.");
            }
        }
    }

    // ===== Prime Numbers
    // ======================================================================================
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

    // ===== Step-by-Step Expression
    // Evaluation=====================================================================================
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

    private static boolean isValidExpression(String expression) {
        for (char c : expression.toCharArray()) {
            if (!Character.isDigit(c) && c != '+' && c != '-' && c != '*' && c != 'x' &&
                    c != ':' && c != '(' && c != ')' && c != ' ') {
                return false;
            }
        }

        int balance = 0;
        for (char c : expression.toCharArray()) {
            if (c == '(')
                balance++;
            else if (c == ')')
                balance--;
            if (balance < 0)
                return false;
        }

        return balance == 0;
    }

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

    // ================== High School Submenu
    // =======================================================================
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
                    ArrayStatistics(input);
                    break;
                case "B":
                    System.out.println("Distance between Two Arrays selected");
                    ArrayDistance(input);
                    break;
                case "C":
                    System.out.println("Returning to Main Menu...");
                    return;
                default:
                    System.out.println("Invalid choice, try again.");
            }
        }
    }

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

    public static double arithmeticMean(double[] a) {
        double sum = 0.0;
        for (int i = 0; i < a.length; i++) {
            sum = sum + a[i];
        }
        return sum / a.length;
    }

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

    
    public static double manhattanDistance(double[] arr1, double[] arr2) {
        double manhattan = 0.0;
        for (int i = 0; i < arr1.length; i++) {
            manhattan += Math.abs(arr1[i] - arr2[i]);
        }
        return manhattan;
    }

    public static double euclideanDistance(double[] arr1, double[] arr2) {
        double euclidean = 0.0;
        for (int i = 0; i < arr1.length; i++) {
            euclidean += Math.pow(arr1[i] - arr2[i], 2);
        }
        return Math.sqrt(euclidean);
    }

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





    // ===== University Submenu
    // =============================================================================================
        /**
     * Connect Four Game
     * -----------------
     * Allows users to play Connect Four in:
     *  - Single-player (vs computer)
     *  - Two-player mode
     * 
     * Features:
     *  - Selectable board sizes (5x4, 6x5, or 7x6)
     *  - Smart computer (blocks or wins strategically)
     *  - Players can forfeit at any time by entering "Q"
     */
        // ===== UNIVERSITY MENU =====
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

    public static void ConnectFour(Scanner input) {
        System.out.println("\n===== CONNECT FOUR =====");
        System.out.println("Select board size:");
        System.out.println("[1] 5 x 4");
        System.out.println("[2] 6 x 5");
        System.out.println("[3] 7 x 6");
        System.out.print("Enter your choice (1-3): ");
        int boardChoice = getValidInt(input, 1, 3);

        int rows = 4, cols = 5;
        if (boardChoice == 2) { rows = 5; cols = 6; }
        else if (boardChoice == 3) { rows = 6; cols = 7; }

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

            // === Player or Computer Move ===
            if (mode == 1 && currentPlayer == 'O') {
                // Computer's turn
                System.out.println("\nComputer is thinking...");
                pauseFor(1000);
                col = getSmartMove(board, 'O', 'X');
                System.out.println("Computer chooses column: " + (col + 1));
                pauseFor(800);
            } else {
                // Human player's turn
                System.out.println("Player " + currentPlayer + "'s turn. (Enter column number or 'Q' to forfeit)");
                col = getPlayerMove(input, board);
                if (col == -1) { // forfeit
                    System.out.println("Player " + currentPlayer + " forfeited. Game Over!");
                    break;
                }
            }

            // Drop the disc in the selected column
            int row = dropDisc(board, col, currentPlayer);
            if (row == -1) {
                System.out.println("Column is full! Try another one.");
                pauseFor(1000);
                continue;
            }

            // Check for win or draw
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
                // Switch player
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }

            // Pause only after the game ends
            if (gameOver) {
                pauseForInput(input);
            }
        }

        System.out.println("Returning to University Menu...");
    }

/* ===== HELPER METHODS ===== */

    /**
     * Wait for the user to press Enter before continuing.
     */
    private static void pauseForInput(Scanner input) {
        System.out.print("\nPress Enter to continue...");
        input.nextLine();
    }

    /**
     * Creates a short delay in milliseconds.
     */
    private static void pauseFor(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Validates that user input is an integer within a given range.
     */
    private static int getValidInt(Scanner input, int min, int max) {
        int val;
        while (true) {
            if (input.hasNextInt()) {
                val = input.nextInt();
                input.nextLine(); // clear newline
                if (val >= min && val <= max)
                    return val;
            } else {
                input.next();
            }
            System.out.print("Invalid input, try again: ");
        }
        }

    /**
     * Displays the game board on the console.
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
     * Drops a disc into the specified column.
     * @return The row index where the disc landed, or -1 if the column is full.
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
     * Handles player input for choosing a column or forfeiting the game.
     * @return Column index or -1 if player forfeits.
     */
    private static int getPlayerMove(Scanner input, char[][] board) {
        while (true) {
            System.out.print("Choose a column (1-" + board[0].length + " or 'Q' to quit): ");
            String entry = input.nextLine().trim().toUpperCase();
            if (entry.equals("Q")) {
                return -1; // forfeit
            }
            try {
                int col = Integer.parseInt(entry) - 1;
                if (col >= 0 && col < board[0].length)
                    return col;
            } catch (NumberFormatException e) {
                // Ignore invalid entry
            }
            System.out.println("Invalid input. Try again.");
        }
    }

    /**
     * Smart AI move selection.
     *  1. Win in the next move if possible
     *  2. Block the opponent’s winning move
     *  3. Otherwise, choose a random valid column
     */
    private static int getSmartMove(char[][] board, char aiPlayer, char humanPlayer) {
        List<Integer> validCols = new ArrayList<>();
        for (int c = 0; c < board[0].length; c++) {
            if (board[0][c] == '.')
                validCols.add(c);
        }

        // Try to win
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

        // Try to block opponent
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

        // Otherwise, choose a random valid column
        return validCols.get((int) (Math.random() * validCols.size()));
    }

    /**
     * Find the row index where a disc would land in a column.
     */
    private static int getDropRow(char[][] board, int col) {
        for (int row = board.length - 1; row >= 0; row--) {
            if (board[row][col] == '.')
                return row;
        }
        return -1;
    }

    /**
     * Check if the board is completely full.
     */
    private static boolean isBoardFull(char[][] board) {
        for (int c = 0; c < board[0].length; c++) {
            if (board[0][c] == '.')
            return false;
        }
        return true;
    }

    /**
     * Check if a player has connected four in any direction.
     */
    private static boolean checkWin(char[][] board, int row, int col, char player) {
        int[][] directions = {
            {1, 0},  // vertical
            {0, 1},  // horizontal
            {1, 1},  // diagonal down-right
            {1, -1}  // diagonal down-left
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
     * Count consecutive discs of the same player in one direction.
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
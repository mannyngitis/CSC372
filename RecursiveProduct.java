import java.util.Scanner;

public class RecursiveProduct {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[5];

        // Reading 5 numbers from the user
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }

        // Calculating the product recursively
        int product = recursiveProduct(numbers, 0);
        System.out.println("The product of the entered numbers is: " + product);

        scanner.close();
    }

    // Recursive method to calculate the product
    private static int recursiveProduct(int[] numbers, int index) {
        if (index == numbers.length - 1) {
            return numbers[index];  // Base case: return the last number
        } else {
            return numbers[index] * recursiveProduct(numbers, index + 1);  // Recursive step
        }
    }
}

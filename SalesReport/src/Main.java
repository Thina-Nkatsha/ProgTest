//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

// Product names
        String[] products = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"
        };

// Two-dimensional array for sales
        int[][] sales = new int[3][3];

// Enter sales for each product
        for (int i = 0; i < products.length; i++) {

            for (int j = 0; j < 3; j++) {

                System.out.print("Enter number of sales for month "
                        + (j + 1) + " for " + products[i] + ": ");

                sales[i][j] = input.nextInt();
            }
            System.out.println();
        }

// Create Product object
        Product product = new Product(products, sales);

        PrintProduct printer = new PrintProduct();
// Display report
        printer.PrintReport(product);

        input.close();
    }
}

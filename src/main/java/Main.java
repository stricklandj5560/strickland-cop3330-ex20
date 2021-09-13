import java.util.Scanner;

/*
 *  UCF COP3330 Fall 2021 Assignment 1 Solution
 *  Copyright 2021 Jonathan Strickland
 */
public class Main {

    final static double wiTax = 0.05;
    final static double eua = 0.005;
    final static double dunn = 0.004;
    final static double ill = 0.08;

    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            System.out.print("What is the order amount? ");
            double amount = (double) Math.round(100 * scan.nextDouble()) / 100;
            System.out.print("What state do you live in? ");
            String state = scan.next().toLowerCase();
            System.out.print("What county do you live in? ");
            String county = scan.next().toLowerCase();
            double tax = 0, taxTotal = 0;
            // logic to figure out tax percentage.
            if (state.equals("wisconsin")) {
                tax = wiTax;
                if (county.equals("eau claire"))
                    tax += eua;
                if (county.equals("dunn"))
                    tax += dunn;
            }
            if (state.equals("illinois"))
                tax = ill;

            taxTotal = (double) Math.round(100 * (amount * tax)) / 100;
            System.out.println(String.format("The tax is $%s.\nThe total is $%s.",
                                taxTotal,
                                amount + taxTotal)
                                );
        }
    }
}

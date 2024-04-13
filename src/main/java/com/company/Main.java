package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int operation;

        while(true) {
            System.out.println("Select domain:");
            System.out.println("1. Mathematics");
            System.out.println("0. Exit");

            operation = scanner.nextInt();

            switch (operation) {
                case 1 -> SecureEquationUtils.showMenu();
                case 0 -> System.exit(0);
                default -> System.out.println("Invalid operation. Please try again.");
            }
        }
    }
}

package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int selectedAlgorithm = readInput();
    }

    /**
     * This function gets input from the user.
     *
     * @return the selected algorithm by user
     */
    public static int readAlgorithmSelection() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Pick an algorithm (int): ");
        int selectedAlgorithm;

        if (scanner.hasNextInt()) {
            selectedAlgorithm = scanner.nextInt();
        } else {
            scanner.next();
            selectedAlgorithm = -1;
        }

        while (selectedAlgorithm < 1 || selectedAlgorithm > 4) {
            System.out.print("Invalid selection of an algorithm, please pick integer from 1 to 4: ");
            if (scanner.hasNextInt()) {
                selectedAlgorithm = scanner.nextInt();
            } else {
                scanner.next();
                selectedAlgorithm = -1;
            }
        }

        return selectedAlgorithm - 1;
    }

    public static int promptAmountOfProcesses() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of processes (int): ");
        int numberOfProcesses;

        if (scanner.hasNextInt()) {
            numberOfProcesses = scanner.nextInt();
        } else {
            scanner.next();
            numberOfProcesses = -1;
        }

        while (numberOfProcesses <= 0) {
            System.out.print("Invalid, Enter number of processes (integer/number/e.g. 4): ");
            if (scanner.hasNextInt()) {
                numberOfProcesses = scanner.nextInt();
            } else {
                scanner.next();
                numberOfProcesses = -1;
            }
        }

        return numberOfProcesses;
    }

    public static void readInputDataFromUser() {
        ArrayList<Integer> arrivalTimes = new ArrayList<Integer>();
        ArrayList<Integer> burtTimes = new ArrayList<Integer>();

        int totalProcesses = promptAmountOfProcesses();

        promptInputDataFromUser(arrivalTimes, totalProcesses, "arrival");
        promptInputDataFromUser(burtTimes, totalProcesses, "burst");
    }

    public static void promptInputDataFromUser(ArrayList<Integer> array, int totalProcesses, String timeType) {
        Scanner scanner = new Scanner(System.in);
        int positiveValue = -1;

        for (int eachProcess = 0; eachProcess < totalProcesses; eachProcess++) {
            System.out.println("Process number #" + (eachProcess + 1));
            System.out.print("Enter " + timeType.toUpperCase() + " time: ");
            if (scanner.hasNextInt()) {
                positiveValue = scanner.nextInt();
            } else {
                scanner.next();
                positiveValue = -1;
            }

            while (positiveValue < 0) {
                System.out.print("Invalid, Enter arrival time of processes #" + (eachProcess + 1) + " (integer/number/e.g. 4): ");
                if (scanner.hasNextInt()) {
                    positiveValue = scanner.nextInt();
                } else {
                    scanner.next();
                    positiveValue = -1;
                }
            }

            array.add(positiveValue);
        }

    }

}
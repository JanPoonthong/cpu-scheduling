package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Integer> arrivalTimes = new ArrayList<>();
        List<Integer> burtTimes = new ArrayList<>();

        int selectedAlgorithm = readAlgorithmSelection() - 1;
        readInputDataFromUser(arrivalTimes, burtTimes);

        if (selectedAlgorithm == 0) {
            FirstComeFirstServed firstComeFirstServed = new FirstComeFirstServed(arrivalTimes, burtTimes);
            System.out.println("Average time: " + firstComeFirstServed.computation() + "ms");
        } else if (selectedAlgorithm == 1) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Pick an quantum (int): ");
            int quantum = scanner.nextInt();
            RoundRobin roundRobin = new RoundRobin(arrivalTimes, burtTimes, quantum);
            System.out.println(roundRobin.computation());
        }
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

        while (selectedAlgorithm < 1 || selectedAlgorithm > 2) {
            System.out.print("Invalid selection of an algorithm, please pick integer from 1 to 2: ");
            if (scanner.hasNextInt()) {
                selectedAlgorithm = scanner.nextInt();
            } else {
                scanner.next();
                selectedAlgorithm = -1;
            }
        }

        return selectedAlgorithm;
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

    public static void readInputDataFromUser(List<Integer> arrivalTimes, List<Integer> burtTimes) {

        int totalProcesses = promptAmountOfProcesses();

        promptComputationDataFromUser(arrivalTimes, totalProcesses, "arrival");
        promptComputationDataFromUser(burtTimes, totalProcesses, "burst");
    }

    public static void promptComputationDataFromUser(List<Integer> array, int totalProcesses, String timeType) {
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
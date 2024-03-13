package com.ronyoung.assignment2;

import java.math.BigDecimal;
import java.util.Scanner;


public class UserInterface {
    
    private final Scanner sc;
    
    private final AccountData savingsBean;
    private final AccountData chequingBean; 
    
    private final Chequing chequing;
    private final Savings savings;
    
    public UserInterface() {
        sc = new Scanner(System.in);
        
        savingsBean = new AccountData();
        chequingBean = new AccountData();
        
        // Get user input for starting values of Savings account.
        System.out.println("Savings account starting balance: ");
        BigDecimal startingBalanceSavings = sc.nextBigDecimal();
        
        System.out.println("Savings account annual interest rate: ");
        BigDecimal annualInterestRateSavings = sc.nextBigDecimal();
        
        // Get user input for starting values of Savings account.
        System.out.println("Savings account starting balance: ");
        BigDecimal startingBalanceChequing = sc.nextBigDecimal();
        
        System.out.println("Savings account annual interest rate: ");
        BigDecimal annualInterestRateChequing = sc.nextBigDecimal();

        chequing = new Chequing(startingBalanceSavings, 
                annualInterestRateSavings,chequingBean);
        savings = new Savings(startingBalanceChequing, 
                annualInterestRateChequing, savingsBean);
    }
    
    public void perform() {
        
        char choice;
            
        /* 
        Loop to call methods based on user's menu choice and then
        print their results.
        */
        do {
            choice = bankMenu();
            System.out.println("Choice = " + choice + "\n");
            switch (choice) {
                
                //If 'A' is selected brings up the Savings menu. 
                case 'A' -> {
                    do {
                        choice = savingsMenu();
                        System.out.println("Choice = " + choice + "\n");
                        switch (choice) {
                            case 'A' -> {
                                
                                // Asks for a Deposit amount then calls the 
                                //makeDeposit method with that amount.
                                System.out.print("Deposit Amount: $");
                                savings.makeDeposit(sc.nextBigDecimal());
                                                       
                            }
                        
                            case 'B' -> {
                                
                                // Asks for a Deposit amount then calls the 
                                //makeWithdrawal method with that amount.
                                System.out.print("Withdraw Amount: $");
                                savings.makeWithdraw(sc.nextBigDecimal());
                            }
                            
                            case 'C' -> {
                                
                                // Calls and prints the doMonthlyReport method.
                                System.out.println(savings.doMonthlyReport());
                                
                            }
                            
                            case 'D' -> {
                                
                                //Prints a returning to previous screen message.
                                System.out.println("Returning to Bank Menu.");                                
                            }
                            
                            default ->
                                // Shouldn't show up but if seen something is wrong.
                                System.out.println("I should never see this #2");
                        }
                    } while (choice != 'D');
                }
                
                //If 'B' is selected, calls 
                case 'B' -> {
                    
                    do {
                        choice = chequingMenu();
                        System.out.println("Choice = " + choice + "\n");
                        switch (choice) {
                            case 'A' -> {
                                
                                // Asks for a Deposit amount then calls the 
                                //makeDeposit method with that amount.
                                System.out.print("Deposit Amount: ");
                                chequing.makeDeposit(sc.nextBigDecimal());
                        
                            }
                        
                            case 'B' -> {
                                
                                // Asks for a Deposit amount then calls the 
                                //makeWithdrawal method with that amount.
                                System.out.print("Withdraw Amount: ");
                                chequing.makeWithdraw(sc.nextBigDecimal());
                            }
                            
                            case 'C' -> {
                                
                                // Calls and prints the doMonthlyReport method.
                                System.out.println(chequing.doMonthlyReport());
                            }
                            
                            case 'D' -> {
                                
                                //Prints a returning to previous screen message.
                                System.out.println("Returning to Bank Menu.");
                            }
                            
                            default ->
                                // Shouldn't show up but if seen something is wrong.
                                System.out.println("I should never see this #3");
                        }
                    } while (choice != 'D');
                    
                }
                
                //If 'C' is selected, calls 
                case 'C' -> {
                    System.out.println("Exiting.");
                }         
                default ->
                    // Shouldn't show up but if seen something is wrong.
                    System.out.println("I should never see this #1");
            }
        } while (choice != 'C');
       
        
    }
    
    private void displayBankMenuText() {
        // Request for input.
        System.out.println("Bank Menu");

        // Menu options.
        System.out.println("A: Savings");
        System.out.println("B: Chequing");
        System.out.println("C: Exit");
    }
    
    private void displaySavingsMenuText() {
        // Request for input.
        System.out.println("Savings Menu");

        // Menu options.
        System.out.println("A: Deposit");
        System.out.println("B: Withdrawal");
        System.out.println("C: Report");
        System.out.println("D: Return to Bank Menu");
    }
    
    private void displayChequingMenuText() {
        // Request for input.
        System.out.println("Chequing Menu");

        // Menu options.
        System.out.println("A: Deposit");
        System.out.println("B: Withdrawal");
        System.out.println("C: Report");
        System.out.println("D: Return to Bank Menu");
    }
    
    
    private char bankMenu() {
        
        char choice;

        // Loop to get desired letter input from user.
        do {
            displayBankMenuText();
            /* 
            Checks if the user input is an allowed value, 
            if not informs them it's not and askes for input again. 
            */
            if (sc.hasNext("[a-dA-D]")) {
                choice = sc.next().toUpperCase().charAt(0);
            } else {
                System.out.println("Invalid choice, please select again");
                choice = 'z';
            }
            sc.nextLine();
        } while (choice == 'z');
        return choice;
    }
    
    private char savingsMenu() {
        
        char choice;

        // Loop to get desired letter input from user.
        do {
            displaySavingsMenuText();
            /* 
            Checks if the user input is an allowed value, 
            if not informs them it's not and askes for input again. 
            */
            if (sc.hasNext("[a-dA-D]")) {
                choice = sc.next().toUpperCase().charAt(0);
            } else {
                System.out.println("Invalid choice, please select again");
                choice = 'z';
            }
            sc.nextLine();
        } while (choice == 'z');
        return choice;
    }
    
    private char chequingMenu() {
        
        char choice;

        // Loop to get desired letter input from user.
        do {
            displayChequingMenuText();
            /* 
            Checks if the user input is an allowed value, 
            if not informs them it's not and askes for input again. 
            */
            if (sc.hasNext("[a-dA-D]")) {
                choice = sc.next().toUpperCase().charAt(0);
            } else {
                System.out.println("Invalid choice, please select again");
                choice = 'z';
            }
            sc.nextLine();
        } while (choice == 'z');
        return choice;
    }
    
}

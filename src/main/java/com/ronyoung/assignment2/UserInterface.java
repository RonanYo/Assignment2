package com.ronyoung.assignment2;

import com.ronyoung.assignment2.Chequing;
import com.ronyoung.assignment2.Savings;
import com.ronyoung.assignment2.AccountData;
import java.math.BigDecimal;
import java.util.Scanner;


public class UserInterface {
    
    private final Scanner sc;
    
    private AccountData savingsBean;
    private AccountData chequingBean; 
    
    private Chequing chequing;
    private Savings savings;
    
    public UserInterface() {
        sc = new Scanner(System.in);
        
        savingsBean = new AccountData();
        chequingBean = new AccountData();
        
        chequing = new Chequing(new BigDecimal("100"), 
                new BigDecimal("0.05"),chequingBean);
        savings = new Savings(new BigDecimal("100"), 
                new BigDecimal("0.05"), savingsBean);
    }
    
    public void perform() {
        
        char choice;
            
        /* 
        Loop to call methods based on user's menu choice and then
        print their results.
        */
        do {
            choice = bankMenu();
            System.out.println("Choice = " + choice);
            switch (choice) {
                
                //If 'A' is selected, calls 
                case 'A' -> {
                    do {
                        choice = savingsMenu();
                        System.out.println("Choice = " + choice);
                        switch (choice) {
                            case 'A' -> {
                                
                                System.out.print("Deposit Amount: ");
                                savings.makeDeposit(sc.nextBigDecimal());
                                                       
                            }
                        
                            case 'B' -> {
                                System.out.print("Withdraw Amount: ");
                                savings.makeWithdraw(sc.nextBigDecimal());
                            }
                            
                            case 'C' -> {
                                
                                savings.doMonthlyReport();
                                
                            }
                            
                            case 'D' -> {
                                
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
                        System.out.println("Choice = " + choice);
                        switch (choice) {
                            case 'A' -> {
                                
                                System.out.print("Deposit Amount: ");
                                chequing.makeDeposit(sc.nextBigDecimal());
                        
                            }
                        
                            case 'B' -> {
                                System.out.print("Withdraw Amount: ");
                                chequing.makeWithdraw(sc.nextBigDecimal());
                            }
                            
                            case 'C' -> {
                                
                                System.out.println(chequing.doMonthlyReport().toString());
                            }
                            
                            case 'D' -> {
                                
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

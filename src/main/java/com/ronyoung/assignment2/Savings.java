package com.ronyoung.assignment2;

import com.ronyoung.assignment2.AccountData;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import java.util.Scanner;

public class Savings {
    
    private AccountData savingsCopy;
    private final AccountData savingsBean;
    
    public Savings(BigDecimal balance, BigDecimal interestRate, AccountData savingsBean ) {
        
        this.savingsBean = savingsBean;
        
        savingsBean.setStartingBalance(balance);
        savingsBean.setCurrentBalance(balance);
        savingsBean.setAnnualInterestRate(interestRate);
    }
    

    public void makeDeposit(BigDecimal depositAmount) {
        
        if (savingsBean.getNumberOfDeposits() == 0) {
            savingsBean.setCurrentBalance(savingsBean.getStartingBalance());
        }
        savingsBean.setNumberOfDeposits(savingsBean.getNumberOfDeposits() + 1);
        
        savingsBean.setTotalOfDeposits(savingsBean.getTotalOfDeposits().add(depositAmount));
        
        savingsBean.setCurrentBalance(savingsBean.getCurrentBalance().add(depositAmount));
        
    }
    
    public boolean makeWithdraw(BigDecimal withdrawAmount) {
        
        if (withdrawAmount.compareTo(savingsBean.getCurrentBalance()) > 0) {
            
            System.out.println("Insufficient funds. Current balance is " + savingsBean.getCurrentBalance() + ".");
            return false;
            
        }
        else {
            
            savingsBean.setNumberOfWithrawals(savingsBean.getNumberOfWithrawals()+ 1);
            savingsBean.setTotalOfWithdrawals(savingsBean.getTotalOfWithdrawals().add(withdrawAmount));

            
            if (savingsBean.getNumberOfWithrawals() > 4) {
                
                savingsBean.setCurrentBalance(savingsBean.getCurrentBalance().subtract(convertToBigDecimal(1)));
                System.out.println("Max number of free withdrawals exceeded, a "
                        + "$1 service fee has been added.");
            }
            
            savingsBean.setCurrentBalance(savingsBean.getCurrentBalance().subtract(withdrawAmount));
            System.out.println("Withdrawal successful, new balance is: $" + 
                    savingsBean.getCurrentBalance());
            
            return true;
        }
    }
    
    public void calculateInterest() {
        
        BigDecimal monthlyInterestRate = 
                savingsBean.getAnnualInterestRate().divide(convertToBigDecimal(12), MathContext.DECIMAL32);
        
        savingsBean.setMonthInterestEarnings(monthlyInterestRate.multiply(savingsBean.getCurrentBalance()));
        savingsBean.setCurrentBalance(savingsBean.getCurrentBalance().add(savingsBean.getMonthInterestEarnings()));
        
    }
    
    public AccountData doMonthlyReport() {
        
        
        savingsBean.setCurrentBalance(savingsBean.getCurrentBalance().subtract(savingsBean.getMonthServiceCharge()));
        
        calculateInterest();
             
        savingsCopy = new AccountData();
        this.savingsCopy = savingsBean;
        
        System.out.println(savingsCopy.toString());
        
        monthlyReset();
        
        return savingsCopy;
        
    }
    
    public void monthlyReset() {
        
        BigDecimal newBalance = savingsBean.getCurrentBalance();
        savingsBean.setStartingBalance(newBalance);
        
        savingsBean.setMonthInterestEarnings(convertToBigDecimal(0));
        savingsBean.setCurrentBalance(convertToBigDecimal(0));
        savingsBean.setMonthServiceCharge(convertToBigDecimal(0));
        savingsBean.setNumberOfDeposits(0);
        savingsBean.setNumberOfWithrawals(0);
        savingsBean.setTotalOfDeposits(convertToBigDecimal(0));
        savingsBean.setTotalOfWithdrawals(convertToBigDecimal(0));
    }
    
    public BigDecimal convertToBigDecimal(float number) {
        
        var newBigDecimal = new BigDecimal(number);
        
        return newBigDecimal;
    }
    
}

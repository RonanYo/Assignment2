package com.ronyoung.assignment2;

import com.ronyoung.assignment2.AccountData;
import java.math.BigDecimal;
import java.math.MathContext;

import java.util.Scanner;

public class Chequing {
    
    private AccountData chequingCopy;
    private final AccountData chequingBean;
    
    public Chequing(BigDecimal balance, BigDecimal annualInterestRate, 
            AccountData chequingBean ) {
        
        this.chequingBean = chequingBean;
        
        chequingBean.setStartingBalance(balance);
        chequingBean.setCurrentBalance(balance);
        chequingBean.setAnnualInterestRate(annualInterestRate);
    }
    

    public void makeDeposit(BigDecimal depositAmount) {
        
        if (chequingBean.getNumberOfDeposits() == 0) {
            chequingBean.setCurrentBalance(chequingBean.getStartingBalance());
        }
        chequingBean.setNumberOfDeposits(chequingBean.getNumberOfDeposits() + 1);
        
        chequingBean.setTotalOfDeposits(chequingBean.getTotalOfDeposits().add(depositAmount));
        
        chequingBean.setCurrentBalance(chequingBean.getCurrentBalance().add(depositAmount));
        
        
    }
    
    public boolean makeWithdraw(BigDecimal withdrawAmount) {
                    
        if (withdrawAmount.compareTo(chequingBean.getCurrentBalance()) > 0) {
            
            System.out.println("Insufficient funds. Current balance is " + chequingBean.getCurrentBalance() + ".");
            return false;
            
        }
        else {
            
            chequingBean.setNumberOfWithrawals(chequingBean.getNumberOfWithrawals()+ 1);            
            chequingBean.setMonthServiceCharge(chequingBean.getMonthServiceCharge().add(convertToBigDecimal(0.5)));
            chequingBean.setCurrentBalance(chequingBean.getCurrentBalance().subtract(convertToBigDecimal(0.5)));
            chequingBean.setTotalOfWithdrawals(chequingBean.getTotalOfWithdrawals().add(withdrawAmount));
                       
            
            chequingBean.setCurrentBalance(chequingBean.getCurrentBalance().subtract(withdrawAmount));
            System.out.println("Withdrawal successful, new balance is: $" + 
                    chequingBean.getCurrentBalance() + ". A service fee of $0.50 was applied");
            
            return true;
        }
        
    }
    
    public void calculateInterest() {
                
        BigDecimal monthlyInterestRate = 
                chequingBean.getAnnualInterestRate().divide(convertToBigDecimal(12), MathContext.DECIMAL32);
        
        chequingBean.setMonthInterestEarnings(monthlyInterestRate.multiply(chequingBean.getCurrentBalance()));
        chequingBean.setCurrentBalance(chequingBean.getCurrentBalance().add(chequingBean.getMonthInterestEarnings()));
        
    }
    
    public AccountData doMonthlyReport() {
        
        chequingBean.setCurrentBalance(chequingBean.getCurrentBalance().subtract(chequingBean.getMonthServiceCharge()));
        
        calculateInterest();
             
        chequingCopy = new AccountData();
        this.chequingCopy = chequingBean;

        
        //System.out.println(chequingCopy.toString());
        
        monthlyReset();
        
        return chequingCopy;
        
    }
    
    public void monthlyReset() {
        
        
        BigDecimal newBalance = chequingBean.getCurrentBalance();
        chequingBean.setStartingBalance(newBalance);
        
        chequingBean.setMonthInterestEarnings(convertToBigDecimal(0));
        chequingBean.setCurrentBalance(convertToBigDecimal(0));
        chequingBean.setMonthServiceCharge(convertToBigDecimal(0));
        chequingBean.setNumberOfDeposits(0);
        chequingBean.setNumberOfWithrawals(0);
        chequingBean.setTotalOfDeposits(convertToBigDecimal(0));
        chequingBean.setTotalOfWithdrawals(convertToBigDecimal(0));
        
    }
    
    public void chequingReportCharge() {
        
        
        chequingBean.setMonthServiceCharge(chequingBean.getMonthServiceCharge().add(convertToBigDecimal(5)));
                
    }
    
    public BigDecimal convertToBigDecimal(double number) {
        
        var newBigDecimal = new BigDecimal(number);
        
        return newBigDecimal;
    }
    
    
}

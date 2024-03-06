package com.ronyoung.assignment2;

import java.math.BigDecimal;

public class AccountData {

    private BigDecimal startingBalance = new BigDecimal(0);
    private BigDecimal currentBalance = new BigDecimal(0);
    private BigDecimal totalOfDeposits = new BigDecimal(0);
    private int numberOfDeposits = 0;
    private BigDecimal totalOfWithdrawals = new BigDecimal(0);
    private int numberOfWithrawals = 0;
    private BigDecimal annualInterestRate = new BigDecimal(0);
    private BigDecimal monthInterestEarnings = new BigDecimal(0);
    private BigDecimal monthServiceCharge = new BigDecimal(0);

    
    
    public AccountData() {
    }

    public AccountData(BigDecimal startingBalance, BigDecimal currentBalance, BigDecimal totalOfDeposits, int numberOfDeposits, BigDecimal totalOfWithdrawals, int numberOfWithrawals, BigDecimal annualInterestRate, BigDecimal monthInterestEarnings, BigDecimal monthServiceCharge) {
        this.startingBalance = startingBalance;
        this.currentBalance = currentBalance;
        this.totalOfDeposits = totalOfDeposits;
        this.numberOfDeposits = numberOfDeposits;
        this.totalOfWithdrawals = totalOfWithdrawals;
        this.numberOfWithrawals = numberOfWithrawals;
        this.annualInterestRate = annualInterestRate;
        this.monthInterestEarnings = monthInterestEarnings;
        this.monthServiceCharge = monthServiceCharge;
    }

    public BigDecimal getStartingBalance() {
        return startingBalance;
    }

    public void setStartingBalance(BigDecimal startingBalance) {
        this.startingBalance = startingBalance;
    }

    public BigDecimal getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(BigDecimal currentBalance) {
        this.currentBalance = currentBalance;
    }

    public BigDecimal getTotalOfDeposits() {
        return totalOfDeposits;
    }

    public void setTotalOfDeposits(BigDecimal totalOfDeposits) {
        this.totalOfDeposits = totalOfDeposits;
    }

    public int getNumberOfDeposits() {
        return numberOfDeposits;
    }

    public void setNumberOfDeposits(int numberOfDeposits) {
        this.numberOfDeposits = numberOfDeposits;
    }

    public BigDecimal getTotalOfWithdrawals() {
        return totalOfWithdrawals;
    }

    public void setTotalOfWithdrawals(BigDecimal totalOfWithdrawals) {
        this.totalOfWithdrawals = totalOfWithdrawals;
    }

    public int getNumberOfWithrawals() {
        return numberOfWithrawals;
    }

    public void setNumberOfWithrawals(int numberOfWithrawals) {
        this.numberOfWithrawals = numberOfWithrawals;
    }

    public BigDecimal getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(BigDecimal annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public BigDecimal getMonthInterestEarnings() {
        return monthInterestEarnings;
    }

    public void setMonthInterestEarnings(BigDecimal monthInterestEarnings) {
        this.monthInterestEarnings = monthInterestEarnings;
    }

    public BigDecimal getMonthServiceCharge() {
        return monthServiceCharge;
    }

    public void setMonthServiceCharge(BigDecimal monthServiceCharge) {
        this.monthServiceCharge = monthServiceCharge;
    }

    @Override
    public String toString() {
        return "AccountData{" + "startingBalance=" + startingBalance + ", currentBalance=" + currentBalance + ", totalOfDeposits=" + totalOfDeposits + ", numberOfDeposits=" + numberOfDeposits + ", totalOfWithdrawals=" + totalOfWithdrawals + ", numberOfWithrawals=" + numberOfWithrawals + ", annualInterestRate=" + annualInterestRate + ", monthInterestEarnings=" + monthInterestEarnings + ", monthServiceCharge=" + monthServiceCharge + '}';
    }
    
    
 
           
}

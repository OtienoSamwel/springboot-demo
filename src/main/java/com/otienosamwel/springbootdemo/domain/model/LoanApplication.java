package com.otienosamwel.springbootdemo.domain.model;

import javax.persistence.*;
import java.time.Duration;
import java.util.Objects;

@Entity
public final class LoanApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int amount;
    @ManyToOne
    private User borrower;
    private int repaymentTerm;
    private double interestRate;

    public LoanApplication() {
    }

    public LoanApplication(
            int amount,
            User borrower,
            int repaymentTerm,
            double interestRate) {

        this.amount = amount;
        this.borrower = borrower;
        this.repaymentTerm = repaymentTerm;
        this.interestRate = interestRate;
    }


    public long getId() {
        return id;
    }

    public int getAmount() {
        return amount;
    }

    public User getBorrower() {
        return borrower;
    }

    public int getRepaymentTerm() {
        return repaymentTerm;
    }

    public double getInterestRate() {
        return interestRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoanApplication that = (LoanApplication) o;
        return amount == that.amount &&
                Double.compare(that.interestRate, interestRate) == 0 &&
                Objects.equals(borrower, that.borrower) &&
                Objects.equals(repaymentTerm, that.repaymentTerm);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, borrower, repaymentTerm, interestRate);
    }

    @Override
    public String toString() {
        return "LoanRequest{" +
                "amount=" + amount +
                ", borrower=" + borrower +
                ", repaymentTerm=" + repaymentTerm +
                ", interestRate=" + interestRate +
                '}';
    }

}



import java.util.Date;

public class Loan {
    // Data fields (Attributes)
    private double annualInterestRate;
    private int numberOfYears;
    private double loanAmount;
    private Date loanDate;

    // No-arg constructor with default values
    public Loan() {
        this(2.5, 1, 1000.0);
    }

    // Constructor with specified interest rate, years, and loan amount
    public Loan(double annualInterestRate, int numberOfYears, double loanAmount) {
        this.annualInterestRate = annualInterestRate;
        this.numberOfYears = numberOfYears;
        this.loanAmount = loanAmount;
        this.loanDate = new Date(); // Automatically set to current date
    }

    // Getter methods
    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public int getNumberOfYears() {
        return numberOfYears;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public Date getLoanDate() {
        return loanDate;
    }

    // Setter methods
    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public void setNumberOfYears(int numberOfYears) {
        this.numberOfYears = numberOfYears;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    // Calculate monthly payment
    public double getMonthlyPayment() {
        double monthlyInterestRate = annualInterestRate / 1200;
        double monthlyPayment = loanAmount * monthlyInterestRate /
                (1 - (1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12)));
        return monthlyPayment;
    }

    // Calculate total payment
    public double getTotalPayment() {
        return getMonthlyPayment() * numberOfYears * 12;
    }
}
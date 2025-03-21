import java.util.*;

public class SavingsAccount extends CheckingAccount{
	protected double interestRate;

	public static void main(String[] args){
		SavingsAccount savings = new SavingsAccount(1000.0, 0.02);
		savings.start();
	}

	public SavingsAccount(double balance, double interestRate){
		super(balance);
		this.interestRate = interestRate;
	}

	public void setInterestRate(double interestRate){
		if(interestRate < 0){
			System.out.println("Invalid, interest rate cannot be negative");
		}
		this.interestRate = interestRate;
	}

	public double interestRate(){
		return interestRate;
	}
	protected void calcInterest(){
		double interestAmount = balance * interestRate;
		setBalance(balance + interestAmount);
		System.out.println("Interest amount: " + interestAmount + ". New balance: " + getBalanceString());
	}
}

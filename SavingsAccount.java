import java.util.*;

public class SavingsAccount extends CheckingAccount{
	protected double interestRate;

	public static void main(String[args]){
		SavingsAccount savings = new SavingsAccount(1000.0, 0.02);
		savings.start()
	}

	public SavingsAccount(double balance, double interestRate){
		super(balance);
		this.interestRate = interestRate;
	}
}

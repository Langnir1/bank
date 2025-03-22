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

	public String menu(){
		return "Savings Account menu:\n" +
		"1) Exit\n" +
		"2) Check balance\n" +
		"3) Deposit\n" +
		"4) Withdraw";
	}

	public void start(){
		Scanner input = new Scanner(System.in);
		int choice;
		boolean keepGoing = true;

		System.out.println("You have entered your Savings Account!");
		System.out.println();

		while(keepGoing){
			System.out.println(menu());
			System.out.println("What would you like to do?: ");
			choice = input.nextInt();

			if(choice == 1){
				System.out.println("Thank you");
				keepGoing = false;
			}
			else if(choice == 2){
				//System.out.println("Balance");
				checkBalance();
			}
			else if(choice == 3){
				//System.out.println("Deposit");
				makeDeposit(input);
			}
			else if(choice == 4){
				//System.out.println("Withdraw");
				makeWithdraw(input);
			}
			else{
				System.out.println("Invalid");
			}
		}
	}
	
}

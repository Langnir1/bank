import java.util.*;

public class CheckingAccount implements hasMenu{
	protected double balance;

	public CheckingAccount(){
		this.balance = 0.0;
	}

	public CheckingAccount(double balance){
		this.balance = balance;
	}

	public static void main(String[] args){
		CheckingAccount account = new CheckingAccount();
		System.out.println("Checking Account: " + account.balance);
		account.start();
	}

	//Need to return a string so this is my attempt. Not sure if System.out would be better.
	public String menu(){
		return "Checking Account menu:\n" +
		"1) Exit\n" +
		"2) Check balance\n" +
		"3) Deposit\n" +
		"4) Withdraw";
	}

	public double getBalance(){
                return balance;
                //Change so that if the input is !double then returns 0
        }

        public String getBalanceString(){
                return String.format("$%.02f", balance);
        }

        public void setBalance(double balance){
                if(balance >= 0){
                        this.balance = balance;
                }
                else{
                        System.out.println("Negative is bad! Don't be in debt!");
                }
        }

	public void start(){
		Scanner input = new Scanner(System.in);
		int choice;
		boolean keepGoing = true;

		System.out.println("You have entered your Checking Account!");
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
	
	public void checkBalance(){
		System.out.println("Your balance is: " + getBalanceString());
	}

	public void makeDeposit(Scanner input){
		System.out.println("How much would you like to deposit? ");
		double amount = input.nextDouble();
		if(amount > 0){
			setBalance(balance + amount);
			System.out.println("Deposited: " + getBalanceString());
		}
		else{
			System.out.println("invalid amount");
		}
	}

	public void makeWithdraw(Scanner input){
		System.out.println("How much would you like to withdraw? ");
		double amount = input.nextDouble();
		if(amount <= 0){
			System.out.println("Invalid amount. Must be higher then zero!");
			return;
		}
		if(amount > balance){
			System.out.println("Inavlid. Your current funds are: " + getBalanceString());
			return;
		}

		setBalance(balance - amount);
		System.out.println("Withdrew: " + getBalanceString());
	}
}



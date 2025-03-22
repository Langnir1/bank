import java.util.*;

public class Customer extends User{
	private CheckingAccount checking;
	private SavingsAccount savings;

	public static void main(String[] args){
		Scanner input = new Scanner(System.in);

		Customer customer = new Customer("testUser", "1111");

		System.out.println("Welcome to Banking");
		boolean keepGoing = false;
		while(!keepGoing){
			System.out.println("Please log in");
			keepGoing = customer.login();
			if(!keepGoing){
				System.out.println("Incorrect");
			}
		}

		System.out.println("Login correct!");
		//System.out.println(menu());
		customer.start();
	}

	public String menu(){
		Scanner input = new Scanner(System.in);

		System.out.println("\n---- Customer Menu ----");
		System.out.println("1. Exit");
		System.out.println("2. Checking Account");
		System.out.println("3. Savings Account");
		System.out.println("4. change PIN");
		System.out.println("5. Report");

		System.out.println("Choose an option: ");
		String choice = input.nextLine();

		return choice;
	}

	public void start(){
		Scanner input = new Scanner(System.in);
		boolean keepGoing = true;

		while(keepGoing){
			String choice = menu();

			if(choice.equals("1")){
				System.out.println("Exit");
				keepGoing = false;
			}
			if(choice.equals("2")){
				System.out.println("Checking account");
				checking.menu();
			}
			if(choice.equals("3")){
				System.out.println("Savings account");
				savings.menu();
			}
			if(choice.equals("4")){
				System.out.println("Change PIN");
				changePin();
			}
			if(choice.equals("5")){
				System.out.println("report");
				System.out.println(getReport());
			}
			//else{
			//	System.out.println("Invalid");
			//}
		}
	}

	public Customer(){
		this.userName = "";
		this.PIN = "";
		this.checking = new CheckingAccount(0.0);
		this.savings = new SavingsAccount(0.0, 0.01);
	}

	public Customer(String userName, String PIN){
		this.userName = userName;
		this.PIN = PIN;
		this.checking = new CheckingAccount(0.0);
		this.savings = new SavingsAccount(0.0, 0.01);
	}

	public void changePin(){
		Scanner input = new Scanner(System.in);

		System.out.println("Enter currenct Pin: ");
		String currentPin = input.nextLine();

		if(currentPin.equals(this.PIN)){
			System.out.println("Enter your new PIN: ");
			String newPin = input.nextLine();

			this.PIN = newPin;
			System.out.println("Your PIN has been changed");
		}
		else{
			System.out.println("Incorrect PIN");
		}
	}
	public String getReport(){
		String report = "---- Customer Report ----\n";
		report += "Username: " + this.userName + "\n";
		report += "Checking Account Balance: $" + this.checking.getBalance() + "\n";
		report += "Savings Account Balance $" + this.savings.getBalance() + "\n";
		return report;
	}
	
}

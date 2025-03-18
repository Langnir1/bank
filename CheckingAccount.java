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

	public void start(){
		System.out.println("You have entered your Checking Account!");
		System.out.println();
		System.out.println(menu());
	}
}



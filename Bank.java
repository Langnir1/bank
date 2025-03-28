import java.util.Scanner;
import java.util.ArrayList;
//Comment on the change to Scanner and ArrayList over util.*
//I looked up what the difference was and found a response that implied that the .* impacts the compile time. I figured it might be a good idea to try and specify
//which packages I'm using.

public class Bank implements hasMenu{
	private Admin admin;
	private ArrayList<Customer> customers;

	public static void main(Strings[] args){
		Bank bank = new Bank();
		bank.start();
	}

	public Bank(){
		this.admin = new Admin();
		this.customer = new ArrayList<>();
	}

	public String menu(){
		System.out.println("\n----Bank Menu----");
		System.out.println("1) Exit");
		System.out.println("2) Admin Login");
		System.out.println("3) Customer Login");
		System.out.println("Action: ");
	}

	public void start(){
		Scanner input = new Scanner(System.in);
		boolean keepGoing = true;

		while(keepGoing){
			System.out.println(menu());
			String choice = input.nextLine();

			if(choice.equals("1")){
				System.out.println("Goodbye");
				keepGoing = false;
			}
			else if(choice.equals("2")){
				System.out.println("Admin login selected");
			}
			else if(choice.equals("3")){
				System.out.println("Customer login selected");
			}
			else{
				System.out.println("Invalid response");
			}
		}
	}
}


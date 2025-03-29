import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;
//Comment on the change to Scanner and ArrayList over util.*
//I looked up what the difference was and found a response that implied that the .* impacts the compile time. I figured it might be a good idea to try and specify
//which packages I'm using.

public class Bank implements hasMenu{
	private Admin admin;
	private ArrayList<Customer> customers;
	private Customer currentCustomer;

	public static void main(String[] args){
		Bank bank = new Bank();
		bank.start();

		bank.loadCustomers();

		bank.customers.add(new Customer("testUser", "1111"));
		bank.customers.add(new Customer("johnDoe", "1234"));
		bank.saveCustomers();
	}

	@SuppressWarnings("unchecked")
	public void saveCustomers(){
		try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("customers.dat"))){
		out.writeObject(customers);
		}
		catch(Exception e){
			//For self reference, Exception e is a general catch that covers, I think, all errors. Since I don't know what errors to catch, I'm just trying this. In other words, learn errors me!
			System.out.println("Error saving customers");
		}
	}

	@SuppressWarnings("unchecked")
	public void loadCustomers(){
		File file = new File("customers.dat");
		try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("customers.dat"))){
		customers = (ArrayList<Customer>) in.readObject();
		}
		catch(Exception e){
			System.out.println("Error loading customers");
		}
	}

	public Bank(){
		this.admin = new Admin();
		this.customers = new ArrayList<>();
	}

	public String  menu(){
		Scanner input = new Scanner(System.in);
		System.out.println("\n----Bank Menu----");
		System.out.println("1) Exit");
		System.out.println("2) Admin Login");
		System.out.println("3) Customer Login");
		System.out.println("Action: ");
		
		String choice = input.nextLine();
		return choice;
	}

	public void start(){
		//Scanner input = new Scanner(System.in);
		boolean keepGoing = true;

		while(keepGoing){
			//System.out.println(menu());
			String choice = menu();

			if(choice.equals("1")){
				System.out.println("Goodbye");
				keepGoing = false;
			}
			else if(choice.equals("2")){
				System.out.println("Admin login selected");
				adminStart();
			}
			else if(choice.equals("3")){
				System.out.println("Customer login selected");
				customerLogin();
			}
			else{
				System.out.println("Invalid response");
			}
		}
	}

	private void adminStart(){
		Scanner input = new Scanner(System.in);
		boolean keepGoing = true;
		
		while(keepGoing){
			System.out.println("\n----Admin Menu----");
			System.out.println("1) Exit Admin mode");
			System.out.println("2) Customer Report");
			System.out.println("3) Add User");
			System.out.println("4) Apply Interest");
			System.out.println("Action: ");

			String choice = input.nextLine();

			if(choice.equals("1")){
				System.out.println("Exiting Admin mode");
				keepGoing = false;
			}
			else if(choice.equals("2")){
				System.out.println("Customer Report");
				fullCustomerReport();
			}
			else if (choice.equals("3")){
				System.out.println("Add User");
				addUser();
			}
			else if(choice.equals("4")){
				System.out.println("Apply Interest");
				applyInterest();
			}
			else{
				System.out.println("Invalid");
			}
		}
	}

	private void fullCustomerReport(){
		System.out.println("\n----Customer Report----");
		for(Customer c : customers){
			System.out.println(c.getReport());
		}
	}

	private void addUser(){
		Scanner input = new Scanner(System.in);
		System.out.println("Enter your Username: ");
		String userName = input.nextLine();
		System.out.println("Enter your PIN: ");
		String PIN = input.nextLine();

		Customer newCustomer = new Customer(userName, PIN);
		customers.add(newCustomer);
		System.out.println("Welcome " + newCustomer.getUserName());
	}

	private void applyInterest(){
		for(Customer c : customers){
			c.getSavings().calcInterest();
		}
		System.out.println("Interest applied");
	}

	private void customerLogin(){
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Username: ");
		String userName = input.nextLine();
		System.out.println("Enter PIN: ");
		String PIN = input.nextLine();

		currentCustomer = null;
		for(Customer c : customers){
			if(c.login(userName,PIN)){
				currentCustomer = c;
			}
		}
		if (currentCustomer != null){
			System.out.println("Login Successful!");
			currentCustomer.start();
		} 
		else{
			System.out.println("Login failed");	
		}
	}
}


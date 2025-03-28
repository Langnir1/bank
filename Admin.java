import java.util.*;

public class Admin extends User{

	public Admin(){
		this.userName = "admin";
		this.PIN = "0000";
	}
	
	public static void main(String[] args){
		Admin admin = new Admin();
		System.out.println(admin.getReport());
	}

	public String menu(){
		Scanner input = new Scanner(System.in);

		System.out.println("\n----Admin Menu----");
		System.out.println("1) Exit");
		System.out.println("2) Customer report");
		System.out.println("3) Add Customer");
		System.out.println("3) Apply Interest Rate");
		System.out.println("What would you like to do: ");

		return input.nextLine();
	}

	public void start(){
		
	}

	public String getReport(){
		return "Admin: " + this.userName + ", PIN: " + this.PIN;
	}
}

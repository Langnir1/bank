import java.io.Serializable;
import java.util.*;

public abstract class User implements hasMenu, Serializable{
	protected String userName;
	protected String PIN;

	public String getUserName(){
		return userName;
	}	

	public void setUserName(String userName){
		this.userName = userName;
	}

	public String getPIN(){
		return PIN;
	}

	public void setPIN(){
		this.PIN = PIN;
	}

	public boolean login(String userName, String PIN){
		return this.userName.equals(userName) && this.PIN.equals(PIN);
	}

	public boolean login(){
		Scanner input = new Scanner(System.in);

		System.out.println("Enter username: ");
		String UserInput = input.nextLine();

		System.out.println("Enter PIN: ");
		String PINInput = input.nextLine();

		return login(UserInput, PINInput);
	}

	public abstract String getReport();
}

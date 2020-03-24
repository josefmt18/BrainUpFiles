import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Creating and Checking Users
 * 
 * @author zfp736 - BrainUP
 */
public class SignUp {

	/**
	 * Adds a user and his info to the account csv file
	 * 
	 * @param username : String
	 * @param password : String
	 * @param firstName : String
	 * @param lastName : String
	 */
	public boolean addAccount(String username, String password, String firstName, String lastName) {
		//checks to see if the username is already in use
		if(checkForAccount(username)){
			System.out.println("This username already exists, try another one!");
			return false;
		}
		//adds a users info to the accounts csv file
		try {
			File users = new File("accounts.csv");
			FileWriter create = new FileWriter(users, true);
			
			create.write(username + "," + password + "," + firstName + "," + lastName + "\n");
			
			create.close();
			
		} catch(IOException e) {
			System.out.println("Something went wrong when adding account!");
		}
		return true;
	}
	
	/**
	 * Checks if the username is already in use
	 * 
	 * @param username : String
	 * @return check : boolean
	 */
	public boolean checkForAccount(String username) {
		boolean check = false;
		String[] data;
		String input;
		
		try {
			File users = new File("accounts.csv");
			Scanner scan = new Scanner(users);
		
			while(scan.hasNext()) {
				input = scan.nextLine();
				data = input.split(",");
			
				if(data[0].equals(username)) {
					check = true;
					break;
				}
			}
			scan.close();
			
		} catch(FileNotFoundException e) {
			System.out.println("Account File not found :(");
		}
		return check;
	}
	
}

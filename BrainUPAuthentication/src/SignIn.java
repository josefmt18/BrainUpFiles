import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * BrainUp
 * Checks if login information is a valid user
 * 
 * @author josemorales
 * @author zfp736
 */

public class SignIn {
	
	/**
	 * Authenticates the Username and Password for User
	 * returns true if info is authentic for an account
	 * returns false if info doesn't match an account
	 * 
	 * @param username
	 * @param password
	 * @return boolean
	 */
	public boolean logIn(String username, String password) {
		String line;
		String[] data;
		
		try {
			File users = new File("accounts.csv");
			@SuppressWarnings("resource")
			Scanner scans = new Scanner(users);
		
			while(scans.hasNext()) {
				line = scans.nextLine();
				if(line.isEmpty()) {
					continue;
				}
				data = line.split(",");
				if(data[0].equals(username)) {
					if(data[1].equals(password)) {
						return true;
					}
				}
			}
			scans.close();
			
		}catch(FileNotFoundException e) {
			System.out.println("File accounts.csv not found");
		}
		return false;
	}

}

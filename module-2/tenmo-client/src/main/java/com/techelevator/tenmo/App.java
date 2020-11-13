package com.techelevator.tenmo;

import com.techelevator.tenmo.models.Account;
import com.techelevator.tenmo.models.AuthenticatedUser;
import com.techelevator.tenmo.models.Transfer;
import com.techelevator.tenmo.models.User;
import com.techelevator.tenmo.models.UserCredentials;
import com.techelevator.tenmo.services.AuthenticationService;
import com.techelevator.tenmo.services.AuthenticationServiceException;
import com.techelevator.tenmo.services.BrokeUserException;
import com.techelevator.view.ConsoleService;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.List;

import javax.naming.NameNotFoundException;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;



public class App {

private static final String API_BASE_URL = "http://localhost:8080/";
    
    private static final String MENU_OPTION_EXIT = "Exit";
    private static final String LOGIN_MENU_OPTION_REGISTER = "Register";
	private static final String LOGIN_MENU_OPTION_LOGIN = "Login";
	private static final String[] LOGIN_MENU_OPTIONS = { LOGIN_MENU_OPTION_REGISTER, LOGIN_MENU_OPTION_LOGIN, MENU_OPTION_EXIT };
	private static final String MAIN_MENU_OPTION_VIEW_BALANCE = "View your current balance";
	private static final String MAIN_MENU_OPTION_SEND_BUCKS = "Send TE bucks";
	private static final String MAIN_MENU_OPTION_VIEW_PAST_TRANSFERS = "View your past transfers";
	private static final String MAIN_MENU_OPTION_REQUEST_BUCKS = "Request TE bucks";
	private static final String MAIN_MENU_OPTION_VIEW_PENDING_REQUESTS = "View your pending requests";
	private static final String MAIN_MENU_OPTION_LOGIN = "Login as different user";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_VIEW_BALANCE, MAIN_MENU_OPTION_SEND_BUCKS, MAIN_MENU_OPTION_VIEW_PAST_TRANSFERS, MAIN_MENU_OPTION_REQUEST_BUCKS, MAIN_MENU_OPTION_VIEW_PENDING_REQUESTS, MAIN_MENU_OPTION_LOGIN, MENU_OPTION_EXIT};
	
    private AuthenticatedUser currentUser;
    private ConsoleService console;
    private AuthenticationService authenticationService;
    private Account account;
    private Transfer aTransfer;
	private RestTemplate apiCall = new RestTemplate();
	
	public double money;
    
    

    public static void main(String[] args) {
    	App app = new App(new ConsoleService(System.in, System.out), new AuthenticationService(API_BASE_URL));
    	app.run();
    }

    public App(ConsoleService console, AuthenticationService authenticationService) {
		this.console = console;
		this.authenticationService = authenticationService;
	}

	public void run() {
		System.out.println("*********************");
		System.out.println("* Welcome to TEnmo! *");
		System.out.println("*********************");
		
		registerAndLogin();
		mainMenu();
	}

	private void mainMenu() {
		while(true) {
			String choice = (String)console.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			if(MAIN_MENU_OPTION_VIEW_BALANCE.equals(choice)) {
				viewCurrentBalance();
			} else if(MAIN_MENU_OPTION_VIEW_PAST_TRANSFERS.equals(choice)) {
				viewTransferHistory();
			} else if(MAIN_MENU_OPTION_VIEW_PENDING_REQUESTS.equals(choice)) {
				viewPendingRequests();
			} else if(MAIN_MENU_OPTION_SEND_BUCKS.equals(choice)) {
				sendBucks();
			} else if(MAIN_MENU_OPTION_REQUEST_BUCKS.equals(choice)) {
				requestBucks();
			} else if(MAIN_MENU_OPTION_LOGIN.equals(choice)) {
				login();
			} else {
				// the only other option on the main menu is to exit
				exitProgram();
			}
		}
	}
	
	/*********************************************
	 * 
	 * As an authenticated user of the system, 
	 * I need to be able to see my Account Balance.
	 * 
	 *********************************************/

	private void viewCurrentBalance() {
		User user = currentUser.getUser();
		System.out.println("View Current Balance");
		
		Account accounts = apiCall.getForObject(API_BASE_URL + "accounts/" + user.getId(), Account.class);
		// ResponseEntity<Account> responseEntity = apiCall.getForEntity(API_BASE_URL + "accounts", Account.class);
		// double currentBalance =  (responseEntity.getBody().getBalance());
		// Money formatted Correctly
		double balance = accounts.getBalance();
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		System.out.println("Your current account balance is: " + formatter.format(balance));
		
		
	}
	
	/*********************************************
   	 * method to view the transfer history 
   	 * 
   	 * used before sending or requesting a transfer 
   	 *********************************************/

	private void viewTransferHistory() {
		User user = currentUser.getUser();
		Account account = new Account();
		System.out.println("View transfer history");
		
		account = apiCall.getForObject(API_BASE_URL + "accounts/" + user.getId(), Account.class);
		int accountId = account.getAccountId();
		
		ResponseEntity<Transfer[]> responseEntity = apiCall.getForEntity(API_BASE_URL + "transfers/accounts/" + accountId, Transfer[].class);
		List<Transfer> currentTransfers = Arrays.asList(responseEntity.getBody());
		
		System.out.println("Transaction History: ");
		printTransfers(currentTransfers);
	}
	
	/*********************************************
   	 * Method to view pending request 
   	 *********************************************/

	private void viewPendingRequests() {
		// To do, return only pending request
		User user = currentUser.getUser();
		Account account = new Account();
		System.out.println("View Pending Request");
		
		account = apiCall.getForObject(API_BASE_URL + "accounts/" + user.getId(), Account.class);
		int accountId = account.getAccountId();
		
		ResponseEntity<Transfer[]> responseEntity = apiCall.getForEntity(API_BASE_URL + "transfers/accounts/" + accountId, Transfer[].class);
		List<Transfer> pendingTransfers = Arrays.asList(responseEntity.getBody());
		
		System.out.println("Pending Request: ");
		printTransfersByStatus(pendingTransfers, 1);
		
		int transferId = requestTransferId(pendingTransfers);
	
		ResponseEntity<User[]> responseEntitys = apiCall.getForEntity(API_BASE_URL + "users", User[].class);
		List<User> users = Arrays.asList(responseEntitys.getBody());
		
		// Instead of asking for the user id get it automatically
		// Prompt user for user to transfer money to and return result
		int userId = (int)grabTransferID(pendingTransfers, 1, transferId);
		
		// how can we call the sendBucks method here to send the amount requested
		
		approveRejectOrNone(userId);
		
	}
	
	
	
	/*********************************************
   	 * Method to send money
   	 * make sure the user id is valid
   	 * make sure the amt is valid
   	 *********************************************/

	private void sendBucks() {

		User user = currentUser.getUser();

		ResponseEntity<User[]> responseEntity = apiCall.getForEntity(API_BASE_URL + "users", User[].class);
		List<User> users = Arrays.asList(responseEntity.getBody());
		
		// Prompt user for user to transfer money to and return result
		int userId = requestUserId(users);
		// Exit method if user enters 0
		if(userId == 0) {
			System.out.println("Exiting User Selection");
			return;
		}
		
		// Prompt user for money to be transfered and return result
		money = requestMoneyToSend(userId);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		// Create a transfer object to pass through the entity used in the API call
		Transfer entityTransfer = new Transfer();
		
		if(money > apiCall.getForObject(API_BASE_URL + "accounts/" + user.getId(), Account.class).getBalance()) {
			System.out.println("Money was greater than balance.  Send a lower amount next time?");
			// Create the transfer and set status to rejected since the user is poor
			entityTransfer = initTransfer(userId, user.getId(), money, 3, 2);
		}
		else {
			// Create the transfer and set status to accepted since the user has enough money
			entityTransfer = initTransfer(userId, user.getId(), money, 2, 2);
		}
		
		HttpEntity anEntity = new HttpEntity(entityTransfer, headers);
		Transfer transfer = apiCall.postForObject(API_BASE_URL + "transfers", anEntity, Transfer.class);
	}
	
	/*********************************************
   	 * Method to initialize a transfer
   	 *********************************************/
	
	private Transfer initTransfer(long toId, long fromId, double amount, int status, int type) {
		Transfer transfer = new Transfer();
		transfer.setAccountFrom((int)fromId);
		transfer.setAccountTo((int)toId);
		transfer.setAmount(amount);
		transfer.setTransferStatusId(status);
		transfer.setTransferTypeId(type);
		return transfer;
	}
	
	/*********************************************
   	 * Method to request buck (BONUS)
   	 *********************************************/

	private void requestBucks() {
		User user = currentUser.getUser();
		// Get a list of users
		ResponseEntity<User[]> responseEntity = apiCall.getForEntity(API_BASE_URL + "users", User[].class);
		List<User> users = Arrays.asList(responseEntity.getBody());
		
		// Get the user id
		int userId = requestUserId(users);
		// Exit method if user enters 0
		if(userId == 0) {
			System.out.println("Exiting User Selection");
			return;
		}
		
		double money = requestMoneyToRequest(userId);
		
		// Make the entity
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		// Create a transfer object to pass through the entity used in the API call
		Transfer entityTransfer = new Transfer();
		
		if(money > apiCall.getForObject(API_BASE_URL + "accounts/" + user.getId(), Account.class).getBalance()) {
			System.out.println("Money was greater than balance.  Send a lower amount next time?");
			// Create the transfer and set status to rejected since the user is poor
			entityTransfer = initTransfer(user.getId(), userId, money, 3, 1);
		}
		else {
			// Create the transfer and set status to accepted since the user has enough money
			entityTransfer = initTransfer(user.getId(), userId, money, 1, 1);
		}
		
		HttpEntity anEntity = new HttpEntity(entityTransfer, headers);
		Transfer transfer = apiCall.postForObject(API_BASE_URL + "transfers", anEntity, Transfer.class);
		
		
	}
	/*********************************************
   	 * Method to request Transfer Id 
   	 *********************************************/
	
	private int requestTransferId(List<Transfer> pendingTransfers) {
		int transferId = console.getUserInputInteger("Please enter transfer number to approve/reject (0 to cancel)");
		// if the user picked a valid account let them transfer the money
		while (transferId < 0 || transferId > pendingTransfers.size()) {
			System.out.println("The id entered wasn't valid try again");
			transferId = console.getUserInputInteger("Please enter transfer number to approve/reject (0 to cancel)");
		}
		return transferId;
	}
	
	/*********************************************
   	 * Method to approve Reject or Don't approve or reject
   	 *********************************************/
	
	private void approveRejectOrNone(int userId) {
		User user = currentUser.getUser();
		
		String[] options = {"Don't Approve or Reject", "Approve", "Reject"};
		for (int i = 0; i < 3; i++) {
			System.out.println(i + ": " + options[i]);
		}
		int transChoose = console.getUserInputInteger("Please Choose an option");
		int statusCode = 0;
		if (transChoose == 0) {
			statusCode = 1;
		} else if (transChoose == 1) {
			statusCode = 2;
		} else if (transChoose == 3) {
			statusCode = 3;
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		// Create a transfer object to pass through the entity used in the API call
		Transfer entityTransfer = new Transfer();
		
		if(money > apiCall.getForObject(API_BASE_URL + "accounts/" + user.getId(), Account.class).getBalance()) {
			System.out.println("Money was greater than balance.  Send a lower amount next time?");
			// Create the transfer and set status to rejected since the user is poor
			entityTransfer = initTransfer(userId, user.getId(), money, statusCode, 2);
		}
		else {
			// Create the transfer and set status to accepted since the user has enough money
			entityTransfer = initTransfer(userId, user.getId(), money, statusCode, 2);
		}
		
		HttpEntity anEntity = new HttpEntity(entityTransfer, headers);
		Transfer transfer = apiCall.postForObject(API_BASE_URL + "transfers", anEntity, Transfer.class);
	}
	
	/*********************************************
   	 * Method to request an exist ID from a list of users
   	 * Prompts for user input
   	 * Repeats until a valid id, or 0 is entered
   	 *********************************************/
	
	private int requestUserId(List<User> users) {
		// Print a list of users and ask the user to select one
		printUsers(users);
		int userId = console.getUserInputInteger("Enter ID of user you are requesting from (0 to cancel)");
		// if the user picked a valid account let them transfer the money
		while (userId < 0 || userId > users.size()) {
			System.out.println("The id entered wasn't valid try again");
			userId = console.getUserInputInteger("Please select an user");
		}
		return userId;
	}
	
	/*********************************************
   	 * Method to request an amount of money to be sent from user
   	 * will repeat until user enters a positive value
   	 *********************************************/
	
	private double requestMoneyToSend(int userId) {
		
		double money = Double.parseDouble((String)console.getUserInput("How much money would you like to send to User #" + userId));
		
		while (money <= 0) {
			System.out.println("Do not enter a negetive amount of money to transfer!");
			money = Double.parseDouble((String)console.getUserInput("How much money would you like to send to User #" + userId));
		}
		return money;
	}
	
	/*********************************************
   	 * Method to request an amount of money to be sent from user
   	 * will repeat until user enters a positive value
   	 *********************************************/
	
	private double getTransferAmount(List<Transfer> transfers) {
		if(transfers.size() > 0) {
			for(Transfer aTransfer : transfers) {
				return aTransfer.getAmount();
			}
		}
		return aTransfer.getAmount();
	}
	
	/*********************************************
   	 * Method to request an amount of money to be sent from user
   	 * will repeat until user enters a positive value
   	 *********************************************/
	
	private double requestMoneyToRequest(int userId) {
		
		double money = Double.parseDouble((String)console.getUserInput("How much money would you like to request From User #" + userId));
		
		while (money <= 0) {
			System.out.println("Do not enter a negetive amount of money to transfer!");
			money = Double.parseDouble((String)console.getUserInput("How much money would you like to request From User #" + userId));
		}
		return money;
	}
	
	/*********************************************
   	 * Method to print transfers in a readable format
   	 *********************************************/
	
	private void printTransfers(List<Transfer> transfers) {
		System.out.println("___________________________________________________");
		System.out.println("Transfers");
		if(transfers.size() > 0) {
			for(Transfer aTransfer : transfers) {
				System.out.print(aTransfer.toString());
			}
		}
		
		
	}
	
	/*********************************************
   	 * Method to print transfers that are currently pending
   	 *********************************************/
	
	private void printTransfersByStatus(List<Transfer> transfers, int a) {
		System.out.println("___________________________________________________");
		System.out.println("Transfers");
		int i = 0;
		for(Transfer aTransfer : transfers) {
			if (aTransfer.getTransferStatusId() == a) {
				i++;
				System.out.print(aTransfer.toString());
				System.out.println("Transfer Number: " + i);
			}
		}
	}
		
	/*********************************************
   	 * Method to print transfers that are currently pending
   	 *********************************************/
	
	public double grabTransferID(List<Transfer> transfers, int a, int b) {
		for(Transfer aTransfer : transfers) {
			// Check to see if it's pending
			if (aTransfer.getTransferStatusId() == a) {
				// Check to see if it's the correct transfer
				if (aTransfer.getTransferId() == b) {
					return aTransfer.getAccountFrom();
				}
					
			}
		}
		return aTransfer.getAccountFrom();
	
		
		
		
	}
	
	/*********************************************
   	 * Method to print users in a readable format
   	 *********************************************/
	
	private void printUsers(List<User> users) {
		System.out.println("-------------------------------------------");
		System.out.println("Users");
		System.out.println("Id - Name");
		System.out.println("-------------------------------------------");
		if(users.size() > 0) {
			System.out.println("Printing out all registered users.");
			for(User anUser : users) {
				System.out.println(anUser.getId() + " - " + anUser.toString());
			}
			System.out.println("-------------------------------------------");
		}
		else {
			System.out.println("No users found");
		}
	}
	
	/*********************************************
   	 * Graceful exit
   	 *********************************************/
	
	private void exitProgram() {
		
		System.out.print("Exiting");
		for (int i = 0; i < 3; i++) {
			
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.print(".");
			
		}
		System.out.println("\n***************************");
		System.out.println("* Thanks for using TEnmo! *");
		System.out.println("***************************");
		System.exit(0);
	}


	
	/*********************************************
   	 * Methods below came with the project don't change!
   	 *********************************************/
	
	private void registerAndLogin() {
		while(!isAuthenticated()) {
			String choice = (String)console.getChoiceFromOptions(LOGIN_MENU_OPTIONS);
			if (LOGIN_MENU_OPTION_LOGIN.equals(choice)) {
				login();
			} else if (LOGIN_MENU_OPTION_REGISTER.equals(choice)) {
				register();
			} else {
				// the only other option on the login menu is to exit
				exitProgram();
			}
		}
	}

	private boolean isAuthenticated() {
		return currentUser != null;
	}

	private void register() {
		System.out.println("Please register a new user account");
		boolean isRegistered = false;
        while (!isRegistered) //will keep looping until user is registered
        {
            UserCredentials credentials = collectUserCredentials();
            try {
            	authenticationService.register(credentials);
            	isRegistered = true;
            	System.out.println("Registration successful. You can now login.");
            } catch(AuthenticationServiceException e) {
            	System.out.println("REGISTRATION ERROR: "+e.getMessage());
				System.out.println("Please attempt to register again.");
            }
        }
	}

	private void login() {
		System.out.println("Please log in");
		currentUser = null;
		while (currentUser == null) //will keep looping until user is logged in
		{
			UserCredentials credentials = collectUserCredentials();
		    try {
				currentUser = authenticationService.login(credentials);
			} catch (AuthenticationServiceException e) {
				System.out.println("LOGIN ERROR: "+e.getMessage());
				System.out.println("Please attempt to login again.");
			}
		}
	}
	
	private UserCredentials collectUserCredentials() {
		String username = console.getUserInput("Username");
		String password = console.getUserInput("Password");
		return new UserCredentials(username, password);
	}
}

package bankAdministration;

import java.util.Scanner;

public class Main {
	
	BankCount accounts[];
	int accountsNumber = 0;

	public static void main(String[] args) {
		Main exercise = new Main();
		exercise.menu();

	}
	
	public void menu(){
		int option = 0;
		accounts = new BankCount[100];
		Scanner keyboard = new Scanner(System.in);
		
		float balance = 0;
		String name;
		
		
		System.out.println("***Welcome to the bank administration***");
		do{
			System.out.println("1. Create an account");
			System.out.println("2. See all accounts data");
			System.out.println("3. Do a operation");
			System.out.println("0. Exit");
			
			option = keyboard.nextInt(); keyboard.nextLine();
			
			switch (option){
			
			case 1:
				System.out.print("Introduce the name: ");
				name = keyboard.nextLine();
				System.out.print("Introduce the balance: ");
				balance = keyboard.nextFloat(); keyboard.nextLine();
				accounts[accountsNumber] = new BankCount(accountsNumber, name, balance);
				System.out.println("Account created");
				System.out.println("Account number: "+accountsNumber);
				System.out.println("**************************");
				accountsNumber++;
				break;
			case 2:
				
				for(int i=0; i<accountsNumber; i++){
					accounts[i].seeData();
					System.out.println("**************************");
				}
				
				break;
			case 3:
				countMenu();
				break;
			
			}
			
		}while (option!=0);
	}
	
	public void countMenu(){
		Scanner keyboard = new Scanner (System.in);
		int option = 0;
		int account = 0, destinationAccount = 0;
		float money = 0;
		
		do{
		System.out.print("Introduce the account number: ");
		account = keyboard.nextInt(); keyboard.nextLine();
		}while((account<0)||(account>=100));
		
		do{
			System.out.println("1. Introduce money");
			System.out.println("2. Take money");
			System.out.println("3. See the account balance");
			System.out.println("4. Do a transference");
			System.out.println("0. Exit");
		
			option = keyboard.nextInt(); keyboard.nextLine();
			
			switch (option){	
			case 1:
				System.out.print("How many money: ");
				money = keyboard.nextFloat(); keyboard.nextLine();
				accounts[account].modifyBalance(money);
				System.out.println("Balance: "+accounts[account].getBalance());
			break;
			case 2:
				System.out.print("How many money: ");
				money = keyboard.nextFloat(); keyboard.nextLine();
				accounts[account].modifyBalance(-money);
				System.out.println("Balance: "+accounts[account].getBalance());
			break;
			case 3:
				System.out.println("Balance: "+accounts[account].getBalance());
			break;
			case 4:
				do{
					System.out.print("Introduce the destination account number: ");
					destinationAccount = keyboard.nextInt(); keyboard.nextLine();
				}while((destinationAccount<0)||(destinationAccount>=100));
			
				System.out.print("How many money: ");
				money = keyboard.nextFloat(); keyboard.nextLine();
			
				accounts[account].modifyBalance(-money);
				accounts[destinationAccount].modifyBalance(money);
			break;
		}
			
		}while (option!=0);
	}

}

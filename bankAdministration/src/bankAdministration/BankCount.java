package bankAdministration;

public class BankCount {
	int countNumber;
	String name;
	float balance;
	
	public BankCount(int countNumber, String name, float balance){
		this.setCountNumber(countNumber);
		this.setName(name);
		this.setBalance(balance);
		
	}
	
	public void seeData(){
		System.out.println("Account number: " +getCountNumber());
		System.out.println("Account owner: " +getName());
		System.out.println("Account balance: " +getBalance());
	}
	
	public int getCountNumber() {
		return countNumber;
	}
	public void setCountNumber(int countNumber) {
		this.countNumber = countNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	
	public void modifyBalance(float money){
		this.balance = this.balance + money;
	}
	
}

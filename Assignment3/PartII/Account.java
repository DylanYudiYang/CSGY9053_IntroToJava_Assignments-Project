//Yudi Yang, Section I, Dean Christakos, 2023.2.15, A3p2
public class Account {
	private static int account_count = 0;
	private double balance = 1000;
	private int id;
	
	public Account() {
		this.id = ++account_count;
	}
	
	public Account(double startingBalance) {
		this.id = ++account_count;
		this.balance = startingBalance;
	}
	
	public boolean withdraw(double amount) {
		if (amount <= balance ) {
			this.balance -= amount;
			return true;
		}
		else return false;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void deposit(double amount) {
		this.balance += amount;
	}
	
	public int getId() {
		return id;
	}
}

package banking;

public class Account {

    protected String accountNumber;
    protected String name;
    protected int balance;
    protected double interestRate;

    public Account(String accountNumber, String name, int balance) {
	    this.accountNumber = accountNumber;
	    this.name = name;
	    this.balance = balance;
	    this.interestRate = interestRate;
    }
    
    public String getName() {
    	return name;
    }
    public int getBalance() {
    	return balance;
    }
    public String getAccountNumber() {
	    return accountNumber;
    }

    public void deposit(int amount) {
	    balance += amount;
    }

    public void withdraw(int amount) {
	    balance -= amount;
    }
    
	public void showAccountInfo() {
	    System.out.println("계좌번호: " + accountNumber);
	    System.out.println("이름: " + name);
	    System.out.println("잔액: " + balance);
	    System.out.println();
	}
}


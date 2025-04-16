package banking;

public class NormalAccount extends Account {
	private int  interestRate;
	
	public NormalAccount(String accNum, String name , int balance, int interestRate) {
			super(accNum, name, balance);
			this.interestRate = interestRate;
	}
	
	public int getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(int interestRate) {
		this.interestRate = interestRate;
	}
	@Override
	public void showAccountInfo() {
		System.out.println("계좌번호>" + getAccountNumber());
		System.out.println("고객이름>" + getName());
		System.out.println("잔고>" + getBalance());
		System.out.println("기본이자>" + interestRate + "%");
	}

				
	@Override
	public String toString() {
		 return super.toString() + ", 이자율: " + interestRate + "%"; 
	}

}

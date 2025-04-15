package banking;

public class NormalAccount extends Account {
	private int  interestRate;
	
	public NormalAccount(String accNum, String name , int balance, int interestRate) {
			super(accNum,name,balance);
			this.interestRate = interestRate;
	}
	
	public int getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(int interestRate) {
		this.interestRate = interestRate;
	}

				
	@Override
	public String toString() {
		 return super.toString() + ", 이자율: " + interestRate + "%"; 
	}

}

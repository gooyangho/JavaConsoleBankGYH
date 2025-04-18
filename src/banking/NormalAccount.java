package banking;

public class NormalAccount extends Account {
	private int  interestRate;
	
	public NormalAccount(String accNum, String name , int balance, int interestRate) {
			super(accNum, name, balance,interestRate);
			this.interestRate = interestRate;
	}
	
	public int getInterestRate() { //이자율반환
		return interestRate;
	}
	public void setInterestRate(int interestRate) { //이자율 설정
		this.interestRate = interestRate;
	}
	@Override
	public void showAccountInfo() {
		System.out.print("계좌번호:" + getAccountNumber() + ", ");
		System.out.print("고객이름:" + getName() + ", ");
		System.out.print("잔고:" + getBalance() + "\n");
		System.out.print("기본이자:" + getInterestRate() + "%,");
		
	}
	
				
	@Override
	public String toString() { //객체의 문자열표현
		 return super.toString() + ", 이자율: " + interestRate + "%"; 
	} //super.toSting 부모클래스 Account , toString 호출하여 문자열 반환
	  //interestRate를 추가하여 이계좌 이자율 포함 문자열 반환

}

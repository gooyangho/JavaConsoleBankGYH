package banking;

public class HighCreditAccount extends NormalAccount {
	private String CreditGrade;
	
	public HighCreditAccount(String accNum, String name, int balance,
			int interestRate,String CreditGrade) {
		super(accNum,name,balance,interestRate);
		this.CreditGrade = CreditGrade;
		}
		public void applyInterest() {
			int additionalRate = 0;
		
		switch(CreditGrade) {
			case "A" :
				additionalRate =7;
				break;
			case "B" :
				additionalRate =4;
				break;
			case "C" :
				additionalRate =1;
				break;			
			default:
				System.out.println("잘못된신용등급입니다.");
				return;
		}
		int totalInterestRate = super.getInterestRate()	+ additionalRate;
		int interestAmount = (int) Math.floor(balance * totalInterestRate / 100.0);
		balance += interestAmount;
		System.out.println("이자 적용 후 잔액:" + balance);
		
		}
		@Override
		public void showAccountInfo() {
			super.showAccountInfo();
			System.out.println("신용등급:" +CreditGrade);
			System.out.println();
		}
	}


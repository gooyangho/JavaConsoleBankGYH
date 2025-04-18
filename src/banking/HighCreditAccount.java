package banking;


public class HighCreditAccount extends NormalAccount {
	private String CreditGrade;
	
	public HighCreditAccount(String accNum, String name, int balance,
			int interestRate,String CreditGrade) {
		super(accNum,name,balance,interestRate);
		this.CreditGrade = CreditGrade;
		}
	
		public void applyInterest() {
			int additionalRate = 0; //이자율을 0으로설정
		
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
		int totalInterestRate = super.getInterestRate()	+ additionalRate;// 부모클래스의 기본 이자율에 추가이자율더함
		int interestAmount = (int) Math.floor(balance * totalInterestRate / 100.0); //이자 계산(소수점 버림)
		balance += interestAmount; //잔액에 이자더하는거고 
		System.out.println("이자 적용 후 잔액:" + balance);
		
		}
		@Override
		public void showAccountInfo() {
			super.showAccountInfo();   	
			System.out.print("신용등급:" +CreditGrade);
		}
	}


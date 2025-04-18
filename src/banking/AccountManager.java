package banking;

import java.util.HashSet;
import java.util.Scanner;

public class AccountManager {	
	
	private Account[] accounts;
	private int numOfAccounts;
	private Scanner scanner;
	private HashSet<String> accountNumbers;
	
	public AccountManager(int size) {
		accounts = new Account[size];
		numOfAccounts = 0;
		scanner = new Scanner(System.in);
		accountNumbers = new HashSet<>();
	}
	public void showMenu() {
		System.out.println("==================Menu===================");
		System.out.print("1.계좌개설, ");
		System.out.print("2.입금, ");
		System.out.print("3.출금, ");
		System.out.print("4.계좌정보출력, \n");
		System.out.print("5.계좌정보삭제,");
		System.out.print("6.프로그램종료,\n");
		System.out.println("========================================");
		
		System.out.print("선택:");
	}
	
	public void run() {
		while (true) {
			try {
				showMenu();
				int choice = scanner.nextInt();
				scanner.nextLine(); //남은버퍼정리
				
			if(choice < 1 || choice > 5 ) {
				throw new Exception("1에서 5사이의 정수를 입력해주세요.");
				}
			switch (choice)	 {
			case 1: 
				System.out.println("계좌계설선택");
				break;
			case 2:
				System.out.println("입 금");
				break;
			case 3:
				System.out.println("출 금");
				break;
			case 4:
				System.out.println("전체계좌정보출력");
				break;
			case 5:
				System.out.println("계좌정보삭제");
				break;
			case 6:
				System.out.println("프로그램종료");
				return;
			}
			} catch (Exception e) {	
				System.out.println("숫자를 입력해야 합니다.");
				scanner.nextLine();
			}
		}
	}	
		
	
	public void makeAccount() {
		System.out.println("***계좌개설***");
		System.out.println("-----계좌선택-----");
		System.out.println("1.보통계좌");
		System.out.println("2.신용신뢰계좌");
		System.out.print("선택");
		int Choice = scanner.nextInt();
		scanner.nextLine();
		
		System.out.print("계좌번호");
		String accNum = scanner.nextLine();
		
		if(accountNumbers.contains(accNum)) {
			System.out.println("이미 등록된 계좌번호입니다");
		}
		
		System.out.print("고객이름");
		String name = scanner.nextLine();
		
		System.out.print("잔고");
		int balence = scanner.nextInt();		
		scanner.nextLine();
		
		System.out.print("기본이자%(정수형태)");
		int interestRate = scanner.nextInt();
		scanner.nextLine();
		
		
		if (Choice == 1) {
			accounts[numOfAccounts++] = new NormalAccount(accNum, name ,balence ,interestRate);
		} else if (Choice ==2) {
			System.out.print("신용등급(A,B,C등급): ");
			String grade = scanner.nextLine().toUpperCase();
			accounts[numOfAccounts++] = new HighCreditAccount(accNum,name,balence,interestRate,grade);
		} else {
			System.out.println("계좌 정보가 잘못 입력되었습니다.");
			return;
		}	
		System.out.println("계좌계설이 완료되었습니다.");
	}	
	
	public void depositMoney() {
		System.out.print("입금할 계좌번호");
		String accNum = scanner.nextLine();
		
		System.out.print("입금액");
		int amount =scanner.nextInt();
		scanner.nextLine();
		
		if (amount<0) {
			System.out.println("음수는 입금불가");
			return;
		}
		if (amount % 500 != 0) {
			System.out.println("500원 단위로 입금가능함");
			return;	
		}
		
		Account account = findAccount(accNum);//계좌번호로 계좌 찾기
		if (account != null) {
			account.deposit(amount); //입금 수행
			if (account instanceof HighCreditAccount) { //해당계좌가 신용계좌라면
				((HighCreditAccount) account).applyInterest(); //이자적용
			}
			System.out.println("입금이 완료되었습니다");
		}else {
			System.out.println("해당 계좌번호가 존재하지 않습니다.");
		}
	}
	 private Account findAccount(String accNum) {
	        for (int i = 0; i < numOfAccounts; i++) {
	            if (accounts[i].getAccountNumber().equals(accNum)) {
	                return accounts[i]; //계좌번호가 일치하면 해당 계좌 반환
	            }
	        }
	        return null;  //못찾으면null 반환
	 	}
	    public void showAccInfo() {
	    	
	    	if(numOfAccounts == 0) {
	    		System.out.println("등록된 계좌가 없습니다.");
	    	return;
	    }
	    System.out.println("***계좌정보출력***");
	    for (int i =0; i< numOfAccounts; i++) {
	    	System.out.println("------계좌정보------");
	    	accounts[i].showAccountInfo();//각 계좌의 정보 출력    	
	    	System.out.println("\n---------------");
	    	}
	    System.out.println("전체계좌정보 출력이 완료되었습니다.");
	    System.out.println("****************************");
	    }
	    public void withdrawMoney() {
	    	Scanner scanner = new Scanner(System.in);
	    	System.out.print("출금할 계좌번호");
	    	String accNum = scanner.nextLine();
	    	
	    	System.out.print("출금액");
	    	int amount =scanner.nextInt();
	    	scanner.nextLine();
	    
	    	Account account = findAccount(accNum);//계좌찾기
	    	
	    	if (amount % 1000 != 0) { //나눈값이 0과일치하지않을경우 메시지출력하고 return
				System.out.println("1000원 단위로 입금가능함");
				return;	
			}
	    	   if (amount < 0) {
	               System.out.println("음수 금액은 출금할 수 없습니다.");
	               return;
	    	   }
	    	if(account.getBalance() < amount)
	    		System.out.println("잔고부족.금액전체를 출금할까요?(y or n)");
	    		String choice = scanner.nextLine();//입력을 받기전 남아있는 줄바꿈
	    		
	    		
	    		
	    	if(choice.equalsIgnoreCase("y")){
	    		System.out.println("출금이 완료되었습니다.");
	    		int balance =account.getBalance();//계좌 잔액가져옴
	    		account.withdraw(balance); // 잔액을 전부 출금
	    	} else {
	    		System.out.println("출금이 취소되었습니다.");  //y가아닌 다른입력이면 취소		   		
	    	}	   	
	    }			
	}
		
		
		
	



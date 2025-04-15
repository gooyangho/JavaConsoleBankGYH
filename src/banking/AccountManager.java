package banking;

import java.util.Scanner;

public class AccountManager {	
	
	private Account[] accounts;
	private int numOfAccounts;
	private Scanner scanner;
	
	public AccountManager(int size) {
		accounts = new Account[size];
		numOfAccounts = 0;
		scanner = new Scanner(System.in);
	}
	public void showMenu() {
		System.out.println("-----Menu-----");
		System.out.println("1. 계좌계설 ");
		System.out.println("2. 입 금 ");
		System.out.println("3. 출 금 ");
		System.out.println("4. 전체계좌정보출력 ");
		System.out.println("5. 프로그램종료 ");
		System.out.print("선택");
	}
	
	public void makeAccount() {
		System.out.print("계좌번호");
		String accNum = scanner.nextLine();
		
		System.out.print("이름");
		String name = scanner.nextLine();
		
		System.out.print("입금액");
		int balance = scanner.nextInt();
		scanner.nextLine();
		
		accounts[numOfAccounts++] = new Account(accNum, name, balance);
		
		System.out.println("***신규계좌개설***");
		System.out.println("계좌번호:" + accNum);
		System.out.println("고객이름:" + name);
		System.out.println("잔고:" + balance); 
		System.out.println("계좌가 개설되었습니다.");	
	}
	
	public void depositMoney() {
		System.out.print("입금할 계좌번호");
		String accNum = scanner.nextLine();
		
		System.out.println("입금액");
		int amount =scanner.nextInt();
		scanner.nextLine();
		
		Account account = findAccount(accNum);
		if (account != null) {
			account.deposit(amount);
			System.out.println("입금이 완료되었습니다");
		}else {
			System.out.println("해당 계좌번호가 존재하지 않습니다.");
		}
	}
	 private Account findAccount(String accNum) {
	        for (int i = 0; i < numOfAccounts; i++) {
	            if (accounts[i].getAccountNumber().equals(accNum)) {
	                return accounts[i];
	            }
	        }
	        return null;  
	 	}
	    public void showAccInfo() {
	    	if(numOfAccounts == 0) {
	    		System.out.println("등록된 계좌가 없습니다.");
	    	return;
	    }
	    System.out.println("***계좌정보출력***");
	    for (int i =0; i< numOfAccounts; i++) {
	    	System.out.println("------------");	
	    	accounts[i].showAccountInfo();	    	
	    	System.out.println("------------");
	    	}
	    System.out.println("전체계좌정보 출력이 완료되었습니다.");
	    }
	    public void withdrawMoney() {
	    	Scanner scanner = new Scanner(System.in);
	    	System.out.print("출금할 계좌번호");
	    	String accNum = scanner.nextLine();
	    	
	    	System.out.print("출금액");
	    	int amount =scanner.nextInt();
	    	scanner.nextLine();
	    	
	    	Account account = findAccount(accNum);
	    	if(account != null) {
	    		account.withdraw(amount);
	    		System.out.println("출금이 완료되었습니다");
	    	}else {
	    		System.out.println("해당 계좌번호가 존재하지 않습니다.");  		   		
	    }
  	}  	    			
}
		
		
		
	



package banking;

import java.util.Scanner;

public class BankingSystemMain {
	static final int MAKE =1;
	static final int DEPOSIT=2;
	static final int WITHDRAW=3;
	static final int INQUIRE=4;
	static final int EXIT=5;
	
	public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	AccountManager manager =new AccountManager(50);
	
	int choice;
	
	while(true) {
		manager.showMenu();
		choice = scanner.nextInt();
		scanner.nextLine();
		
		switch(choice) {
		case 1 :
			manager.makeAccount();
			break;
		case 2:
			manager.depositMoney();
			break;
		case 3:
			manager.withdrawMoney();
			break;
		case 4:
			manager.showAccInfo();
			break;
		case 5:
			System.out.println("프로그램을종료합니다");
			return;
			default:
			System.out.println("잘못된선택입니다");
		}
	}	
}
		static void showMenu() {
		System.out.println("메뉴를 출력합니다.");
		}
		static void makeAccount() {
		System.out.println("계좌를 개설합니다.");
		}
		static void depositMoney() {
		System.out.println("입 금");
		}
		static void withdrawMoney() {
		System.out.println("출 금");
		}
		static void showAccinfo() {
		System.out.println("전체 계좌를 출력합니다");		
	}
}
	
	
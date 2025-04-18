package banking;

import java.util.Scanner;

public class BankingSystemMain {
	
	
	public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	AccountManager manager =new AccountManager(50);
	
	int choice;
	
	while(true) { //계속해서 메뉴출력
		manager.showMenu();
		choice = scanner.nextInt();
		scanner.nextLine();
		
		switch(choice) {
		case 1 :
			manager.makeAccount();//계좌개설
			break;
		case 2:
			manager.depositMoney();//입금
			break;
		case 3:
			manager.withdrawMoney(); //출금액
			break;
		case 4:
			manager.showAccInfo(); //계좌정보
			break;
	
		case 5:
			System.out.println("프로그램을종료합니다");
			return;
			default:
			System.out.println("메뉴 입력 예외발생됨.");
			System.out.println("메뉴는 1~6사이의 정수를 입력하세요");
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
		static void deleteAccount()	{
		System.out.println("계좌 정보를 삭제합니다");
	}
}
	
	
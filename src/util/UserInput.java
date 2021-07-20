package util;

import java.util.Scanner;

public class UserInput {
	static Scanner scanner = new Scanner(System.in);
	
	public static int menuInput() {
		System.out.print("\n입력:");
		return Integer.parseInt(scanner.nextLine());
	}

	public static int handledIntegerInput(String msg){
		System.out.print(msg);
		try{
			int result = Integer.parseInt(scanner.nextLine());
			return result;
		} catch(NumberFormatException e){
			System.out.println("올바르지 않은 입력입니다.");
		}
		return 0;
	}
}

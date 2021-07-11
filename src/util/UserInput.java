package util;

import java.util.Scanner;

public class UserInput {
	static Scanner scanner = new Scanner(System.in);
	
	public static int menuInput() {
		System.out.print("\n입력:");
		return Integer.parseInt(scanner.nextLine());
	}

}

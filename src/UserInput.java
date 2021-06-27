import java.util.Scanner;

public class UserInput {
	static Scanner scanner = new Scanner(System.in);
	
	public static int logInPageInput() {
		System.out.print("\n입력:");
		return scanner.nextInt();
	}
	
	public static String signInUserInput() {
		System.out.print("아이디:");
		String id = scanner.next();  //왜 nextLine()을 하면 안될까..
		System.out.print("비밀번호:");
		String password = scanner.next();
		
		return id+"/"+password;
	}
	
	public static int mainMenuInput() {   //logInPageInput과 통합 고려해보자
		System.out.print("\n입력:");
		return scanner.nextInt();
	}
	
	public static String registerProductInput() {
		System.out.print("상품 이름:");
		String name = scanner.next();
		System.out.print("목표 금액:");
		int goalAmount = scanner.nextInt();
		System.out.print("펀딩 금액:");
		int fundingPrice = scanner.nextInt();
		return name+"/"+goalAmount+"/"+fundingPrice;
	}
	
	public static int productListInput() {
		System.out.print("\n입력:");
		return scanner.nextInt();
	}
	
	public static int depositAmountInput() {
		System.out.print("충전 액수를 입력하세요:");
		return scanner.nextInt();
	}
	
	public static boolean isFundingInput() {
		System.out.print("충전하시겠습니까?(y/n)");
		while(scanner.hasNextLine()) {
			try {
				if(scanner.nextLine().charAt(0)=='y')
					return true;
				else if(scanner.nextLine().charAt(0)=='n')
					return false;
				else
					throw new Exception();
			} catch(Exception e) {
				System.out.print("충전하시겠습니까?(y/n)");
			}
		}
		return false;
	}
}

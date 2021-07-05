import java.util.Scanner;
import DTO.Product;

public class UserInput {
	static Scanner scanner = new Scanner(System.in);
	
	public static int menuInput() {
		System.out.print("\n입력:");
		return scanner.nextInt();
	}
	
	public static String signInUserInput() {
		System.out.print("아이디:");
		String id = scanner.next();
		System.out.print("비밀번호:");
		String password = scanner.next();
		
		return id+"/"+password;
	}
	
	public static String registerProductInput() {
		scanner.nextLine();
		System.out.print("상품명:");
		String name = scanner.nextLine();
		System.out.print("목표액:");
		int goalAmount = scanner.nextInt();
		System.out.print("금액:");
		int fundingPrice = scanner.nextInt();
		return name+"/"+goalAmount+"/"+fundingPrice;
	}

	public static int depositInput() {
		int amount;
		while(true){
			try{
				System.out.print("충전금액:");
				amount = scanner.nextInt();
				if(amount<=0){
					throw new Exception("올바르지 않은 금액입니다. 다시 입력해주세요.");
				}
				return amount;
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
	}
	
	public static boolean isFunding(Product product) {
		System.out.println("=================================\n");
		System.out.println(product);
		System.out.println("\n계좌 잔액은 "+ SERVICE.UserService.getCurrentUser().getAccount()+"입니다.\n");
		while(scanner.hasNextLine()) {
			scanner.nextLine();
			System.out.print("펀딩 하시겠습니까?(y/n):");
			try {
				if(scanner.nextLine().charAt(0)=='y') {
					try{
						if(SERVICE.UserService.getCurrentUser().getAccount()>=product.getFundingPrice()){
							return true;
						}else{
							throw new Exception("잔액이 부족합니다.");
						}
					}catch(Exception e){
						System.out.println(e.getMessage());
						return false;
					}
				}
				else if(scanner.nextLine().charAt(0)=='n') {
					return false;
				}
				else
					throw new Exception("올바르지 않은 입력입니다. 다시 입력해주세요.");
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return false;
	}
}

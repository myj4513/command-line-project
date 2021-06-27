import java.util.Scanner;

public class UserInput {
	static Scanner scanner = new Scanner(System.in);
	
	public static int logInPageInput() {
		System.out.print("\n�Է�:");
		return scanner.nextInt();
	}
	
	public static String signInUserInput() {
		System.out.print("���̵�:");
		String id = scanner.next();  //�� nextLine()�� �ϸ� �ȵɱ�..
		System.out.print("��й�ȣ:");
		String password = scanner.next();
		
		return id+"/"+password;
	}
	
	public static int mainMenuInput() {   //logInPageInput�� ���� ����غ���
		System.out.print("\n�Է�:");
		return scanner.nextInt();
	}
	
	public static String registerProductInput() {
		System.out.print("��ǰ �̸�:");
		String name = scanner.next();
		System.out.print("��ǥ �ݾ�:");
		int goalAmount = scanner.nextInt();
		System.out.print("�ݵ� �ݾ�:");
		int fundingPrice = scanner.nextInt();
		return name+"/"+goalAmount+"/"+fundingPrice;
	}
	
	public static int productListInput() {
		System.out.print("\n�Է�:");
		return scanner.nextInt();
	}
	
	public static int depositAmountInput() {
		System.out.print("���� �׼��� �Է��ϼ���:");
		return scanner.nextInt();
	}
	
	public static boolean isFundingInput() {
		System.out.print("�����Ͻðڽ��ϱ�?(y/n)");
		while(scanner.hasNextLine()) {
			try {
				if(scanner.nextLine().charAt(0)=='y')
					return true;
				else if(scanner.nextLine().charAt(0)=='n')
					return false;
				else
					throw new Exception();
			} catch(Exception e) {
				System.out.print("�����Ͻðڽ��ϱ�?(y/n)");
			}
		}
		return false;
	}
}

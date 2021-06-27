
public class ShowPage {
	public static void drawLine() {
		System.out.println("=================================\n");
	}
	
	public static void showLogInMenuPage() {
		drawLine();
		System.out.println("1. ȸ������");
		System.out.println("2. �α���");
	}
	
	public static void showSignInPage() {
		drawLine();
		System.out.println("[ȸ������]\n");
	}
	
	public static void showSuccessSignInPage() {
		drawLine();
		System.out.println("ȸ�������� �Ϸ�Ǿ����ϴ�.\n");
	}
	
	public static void showLogInPage() {
		drawLine();
		System.out.println("[�α���]\n");
	}
	
	public static void showMainMenuPage() {
		drawLine();
		System.out.println("1.��ǰ ��� ����");
		System.out.println("2.��ǰ ����ϱ�");
		System.out.println("3.�ݵ��ϱ�");
		System.out.println("4.�ݵ� ����ϱ�");
		System.out.println("5.��ȸ�ϱ�");
		System.out.println("6.�����ϱ�");
	}
	
	public static void showProductListPage() {
		drawLine();
		System.out.println("[��ǰ ��� ����]\n");
	}
	
	public static void showRegisterProductPage() {
		drawLine();
		System.out.println("[��ǰ ����ϱ�]\n");
	}
	
	public static void showProductList() {
		for(int i=0;i<Index.productNum;i++) {
			System.out.println(i+1+". "+Index.productArr[i].getName());
		}
	}
	
	public static void showDepositPage() {
		drawLine();
		System.out.println("[�����ϱ�]\n");
		System.out.println("�����ܾ��� "+Index.userArr[Index.curUser].getAccount()+"�� �Դϴ�.\n");
	}
	
	public static void showProductPage(int productNum) {
		int i = productNum-1;
		drawLine();
		System.out.println("[��ǰ ����]\n");
		System.out.println("��ǰ��:"+Index.productArr[i].getName()+"��");
		System.out.println("��ǥ �׼�:"+Index.productArr[i].getGoalAmount()+"��");
		System.out.println("���� �ݵ� �׼�:"+Index.productArr[i].getCurrentAmount()+"��");
		System.out.println("�޼���:"+(Index.productArr[i].getCurrentAmount()/Index.productArr[i].getGoalAmount())*100+"%");
		System.out.println("�ݵ� �ݾ�:"+Index.productArr[i].getFundingPrice());
		System.out.println();
		System.out.println("���� �ܾ��� "+Index.userArr[Index.curUser].getAccount()+"���Դϴ�.");
	}
}

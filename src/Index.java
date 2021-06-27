import dao.ProductDao;
import dto.Product;
import dto.User;
import util.UserService;

public class Index {
	static User[] userArr = new User[10];
	static int curUser;
	static Product[] productArr = new Product[10];
	static int userNum = 0;
	static int productNum = 0;

	private static ProductDao productDao;



	public static void main(String[] args) {
		start();
	}

	public static void init() {
		productDao = new ProductDao();

	}

	private static void start() {
		while(true) {
			if(UserService.isCurrentUserLogin()) {//�α��� ����
				ShowPage.showMainMenuPage();
				int input = UserInput.mainMenuInput();
				switch(input) {
				case 1:
					ShowPage.showProductListPage();
					ShowPage.showProductList();
					int productListInput = UserInput.productListInput();
					ShowPage.showProductPage(productListInput);
					boolean isFunding = UserInput.isFundingInput();
					break;
				case 2:
					ShowPage.showRegisterProductPage();
					String registerProductInput = UserInput.registerProductInput();
					productArr[productNum++] = new Product(registerProductInput);
					System.out.println("\n��ǰ�� ��ϵǾ����ϴ�.");
					break;
				case 6:
					ShowPage.showDepositPage();
					int depositAmount = UserInput.depositAmountInput();
					userArr[curUser].deposit(depositAmount);
					break;
				}

			}else {//�α��� ����
				while(true) {
					ShowPage.showLogInMenuPage();
					int input = UserInput.logInPageInput();

					switch(input) {
					case 1:
						ShowPage.showSignInPage();
						String signInInput = UserInput.signInUserInput();
//						userArr[userNum++] = new User(signInInput);
						ShowPage.showSuccessSignInPage();
						break;
					case 2:
						ShowPage.showLogInPage();
						String logInInput = UserInput.signInUserInput();
						logIn(logInInput);
						break;
					}
					if(UserService.isCurrentUserLogin()) break;
				}
			}
		}
	}

	public static void logIn(String logInInput) {
		String[] arr = logInInput.split("/");
		String id = arr[0].trim();
		String password = arr[1].trim();
		
		for(int i=0;i<userArr.length;i++) {
			if(userArr[i]!=null) {
				if(id.equals(userArr[i].getId())&&password.equals(userArr[i].getPassword())) {
					System.out.println("\n�α��� ����!!");
					curUser = i;
					return;
				}
			}
		}
		System.out.println("��ġ�ϴ� ���̵� ��й�ȣ�� �����ϴ�.");
	}
}

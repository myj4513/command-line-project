import dao.ProductDAO;
import dao.UserDAO;
import dto.Product;
import dto.User;
import util.UserService;

public class Index {
	private static ProductDAO productDAO;
	private static UserDAO userDAO;


	public static void main(String[] args) {
		init();
		start();
	}

	public static void init(){
		productDAO = new ProductDAO();
		userDAO = new UserDAO();
	}

	private static void start(){
		while(true) {
			if(UserService.isCurrentUserLoggedIn()) { //if logged in.
				ShowPage.showMainMenuPage();
				int input = UserInput.menuInput();
				switch(input) {
					case 1:
						ShowPage.showRegisterProductPage();
						String registerProductInput = UserInput.registerProductInput();
						productDAO.addProduct(new Product(registerProductInput));
						break;
					case 2:
						ShowPage.showProductListPage();
						if(productDAO.getProducts().isEmpty()){
							System.out.println("죄송합니다. 상품이 존재하지 않습니다.");
							break;
						}
						productDAO.getProductList();
						Product product = productDAO.getProduct(UserInput.menuInput());
						if(UserInput.isFunding(product)){ // funding yes!
							userDAO.fund(product);
						}//else 일때 뭘해야할까
						break;
					case 3:
						ShowPage.showCancelFundingPage();
						System.out.println("size:"+productDAO.getProducts().size());
						if(productDAO.getProducts().isEmpty()){
							System.out.println("죄송합니다. 펀딩 내역이 존재하지 않습니다.");
							break;
						}
						util.UserService.showFundingHistory();
						Product cancelProduct =  util.UserService.getCurrentUser().getFundingHistory().get(UserInput.menuInput()-1);
						userDAO.cancelFunding(cancelProduct);
						break;
					case 4:
						ShowPage.showFundingListPage();
						if(productDAO.getProducts().isEmpty()){
							System.out.println("죄송합니다. 펀딩 내역이 존재하지 않습니다.");
							break;
						}
						util.UserService.showFundingHistory();
						break;
					case 5:
						ShowPage.showDepositPage();
						userDAO.deposit(UserInput.depositInput());
						break;
				}


			}else {//login failed
				ShowPage.showLogInMenuPage();
				int input = UserInput.menuInput();

				switch(input) {
					case 1:
						ShowPage.showSignInPage();
						String signInInput = UserInput.signInUserInput();
						userDAO.addUser(new User(signInInput));
						ShowPage.showSuccessSignInPage();
						break;
					case 2:
						ShowPage.showLogInPage();
						String logInInput = UserInput.signInUserInput();
						userDAO.logIn(logInInput);
						break;
				}
			}
		}
	}
}

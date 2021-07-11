import DAO.*;
import SERVICE.*;
import UTIL.UserInput;
import VIEW.*;
import Exception.IndexOutOfBoundsException;

public class Index {
	public static ProductService productService;
	public static UserService userService;
	public static FundingService fundingService;
	public static ProductDAO productDAO;
	public static UserDAO userDAO;
	public static FundingDAO fundingDAO;


	public static void main(String[] args) {
		init();
		start();
	}

	public static void init(){
		productDAO = new ProductDAO();
		userDAO = new UserDAO();
		fundingDAO = new FundingDAO();
		productService = new ProductService(productDAO);
		userService = new UserService(userDAO);
		fundingService = new FundingService(fundingDAO);
	}

	private static void start() {
		while(true) {
			if(userService.isCurrentUserLoggedIn()) { //logged in
				ShowPage.showMainMenuPage();
				int input = UserInput.menuInput();
				try{
					if(input<1 || input>5)
						throw new IndexOutOfBoundsException();
				} catch (IndexOutOfBoundsException e){
					System.out.println(e.getMessage());
				}
				switch(input) {
					case 1: //1.상품 등록하기
						ProductView.showRegisterProduct(productDAO);
						break;
					case 2: //2.펀딩하기
						ProductView.showProductsList(productDAO);
						if(productDAO.getProducts().isEmpty()) break; //상품이 하나도 없으면
						int productIndex = UserInput.menuInput();
						FundingView.showFunding(userService, productService, fundingDAO, productIndex);
						break;
					case 3: //3.펀딩 취소하기
						ShowPage.showCancelFundingPage();
						FundingView.showFundingProductList(fundingDAO, userService.getCurrentUser());
						if(fundingDAO.getFundingProductList(userService.getCurrentUser()).isEmpty()) break; //펀딩내역이 없으면..
						int fundingIndex = UserInput.menuInput();
						FundingView.showCancelFunding(userService, productService, fundingService, fundingDAO, fundingIndex);
						break;
					case 4: //4.펀딩내역 조회하기
						ShowPage.showFundingListPage();
						FundingView.showFundingProductList(fundingDAO, userService.getCurrentUser());
						break;
					case 5: //5.충전하기
						UserView.showDeposit(userService);
						break;
				}
			}else {//login failed
				ShowPage.showLogInMenuPage();
				int input = UserInput.menuInput();
				try{
					if(input<1 || input>2)
						throw new IndexOutOfBoundsException();
				} catch (IndexOutOfBoundsException e){
					System.out.println(e.getMessage());
				}

				switch(input) {
					case 1: //회원가입
						UserView.showSignIn(userDAO);
						break;
					case 2: //로그인
						UserView.showLogin(userService);
						break;
				}
			}
		}
	}
}


public class ShowPage {
	public static void drawLine() {
		System.out.println("=================================\n");
	}
	
	public static void showLogInMenuPage() {
		drawLine();
		System.out.println("1. 회원가입");
		System.out.println("2. 로그인");
	}
	
	public static void showSignInPage() {
		drawLine();
		System.out.println("[회원가입]\n");
	}
	
	public static void showSuccessSignInPage() {
		drawLine();
		System.out.println("회원가입이 완료되었습니다.\n");
	}
	
	public static void showLogInPage() {
		drawLine();
		System.out.println("[로그인]\n");
	}

	public static void showFundingListPage(){
		drawLine();
		System.out.println("[펀딩내역 조회하기]\n");
	}
	
	public static void showCancelFundingPage(){
		drawLine();
		System.out.println("[펀딩 취소하기]\n");
	}
	
	public static void showMainMenuPage() {
		drawLine();
		System.out.println("1.상품 등록하기");
		System.out.println("2.펀딩하기");
		System.out.println("3.펀딩 취소하기");
		System.out.println("4.펀딩내역 조회하기");
		System.out.println("5.충전하기");
	}
	
	public static void showProductListPage() {
		drawLine();
		System.out.println("[상품 목록 보기]\n");
	}
	
	public static void showRegisterProductPage() {
		drawLine();
		System.out.println("[상품 등록하기]\n");
	}


	
	public static void showDepositPage() {
		drawLine();
		System.out.println("[충전하기]\n");
		System.out.println("계좌 잔액은 "+UTIL.UserService.getCurrentUser().getAccount()+"입니다.\n");
	}
}

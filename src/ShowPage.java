
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
	
	public static void showMainMenuPage() {
		drawLine();
		System.out.println("1.상품 목록 보기");
		System.out.println("2.상품 등록하기");
		System.out.println("3.펀딩하기");
		System.out.println("4.펀딩 취소하기");
		System.out.println("5.조회하기");
		System.out.println("6.충전하기");
	}
	
	public static void showProductListPage() {
		drawLine();
		System.out.println("[상품 목록 보기]\n");
	}
	
	public static void showRegisterProductPage() {
		drawLine();
		System.out.println("[상품 등록하기]\n");
	}
	
	public static void showProductList() {
		for(int i=0;i<Index.productNum;i++) {
			System.out.println(i+1+". "+Index.productArr[i].getName());
		}
	}
	
	public static void showDepositPage() {
		drawLine();
		System.out.println("[충전하기]\n");
		System.out.println("현재잔액은 "+Index.userArr[Index.curUser].getAccount()+"원 입니다.\n");
	}
	
	public static void showProductPage(int productNum) {
		int i = productNum-1;
		drawLine();
		System.out.println("[상품 정보]\n");
		System.out.println("상품명:"+Index.productArr[i].getName()+"원");
		System.out.println("목표 액수:"+Index.productArr[i].getGoalAmount()+"원");
		System.out.println("현재 펀딩 액수:"+Index.productArr[i].getCurrentAmount()+"원");
		System.out.println("달성률:"+(Index.productArr[i].getCurrentAmount()/Index.productArr[i].getGoalAmount())*100+"%");
		System.out.println("펀딩 금액:"+Index.productArr[i].getFundingPrice());
		System.out.println();
		System.out.println("계좌 잔액은 "+Index.userArr[Index.curUser].getAccount()+"원입니다.");
	}
}

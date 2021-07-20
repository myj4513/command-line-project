package view;

import dao.*;
import java.util.*;
import dto.Product;
import util.UserInput;

public class ProductView {
    static Scanner s = new Scanner(System.in);

    public static void showProductsList(ProductDAO productDAO){
        ShowPage.drawLine();
        System.out.println("[펀딩하기]\n");
        if(productDAO.getProducts().isEmpty()){
            System.out.println("상품이 존재하지 않습니다.");
            return;
        }
        List<Product> list = productDAO.getProducts();
        list.stream().forEach(p->System.out.println(list.indexOf(p)+1+"."+p.getName()));
    }

    public static void showRegisterProduct(ProductDAO productDAO){
        ShowPage.drawLine();
        System.out.println("[상품 등록하기]\n");
        System.out.print("상품명 : ");
        String name = s.nextLine();
        int goalAmount = 0;
        int fundingPrice = 0;
        while(goalAmount == 0){
            goalAmount = UserInput.handledIntegerInput("목표액 : ");
        }
        while(fundingPrice == 0){
            fundingPrice = UserInput.handledIntegerInput("금액 : ");
        }
        Product product = new Product(name, goalAmount, fundingPrice);
        productDAO.addProduct(product);
        System.out.println();

        System.out.println("상품이 등록되었습니다.");
    }

    public static void showProduct(Product product){
        System.out.println("상품명 : "+product.getName());
        System.out.println("목표액 : "+product.getGoalAmount()+"원");
        System.out.println("현재 펀딩액 : "+product.getCurrentAmount()+"원");
        System.out.println("달성률 : "+((double)product.getCurrentAmount()/ product.getGoalAmount()*100)+"%");
        System.out.println("금액 : "+product.getFundingPrice()+"원");
    }
}

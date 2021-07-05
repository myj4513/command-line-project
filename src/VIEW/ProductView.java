package VIEW;

import DAO.*;
import java.util.*;
import DTO.Product;

public class ProductView {
    static Scanner s = new Scanner(System.in);

    public static void showProductsList(ProductDAO productDAO){
        ShowPage.drawLine();
        System.out.println("[펀딩하기]\n");
        if(productDAO.getProducts().isEmpty()){
            System.out.println("상품이 존재하지 않습니다.");
            return;
        }
        Iterator it = productDAO.getProductsIterator();
        int count = 0;
        while(it.hasNext()){
            Product product = (Product)it.next();
            System.out.println(++count+"."+product.getName());
        }
    }

    public static void showRegisterProduct(ProductDAO productDAO){
        ShowPage.drawLine();
        System.out.println("[상품 등록하기]\n");
        System.out.print("상품명 : ");
        String name = s.nextLine();
        System.out.print("목표액 : ");
        int goalAmount = Integer.parseInt(s.nextLine());
        System.out.print("금액 : ");
        int fundingPrice = Integer.parseInt(s.nextLine());
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

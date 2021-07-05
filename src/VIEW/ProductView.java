package VIEW;

import DAO.*;
import java.util.*;
import DTO.Product;
public class ProductView {
    public static void showProductsList(ProductDAO productDAO){
        Iterator it = productDAO.getProductsIterator();
        while(it.hasNext()){
            Product product = (Product)it.next();
            int count = 0;
            System.out.println(++count+","+product.getName());
        }
    }

    public static void showProduct(Product product){
        System.out.println("상품명 : "+product.getName());
        System.out.println("목표액 : "+product.getGoalAmount()+"원");
        System.out.println("현재 펀딩액 : "+product.getCurrentAmount()+"원");
        System.out.println("달성률 : "+((double)product.getCurrentAmount()/ product.getGoalAmount()*100)+"%");
        System.out.println("금액 : "+product.getFundingPrice()+"원");
    }
}

package UTIL;

import DTO.Product;
import DTO.User;
import java.util.*;

public class ProductService {
    public static Product currentProduct;

    public static void setCurrentProduct(Product product){
        currentProduct = product;
    }

    public static Product getCurrentProduct(){
        return currentProduct;
    }

    public static void addSponsor(User user){
        currentProduct.getSponsor().add(user);
    }

    public static void showSponsors(){
        Iterator it = currentProduct.getSponsor().iterator();
        while(it.hasNext()){
            User user = (User)it.next();
            System.out.println(user.getId());
        }
    }
}

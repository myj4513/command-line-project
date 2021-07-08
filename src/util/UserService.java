package util;

import dto.User;
import dto.Product;
import java.util.*;

public class UserService {
    private static User currentUser = null;

    public static void login(User user){
        currentUser = user;
    }

    public static boolean isCurrentUserLoggedIn(){
        return currentUser != null;
    }

    public static User getCurrentUser(){
        return currentUser;
    }

    public static void addFundingHistory(Product product){
        currentUser.getFundingHistory().add(product);
    }

    public static void showFundingHistory(){
        Iterator it = currentUser.getFundingHistory().iterator();
        int count = 0;
        while(it.hasNext()){
            Product product = (Product)it.next();
            System.out.println(++count+"."+product.getName());
        }
        System.out.println();
    }
}

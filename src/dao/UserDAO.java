package dao;

import java.util.*;
import dto.User;
import dto.Product;

public class UserDAO {
    private List<User> users = new ArrayList<User>();

    public List getUsers(){
        return users;
    }

    public void addUser(User user){
        users.add(user);
    }

    public void removeUser(User user){
        users.remove(user);
    }

    public void logIn(String logInInput) {
        String[] arr = logInInput.split("/");
        String id = arr[0].trim();
        String password = arr[1].trim();

        Iterator it = users.iterator();
        while(it.hasNext()){
            User user = (User)it.next();
            if(user.getId().equals(id)){
                if(user.getPassword().equals(password)){
                    //login success
                    util.UserService.login(user);
                    System.out.println("로그인 되었습니다.");
                }else{
                    //wrong password
                    System.out.println("비밀번호가 일치하지 않습니다.");
                }
                return;
            }
        }
        System.out.println("존재하지 않는 아아디입니다.");
    }

    public void deposit(int amount){
        User user = util.UserService.getCurrentUser();
        user.setAccount(amount+user.getAccount());
    }

    public void fund(Product product){
        User tmp = util.UserService.getCurrentUser();
        util.ProductService.addSponsor(tmp);
        util.UserService.addFundingHistory(util.ProductService.getCurrentProduct());
        int userAccount = tmp.getAccount();
        tmp.setAccount(userAccount- product.getFundingPrice());
        product.addCurrentAmount();
        System.out.println("펀딩이 완료되었습니다.");
    }

    public void cancelFunding(Product product){
        util.UserService.getCurrentUser().getFundingHistory().remove(product);
        //회원 잔액 복구, 상품 현재 펀딩액 복구
        product.subtractCurrentAmount();
        int currentAccount = util.UserService.getCurrentUser().getAccount();
        util.UserService.getCurrentUser().setAccount(currentAccount+ product.getFundingPrice());
        System.out.println("["+product.getName()+"] 펀딩이 취소되었습니다.");
    }
}

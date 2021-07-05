package VIEW;

import java.util.*;
import SERVICE.UserService;
import DAO.UserDAO;
import DTO.User;
import Exception.*;

public class UserView {
    static Scanner s = new Scanner(System.in);
    public static void showLogin(UserService userService){
        System.out.println("[로그인]\n");
        System.out.print("아이디 : ");
        String id = s.nextLine();
        System.out.print("비밀번호 : ");
        String password = s.nextLine();

        try{
            userService.login(id, password);
        } catch(WrongPasswordException e){
            System.out.println(e.getMessage());
        } catch(NoExistingIdException e){
            System.out.println(e.getMessage());
        }
    }

    public static void showDeposit(UserService userService){
        System.out.println("[충전하기]\n");
        System.out.println("현재 잔액은 "+userService.getCurrentUser().getAccount()+"원입니다.");
        System.out.print("충전금액 : ");
        int amount = s.nextInt();

        try{
            userService.deposit(amount);
        } catch(InvalidAmountException e){
            System.out.println(e.getMessage());
        }
    }

    public static void showSignIn(UserDAO userDAO){
        System.out.println("[회원가입]\n");
        System.out.print("아이디 : ");
        String id = s.nextLine();
        System.out.print("비밀번호 : ");
        String password = s.nextLine();

        userDAO.addUser(new User(id, password));
    }
}

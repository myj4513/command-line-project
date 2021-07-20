package view;

import java.security.NoSuchAlgorithmException;
import java.util.*;
import service.UserService;
import dao.UserDAO;
import dto.User;
import exceptions.*;
import util.SHA256;
import util.UserInput;

public class UserView {
    static Scanner s = new Scanner(System.in);
    public static void showLogin(UserService userService){
        ShowPage.drawLine();
        System.out.println("[로그인]\n");
        System.out.print("아이디 : ");
        String id = s.nextLine();
        System.out.print("비밀번호 : ");
        String password = s.nextLine();
        System.out.println();

        try{
            String encryptedPassword = SHA256.encrypt(password);
            userService.login(id, encryptedPassword);
            System.out.println("로그인 되었습니다.");
            System.out.println("환영합니다! \""+id+"\"님.");
        } catch(WrongPasswordException e){
            System.out.println(e.getMessage());
        } catch(NoExistingIdException e){
            System.out.println(e.getMessage());
        } catch(NoSuchAlgorithmException e){
            e.printStackTrace();
        }
    }

    public static void showDeposit(UserService userService){
        ShowPage.drawLine();
        System.out.println("[충전하기]\n");
        System.out.println("현재 잔액은 "+userService.getCurrentUser().getAccount()+"원입니다.");
        System.out.println();
        int amount = 0;
        while(amount==0){
            amount = UserInput.handledIntegerInput("충전금액 : ");
        }
        System.out.println();
        try{
            userService.deposit(amount);
            System.out.println("충전이 완료되었습니다.");
            System.out.println("충전 후 잔액은 "+userService.getCurrentUser().getAccount()+"원입니다.");
        } catch(InvalidAmountException e){
            System.out.println(e.getMessage());
        }
    }

    public static void showSignIn(UserDAO userDAO) {
        ShowPage.drawLine();
        System.out.println("[회원가입]\n");
        System.out.print("아이디 : ");
        String id = s.nextLine();
        System.out.print("비밀번호 : ");
        String password = s.nextLine();

        try {
            String encryptedPassword = SHA256.encrypt(password);
            userDAO.addUser(new User(id, encryptedPassword));
        } catch (IdAlreadyExistsException e) {
            System.out.println(e.getMessage());
        } catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
    }
}

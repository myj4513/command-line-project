package SERVICE;

import DAO.UserDAO;
import DTO.User;
import Exception.*;
import DTO.Product;
import java.util.*;

public class UserService {
    private User currentUser = null;
    public UserDAO userDAO;

    public UserService(UserDAO userDAO){
        this.userDAO = userDAO;
    }

    public void login(String id, String password) throws Exception{
        if(userDAO.getUsers().containsKey(id)){
            if(userDAO.getUsers().get(id).getPassword().equals(password)){
                //log in 성공
                currentUser = userDAO.getUsers().get(id);
            } else{
                //wrong password
                throw new WrongPasswordException("올바르지 않은 비밀번호입니다.");
            }
        } else{
            throw new NoExistingIdException("존재하지 않는 아이디입니다.");
        }
    }

    public void deposit(int amount) throws Exception{
        if(amount <= 0){
            throw new InvalidAmountException("올바르지 않은 금액입니다.");
        }else{
            int account = currentUser.getAccount();
            currentUser.setAccount(account + amount);
        }
    }

    public boolean isCurrentUserLoggedIn(){
        return currentUser != null;
    }

    public User getCurrentUser(){
        return currentUser;
    }
}

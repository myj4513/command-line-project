package service;

import dao.UserDAO;
import dto.User;
import exceptions.*;
import util.SHA256;
import java.security.NoSuchAlgorithmException;

public class UserService {
    private User currentUser = null;
    public UserDAO userDAO;

    public UserService(UserDAO userDAO){
        this.userDAO = userDAO;
    }

    public void login(String id, String password) {
        if(userDAO.getUsers().containsKey(id)){
            String encryptedPassword = getEncryptedPassword(password);
            if(userDAO.getUsers().get(id).getPassword().equals(encryptedPassword)){
                //log in 성공
                currentUser = userDAO.getUsers().get(id);
            } else{
                //wrong password
                throw new WrongPasswordException();
            }
        } else{
            throw new NoExistingIdException();
        }
    }

    public void signIn(UserDAO userDAO, String id, String password){
        String encryptedPassword = getEncryptedPassword(password);
        if(!encryptedPassword.equals("")){ //암호화중 예외발생가 발생하지않았다면
            userDAO.addUser(new User(id, encryptedPassword));
        }
    }

    private String getEncryptedPassword(String password){
        try{
            return SHA256.encrypt(password);
        } catch(NoSuchAlgorithmException e){
            System.out.println(e.getMessage());
        }
        return ""; //예외가 발생하면 빈 문자열 반환
    }

    public void deposit(int amount) {
        if(amount <= 0){
            throw new InvalidAmountException();
        }else{
            int account = currentUser.getAccount();
            currentUser.setAccount(account + amount);
        }
    }

    public void addAccount(int amount){
        int curAmount = currentUser.getAccount();
        currentUser.setAccount(curAmount+amount);
    }

    public void subtractAccount(int amount){
        int curAmount = currentUser.getAccount();
        if(curAmount<amount)
            throw new NotEnoughMoneyException();
        currentUser.setAccount(curAmount-amount);
    }

    public boolean isCurrentUserLoggedIn(){
        return currentUser != null;
    }

    public User getCurrentUser(){
        return currentUser;
    }
}

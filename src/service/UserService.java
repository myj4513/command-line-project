package service;

import dao.UserDAO;
import dto.User;
import exceptions.*;

public class UserService {
    private User currentUser = null;
    public UserDAO userDAO;

    public UserService(UserDAO userDAO){
        this.userDAO = userDAO;
    }

    public void login(String id, String password) throws WrongPasswordException, NoExistingIdException{
        if(userDAO.getUsers().containsKey(id)){
            if(userDAO.getUsers().get(id).getPassword().equals(password)){
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

    public void deposit(int amount) throws InvalidAmountException{
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

    public void subtractAccount(int amount)throws NotEnoughMoneyException{
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

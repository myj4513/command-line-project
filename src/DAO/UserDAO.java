package DAO;

import java.util.*;
import DTO.User;
import DTO.Product;
import exception.IdAlreadyExistsException;

public class UserDAO {
    private Map<String, User> users = new HashMap<String, User>();

    public Map<String, User> getUsers(){
        return users;
    }

    public void addUser(User user) throws IdAlreadyExistsException{
        if(users.containsKey(user.getId())){
            throw new IdAlreadyExistsException();
        }
        users.put(user.getId(), user);
    }

    public void removeUser(User user){
        users.remove(user.getId());
    }
}

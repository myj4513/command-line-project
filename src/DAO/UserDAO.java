package DAO;

import DTO.User;
import Exception.IdAlreadyExistsException;

import java.util.HashMap;
import java.util.Map;

public class UserDAO {
    private Map<String, User> users = new HashMap<>();

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

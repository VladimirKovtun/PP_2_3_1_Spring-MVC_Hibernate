package web.service;

import web.entity.User;

import java.util.List;

public interface UserService {

    List<User> showAllUsers();
    void addUser(User user);

    User getUser(int id);

    void editUser(Integer id, User user);

    void removeUser(User user);
}

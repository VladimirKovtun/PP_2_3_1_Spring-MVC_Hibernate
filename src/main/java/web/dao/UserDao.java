package web.dao;

import web.entity.User;

import java.util.List;

public interface UserDao {

    List<User> getAllUsers();

    void saveUser(User user);

    User getUserById(Integer id);

    void updateUser(User user);

    void deleteUser(User user);
}

package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.entity.User;


import java.util.List;

@Service
public class UserServiceImpl  implements UserService{
    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> showAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    @Transactional
    public void addUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    @Transactional(readOnly = true)
    public User getUser(int id) {
        return userDao.getUserById(id);
    }

    @Override
    @Transactional
    public void editUser(Integer id, User user) {
        User userById = userDao.getUserById(id);
        userById.setName(user.getName());
        userById.setLastName(user.getLastName());
        userById.setAge(user.getAge());
        userById.seteMail(user.geteMail());
        userDao.updateUser(userById);
    }

    @Override
    @Transactional
    public void removeUser(User user) {
        userDao.deleteUser(user);
    }
}

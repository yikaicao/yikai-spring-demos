package service;

import dao.UserDaoImpl;
import entity.User;

import java.util.List;

public class UserServiceImpl {
    private UserDaoImpl userDao;
    public UserServiceImpl() {

    }
    public List<User> findUserList() {
        return this.userDao.findUserList();
    }

    public void setUserDao(UserDaoImpl userDao) {
        this.userDao = userDao;
    }
}

package dao;

import entity.User;

import java.util.Collections;
import java.util.List;

public class UserDaoImpl {
    public UserDaoImpl() {}

    public List<User> findUserList() {
        return Collections.singletonList(new User("yikai", 99));
    }
}

package dao;

import entity.User;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

public class UserDaoImpl {
    public UserDaoImpl() {}

    public List<User> findUserList() {
        return Collections.singletonList(new User("yikai", 98));
    }
}

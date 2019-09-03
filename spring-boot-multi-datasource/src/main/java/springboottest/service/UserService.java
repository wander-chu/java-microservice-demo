package springboottest.service;

import springboottest.database.master.User;
import springboottest.database.slave.User2;

import java.util.List;

public interface UserService {
    List<User> getUserList();

    List<User2> getUserList2();
}
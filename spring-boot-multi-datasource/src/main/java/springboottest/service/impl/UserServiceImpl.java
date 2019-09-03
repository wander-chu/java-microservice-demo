package springboottest.service.impl;

import springboottest.database.master.User;
import springboottest.database.master.UserRepository;
import springboottest.database.slave.User2;
import springboottest.database.slave.UserRepository2;
import springboottest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRepository2 userRepository2;

    @Override
    public List<User> getUserList() {
        return userRepository.findAll();
    }

    @Override
    public List<User2> getUserList2() {
        return userRepository2.findAll();
    }
}

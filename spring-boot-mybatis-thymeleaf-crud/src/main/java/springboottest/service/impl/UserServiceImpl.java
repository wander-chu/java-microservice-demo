package springboottest.service.impl;

import springboottest.model.User;
import springboottest.mapper.UserMapper;
import springboottest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getUserList() {
        return userMapper.selectAll();
    }

    @Override
    public User findUserById(long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public void save(User user) {
        userMapper.insert(user);
    }

    @Override
    public void edit(User user) {
        userMapper.updateByPrimaryKey(user);
    }

    @Override
    public void delete(long id) {
        userMapper.deleteByPrimaryKey(id);
    }
}
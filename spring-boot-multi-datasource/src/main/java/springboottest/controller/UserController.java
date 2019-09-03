package springboottest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import springboottest.database.master.User;
import springboottest.database.slave.User2;
import springboottest.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/")
    public List<User> master() {
        return userService.getUserList();
    }

    @RequestMapping("slave")
    public List<User2> slave() {
        return userService.getUserList2();
    }
}

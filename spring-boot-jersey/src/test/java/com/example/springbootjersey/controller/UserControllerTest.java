package com.example.springbootjersey.controller;

import com.example.springbootjersey.SpringBootJerseyApplication;
import com.example.springbootjersey.model.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringBootJerseyApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
public class UserControllerTest {
    @Value("${local.server.port}")
    private int port;

    @Test
    public void findUserById() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:" + port + "/user/1");
        Response response = target.request(MediaType.APPLICATION_JSON).get();
        User user = response.readEntity(User.class);
        assertTrue(response.getStatus() == 200);
        assertTrue(user.getId() == 1);
    }

    @Test
    public void findAllUsers() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:" + port + "/user");
        Response response = target.request(MediaType.APPLICATION_JSON).get();
        List<User> users = response.readEntity(new GenericType<List<User>>() {
        });
        assertTrue(response.getStatus() == 200);
        assertTrue(users.size() == 1);
    }

    @Test
    public void addUser() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:" + port + "/user");
        User user = new User();
        user.setId(2);
        user.setUsername("wander");
        user.setSex("男");
        user.setAge(35);
        Response response = target.request(MediaType.APPLICATION_JSON).post(Entity.json(user));
        assertTrue(response.getStatus() == 201);
    }

    @Test
    public void updateUser() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:" + port + "/user");
        User user = new User();
        user.setId(1);
        user.setUsername("wander2");
        user.setSex("男");
        user.setAge(35);
        Response response = target.request(MediaType.APPLICATION_JSON).put(Entity.json(user));
        user = response.readEntity(User.class);
        assertTrue(response.getStatus() == 200);
        assertEquals("wander2", user.getUsername());
    }

    @Test
    public void deleteUser() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:" + port + "/user/1");
        Response response = target.request(MediaType.APPLICATION_JSON).delete();
        assertTrue(response.getStatus() == 204);
    }
}
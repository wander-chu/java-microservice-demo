package com.example.springbootjersey.controller;

import com.example.springbootjersey.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.*;

@Path("user")
@Component
@Slf4j
public class UserController {
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findUserById(@PathParam("id") Integer id) {
        User user = new User();
        user.setId(id);
        user.setUsername("wander");
        user.setSex("男");
        user.setAge(35);
        return Response.ok(user).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAllUsers() {
        List<User> users = new ArrayList<>();
        User user = new User();
        user.setId(1);
        user.setUsername("wander");
        user.setSex("男");
        user.setAge(35);
        users.add(user);
        return Response.ok(users).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addUser(User user) {
        if (user.getId() == 1)
            return Response.status(Response.Status.CONFLICT).build();
        else
            return Response.created(URI.create("/user/" + user.getId())).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateUser(User user) {
        return Response.ok(user).build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteUser(@PathParam("id") Integer id) {
        return Response.noContent().build();
    }
}
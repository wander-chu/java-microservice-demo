package com.example.springbootswagger.controller;

import com.example.springbootswagger.model.vo.User;
import com.fasterxml.jackson.databind.util.JSONPObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;

/**
 * 测试接口 - controller类
 *
 * @author wander
 */
@Api(tags = "测试接口")
@RestController
@RequestMapping(value = "tests")
public class TestController {
    @ApiOperation(value = "GET请求参数的测试", notes = "@RequestParam用来获得静态的URL请求参数；@PathVariable用来获得动态的URL请求入参")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "编号", required = true, paramType = "path"),
            @ApiImplicitParam(name = "name", value = "名称", required = false, paramType = "query")
    })
    @GetMapping(value = "{id}")
    public ResponseEntity<String> testGet(@PathVariable(value = "id") Long id, @RequestParam(required = false) String name) {
        if (StringUtils.isEmpty(name))
            name = "wander";

        return ResponseEntity.ok("编号: " + id + "\t名称: " + name);
    }

    @ApiOperation(value = "POST请求参数的测试", notes = "@RequestBody用来获取post请求参数",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PostMapping
    public ResponseEntity<User> testPost(@RequestBody User user) {
        return ResponseEntity.ok(user);
    }
}

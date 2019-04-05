package com.example.springbootswagger.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "用户信息")
public class User {
    @ApiModelProperty(value = "姓名", required = true, position = 1)
    private String name;
    @ApiModelProperty(value = "年龄", required = false, position = 2)
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

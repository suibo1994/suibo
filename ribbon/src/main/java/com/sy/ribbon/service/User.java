package com.sy.ribbon.service;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;


@ApiModel(value = "User",description = "测试使用的信息")
public class User implements Serializable {
    @ApiModelProperty(value = "用户id" ,required = true)
    private Integer id;

    @ApiModelProperty(value = "名称" ,required = true)
    private String username;

    @ApiModelProperty(value = "用户名" ,required = true)
    private String nickname;

    @ApiModelProperty(value = "密码" ,required = true)
    private String password;

    @ApiModelProperty(value = "状态" ,required = true)
    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}

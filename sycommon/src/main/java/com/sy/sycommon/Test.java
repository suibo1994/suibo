package com.sy.sycommon;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "Test",description = "测试使用的信息")
public class Test implements Serializable {


    @ApiModelProperty(value = "用户id" ,required = true)
    private Integer id;


    @ApiModelProperty(value = "用户名",required = true)
    private String name;


    @ApiModelProperty(value = "用户密码",required = true)
    private String word;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

}

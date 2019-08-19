package com.sy.admin;



import com.sy.sycommon.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 言曌
 * @date 2018/7/29 下午10:50
 */
@Api("人员测试")
@Controller
public class UserController {

    @Autowired(required = false)
    private UserService userService;

    @GetMapping("/user")
    @ApiOperation(value="查询User", notes="查询User" )
    @ApiImplicitParam(name = "User", value = "User信息", required = true, dataType = "User")
    public ResponseEntity<ResultVO> userList() {
        System.out.println(userService + "user........");
        List<User> userList = userService.listUsers();
        return ResponseEntity.ok().body(new ResultVO(StatusCodeEnum.SUCCESS_CODE.getCode(), StatusCodeEnum.SUCCESS_CODE.getMessage(), userList));
    }
    @GetMapping("/user2")
    @ApiOperation(value="添加User", notes="增加User" )
    @ApiImplicitParam(name = "User", value = "User信息", required = true, dataType = "User")
    public User user2(@RequestBody User user) {

        return user;
    }

    @GetMapping("/user/{id}")
    @ApiOperation(value = "单个人员", notes = "查询单个人员")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", paramType = "path", value = "编号", required = true, dataType = "Long")
    })
     public ResponseEntity<ResultVO> userList(@PathVariable("id") Integer id) {
        User user = userService.getUserById(id);
        return ResponseEntity.ok().body(new ResultVO(StatusCodeEnum.SUCCESS_CODE.getCode(), StatusCodeEnum.SUCCESS_CODE.getMessage(), user));
    }


    @PostMapping("/user")
    @ApiOperation(value="添加User", notes="增加User" )
    @ApiImplicitParam(name = "User", value = "User信息", required = true, dataType = "User")
    public ResponseEntity<ResultVO> insertUser(@RequestBody User user) {
        User result = null;
        try {
            result = userService.insertUser(user);
        } catch (Exception e) {
            return ResponseEntity.status(StatusCodeEnum.DEFAULT_FAIL_CODE.getCode()).body(new ResultVO(StatusCodeEnum.DEFAULT_FAIL_CODE.getCode(), StatusCodeEnum.DEFAULT_FAIL_CODE.getMessage()));
        }
        return ResponseEntity.ok().body(new ResultVO(StatusCodeEnum.SUCCESS_CODE.getCode(), StatusCodeEnum.SUCCESS_CODE.getMessage(), result));
    }

    @PutMapping("/user")
    @ApiOperation(value="修改User", notes="修改User" )
    @ApiImplicitParam(name = "User", value = "User信息", required = true, dataType = "User")
    public ResponseEntity<ResultVO> updateUser(@RequestBody User user) {
        try {
            if (user != null && user.getId() != null) {
                userService.updateUser(user);
            } else {
                return ResponseEntity.status(StatusCodeEnum.DEFAULT_FAIL_CODE.getCode()).body(new ResultVO(StatusCodeEnum.DEFAULT_FAIL_CODE.getCode(), StatusCodeEnum.DEFAULT_FAIL_CODE.getMessage()));
            }
        } catch (Exception e) {
            return ResponseEntity.status(StatusCodeEnum.DEFAULT_FAIL_CODE.getCode()).body(new ResultVO(StatusCodeEnum.DEFAULT_FAIL_CODE.getCode(), StatusCodeEnum.DEFAULT_FAIL_CODE.getMessage()));
        }
        return ResponseEntity.ok().body(new ResultVO(StatusCodeEnum.SUCCESS_CODE.getCode(), StatusCodeEnum.SUCCESS_CODE.getMessage(), user));
    }

    @DeleteMapping("/user/{id}")
    @ApiOperation(value = "删除人员", notes = "删除单个人员")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", paramType = "path", value = "编号", required = true, dataType = "Long")
    })
    public ResponseEntity<ResultVO> deleteUser(@PathVariable("id") Integer id) {
        try {
            userService.deleteUserById(id);
        } catch (Exception e) {
            return ResponseEntity.status(StatusCodeEnum.DEFAULT_FAIL_CODE.getCode()).body(new ResultVO(StatusCodeEnum.DEFAULT_FAIL_CODE.getCode(), StatusCodeEnum.DEFAULT_FAIL_CODE.getMessage()));
        }
        return ResponseEntity.ok().body(new ResultVO(StatusCodeEnum.SUCCESS_CODE.getCode(), StatusCodeEnum.SUCCESS_CODE.getMessage(), id));
    }


}

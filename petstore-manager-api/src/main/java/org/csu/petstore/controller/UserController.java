package org.csu.petstore.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.csu.petstore.base.BaseResult;
import org.csu.petstore.base.ResponseCode;
import org.csu.petstore.domain.User;
import org.csu.petstore.service.AddressService;
import org.csu.petstore.service.UserService;
import org.csu.petstore.utils.ParamsCheckUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Api(value = "用户管理", description = "用户管理相关接口")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AddressService addressService;

    @PostMapping(value = "/login")
    @ApiOperation(value = "登录", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "账号", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, paramType = "query", dataType = "String")
    })
    public BaseResult<Map<String, Object>> login(HttpServletRequest request, String username, String password) {
        BaseResult<Map<String, Object>> responseResult = ParamsCheckUtil.checkNecessaryParams("params[username,password]", username, password);
        if (null != responseResult) {
            return responseResult;
        }

        User user = userService.login(username, password);
        if (user == null) {
            return BaseResult.getInstance(ResponseCode.LOGIN_USERNAME_OR_PASSWORD_ERROR_903);
        }

        Map<String, Object> result = new HashMap<>();
        result.put("user", user);
        return BaseResult.getInstance(ResponseCode.SUCCESS, result);
    }

    public void zlunMethod() {
        System.out.println("this is zlun method");
    }
}

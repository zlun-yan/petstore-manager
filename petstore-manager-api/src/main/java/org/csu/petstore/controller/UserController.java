package org.csu.petstore.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.csu.petstore.base.BaseResult;
import org.csu.petstore.base.ResponseCode;
import org.csu.petstore.domain.User;
import org.csu.petstore.service.AddressService;
import org.csu.petstore.service.ImagesService;
import org.csu.petstore.service.UserService;
import org.csu.petstore.utils.DateUtil;
import org.csu.petstore.utils.ParamsCheckUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.stream.Collectors;

@Api(value = "用户管理", description = "用户管理相关接口")
@RestController
@RequestMapping("/user")
public class UserController extends BaseController{

    @Autowired
    private UserService userService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private ImagesService imagesService;

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

        request.getSession().setAttribute("userInfo", user);

        Map<String, Object> result = new HashMap<>();
        result.put("userInfo", user);
        return BaseResult.getInstance(ResponseCode.SUCCESS, result);
    }

    @GetMapping(value = "/address")
    @ApiOperation(value = "获取地址信息", notes = "获取地址信息")
    @ApiImplicitParams({
    })
    public BaseResult<Map<String, Object>> addressInfo(HttpServletRequest request) {
        Map<String, Object> result = new HashMap<>();
        User user = this.getUserInfo(request);
        result.put("addressInfo", addressService.getAddressByUserId(user.getId()));
        return BaseResult.getInstance(ResponseCode.SUCCESS,result);
    }

    @PostMapping(value = "/uploadImg")
    @ApiOperation(value = "上传图片", notes = "")
    public BaseResult<Map<String, Object>> upLoadImg(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
        if (!file.isEmpty()) {
            String fileName = file.getOriginalFilename();
            if (fileName.endsWith("png") || fileName.endsWith("jpg") ) {
                try {
                    imagesService.uploadSaveImages(file, "D:\\ZlunTemp\\static\\uploadImg");

                    return BaseResult.getInstance(ResponseCode.SUCCESS);
                } catch (Exception e) {
                    e.printStackTrace();
                    return BaseResult.getInstance(ResponseCode.SYSTEM_ERROR);
                }
            } else{
                return BaseResult.getInstance(ResponseCode.UPLOAD_FILE_FORMAT_IS_WRONG_906);
            }
        }
        return BaseResult.getInstance(ResponseCode.UPLOAD_FILE_VALIDATE_NULL_907);
    }
}

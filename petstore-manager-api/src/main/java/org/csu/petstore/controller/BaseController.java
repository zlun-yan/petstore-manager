package org.csu.petstore.controller;

import org.csu.petstore.domain.User;

import javax.servlet.http.HttpServletRequest;

public class BaseController {

    public boolean isLogin(HttpServletRequest request){
        Object userObj = request.getSession().getAttribute("userInfo");
        if (userObj == null) {
            return false;
        }
        return true;
    }

    public User getUserInfo(HttpServletRequest request) {
        if (isLogin(request)) {
            return  (User)request.getSession().getAttribute("userInfo");
        }

        return null;
    }
}

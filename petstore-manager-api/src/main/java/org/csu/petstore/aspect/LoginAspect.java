package org.csu.petstore.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.csu.petstore.base.BaseResult;
import org.csu.petstore.base.ResponseCode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Aspect
@Component
public class LoginAspect {

//    @Pointcut("(execution(* com.rexi.cost.mgr.controller..*(..)))")
    @Pointcut("(execution(* org.csu.petstore.controller..*(..)))")
    public void loginCut(){}

    @Around("loginCut()")
    public Object invoke(ProceedingJoinPoint joinPoint) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getRequest();
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getResponse();

        if (true) {
            if (!isLogin(request)) {
                return BaseResult.getInstance(ResponseCode.USER_NOT_LOGIN_905);
            }
        }

        return joinPoint.proceed();
    }

    public boolean isLogin(HttpServletRequest request){
//        Object userObj = request.getSession().getAttribute("userInfo");
//        if (userObj == null) {
//            return false;
//        }

        System.out.println("zlun login aspect");
        return true;
    }

    // 关于这个注解后面的写法 week2 execution(访问修饰符 返回值类型 类 方法 参数)
//    @Before(value = "execution(* org.csu.petstore.*.*(..))")
//    public void beforeAdvice() {
//        System.out.println("before advice...");
//    }
}

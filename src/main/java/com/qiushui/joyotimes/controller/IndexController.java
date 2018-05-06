package com.qiushui.joyotimes.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qiushui.joyotimes.domain.dao.SystemConfigRepository;
import com.qiushui.joyotimes.domain.dao.UserInfoRepository;
import com.qiushui.joyotimes.domain.entity.UserInfo;

@Controller

public class IndexController {
	@Autowired
	SystemConfigRepository systemConfigRepository;
	@Autowired
	UserInfoRepository userInfoRepository;
	@RequestMapping("/index")
	public String index(HttpSession session) {
		return "index";
	}
	@RequestMapping(value = "/login1",method = RequestMethod.POST)
    public String login(UserInfo userinfo){
        //添加用户认证信息
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(
        		userinfo.getUsername(),
                userinfo.getPassword());
        //进行验证，这里可以捕获异常，然后返回对应信息
        subject.login(usernamePasswordToken);
        return "login";
    }
	@RequestMapping(value = "/login",method = RequestMethod.POST)
	public Map<String, Object> login(HttpServletRequest request, Map<String, Object> map) throws Exception{
	    System.out.println("HomeController.login()");
	    // 登录失败从request中获取shiro处理的异常信息。
	    // shiroLoginFailure:就是shiro异常类的全类名.
	    String exception = (String) request.getAttribute("shiroLoginFailure");
	    System.out.println("exception=" + exception);
	    String msg = "";
	    if (exception != null) {
	        if (UnknownAccountException.class.getName().equals(exception)) {
	            System.out.println("UnknownAccountException -- > 账号不存在：");
	            msg = "UnknownAccountException -- > 账号不存在：";
	        } else if (IncorrectCredentialsException.class.getName().equals(exception)) {
	            System.out.println("IncorrectCredentialsException -- > 密码不正确：");
	            msg = "IncorrectCredentialsException -- > 密码不正确：";
	        } else if ("kaptchaValidateFailed".equals(exception)) {
	            System.out.println("kaptchaValidateFailed -- > 验证码错误");
	            msg = "kaptchaValidateFailed -- > 验证码错误";
	        } else {
	            msg = "else >> "+exception;
	            System.out.println("else -- >" + exception);
	        }
	    }
	    map.put("msg", msg);
	    // 此方法不处理登录成功,由shiro进行处理
	    return map;
	}
	@RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String logout(){
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
        return "login";
    }
	@RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){
        return "login";
    }
}

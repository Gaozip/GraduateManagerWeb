package org.whale.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.whale.pojo.User;

@Component
@Aspect
public class RouterAuthLoginFilter {

	public RouterAuthLoginFilter() {}

	@Pointcut("@annotation(org.whale.common.AuthLogin)")
	public void authLoginAspect() {}

	@Before("authLoginAspect()")
	public void doBefore(JoinPoint joinPoint) {
		User user = getUser();
		if (user == null) {
			throw new NotLoginException("用户未登录！");
		}
	}
	
	 /**
     * 从session中获取当前用户
     * @return
     */
    private User getUser(){
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) requestAttributes;
        HttpServletRequest request = servletRequestAttributes.getRequest();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        return user;
    }

}

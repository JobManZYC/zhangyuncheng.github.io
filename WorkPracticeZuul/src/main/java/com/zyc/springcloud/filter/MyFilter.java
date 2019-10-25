package com.zyc.springcloud.filter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import com.auth0.jwt.algorithms.Algorithm;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.zyc.springcloud.jwt.JWTVerifies;

import ch.qos.logback.classic.Logger;

@Component
public class MyFilter extends ZuulFilter{

	private static Logger log = (Logger) LoggerFactory.getLogger(MyFilter.class);
	
	@Override
	public boolean shouldFilter() {
		// 登录 和 注册 不进行判断token
		RequestContext rct=RequestContext.getCurrentContext();
		HttpServletRequest request=rct.getRequest();
		String url=request.getRequestURI();

		if(url.equals("/userzuul/login")|| url.equals("/userzuul/register")||url.equals("/userzuul/main")) {
			return false;
		}else {
			return true;
		}
//		if(url.equals("/userzuul/getuserinfo")) {
//			return true;
//		}
//		return false;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "pre";
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public Object run() {		
		RequestContext rct=RequestContext.getCurrentContext();
		HttpServletRequest request=rct.getRequest();
		log.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
		Cookie[] cookies = request.getCookies();
		String token=null;
		String username=null;
		int  flag=0;
		for(Cookie cookie:cookies) {
			if(cookie.getName().equals("token")) {
				token=cookie.getValue();				
			}
			if(cookie.getName().equals("username")&&flag==0) {
				username=cookie.getValue();	
				flag=1;
			}
		}		
		if(JWTVerifies.verify(token,username)) {
            log.warn("token is empty");
            rct.setSendZuulResponse(false);
            rct.setResponseStatusCode(401);
            try {
            	rct.getResponse().getWriter().write("token is empty or error");
            }catch (Exception e){}
            return null;
        }
        log.info("ok");
        return null;
	}

}

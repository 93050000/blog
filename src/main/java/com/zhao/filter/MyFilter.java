package com.zhao.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

//@WebFilter(value = {"/antionLogin","/antionMyFilter"})
//组件注册使用
@Component
public class MyFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		chain.doFilter(request,response);
		
	}

}

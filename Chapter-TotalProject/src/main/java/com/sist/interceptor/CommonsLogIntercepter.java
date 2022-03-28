package com.sist.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
// ==> AOP
public class CommonsLogIntercepter extends HandlerInterceptorAdapter{

	// 메소드 수행전 (Controller 메소드가 수행하기 전)
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("=============================");
		System.out.println("1. 클라이언트 요청");
		System.out.println("2. 요청한 URI:"+request.getRequestURI());
		System.out.println("3. 요청 처리 준비 종료");
		return super.preHandle(request, response, handler);
	}
    // 메소드 수행후 (Controller 메소드 수행 완료)
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("============================");
		System.out.println("1. @GetMapping,@PostMapping,@RequestMapping 찾기");
		System.out.println("2. 요청 처리");
		System.out.println("3. 결과값을 JSP로 전송:"+modelAndView.getViewName());
		System.out.println("4. 전송 준비 종료");
		super.postHandle(request, response, handler, modelAndView);
	}
    // 메소드 수행이 종료후에 화면에 JSP가 출력하기 전 
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("==========================");
		System.out.println("1. JSP로 전송 완료 ");
		System.out.println("2. 화면 출력..");
		// TODO Auto-generated method stub
		super.afterCompletion(request, response, handler, ex);
	}
   
}

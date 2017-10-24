package mshop.common.logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoggerInterceptor extends HandlerInterceptorAdapter {
	
	/**
	 * log4j의 log객체를 log라는 이름으로 생성함
	 * 생성자에 현재 클래스 입력
	 *  
	 */
	
	protected Log log = LogFactory.getLog(LoggerInterceptor.class);
	
	// 전처리기
	// 클라이언트 --> 컨트롤러 요청을 처리
	// 컨트롤러가 호출되기 전에 실행됨
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		if(log.isDebugEnabled()) {
			log.debug("=========== start ============");
			log.debug("Request URL \t : " + request.getRequestURI());
		}
		
		return super.preHandle(request, response, handler);				
	}
	
	// 후처리기
	// 컨트롤러 --> 클라이언트 요청을 처리
	// 컨트롤러가 실행되고 난 후에 호출됨
	public void postHandle(HttpServletRequest requset, HttpServletResponse response, Object handler) throws Exception {
		
		if(log.isDebugEnabled()) {
			log.debug("=========== end ============");
		}
		
	}	

}

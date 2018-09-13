package egovframework.example.cmmn.webSocket;

import java.util.Collection;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

/**
 * ========================================
 * 작성자       | 정종문
 * 최초생성일  | 2018-09-08
 * 페이지       | WebSocketInterceptor.java
 * 설명          | 웹 채팅 시 WebSocketHandler 에서 기존 session에 담겨진 값을 사용하지 못하여
 *           임의로 작성한 Interceptor를 통해 기존 session의 정보를 Handler에서 사용가능 하도록 재가공.
 * ========================================
 */
public class WebSocketInterceptor extends HttpSessionHandshakeInterceptor{

	private static final Logger logger = LoggerFactory.getLogger(WebSocketInterceptor.class);
	
	private Collection<String> attributeNames;

	@Override
	public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
			Map<String, Object> attributes) throws Exception {
		logger.info("{} session 정보 가공... ", "WebSocketHandler");
		
		if ( request instanceof ServerHttpRequest) {
			ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) request;
			HttpSession session = servletRequest.getServletRequest().getSession(false);
			if ( session != null ) {
				Enumeration<String> names = session.getAttributeNames();
				while (names.hasMoreElements()) {
					String name = names.nextElement();
					if (CollectionUtils.isEmpty(this.attributeNames) || this.attributeNames.contains(name)) {
						if (logger.isTraceEnabled()) {
							logger.trace("Adding HTTP session attribute to handshake attributes: " + name);
						}
						attributes.put(name, session.getAttribute(name));
					}
					else {
						if (logger.isTraceEnabled()) {
							logger.trace("Skipped HTTP session attribute");
						}
					}
				}
			}
		}
		return true;
	}
	
}

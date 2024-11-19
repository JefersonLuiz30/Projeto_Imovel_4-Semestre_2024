package app.interceptor;

import java.io.IOException;

import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AutorizacaoInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, 
		Object handler) {
		String uri = req.getRequestURI();		
		if (uri.endsWith("index")
				|| uri.endsWith("loginusuario")
				|| uri.endsWith("cadastrarusuario")
				|| uri.endsWith("empresa")
				|| uri.contains("/imagens")
				|| uri.contains("/css")
				|| uri.contains("/js")) {
			return true;
		} else if (req.getSession().getAttribute("usuario") != null) {
			return true;
		} else {
			try {
				res.sendRedirect("/loginusuario");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return false;
		}
	}
}

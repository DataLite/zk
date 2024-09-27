package org.zkoss.zktest.http;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.zkoss.zk.ui.http.DHtmlLayoutServlet;

public class ZKTestServlet extends DHtmlLayoutServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String zktheme = request.getParameter("zktheme");
		List<String> themes = Arrays.asList("atlantic", "silvertail", "sapphire");
		boolean isDefaultTheme = zktheme == null || !themes.contains(zktheme.toLowerCase());
		if (!isDefaultTheme) { // fixed for HtmlUnit issue
			Cookie cookie = new Cookie("zktheme",
					isDefaultTheme ? null : zktheme);
			cookie.setPath("/zktest/");
			((HttpServletResponse) response).addCookie(cookie);
		}
		super.doGet(request, response);
	}
}

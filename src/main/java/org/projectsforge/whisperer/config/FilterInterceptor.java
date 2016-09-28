package org.projectsforge.whisperer.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class FilterInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		request.setAttribute("COMMAND", "NULL");
		String part1 = "";
		String part2 = "";
		String part3 = "";

		String spli = request.getParameter("msg");
		if (spli != null) {
			String[] spStrings = spli.split("@");
			if (spStrings.length == 1)
				return true;
			spli = spStrings[1];
			spStrings = spli.split(":");
			if (spStrings.length == 1) {
				spStrings = spStrings[0].split(" ");
				if (spStrings.length >= 3) {
					part1 = spStrings[0];
					part2 = spStrings[1];
					part3 = spStrings[2];
				} else {
					part1 = spStrings[0];
					if (spStrings.length == 2) {
						part2 = spStrings[1];
						String[] splitS = part2.split(" ");
						part2 = splitS[0];
						if (splitS.length == 2)
							part3 = splitS[1];
					}
				}
			}else {
				part1 = spStrings[0];
				if (spStrings.length == 2) {
					part2 = spStrings[1];
					String[] splitS = part2.split(" ");
					part2 = splitS[0];
					if (splitS.length == 2)
						part3 = splitS[1];
				}
			}
			switch (part1) {
			case "create-user":
				request.setAttribute("COMMAND", "CREATEUSER");
				request.setAttribute("name", part2);
				request.setAttribute("password", part3);
				break;
			case "login":
				response.sendRedirect("/login");
				break;
			case "logout":
				response.sendRedirect("/logout");
				break;
			case "clock":
				switch (part2) {
				case "enable-clockroom":
					request.setAttribute("periode", part3);
					break;
				case "now":
					request.setAttribute("COMMAND", "CURRENTTIME");
					break;
				default:
					break;
				}
				break;
			case "whoami":
				request.setAttribute("COMMAND", "WHOAMI");
				break;
			case "room":
				if (part2 .equals("list"))
					request.setAttribute("COMMAND", "ROOMLIST");
				if(part2.equals("create")){
					request.setAttribute("COMMAND", "CREATEROOM");
					request.setAttribute("ROOMNAME", part3);
				}
				if(part2.equals("switch")){
					request.setAttribute("COMMAND", "SWITCHROOM");
					request.setAttribute("ROOMNAME", part3);
				}
				if(part2.equals("survey")){
					request.setAttribute("COMMAND", "SURVEY");
					request.setAttribute("NAME", part3);
				}
				if(part2.equals("no-survey")){
					request.setAttribute("COMMAND", "NOSURVEY");
					request.setAttribute("NAME", part3);
				}
				break;
			case "history":
				switch (part2) {
				case "show":
					request.setAttribute("COMMAND", "HISTORY");
					request.setAttribute("n", part3);
					break;
				case "clear":
					request.setAttribute("COMMAND", "HISTORYCLEAR");
					break;
				default:
					break;
				}
				break;
			case "lastseen":
				
				request.setAttribute("COMMAND", "LASTSEEN");
				request.setAttribute("NAME", part2);

				
				break;

			default:
				break;
			}
			return true;

		}
		System.out.println("！Before Method Execution！");
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		System.out.println("！method executed！");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("！Request Completed！");
	}
}

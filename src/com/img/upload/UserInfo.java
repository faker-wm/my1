package com.img.upload;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/userinfo")
public class UserInfo  extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		
		String username = req.getParameter("username");
		String headimg = req.getParameter("headimg");
		String[] str =  req.getParameterValues("hobby");
		System.out.println(str.toString());
		System.out.println(Arrays.toString(str));
		String ah = "";
		for (String string : str) {
			ah+=string+"¡¢";
		}
		ah =  ah.substring(0, ah.length()-1);
		System.out.println(ah);
//		super.doGet(req, resp);
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	
}

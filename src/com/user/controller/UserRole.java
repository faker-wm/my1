package com.user.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.Request;

import com.img.utils.Connect;
import com.img.utils.PageUtils;
import com.user.entity.Banner;
import com.user.entity.User;

@WebServlet("/user_role")
public class UserRole  extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection connect = Connect.druidTest();
		 
		String id = req.getParameter("id");
		String roleid = req.getParameter("roleid");
		
		String sql = " update user set role_id=? where id = ?";

		List<User> lists = new ArrayList<>();
		int i = 0;
		try {
			PreparedStatement preparedStatement = connect.prepareStatement(sql);
			preparedStatement.setInt(1, Integer.parseInt(roleid));
			preparedStatement.setInt(2, Integer.parseInt(id));
			 i = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
 
		if (i>0) {
			req.setAttribute("date", "³É¹¦");
		}else {
			req.setAttribute("date", "Ê§°Ü");
		}
		req.getRequestDispatcher("/WEB-INF/back/privilege-users.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	
}

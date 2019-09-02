package com.user.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSONObject;
import com.img.utils.Connect;
import com.user.entity.User;

@WebServlet("/login")
public class login extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		Map<String, String> map = new HashMap<>();
		User user = new User();
		String username =  req.getParameter("username");
		String password =  req.getParameter("password");
		Connection connection =  Connect.druidTest();
//		String sql = "select * from UserInfo where username=? and password=?";
		String sql = "select * from user where username=? and password=?";
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement =  connection.prepareStatement(sql);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			preparedStatement.execute();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			ResultSet resultSet =  preparedStatement.getResultSet();
			 resultSet.last();
			 int count  = resultSet.getRow();
			 resultSet.beforeFirst();
			 
			if (count>0) {
				while (resultSet.next()) {
					int id =  resultSet.getInt("id");
					String username1 =  resultSet.getString("username");
					String password1 =  resultSet.getString("password");
					int role_id =  resultSet.getInt("role_id");
//					Date createTime =  resultSet.getTimestamp("CreatTime");
					user.setId(id);
					user.setRoleId(role_id);
					user.setUsername(username1);
					user.setPassword(password1);
//					user.setCreateTime(createTime);
				}
			  HttpSession session =  req.getSession();
			  session.setMaxInactiveInterval(18000);
			  session.setAttribute("userinfo", user);
			  map.put("message", "³É¹¦");
			}else {
				map.put("message", "Ê§°Ü");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		resp.getWriter().println(JSONObject.toJSON(map));
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

	
}

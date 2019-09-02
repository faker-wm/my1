package com.user.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.img.utils.Connect;
import com.user.entity.User;

@WebServlet("/index")
public class index  extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(req.getSession().getMaxInactiveInterval());
		User user =  (User) req.getSession().getAttribute("userinfo");
		int role_id = user.getRoleId();
		System.out.println(role_id);
		Connection connection =  Connect.druidTest();
		String sql = "SELECT * from one_catalog where  role_id = ?";
		List<Map<String, Object>> lists = new ArrayList<>();
		List<Map<String, Object>> lists2 = new ArrayList<>();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, role_id);
			ResultSet resultSet =  preparedStatement.executeQuery();
			while (resultSet.next()) {
			Map<String, Object> map = new HashMap<>();
			 int id =	resultSet.getInt("id");
			 String module =	resultSet.getString("module");
			 map.put("id", id);
			 map.put("module", module);
			 lists.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		for (Map<String, Object> map : lists) {
			 int id = (int) map.get("id");
			 String sql2 = "SELECT * from two_catalog where  role_id = ? and superior_module=?";
				try {
					PreparedStatement preparedStatement = connection.prepareStatement(sql2);
					preparedStatement.setInt(1, role_id);
					preparedStatement.setInt(2, id);
					ResultSet resultSet =  preparedStatement.executeQuery();
					while (resultSet.next()) {
						Map<String, Object> map2 = new HashMap<>();
					 int superior_module =	resultSet.getInt("superior_module");
					 String module =	resultSet.getString("module");
					 String url =	resultSet.getString("url");
					 map2.put("superior_module", superior_module);
					 map2.put("module", module);
					 map2.put("url", url);
					 lists2.add(map2);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		req.setAttribute("one", lists);
		req.setAttribute("two", lists2);
		req.getRequestDispatcher("/WEB-INF/back/index.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	
}

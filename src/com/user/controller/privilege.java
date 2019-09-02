package com.user.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.img.utils.Connect;

@WebServlet("/privilege")
public class privilege extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		Map<String, String> map = new HashMap<>();

		String id = req.getParameter("id");
		String module = req.getParameter("module");
		String superior_module = req.getParameter("superior_module");
		String url = req.getParameter("url");
		String grade = req.getParameter("grade");

		// id等于null是新增反之是修改
		if (id == null || id == "") {
			Connection connect = Connect.druidTest();
			String sql = " insert into privilege values(null,?,?,?,?)";
			int i = 0;
			try {
				PreparedStatement preparedStatement = connect.prepareStatement(sql);
				preparedStatement.setString(1, module);
				preparedStatement.setString(2, superior_module);
				preparedStatement.setString(3, url);
				preparedStatement.setInt(4, Integer.valueOf(grade));
				i = preparedStatement.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (i > 0) {
				map.put("message", "成功");
			} else {
				map.put("message", "失败");
			}
		} /*else {
			Connection connect =  Connect.druidTest();
			String sql = " update banner set banner=?,title=?,URL=?,banner.order=?,banner.start=?  where id=? ";
			int i = 0;
			 try {
				PreparedStatement preparedStatement =  connect.prepareStatement(sql);
				preparedStatement.setString(1, banner);
				preparedStatement.setString(2, title);
				preparedStatement.setString(3, URL);
				preparedStatement.setInt(4, Integer.valueOf(order));
				preparedStatement.setInt(5, Integer.valueOf(start));
				preparedStatement.setInt(6, Integer.valueOf(id));
				i = preparedStatement.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (i>0) {
				map.put("message", "成功");
			}else {
				map.put("message", "失败");
			}
		}*/
		resp.getWriter().print(JSONObject.toJSON(map));
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}

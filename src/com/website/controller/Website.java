package com.website.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.img.utils.Connect;
import com.img.utils.PageUtils;
import com.user.entity.Banner;

@WebServlet("/website")
public class Website extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection connect = Connect.druidTest();

		String sql = " select * from banner  ";
		List<Banner> lists = new ArrayList<>();
		try {
			PreparedStatement preparedStatement = connect.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				int order = rs.getInt("order");
				int start = rs.getInt("start");
				String banner2 = rs.getString("banner");
				String title = rs.getString("title");
				String URL = rs.getString("URL");

				Banner banner3 = new Banner();
				banner3.setId(id);
				banner3.setBanner(banner2);
				banner3.setTitle(title);
				banner3.setURL(URL);
				banner3.setOrder(order);
				banner3.setStart(start);
				lists.add(banner3);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 返回查询出的数据
		req.setAttribute("banner", lists);
		req.getRequestDispatcher("/WEB-INF/website/index.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

	
}

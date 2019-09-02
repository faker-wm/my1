package com.user.controller;

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
import com.user.entity.Banner;
import com.user.entity.Privilege;

@WebServlet("/updateprivilege")
public class UpdatePrivilege extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		
 
		String type =  req.getParameter("type");
		System.out.println(type);
		if (type.equals("add")) {
			List<Privilege> lists = new ArrayList<>();
			Connection connection = Connect.druidTest();
			String sql = " select * from  privilege where grade=1";
			try {
				PreparedStatement preparedStatement =  connection.prepareStatement(sql);
				ResultSet rs =  preparedStatement.executeQuery();
				while (rs.next()) {
					Privilege privilege = new Privilege();
					privilege.setId(rs.getInt("id"));
					privilege.setModule(rs.getString("module"));
					lists.add(privilege);
				}
				req.setAttribute("privilege", lists);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			req.getRequestDispatcher("/WEB-INF/back/privilege-add.jsp").forward(req, resp);
			return;
		}
		/*else if (type.equals("update")) {
			String id =  req.getParameter("id");
			
			Connection connection = Connect.druidTest();
			String sql = " select * from banner where id = ? ";
			try {
				PreparedStatement preparedStatement =  connection.prepareStatement(sql);
				preparedStatement.setInt(1, Integer.valueOf(id));
				ResultSet rs =  preparedStatement.executeQuery();
				while (rs.next()) {
					int id1 = rs.getInt("id");
					int order = rs.getInt("order");
					int start = rs.getInt("start");
					String banner2 = rs.getString("banner");
					String title = rs.getString("title");
					String URL = rs.getString("URL");
					
					banner3.setId(id1);
					banner3.setBanner(banner2);
					banner3.setTitle(title);
					banner3.setURL(URL);
					banner3.setOrder(order);
					banner3.setStart(start);
				}
				req.setAttribute("banner", banner3);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			req.getRequestDispatcher("/WEB-INF/back/banner-add.jsp").forward(req, resp);
			return;
		}else if (type.equals("delete")) {
			String id =  req.getParameter("id");
			
			Connection connection = Connect.druidTest();
			String sql = " delete from banner where id = ? ";
			try {
				PreparedStatement preparedStatement =  connection.prepareStatement(sql);
				preparedStatement.setInt(1, Integer.valueOf(id));
				preparedStatement.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			req.getRequestDispatcher("/bannerSelect").forward(req, resp);
			return;
			
		}*/
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	
}

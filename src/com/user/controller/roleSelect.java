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

import com.img.utils.Connect;
import com.img.utils.PageUtils;
import com.user.entity.Banner;
import com.user.entity.User;

@WebServlet("/role_select")
public class roleSelect  extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection connect = Connect.druidTest();
		String countsql = " select count(*) count from role";
		int count = 0;
		try {
			PreparedStatement preparedStatement1 = connect.prepareStatement(countsql);
			ResultSet rs1 = preparedStatement1.executeQuery();
			while (rs1.next()) {
				count = rs1.getInt("count");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		/**
		 * currentPage:当前页 count:总记录数 pageSize:每页显示的条数
		 */
		// 获取前台当前第几页
		String currentPage = req.getParameter("currentPage");
		// 获取前台每页显示的条数
		String pageSize = req.getParameter("pageSize");

		// 调用分页工具类
		PageUtils pageUtils = new PageUtils(currentPage, count, pageSize);
		// 从分页工具类中得到开始记录数
		int begin = pageUtils.getPageRecord();
		// 从分页工具类中得到每页显示记录数
		int number = pageUtils.getPageSize();
		// 从分页工具类中得到前台页面分页模型（传入页面使用的html代码）
		String page = pageUtils.getPage();

		String sql = " select * from role limit " + begin + ", " + number + " ";

		List<Map<String, Object>> lists = new ArrayList<>();
		try {
			PreparedStatement preparedStatement = connect.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String role_name = rs.getString("role_name");
				Map<String, Object> map = new HashMap<>();
				map.put("id", id);
				map.put("role_name", role_name);
				lists.add(map);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 返回查询出的数据
		req.setAttribute("user", lists);
		// 返回每页显示记录数
		req.setAttribute("number", number);
		// 返回页面分页html模型
		req.setAttribute("page", page);
		req.getRequestDispatcher("/WEB-INF/back/privilege-role.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	
}

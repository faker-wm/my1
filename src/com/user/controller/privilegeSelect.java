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

import com.alibaba.fastjson.JSONObject;
import com.img.utils.Connect;
import com.img.utils.PageUtils;
import com.img.utils.Pager;
import com.user.entity.Banner;

@WebServlet("/privilegeSelect")
public class privilegeSelect extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//查询哪个角色的权限
		String role_id = req.getParameter("role_id");
		if (role_id==null) {
			role_id = "0";
		}
		Connection connect = Connect.druidTest();
		String sql = "SELECT privilege.*,isvisit,mo.module superior_module_name from privilege LEFT JOIN (SELECT * from privilege_role WHERE  role_id= ? ) privilege_role  ON privilege.id=privilege_role.privilege_id  LEFT JOIN privilege mo ON privilege.superior_module = mo.id";
		List<Map<String, Object>> lists1 = new ArrayList<>();
		List<Map<String, Object>> lists = new ArrayList<>();
		try {
			PreparedStatement preparedStatement = connect.prepareStatement(sql);
			preparedStatement.setInt(1, Integer.valueOf(role_id));
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String isvisit = rs.getString("isvisit");
				String module = rs.getString("module");
				String grade = rs.getString("grade");
				String superior_module_name = rs.getString("superior_module_name");
				Map<String, Object> map = new HashMap<>();
				map.put("id", id);
				map.put("module", module);
				map.put("superior_module_name", superior_module_name);
				map.put("isvisit", isvisit);
				map.put("grade", grade);
				lists1.add(map);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String sql1 = " select * from role ";
		try {
			PreparedStatement preparedStatement = connect.prepareStatement(sql1);
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
		req.setAttribute("role", lists);
		// 返回查询出的数据
		req.setAttribute("privilege", lists1);
		req.setAttribute("role_id", role_id);
		req.getRequestDispatcher("/WEB-INF/back/privilege-roles-modles.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}

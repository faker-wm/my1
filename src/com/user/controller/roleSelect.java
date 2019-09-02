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
		 * currentPage:��ǰҳ count:�ܼ�¼�� pageSize:ÿҳ��ʾ������
		 */
		// ��ȡǰ̨��ǰ�ڼ�ҳ
		String currentPage = req.getParameter("currentPage");
		// ��ȡǰ̨ÿҳ��ʾ������
		String pageSize = req.getParameter("pageSize");

		// ���÷�ҳ������
		PageUtils pageUtils = new PageUtils(currentPage, count, pageSize);
		// �ӷ�ҳ�������еõ���ʼ��¼��
		int begin = pageUtils.getPageRecord();
		// �ӷ�ҳ�������еõ�ÿҳ��ʾ��¼��
		int number = pageUtils.getPageSize();
		// �ӷ�ҳ�������еõ�ǰ̨ҳ���ҳģ�ͣ�����ҳ��ʹ�õ�html���룩
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
		// ���ز�ѯ��������
		req.setAttribute("user", lists);
		// ����ÿҳ��ʾ��¼��
		req.setAttribute("number", number);
		// ����ҳ���ҳhtmlģ��
		req.setAttribute("page", page);
		req.getRequestDispatcher("/WEB-INF/back/privilege-role.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	
}

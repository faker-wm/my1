package com.user.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.img.utils.Connect;
import com.user.entity.Banner;

@WebServlet("/update_privilege_role")
public class UpdatePrivilegeRole extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");

		String privilege_id = req.getParameter("privilege_id");
		String isvisit = req.getParameter("isvisit");
		String role_id = req.getParameter("role_id");
		int count = 0;
		Connection connect = Connect.druidTest();
		String sql = "select  *    from  privilege_role where privilege_id = ? and role_id=?";
		try {
			PreparedStatement preparedStatement = connect.prepareStatement(sql);
			preparedStatement.setInt(1, Integer.parseInt(privilege_id));
			preparedStatement.setInt(2, Integer.parseInt(role_id));
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.last();
			count = resultSet.getRow();
			resultSet.beforeFirst();
			
			if (count > 0) {
				resultSet.next();
			    int id = resultSet.getInt("id");
				String updatesql = " update privilege_role set isvisit= ? where id = ?";
				PreparedStatement preparedStatementupdatesql = connect.prepareStatement(updatesql);
				preparedStatementupdatesql.setInt(1, Integer.parseInt(isvisit));
				preparedStatementupdatesql.setInt(2, id);
				preparedStatementupdatesql.executeUpdate();
			} else {
				String insertsql = "  insert into  privilege_role values(null,?,?,?)";
				PreparedStatement preparedStatementinsertsql  = connect.prepareStatement(insertsql);
				preparedStatementinsertsql.setInt(1, Integer.parseInt(privilege_id));
				preparedStatementinsertsql.setInt(2, Integer.parseInt(role_id));
				preparedStatementinsertsql.setInt(3, Integer.parseInt(isvisit));
				preparedStatementinsertsql.executeUpdate();
			}
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		resp.getWriter().print("³É¹¦");
		return;

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}

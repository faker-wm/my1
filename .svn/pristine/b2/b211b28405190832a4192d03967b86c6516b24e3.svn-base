package com.img.upload;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.img.utils.upload;

@WebServlet("/img")
public class imgupload extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String  saveFilename = null;
	 
		List<Map<String, String>> lists = new ArrayList<>();
		upload upload = new upload();
		String re = upload.uploadfile(req, resp, lists);
		if ("sucess".equals(re)) {
			for (Map<String, String> map : lists) {
				saveFilename =  map.get("saveFilename");
				System.out.println(saveFilename);
			}
		}
		
		String json =  JSONObject.toJSON(lists).toString();
		resp.getWriter().println(json);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	
}

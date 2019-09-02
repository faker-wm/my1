package com.img.utils;
/**
 * 分页工具类
 * 
 * @author H.ros
 *
 */
public class PageUtils {
	// 当前页默认第1页（从页面获取的当前页码，未计算）
	private int currentPage = 1;
	// 前一页
	private int prevPage;
	// 下一页
	private int nextPage;
	// 尾页
	private int lastPage;
	// 总记录数
	private int count;
	// 每页的条数,默认10条
	private int pageSize = 10;
	// 开始记录数，分页计入数（使用时调用的初始页，计算后）
	private int pageRecord;
	// 页面分页html模型代码
	private String page;
 
	// 有参构造器
	public PageUtils(String currentPage, int count, String pageSize) {
		init(currentPage, count, pageSize);
		initLastPage();
		initCurrentPage();
		initPrevPage();
		initNextPage();
		initPageRecord();
		initPage();
	}
 
	// 初始化三个重要元素
	private void init(String currentPage, int count, String pageSize) {
		if (currentPage != null && currentPage != "" && currentPage != "0") {
			this.currentPage = Integer.parseInt(currentPage);
		}
		
		this.count = count;
		
		if (pageSize != null && pageSize != "" && pageSize != "0") {
			this.pageSize = Integer.parseInt(pageSize);;
		}
	}
 
	// 初始化尾页
	private void initLastPage() {
		if (count % pageSize == 0) {
			lastPage = count / pageSize;
		} else {
			lastPage = count / pageSize + 1;
		}
	}
 
	// 初始化并矫正当前页(防止外部访问出错)
	private void initCurrentPage() {
		if (currentPage < 1) {
			currentPage = 1;
		} else if (currentPage > lastPage) {
			currentPage = lastPage;
		}
	}
 
	// 初始化上一页
	private void initPrevPage() {
		if (currentPage != 1) {
			prevPage = currentPage - 1;
		}else{
			prevPage = 1;
		}
	}
 
	// 初始化下一页
	private void initNextPage() {
		if (currentPage != lastPage) {
			nextPage = currentPage + 1;
		}else{
			nextPage = lastPage;
		}
	}
 
	// 初始化分页计入数
	private void initPageRecord() {
		pageRecord = (currentPage - 1) * pageSize;
        if(pageRecord < 0){
            pageRecord = 0;
        }
	}
 
	// 初始化html页面分页模型代码
	private void initPage() {
		page = "<div style='text-align: right;'>";
		page += "第" + currentPage + "/" + lastPage + "页，共" + count + "条记录。";
		page += "<select style='width: 70px;' id='pageSize' onchange='page(1)'><option>10</option><option>20</option><option>50</option></select>";
		page += "<input type='button' value='首页' onclick='page(1)' />";
		page += "<input type='button' value='上一页' onclick='page(" + prevPage + ")' />";
		page += "<input type='button' value='下一页' onclick='page(" + nextPage + ")' />";
		page += "<input type='button' value='尾页' onclick='page(" + lastPage + ")' />";
		page += "</div>";
	}
 
	/*
	 * 对外访问通道
	 */
	public int getCurrentPage() {
		return currentPage;
	}
 
	public int getPrevPage() {
		return prevPage;
	}
 
	public int getNextPage() {
		return nextPage;
	}
 
	public int getLastPage() {
		return lastPage;
	}
 
	public int getCount() {
		return count;
	}
 
	public int getPageSize() {
		return pageSize;
	}
 
	public int getPageRecord() {
		return pageRecord;
	}
 
	public String getPage() {
		return page;
	}
 
}

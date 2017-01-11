package com.itcast.session;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out=resp.getWriter();
		Map<String, Book> books=DB.getAll();
		for (Map.Entry<String, Book> entry: books.entrySet()) {
			Book book=entry.getValue();
			out.println(book.getName()+"<a href='/ShoppingDemo/buy?id="+book.getId()+"' target='_blank'>购买</a><br/>");
		}
	}
}
class DB{
	//否则不按顺序存储
	private static Map<String, Book> map=new LinkedHashMap<String, Book>();
	static{
		map.put("1", new Book("1", "Java web", "张孝祥", "开发入门经典"));
		map.put("2", new Book("2", "C语言程序设计", "谭浩强", "程序入门"));
		map.put("3", new Book("3", "数据结构", "严蔚敏", "高手进阶"));
		map.put("4", new Book("4", "PHP程序设计", "不知", "世界上最好的语言"));
	}
	
	public static Map getAll(){
		return map;
	}
}

class Book implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private String author;
	private String description;
	
	public Book(){
		
	}
	
	public Book(String id, String name, String author, String description) {
		this.id = id;
		this.name = name;
		this.author = author;
		this.description = description;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
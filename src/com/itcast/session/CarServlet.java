package com.itcast.session;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CarServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out=resp.getWriter();
		
		HttpSession session=req.getSession(false);
		if (session==null) {
			out.write("购物车为空!");
			return;
		}
		List<Book> books=(List<Book>) session.getAttribute("list");
		out.write("你购买了如下产品: <br/>");
		for (Book book : books) {
			out.write(book.getName()+"<br/>");
		}
		
	}
}

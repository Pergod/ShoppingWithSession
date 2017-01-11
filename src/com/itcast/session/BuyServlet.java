package com.itcast.session;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BuyServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		Book book=(Book) DB.getAll().get(id);
		HttpSession session=req.getSession();
		LinkedList<Book> books=(LinkedList<Book>) session.getAttribute("list");
		if (books == null) {
			books=new LinkedList<Book>();
			session.setAttribute("list", books); 
		}
		if (books.contains(book)) {
			books.remove(book);
		}
		books.addFirst(book);
		resp.sendRedirect("/ShoppingDemo/car");
	}
}

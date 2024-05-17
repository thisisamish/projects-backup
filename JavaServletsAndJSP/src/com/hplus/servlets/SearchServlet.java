package com.hplus.servlets;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hplus.beans.Product;
import com.hplus.dao.ApplicationDao;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String searchString = req.getParameter("search");
		ApplicationDao dao = new ApplicationDao();
		List<Product> products = dao.searchProducts(searchString);
		String page = getHTMLString(req.getServletContext().getRealPath("/html/search.html"), products);
		resp.getWriter().write(page);
	}
	
	public String getHTMLString(String filePath, List<Product> products) {
		String page = null;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
			String line = "";
			StringBuffer buffer = new StringBuffer();
			while ((line = reader.readLine()) != null) {
				buffer.append(line);
			}
			reader.close();
			page = buffer.toString();
			
			page = MessageFormat.format(page, products.get(0).getProductImgPath(), products.get(1).getProductImgPath(), products.get(2).getProductImgPath(),
					products.get(0).getProductName(), products.get(1).getProductName(), products.get(2).getProductName(), 0);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return page;
	}
}

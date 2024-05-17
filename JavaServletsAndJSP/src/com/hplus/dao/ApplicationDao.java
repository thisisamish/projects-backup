package com.hplus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hplus.beans.Product;

public class ApplicationDao {
	public List<Product> searchProducts(String searchString) {
		Product product = null;
		List<Product> products = new ArrayList<>();
		Connection conn = DBConnection.getConnection();
		
		String sql = "select * from products where product_name like ?";
		
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, "%" + searchString + "%");
			ResultSet set = statement.executeQuery();
			while (set.next()) {
				product = new Product();
				product.setProductId(set.getInt("product_id"));
				product.setProductImgPath(set.getString("image_path"));
				product.setProductName(set.getString("product_name"));
				products.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return products;
	}
}

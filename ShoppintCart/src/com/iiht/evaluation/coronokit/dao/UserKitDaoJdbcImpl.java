package com.iiht.evaluation.coronokit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.iiht.evaluation.coronokit.exception.ServiceException;
import com.iiht.evaluation.coronokit.model.ProductMaster;

public class UserKitDaoJdbcImpl implements UserKitDao{

	public static final String GET_PROD_BY_ID_QRY = "SELECT pid,pname,pcost,pdesc FROM products WHERE pid=?";
	public static final String GET_ALL_PRODS_QRY = "SELECT pid,pname,pcost,pdesc FROM products";
	
	@Override
	public ProductMaster getById(int productID) throws ServiceException {
		ProductMaster product = null;

		try (Connection con = ConnectionFactory.getConnection();
				PreparedStatement pst = con.prepareStatement(GET_PROD_BY_ID_QRY);) {

			pst.setInt(1, productID);
			
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				product = new ProductMaster();
				product.setId(rs.getInt(1));;
				product.setProductName(rs.getString(2));;
				product.setCost(rs.getDouble(3));;
				product.setProductDescription(rs.getString(4));;
			}

		} catch (SQLException exp) {
			throw new ServiceException("Feteching product failed!");
		}

		return product;
	}
	
	@Override
	public List<ProductMaster> getAll() throws ServiceException {
		List<ProductMaster> products = new ArrayList<>();
		
		try (Connection con = ConnectionFactory.getConnection();
				PreparedStatement pst = con.prepareStatement(GET_ALL_PRODS_QRY);) {
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				ProductMaster product = new ProductMaster();
				product.setId(rs.getInt(1));
				product.setProductName(rs.getString(2));
				product.setCost(rs.getDouble(3));
				product.setProductDescription(rs.getString(4));
				
				products.add(product);
			}
			
			if(products.isEmpty()) {
				products=null;
			}

		} catch (SQLException exp) {
			throw new ServiceException("Feteching products failed!");
		}
		
		return products;
	}

}

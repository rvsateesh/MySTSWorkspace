package com.iiht.evaluation.coronokit.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.iiht.evaluation.coronokit.exception.ServiceException;
import com.iiht.evaluation.coronokit.model.ProductMaster;
import com.iiht.evaluation.coronokit.dao.ConnectionFactory;
import com.iiht.evaluation.coronokit.dao.ProductMasterDao;

public class AdminDaoJdbcImpl implements AdminDao{
	
	public static final String INS_PROD_QRY = "INSERT INTO products(pid,pname,pcost,pdesc) VALUES(?,?,?,?)";
	public static final String UPD_PROD_QRY = "UPDATE products set pname=?,pcost=?,pdesc=? WHERE pid=?";
	public static final String DEL_PROD_QRY = "DELETE FROM products WHERE pid=?";
	public static final String GET_ALL_PRODS_QRY = "SELECT pid,pname,pcost,pdesc FROM products";
	public static final String GET_PROD_BY_ID_QRY = "SELECT pid,pname,pcost,pdesc FROM products WHERE pid=?";

	@Override
	public ProductMaster add(ProductMaster product) throws ServiceException {
		if (product != null) {
			try (Connection con = ConnectionFactory.getConnection();
					PreparedStatement pst = con.prepareStatement(INS_PROD_QRY);) {

				pst.setInt(1, product.getId());
				pst.setString(2, product.getProductName());
				pst.setDouble(3, product.getCost());
				pst.setString(4, product.getProductDescription());

				pst.executeUpdate();
			} catch (SQLException exp) {
				throw new ServiceException("Adding product failed!");
			}
		}
		return product;
	}

	@Override
	public ProductMaster save(ProductMaster product) throws ServiceException {
		if (product != null) {
			try (Connection con = ConnectionFactory.getConnection();
					PreparedStatement pst = con.prepareStatement(UPD_PROD_QRY);) {

				pst.setString(1, product.getProductName());
				pst.setDouble(2, product.getCost());
				pst.setString(3, product.getProductDescription());
				pst.setInt(4, product.getId());

				pst.executeUpdate();
			} catch (SQLException exp) {
				throw new ServiceException("Saving product failed!");
			}
		}

		return product;
	}

	@Override
	public boolean deleteById(int productID) throws ServiceException {
		boolean isDeleted = false;
		try (Connection con = ConnectionFactory.getConnection();
				PreparedStatement pst = con.prepareStatement(DEL_PROD_QRY);) {

			pst.setInt(1, productID);

			int rowsCount = pst.executeUpdate();

			isDeleted = rowsCount > 0;

		} catch (SQLException exp) {
			throw new ServiceException("Deleting product failed!");
		}
		return isDeleted;
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

}

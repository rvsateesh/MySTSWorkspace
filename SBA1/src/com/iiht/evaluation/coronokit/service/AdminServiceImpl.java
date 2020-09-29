package com.iiht.evaluation.coronokit.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.iiht.evaluation.coronokit.dao.AdminDao;
import com.iiht.evaluation.coronokit.dao.AdminDaoJdbcImpl;
import com.iiht.evaluation.coronokit.exception.ServiceException;
import com.iiht.evaluation.coronokit.model.ProductMaster;

public class AdminServiceImpl implements AdminService{
	
	private AdminDao adminDao;

	public AdminServiceImpl(AdminDao adminDao) {
		super();
		this.adminDao = new AdminDaoJdbcImpl();
	}

	private boolean isValidProductID(Integer productId) {
		return productId!=null && productId>0; 
	}
	
	private boolean isValidProductName(String productName) {
		return productName!=null && (productName.length()>=3 || productName.length()<=20);
	}
	
	private boolean isValidProductCost(Double productCost) {
		return productCost!=null && productCost>=0;
	}
	
	public boolean isValidProduct(ProductMaster product) throws ServiceException {
		List<String> errMsgs = new ArrayList<>();
		boolean isValid=true;
		
		if(product!=null) {
			if(!isValidProductID(product.getId())) {
				isValid=false;
				errMsgs.add("Product id can not left blank and must be a positive number, Duplicates are not allowed");
			}
			if(!isValidProductName(product.getProductName())) {
				isValid=false;
				errMsgs.add("Product name can not left blank and must be of 3 to 20 in length");
			}
			if(!isValidProductCost(product.getCost())) {
				isValid=false;
				errMsgs.add("Product cost can not be left blank and must be greater than or equal to 0");
			}
			
			if(!errMsgs.isEmpty()) {
				throw new ServiceException("Invalid Product: "+errMsgs);
			}
		}else {
			isValid=false;
			throw new ServiceException("Product details are not supplied");
		}
		
		return isValid;
	}
	@Override
	public List<ProductMaster> getAllProducts() throws ServiceException {
		return adminDao.getAll();
	}

	@Override
	public ProductMaster validateAndAdd(ProductMaster product) throws ServiceException {
		if(isValidProduct(product)) {
			adminDao.add(product);
		}
		return product;
	}

	@Override
	public ProductMaster validateAndSave(ProductMaster product) throws ServiceException {
		if(isValidProduct(product)) {
			adminDao.save(product);
		}
		return product;
	}

	@Override
	public boolean deleteProduct(int productID) throws ServiceException {
		return adminDao.deleteById(productID);
	}

	@Override
	public ProductMaster getProduct(int productID) throws ServiceException {
		return adminDao.getById(productID);
	}

}

package com.iiht.evaluation.coronokit.service;

import com.iiht.evaluation.coronokit.model.ProductMaster;
import com.iiht.evaluation.coronokit.exception.ServiceException;
import java.util.List;



public interface AdminService {
	
	List<ProductMaster> getAllProducts() throws ServiceException;
	ProductMaster validateAndAdd(ProductMaster product) throws ServiceException;
	ProductMaster validateAndSave(ProductMaster product) throws ServiceException;	
	boolean deleteProduct(int productID) throws ServiceException;
	ProductMaster getProduct(int productID) throws ServiceException;

}

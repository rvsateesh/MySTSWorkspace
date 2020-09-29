package com.iiht.evaluation.coronokit.dao;

import java.util.List;
import com.iiht.evaluation.coronokit.model.ProductMaster;
import com.iiht.evaluation.coronokit.exception.ServiceException;

public interface AdminDao {
	
	ProductMaster add(ProductMaster product) throws ServiceException;

	ProductMaster save(ProductMaster product) throws ServiceException;

	boolean deleteById(int productID) throws ServiceException;
	
	ProductMaster getById(int productID) throws ServiceException;

	List<ProductMaster> getAll() throws ServiceException;
}

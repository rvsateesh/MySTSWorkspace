package com.iiht.evaluation.coronokit.dao;

import java.util.List;
import com.iiht.evaluation.coronokit.exception.ServiceException;
import com.iiht.evaluation.coronokit.model.ProductMaster;

public interface UserKitDao {
	ProductMaster getById(int productID) throws ServiceException;
	List<ProductMaster> getAll() throws ServiceException;
}

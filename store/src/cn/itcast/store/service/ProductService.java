package cn.itcast.store.service;

import java.sql.SQLException;
import java.util.List;

import cn.itcast.store.domain.Order;
import cn.itcast.store.domain.Product;
import cn.itcast.store.utils.PageModel;

public interface ProductService {

	List<Product> findNewProducts()throws SQLException ;

	List<Product> findHotProducts()throws SQLException ;

	Product findProductByPid(String pid)throws SQLException ;

	PageModel findProductsWithCidAndPage(String cid, int curNum)throws SQLException ;

	void saveProduct(Product product)throws SQLException ;
	
	List<Product> findProductByPname(String pname)throws SQLException ;

	List<Product> findProductByShop_price()throws SQLException ;
	
	List<Product> findAllProducts()throws Exception;
	
	List<Product> findAllProductsWithPflag(String pflag)throws Exception;
	
	void updateProducts(Product product)throws SQLException ;
	
	void deleteProducts(String pid)throws SQLException;
}

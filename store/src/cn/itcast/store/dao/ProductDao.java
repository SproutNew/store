package cn.itcast.store.dao;

import java.sql.SQLException;
import java.util.List;

import cn.itcast.store.domain.Product;

public interface ProductDao {

	List<Product> findNewProducts()throws SQLException ;

	List<Product> findHotProducts()throws SQLException ;

	Product findProductByPid(String pid)throws SQLException ;

	int findTotalNum(String cid)throws SQLException ;

	List<Product> findProductsWithCidAndPage(String cid, int startIndex, int pageSize)throws SQLException ;

	void saveProduct(Product product)throws SQLException ;
	
	List<Product> findProductByPname(String pname)throws SQLException ;
	
	List<Product> findProductByShop_price()throws SQLException ;
	
	List<Product> findAllProducts()throws Exception;
	
	List<Product> findAllProductsWithPflag(String pflag)throws Exception;
	
	void updateProducts(Product product)throws SQLException ;
	
	void deleteProducts(String pid)throws SQLException;
}
package cn.itcast.store.web.servlet;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.store.domain.Category;
import cn.itcast.store.domain.Order;
import cn.itcast.store.domain.Product;
import cn.itcast.store.service.CategoryService;
import cn.itcast.store.service.OrderService;
import cn.itcast.store.service.ProductService;
import cn.itcast.store.service.serviceImp.CategoryServiceImp;
import cn.itcast.store.service.serviceImp.OrderServiceImp;
import cn.itcast.store.service.serviceImp.ProductServiceImp;
import cn.itcast.store.web.base.BaseServlet;

public class AdminProductServlet extends BaseServlet {

	ProductService ProductService=new ProductServiceImp();	
	
	public String addProUI(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//_服务端查询到所有分类,
		CategoryService CategoryService=new CategoryServiceImp();
		//放入request中,
		request.setAttribute("allCats", CategoryService.findAllCats());
		//转发到admin/product/add.jsp
		return "admin/product/add.jsp";
	}
	
	public String findAllProducts(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//获取pflag,
		String pflag=request.getParameter("pflag");
		//用来存放全部订单或者不同状态商品
		List<Product> list=null;
		if(null==pflag||"".equals(pflag)){
			//如果获取不到查询全部商品,
			list=ProductService.findAllProducts();
		}else{
			//如果可以获取到pflag,查询不同状态下的商品	
			list=ProductService.findAllProductsWithPflag(pflag);
		}
		//将查询到的订单放入request,
		request.setAttribute("products", list);
		//转发到admin/order/list.jsp
		return "/admin/product/list.jsp";
	}
	

	public String deleteProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//获取到被删除商品pid
		String pid=request.getParameter("pid");
		Product product=(Product)request.getSession().getAttribute("product");
		ProductService.deleteProducts(pid);
		response.sendRedirect(request.getContextPath()+"/admin/product/list.jsp");
		return null;
	}
}
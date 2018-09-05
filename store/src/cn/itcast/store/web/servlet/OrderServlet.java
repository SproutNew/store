package cn.itcast.store.web.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.store.domain.Cart;
import cn.itcast.store.domain.CartItem;
import cn.itcast.store.domain.Order;
import cn.itcast.store.domain.OrderItem;
import cn.itcast.store.domain.User;
import cn.itcast.store.service.OrderService;
import cn.itcast.store.service.serviceImp.OrderServiceImp;
import cn.itcast.store.utils.PageModel;
import cn.itcast.store.utils.UUIDUtils;
import cn.itcast.store.web.base.BaseServlet;

public class OrderServlet extends BaseServlet {

	OrderService OrderService=new OrderServiceImp();
	
	public String saveOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 //获取用户 session
		User uu=(User)request.getSession().getAttribute("loginUser");
		 //获取到购物车
		Cart cart=(Cart)request.getSession().getAttribute("cart");
		 //创建订单对象 
		Order order=new Order();
		 //为订单对象赋予值: oid,orderTime,state
		order.setOid(UUIDUtils.getId());
		order.setOrderTime(new Date());
		order.setState(1);
		 //获取到购物车中的总计为订单对象下的总计赋值
		order.setTotal(cart.getTotal());
		 //为订单对象关联用户
		order.setUser(uu);		
		 //遍历购物车中的所有购物项
		for(CartItem item:cart.getCartItems()){
			//遍历的同时创建订单项 
			OrderItem oItem=new OrderItem();
			oItem.setItemid(UUIDUtils.getId());
			oItem.setProduct(item.getProduct());
			oItem.setQuantity(item.getNum());
			oItem.setTotal(item.getSubTotal());
			oItem.setOrder(order);			
			order.getList().add(oItem);			
		}
		
		OrderService.saveOrder(order);
		
		//清空购物车
		cart.clearCart();
		//向request内放置一份order,便于在订单详情页面显示订单信息
		request.setAttribute("order", order);
		return "/jsp/order_info.jsp";
	}

	
	//findOrdersByUidWithPage
	public String findOrdersByUidWithPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//获取数据
		int curNum=Integer.parseInt(request.getParameter("num"));
		User user=(User)request.getSession().getAttribute("loginUser");
		  //调用业务层功能,返回PageModel对象(1_分页参数2_所有订单3_url)
		PageModel pm=OrderService.findOrdersByUidWithPage(user,curNum);
		  //将PageModel对象放入request,转发到order_list.jsp页面
		request.setAttribute("page", pm);
		return "/jsp/order_list.jsp";
	}
	//findOrderByOid
	public String findOrderByOid(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//服务端获取oid,根据oid查询订单(订单上携带当前订单上所有的订单项以及商品),
		String oid=request.getParameter("oid");
		Order order=OrderService.findOrderByOid(oid);
		  //将订单放入request内
		request.setAttribute("order", order);
		  //转发到订单详情页面order_info.jsp
		return "/jsp/order_info.jsp";
	}
}
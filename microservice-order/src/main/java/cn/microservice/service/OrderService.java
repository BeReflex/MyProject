package cn.microservice.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.microservice.pojo.Item;
import cn.microservice.pojo.Order;
import cn.microservice.pojo.OrderDetail; 

@Service
public class OrderService {

	private static final Map<String,Order> MAP = new HashMap<String,Order>();
	
	static {
		
		//构造测试数据
		Order order = new Order();
		order.setOrderId("112233445566778899");
		order.setCreateDate(new Date());
		order.setUpdateDate(order.getCreateDate());
		order.setUserId(1L);
		
		//创建OrderDetail集合对象
		List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
		
		//此处没有商品的数据，需要调用商品微服务获取
		Item item = new Item();
		item.setId(1L);
		orderDetails.add(new OrderDetail(order.getOrderId(),item));
		
		//构造第二个商品数据
		item = new Item();
		item.setId(2L);
		orderDetails.add(new OrderDetail(order.getOrderId(),item));
		
		//将OrderDetail数据集设置给Order对象
		order.setOrderDetails(orderDetails);
		
		//将Order对象添加到Map中
		MAP.put(order.getOrderId(), order);
		
		//
	}
	@Autowired
	private Itemservice itemservice;
	/**
	 * 根据订单id查找订单
	 * @param orderid
	 * @return
	 */
	public Order queryOrderById(String orderid) {
		Order order =  MAP.get(orderid); 
		
		/**
		 * 获取Order对象中所有的OrderDetail,然后进行遍历，
		 * 获取每一个OrderDetail对象，
		 * 然后从OrderDetail对象中获取商品的Id,然后调用商品微服务查询商品信息
		 */
		List<OrderDetail> orderDetails = order.getOrderDetails();
		for(OrderDetail orderDetail :orderDetails) {
			Long id = orderDetail.getItem().getId();
			
			Item item = itemservice.queryItemById(id);
			orderDetail.setItem(item);
			
		}
		return order;
	}
}

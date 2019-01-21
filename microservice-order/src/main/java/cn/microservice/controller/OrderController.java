package cn.microservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.microservice.pojo.Order;
import cn.microservice.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	private OrderService orderservice;
	
	@RequestMapping(value = "/order/{orderId}")
	public Order queryOrderById(@PathVariable(name = "orderId") String orderId) {
		return orderservice.queryOrderById(orderId);
	}
}

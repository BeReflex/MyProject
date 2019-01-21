package cn.microservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.microservice.pojo.Item;
import cn.microservice.service.ItemService;

@RestController
public class ItemController {

	@Autowired
	private ItemService itemservice;
	
	//@RequestMapping(value = "/item/{id}",method = RequestMethod.GET)
	@GetMapping(value = "/item/{id}")
	public Item queryById(@PathVariable(name = "id") Long id) {
		return itemservice.queryItemById(id);
		
	}
}

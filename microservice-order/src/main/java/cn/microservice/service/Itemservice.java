package cn.microservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import cn.microservice.pojo.Item;

/**
 * Itemservice class
 * item service方法类
 * @author admin
 * @dete 2019/1/21
 */

@Service
public class Itemservice {

	
	  @Autowired private RestTemplate resetTemplate;
	  
	  @Value("${item.url}") private String itemUrl;
	  
	  public Item queryItemById(Long id) {
	  
	  //Item item = resetTemplate.getForObject("http://localhost:8083/item/" + id,Item.class);
	  
	  System.out.println(itemUrl);
	  
	  Item item = resetTemplate.getForObject(itemUrl + id,Item.class); return item;
	  }
  
	 
}

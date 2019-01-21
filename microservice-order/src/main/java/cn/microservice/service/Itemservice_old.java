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
public class Itemservice_old {

	 
	@Autowired
	private DiscoveryClient discoveryclient;

	@Autowired
	private RestTemplate resetTemplate;

	public Item queryItemById(Long id) {

	 
		String serviceId = "MICROSERVICE-ITEM";
		List<ServiceInstance> instances = discoveryclient.getInstances(serviceId);
		if (instances == null || instances.isEmpty()) {
			System.out.println("instances 为空！");
			return null;
		}

		ServiceInstance serviceinstance = instances.get(0);

		String url = "http://" + serviceinstance.getHost() + ":" + serviceinstance.getPort() + "/item/";

		System.out.println(url);

		Item item = resetTemplate.getForObject(url + id, Item.class);

		return item;

	}
}

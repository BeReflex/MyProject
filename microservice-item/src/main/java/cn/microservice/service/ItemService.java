package cn.microservice.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import cn.microservice.pojo.Item;

@Service
public class ItemService {

	private static final Map<Long,Item> Map = new HashMap<Long, Item>();
	
	static {
		Map.put(1L, new Item(1L,"商品标题1","http://图片1","商品描述1",1000L));
		Map.put(2L, new Item(1L,"商品标题1","http://图片2","商品描述2",2000L));
		Map.put(3L, new Item(1L,"商品标题1","http://图片3","商品描述3",3000L));
		Map.put(4L, new Item(1L,"商品标题1","http://图片4","商品描述4",4000L));
		Map.put(5L, new Item(1L,"商品标题1","http://图片5","商品描述5",5000L));
	}
	/**
	 * 根据ID获取Item类
	 * @param id
	 * @return
	 */
	public Item queryItemById(Long id) {
		return Map.get(id);
	}
}

package mshop.cart.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import mshop.cart.dao.CartDAO;
import mshop.common.common.CommandMap;

@Service("CartService")
public class CartServiceImpl implements CartService {
	
	@Resource(name="cartDAO")
	private CartDAO cartDAO;

	@Override
	public List<Map<String, Object>> openCartList(CommandMap commandMap) throws Exception {		
		return cartDAO.openCartList(commandMap);
	}

	@Override
	public void deleteCart(Map<String, Object> map) throws Exception {
		cartDAO.deleteCart(map);
		
	}
	
	

}

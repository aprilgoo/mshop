package mshop.cart.service;

import java.util.List;
import java.util.Map;

import mshop.common.common.CommandMap;

public interface CartService {

	List<Map<String, Object>> openCartList(CommandMap commandMap) throws Exception;

	void deleteCart(Map<String, Object> map) throws Exception;

}

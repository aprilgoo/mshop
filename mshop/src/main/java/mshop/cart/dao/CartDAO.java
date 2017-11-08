package mshop.cart.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import mshop.common.common.CommandMap;
import mshop.common.dao.AbstractDAO;

@Repository("cartDAO")
public class CartDAO extends AbstractDAO {

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> openCartList(CommandMap commandMap) throws Exception {	
		Map<String, Object> map = new HashMap();
		return selectList("cart.openCartList", map);
	}

	public void deleteCart(Map<String, Object> map) throws Exception {
		update("cart.deleteCart", map);		
	}


}

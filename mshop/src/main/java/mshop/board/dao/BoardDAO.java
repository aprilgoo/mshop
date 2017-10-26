package mshop.board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import mshop.common.dao.AbstractDAO;

@Repository("boardDAO")
public class BoardDAO extends AbstractDAO {

	@SuppressWarnings("unchecked")
	public List<Map<String, String>> openProductList(String opt, String keyword) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("opt", opt);
		map.put("keyword", keyword);
		return (List<Map<String, String>>)selectList("board.openProductList", map);
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> openBoardDetail(Map<String, Object> map) throws Exception {
		return (Map<String,Object>)selectOne("board.selectBoardDetail", map);
	}

	public void insertBoard(Map<String, Object> map) throws Exception {
		insert("board.insertBoard", map);		
	}

	public void updateBoard(Map<String, Object> map) throws Exception {
		update("board.updateBoard", map);
		
	}

	public void deleteBoard(Map<String, Object> map) throws Exception {
		update("board.deleteBoard", map);
		
	}

	public void insertCart(Map<String, Object> map) throws Exception {
		insert("board.insertCart", map);
		
	}
	
	

}

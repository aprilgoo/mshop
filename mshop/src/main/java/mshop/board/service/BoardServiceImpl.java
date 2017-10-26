package mshop.board.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import mshop.board.dao.BoardDAO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	
	@Resource(name="boardDAO")
	private BoardDAO boardDAO;

	@Override
	public List<Map<String, String>> openProductList(String opt, String keyword) throws Exception {
		return boardDAO.openProductList(opt, keyword);
	}

	@Override
	public void insertBoard(Map<String, Object> map) throws Exception {
		boardDAO.insertBoard(map);
		
	}

	@Override
	public Map<String, Object> openBoardDetail(Map<String, Object> map) throws Exception {
		map = boardDAO.openBoardDetail(map);
		return map;
	}

	@Override
	public void updateBoard(Map<String, Object> map) throws Exception {
		boardDAO.updateBoard(map);		
	}

	@Override
	public void deleteBoard(Map<String, Object> map) throws Exception {
		boardDAO.deleteBoard(map);
		
	}

	@Override
	public void insertCart(Map<String, Object> map) throws Exception {
		boardDAO.insertCart(map);
		
	}

}

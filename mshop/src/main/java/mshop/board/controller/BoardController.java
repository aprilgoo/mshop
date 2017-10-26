package mshop.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import mshop.board.service.BoardService;
import mshop.common.common.CommandMap;

@Controller
public class BoardController {
	
	@Resource(name="boardService")
    private BoardService boardService;	
	
	Logger log = Logger.getLogger(this.getClass());
	
	//게시판 목록
	//opt(option)와 keyword(검색어)로
    @RequestMapping(value="/board/openProductList.do")
    public ModelAndView openProductList(@RequestParam(defaultValue="") String opt, @RequestParam(defaultValue="")String keyword) throws Exception{
        ModelAndView mv = new ModelAndView("board/productList");
                  
        List<Map<String, String>> list = boardService.openProductList(opt, keyword);    
       
    	Map<String,Object>map = new HashMap<String, Object>();
    	map.put("list", list);    
    	map.put("opt", opt);
    	map.put("keyword", keyword);
    	mv.addObject("map", map); 
    	mv.setViewName("board/sell_list");
        return mv;
        
    }
    
    //글쓰기 화면 열기
    @RequestMapping(value="/board/openBoardWrite.do", method=RequestMethod.POST)
    public ModelAndView openBoardWrite(CommandMap commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("board/boardWrite");         
        return mv;
    }
    
    
    //DB에 글 내용 넣기
    @RequestMapping(value="/board/insertBoard.do")
	public ModelAndView insertBoard(CommandMap commandMap) throws Exception {
	
	ModelAndView mv = new ModelAndView("redirect:/board/openProductList.do");
	
	boardService.insertBoard(commandMap.getMap());
	
	return mv;    	
}    
    
    
    // 상세 화면 보기
    @RequestMapping(value="/board/openBoardDetail.do")
    public ModelAndView openBoardDetail(CommandMap commandMap) throws Exception {
    	ModelAndView mv = new ModelAndView("board/sell_detail");
    	
    	Map<String,Object> map = boardService.openBoardDetail(commandMap.getMap());    	
    	mv.addObject("map", map);    	
    	
		return mv;
    	  	
    }
    
    // 글 내용 수정 화면 열기
    @RequestMapping(value="/board/openBoardModify.do")    
    public ModelAndView openBoardUpdate(CommandMap commandMap) throws Exception {
    	ModelAndView mv = new ModelAndView("board/sell_modify");
    	
    	Map<String,Object> map =boardService.openBoardDetail(commandMap.getMap());
    	mv.addObject("map", map);    	
    	
    	return mv;    	
    }
    
    //DB에 수정한 내용 넣기
    @RequestMapping(value="/board/updateBoard.do")    
    public ModelAndView updateBoard(CommandMap commandMap) throws Exception {
    	ModelAndView mv = new ModelAndView("redirect:/board/openSellDetail.do");
    	
    	boardService.updateBoard(commandMap.getMap());
    	
    	mv.addObject("PRO_NO", commandMap.get("PRO_NO"));
    	return mv;
    }
    
    //게시물 삭제
    @RequestMapping(value="/board/deleteBoard.do")
    
    public ModelAndView deleteBoard(CommandMap commandMap) throws Exception {
    	ModelAndView mv = new ModelAndView("redirect:/board/openProductList.do");    	 
    	boardService.deleteBoard(commandMap.getMap());
    	return mv;
    	
    }      
	
	
    //장바구니에 담기
	@RequestMapping(value="/board/insertCart.do")
	public ModelAndView insertCart(CommandMap commandMap) throws Exception {
		ModelAndView mv = new ModelAndView("redirect:/cart/openCartList.do");	

		boardService.insertCart(commandMap.getMap());	
		return mv;		
	
	}  
	
}



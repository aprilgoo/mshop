package mshop.user.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import mshop.common.common.CommandMap;
import mshop.user.service.UserService;

public class UserController {
	
	 @Resource(name="userService")
	  private UserService userService;
	 
	 
	 /** 
	  * 로그인	 
	  */
	  
	  // 로그인 폼 열기
	  @RequestMapping({"/user/login_Form.do"})
	  public ModelAndView login_Form() throws Exception
	  {
	    ModelAndView mv = new ModelAndView("redirect:/page/user/user_login.jsp");
	    return mv;
	  }
	  
	  //로그인 기능
	  @RequestMapping({"/user/openLoginSession.do"})
	  public String openLoginSession(HttpSession session, HttpServletResponse response, HttpServletRequest request, CommandMap commandMap) throws Exception
	  {
	    String returnURL = "";
	    Map<String, Object> map = new HashMap<String, Object>();
	    map = userService.openLoginSession(commandMap.getMap());
	    map.get("no");
	    
	    // 세션에 아이디가 없을 경우 
	    if (session.getAttribute("user") != null) {
	      session.removeAttribute("user");
	    }
	    
	    // 세션에 저장된 아이디와 비밀번호와 db에 저장된 아이디, 비밀번호가 같을 때
	    if ((request.getParameter("user_id").equals((String)map.get("user_id"))) && (request.getParameter("user_password").equals((String)map.get("user_password"))))
	    {
	      request.getSession().setAttribute("user", map);
	      request.getSession().setAttribute("user_id", map.get("user_id"));
	      request.getSession().setAttribute("user_password", map.get("user_password"));
	      request.getSession().setAttribute("no", map.get("no"));
	      returnURL = "redirect:/page/user/user_page.jsp";
	      return returnURL;
	    }
	    returnURL = "redirect:/page/user/user_login.jsp";
	    return returnURL;
	  }
	  
	  
	  /**
	   * 회원 정보 수정
	   * 
	   */
	  
	  
	  // 회원 정보 수정 페이지 열기
	  @RequestMapping({"/user/openUserUpdate.do"})
	  public String openUserUpdate(CommandMap commandMap)
	    throws Exception
	  {
	    String returnURL = "";
	    
	    returnURL = "redirect:/page/user/user_modify.jsp";
	    return returnURL;
	  }
	  
	  // 회원 정보 수정 기능
	  @RequestMapping({"/user/updateUser.do"})
	  public String updateUser(HttpSession session, HttpServletResponse response, HttpServletRequest request, CommandMap commandMap)
	    throws Exception
	  {
	    String returnURL = "";
	    
	    Map<String, Object> map = new HashMap<String, Object>();
	    map = userService.updateUser(commandMap.getMap());
	    
	    request.getSession().setAttribute("user", map);
	    
	    returnURL = "redirect:/user/userPage.do";
	    return returnURL;
	  }
	  
	  // 회원 정보 페이지 열기
	  @RequestMapping({"/user/userPage.do"})
	  public String userPage(HttpServletRequest request, CommandMap commandMap)
	    throws Exception
	  {
	    String returnURL = "";
	    returnURL = "redirect:/page/user/user_page2.jsp";
	    return returnURL;
	  }
	  
	  
	  /**
	   * 회원 탈퇴
	   */
	  
	  
	  @RequestMapping({"/user/openDeletePage.do"})
	  public ModelAndView openDeletePage(CommandMap commandMap)
	    throws Exception
	  {
	    ModelAndView mv = new ModelAndView("redirect:/page/user/user_delete.jsp");
	    return mv;
	  }
	  
	  @RequestMapping({"/user/deleteUser.do"})
	  public ModelAndView deleteUser(HttpSession session, CommandMap commandMap)
	    throws Exception
	  {
	    ModelAndView mv = new ModelAndView("redirect:/index.jsp");
	    userService.deleteUser(commandMap.getMap());
	    session.invalidate();
	    return mv;
	  }
	
	

}

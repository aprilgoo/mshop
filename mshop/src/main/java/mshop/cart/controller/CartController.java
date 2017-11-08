package mshop.cart.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import mshop.cart.service.CartService;
import mshop.common.common.CommandMap;

@Controller
public class CartController
{
  @Resource(name="cartService")
  private CartService cartService;
  
  @RequestMapping({"/cart/openCartList.do"})
  public ModelAndView openCartList(CommandMap commandMap)
    throws Exception
  {
    ModelAndView mv = new ModelAndView("cart/cart_list");
    
    Map<String, Object> map = new HashMap<String, Object>();
    List<Map<String, Object>> list = this.cartService.openCartList(commandMap);
    map.put("list", list);
    mv.addObject("map", map);
    return mv;
  }
  
  @RequestMapping({"/cart/deleteCart.do"})
  public ModelAndView deleteCart(CommandMap commandMap)
    throws Exception
  {
    ModelAndView mv = new ModelAndView("redirect:openCartList.do");
    this.cartService.deleteCart(commandMap.getMap());
    return mv;
  }
}

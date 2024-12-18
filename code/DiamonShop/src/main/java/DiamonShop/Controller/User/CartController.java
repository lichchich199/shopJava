package DiamonShop.Controller.User;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import DiamonShop.Entity.CartDto;
import DiamonShop.Service.User.CartService;

@Controller
public class CartController extends BaseController{
	@Autowired
	CartService cartService;
	
	private String getPath() {
		return "redirect:/detailProduct/{id}";
	}

	@RequestMapping(value = {"listCart"}, method = RequestMethod.GET)
	public ModelAndView addCart() {
		
		_mvShare.setViewName("user/cart/listCart");
		return _mvShare;
	} 
	
	@RequestMapping(value = {"addCart/{id}"}, method = RequestMethod.GET)
	public String addCart(HttpServletRequest request ,HttpSession session, @PathVariable String id) {
		HashMap<String, CartDto> cart = (HashMap<String, CartDto>)session.getAttribute("cart");
		
		if(cart == null) {
			cart = new HashMap<String, CartDto>();
		}
		cart = cartService.addCart(id, cart);
		
		session.setAttribute("cart", cart);
		session.setAttribute("totalQuantity", cartService.totalQuantity(cart));
		session.setAttribute("totalPrice", cartService.totalPrice(cart));
		
		return "redirect:" + request.getHeader("Referer");
	}
	
	@RequestMapping(value = {"editCart/{id}/{quantity}"}, method = RequestMethod.GET)
	public String editCart(HttpServletRequest request ,HttpSession session, @PathVariable String id, @PathVariable int quantity) {
		HashMap<String, CartDto> cart = (HashMap<String, CartDto>)session.getAttribute("cart");
		
		if(cart == null) {
			cart = new HashMap<String, CartDto>();
		}
		cart = cartService.editCart(id, quantity , cart);
		
		session.setAttribute("cart", cart);
		session.setAttribute("totalQuantity", cartService.totalQuantity(cart));
		session.setAttribute("totalPrice", cartService.totalPrice(cart));
		
		return "redirect:" + request.getHeader("Referer");
	}
	
	@RequestMapping(value = {"deleteCart/{id}"}, method = RequestMethod.GET)
	public String deleteCart(HttpServletRequest request ,HttpSession session, @PathVariable String id) {
		HashMap<String, CartDto> cart = (HashMap<String, CartDto>)session.getAttribute("cart");
		
		if(cart == null) {
			cart = new HashMap<String, CartDto>();
		}
		cart = cartService.deleteCart(id, cart);
		
		session.setAttribute("cart", cart);
		session.setAttribute("totalQuantity", cartService.totalQuantity(cart));
		session.setAttribute("totalPrice", cartService.totalPrice(cart));
		
		return "redirect:" + request.getHeader("Referer");
	}
	

}

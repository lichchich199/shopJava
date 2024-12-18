package DiamonShop.Controller.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import DiamonShop.Entity.Users;
import DiamonShop.Service.User.AccountService;

@Controller
public class UserController extends BaseController{
	
	@Autowired
	AccountService accountService;
	
	private String getPath() {
		return "user/account/register";
	}
	
	@RequestMapping(value = {"/register"}, method = RequestMethod.GET)
	public ModelAndView register() {
		
		
		_mvShare.addObject("user", new Users());
		_mvShare.setViewName(getPath());
		
		return _mvShare;
	}
	
	@RequestMapping(value = {"/register"}, method = RequestMethod.POST)
	public ModelAndView registerConfirm(@ModelAttribute("userRegister") Users users) {
		int count = accountService.addAccount(users);
		if(count > 0) {
			_mvShare.addObject("status", "Đăng ký tài khoản thành công");
		}
		
		_mvShare.addObject("status", "Đăng ký tài khoản thất bại");
		
		_mvShare.addObject("user", users);
		_mvShare.setViewName(getPath());
		return _mvShare;
	}
	
	
	@RequestMapping(value = {"/login"}, method = RequestMethod.POST)
	public ModelAndView login(HttpSession session, @ModelAttribute("user") Users users) {
		boolean isValidAccount = accountService.isValidAccount(users);
		if(isValidAccount) {
			_mvShare.addObject("statusLogin", "Đăng nhập thành công");
			_mvShare.setViewName("redirect:home");
			session.setAttribute("loginUser", users);
		} else {
			_mvShare.addObject("statusLogin", "Đăng nhập thất bại");
		}
		
		return _mvShare;
	}
	
	@RequestMapping(value = {"/logout"}, method = RequestMethod.GET)
	public String login(HttpSession session, HttpServletRequest request) {
		session.removeAttribute("loginUser");
		return "redirect:" + request.getHeader("Referer");
	}
	
	
}

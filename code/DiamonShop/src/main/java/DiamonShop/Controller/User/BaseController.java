package DiamonShop.Controller.User;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import DiamonShop.Service.User.HomeService;

@Controller
public class BaseController {
	@Autowired
	HomeService _homeService;
	
	protected ModelAndView _mvShare = new ModelAndView();
	
	@PostConstruct
	protected ModelAndView Init() {
		_mvShare.addObject("menus", _homeService.getDataMenus());
		_mvShare.addObject("categories", _homeService.getDataCategories());
		return _mvShare;
	}

}

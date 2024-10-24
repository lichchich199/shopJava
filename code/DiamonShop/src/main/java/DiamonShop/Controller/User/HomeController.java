package DiamonShop.Controller.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController extends BaseController{
	
	private String getPath() {
		return "user/index";
	}
	
	@RequestMapping(value = {"/", "home"}, method = RequestMethod.GET)
	public ModelAndView index() {
		_mvShare.addObject("slices", _homeService.getDataSlides());
		_mvShare.addObject("highlightProducts", _homeService.getDataProducts(false, true));
		_mvShare.addObject("newProducts", _homeService.getDataProducts(true, false));
		
		_mvShare.setViewName(getPath());
		return _mvShare;
	}
	

}

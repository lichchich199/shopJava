package DiamonShop.Controller.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import DiamonShop.Dto.ProductsDto;
import DiamonShop.Service.User.ProductService;

@Controller
public class ProductController extends BaseController{
	
	@Autowired
	ProductService productService;
	
	private String getPath() {
		return "user/products/product";
	}
	
	@RequestMapping(value = {"/detailProduct/{id}"}, method = RequestMethod.GET)
	public ModelAndView index(@PathVariable String id) {
		ProductsDto productsDto = productService.getProductById(id);
		
		_mvShare.addObject("product", productsDto);
		_mvShare.addObject("productsRelate", productService.getProductByIdCategory(Integer.toString(productsDto.getIdCategory())
));
		
		_mvShare.setViewName(getPath());
		return _mvShare;
	}
	

}

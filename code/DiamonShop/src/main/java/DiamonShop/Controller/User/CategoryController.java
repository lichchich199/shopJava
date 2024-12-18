package DiamonShop.Controller.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import DiamonShop.Dto.PaginationDto;
import DiamonShop.Dto.ProductsDto;
import DiamonShop.Service.User.CategoryService;
import DiamonShop.Service.User.PaginationService;

@Controller
public class CategoryController extends BaseController{
	private int totalProductPerPage = 9;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	PaginationService paginationService;
	
	private String getPath() {
		return "user/products/category";
	}

	@RequestMapping(value = {"product/{id}", "product/{id}/{currentPage}"}, method = RequestMethod.GET)
	public ModelAndView product(@PathVariable String id, @PathVariable(required = false) String currentPage) {
		List<ProductsDto> products = categoryService.getDataProductsById(id);
		PaginationDto paginationDto = paginationService.getPaginationInfo(products.size(), totalProductPerPage, currentPage);
		
		_mvShare.addObject("idCategory", id);
		_mvShare.addObject("pagination", paginationDto);
		_mvShare.addObject("products", categoryService.getDataProductsForPagination(id, totalProductPerPage, paginationDto.getStart()));
		
		_mvShare.setViewName(getPath());
		return _mvShare;
	} 

}

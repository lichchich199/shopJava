package DiamonShop.Service.User;

import java.util.List;

import org.springframework.stereotype.Service;

import DiamonShop.Dto.ProductsDto;
import DiamonShop.Entity.Categories;
import DiamonShop.Entity.Menus;
import DiamonShop.Entity.Slides;

@Service
public interface HomeService {
	public List<Menus> getDataMenus();
	public List<Slides> getDataSlides();
	public List<Categories> getDataCategories();
	public List<ProductsDto> getDataProducts(boolean isNewProduct, boolean isHighlightProduct);
}

package DiamonShop.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DiamonShop.Dao.CategoriesDao;
import DiamonShop.Dao.MenusDao;
import DiamonShop.Dao.ProductsDao;
import DiamonShop.Dao.SlidesDao;
import DiamonShop.Dto.ProductsDto;
import DiamonShop.Entity.Categories;
import DiamonShop.Entity.Menus;
import DiamonShop.Entity.Slides;

@Service
public class HomeServiceImpl implements HomeService{
	@Autowired
	private MenusDao menusDao;
	
	@Autowired
	private SlidesDao slidesDao;
	
	@Autowired
	private CategoriesDao categoriesDao;
	
	@Autowired
	private ProductsDao productsDao;
	
	public List<Menus> getDataMenus() {
		return menusDao.getDataMenus();
	}
	
	public List<Slides> getDataSlides() {
		return slidesDao.getDataSlices();
	}


	public List<Categories> getDataCategories() {
		return categoriesDao.getDataCategories();
	}

	public List<ProductsDto> getDataProducts(boolean isNewProduct, boolean isHighlightProduct) {
		return productsDao.getDataProducts(isNewProduct, isHighlightProduct);
	}



}

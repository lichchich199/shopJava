package DiamonShop.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DiamonShop.Dao.ProductsDao;
import DiamonShop.Dto.ProductsDto;

@Service
public class CategoryServiceImpl implements CategoryService{
	@Autowired
	private ProductsDao productsDao;
	
	
	public List<ProductsDto> getDataProductsById(String idCategory) {
		return productsDao.getDataProductsByIdCategory(idCategory);
	}
	
	public List<ProductsDto> getDataProductsForPagination(String idCategory, int limit, int offSet) {
		
		return productsDao.getDataProductsForPagination(idCategory, limit, offSet);
	}
	
}

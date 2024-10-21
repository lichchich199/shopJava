package DiamonShop.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DiamonShop.Dao.ProductsDao;
import DiamonShop.Dto.ProductsDto;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	ProductsDao productsDao;
	

	public ProductsDto getProductById(String idProduct) {
		return productsDao.getProductByID(idProduct);
	}
	
	public List<ProductsDto> getProductByIdCategory(String idCategory) {
		return productsDao.getDataProductsByIdCategory(idCategory);
	}

}

package DiamonShop.Service.User;

import java.util.List;

import org.springframework.stereotype.Service;

import DiamonShop.Dto.ProductsDto;

@Service
public interface CategoryService {
	
	List<ProductsDto> getDataProductsById(String idCategory);
	
	List<ProductsDto> getDataProductsForPagination(String idCategory, int limit, int offSet) ;
}

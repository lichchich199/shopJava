package DiamonShop.Service.User;

import java.util.List;

import org.springframework.stereotype.Service;

import DiamonShop.Dto.ProductsDto;

@Service
public interface ProductService {
	ProductsDto getProductById(String idProduct);

	List<ProductsDto> getProductByIdCategory(String idCategory);
}

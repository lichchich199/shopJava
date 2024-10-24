package DiamonShop.Dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import DiamonShop.Dto.ProductsDto;
import DiamonShop.Entity.CartDto;

@Repository
public class CartDao extends BaseDao {
	@Autowired
	ProductsDao productsDao;

	public HashMap<String, CartDto> addCart(String productId, HashMap<String, CartDto> cart) {
		CartDto itemCart = new CartDto();

		ProductsDto productsDto = productsDao.getProductByID(productId);

		if (productsDto != null) {
			if(cart.containsKey(productId)) {
				itemCart = cart.get(productId);
				itemCart.setQuantity(itemCart.getQuantity() + 1);
				itemCart.setTotalPrice(itemCart.getProduct().getPrice() * itemCart.getQuantity());
			} else {
				itemCart.setProduct(productsDto);
				itemCart.setQuantity(1);
				itemCart.setTotalPrice(productsDto.getPrice());
			}
		}
		cart.put(productId, itemCart);

		return cart;
	}

	public HashMap<String, CartDto> editCart(String productId, int quantity, HashMap<String, CartDto> cart) {
		if (cart == null) {
			return cart;
		}
		CartDto itemCart = new CartDto();
		if (cart.containsKey(productId)) {
			itemCart = cart.get(productId);
			itemCart.setQuantity(quantity);
			itemCart.setTotalPrice(itemCart.getProduct().getPrice() * quantity);
		}
		cart.put(productId, itemCart);

		return cart;
	}

	public HashMap<String, CartDto> deleteCart(String productId, HashMap<String, CartDto> cart) {
		if (cart == null) {
			return cart;
		}
		if (cart.containsKey(productId)) {
			cart.remove(productId);
		}

		return cart;
	}
	
	public int totalQuantity(HashMap<String, CartDto> cart) {
		int totalQuantity = 0;
		for(Map.Entry<String, CartDto> itemCart : cart.entrySet()) {
			totalQuantity += itemCart.getValue().getQuantity();
		}
		
		return totalQuantity;
	}
	
	public double totalPrice(HashMap<String, CartDto> cart) {
		int totalPrice = 0;
		for(Map.Entry<String, CartDto> itemCart : cart.entrySet()) {
			totalPrice += itemCart.getValue().getTotalPrice();
		}
		
		return totalPrice;
	}
}

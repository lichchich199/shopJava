package DiamonShop.Service.User;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DiamonShop.Dao.CartDao;
import DiamonShop.Entity.CartDto;

@Service
public class CartServiceImpl implements CartService {
	@Autowired
	CartDao cartDao;

	public HashMap<String, CartDto> addCart(String productId, HashMap<String, CartDto> cart) {
		return cartDao.addCart(productId, cart);
	}

	public HashMap<String, CartDto> editCart(String productId, int quantity, HashMap<String, CartDto> cart) {
		return cartDao.editCart(productId, quantity, cart);
	}

	public HashMap<String, CartDto> deleteCart(String productId, HashMap<String, CartDto> cart) {
		return cartDao.deleteCart(productId, cart);
	}

	public int totalQuantity(HashMap<String, CartDto> cart) {
		return cartDao.totalQuantity(cart);
	}

	public double totalPrice(HashMap<String, CartDto> cart) {
		return cartDao.totalPrice(cart);
	}

}

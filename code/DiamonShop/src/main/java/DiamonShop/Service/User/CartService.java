package DiamonShop.Service.User;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import DiamonShop.Entity.CartDto;

@Service
public interface CartService {
	public HashMap<String, CartDto> addCart(String productId, HashMap<String, CartDto> cart);
	
	public HashMap<String, CartDto> editCart(String productId, int quantity, HashMap<String, CartDto> cart);
	
	public HashMap<String, CartDto> deleteCart(String productId, HashMap<String, CartDto> cart);
	
	public int totalQuantity(HashMap<String, CartDto> cart);

	public double totalPrice(HashMap<String, CartDto> cart);
}

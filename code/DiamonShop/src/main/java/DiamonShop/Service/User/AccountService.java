package DiamonShop.Service.User;

import org.springframework.stereotype.Service;

import DiamonShop.Entity.Users;

@Service
public interface AccountService {
	public int addAccount(Users user);
	
	public boolean isValidAccount(Users user);
}

package DiamonShop.Service.User;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DiamonShop.Dao.UserDao;
import DiamonShop.Entity.Users;

@Service
public class AccountServiceImpl implements AccountService{
	@Autowired
	UserDao userDao;
	
	public int addAccount(Users user) {
		user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12)));
		
		return userDao.addAccount(user);
	}

	public boolean isValidAccount(Users user) {
		String pass = user.getPassword();
		
		user = userDao.getUserByAccount(user);
		if(user != null) {
			if(BCrypt.checkpw(pass, user.getPassword())) {
				return true;
			}
		}
		
		return false;
	}

}

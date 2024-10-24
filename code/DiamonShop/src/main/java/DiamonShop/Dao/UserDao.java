package DiamonShop.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import DiamonShop.Entity.SlicesMapper;
import DiamonShop.Entity.Slides;
import DiamonShop.Entity.Users;
import DiamonShop.Entity.UsersMapper;

@Repository
public class UserDao extends BaseDao {

	public int addAccount(Users user) {
		int result = 0;

		StringBuilder sql = new StringBuilder();
		sql.append("INSERT ");
		sql.append("INTO `users` ");
		sql.append("( ");
		sql.append("`user`, ");
		sql.append("`password`, ");
		sql.append("`display_name`, ");
		sql.append("`address` ");
		sql.append(") VALUES ");
		sql.append("( ");
		sql.append("'" + user.getUser() + "',");
		sql.append("'" + user.getPassword() + "',");
		sql.append("'" + user.getDisplayName() + "',");
		sql.append("'" + user.getAddress() + "'");
		sql.append(")");

		result = _jdbcTemplate.update(sql.toString());

		return result;
	}

	public Users getUserByAccount(Users user) {

		Users result = new Users();
		String sql = "SELECT * FROM `users` WHERE user='" + user.getUser() +"'";

		result = _jdbcTemplate.queryForObject(sql, new UsersMapper());

		return result;
	}

}

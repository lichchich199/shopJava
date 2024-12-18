package DiamonShop.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UsersMapper implements RowMapper<Users> {

	public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
		Users users = new Users();

		users.setId(rs.getInt("id"));
		users.setUser(rs.getString("user"));
		users.setPassword(rs.getString("password"));
		users.setDisplayName(rs.getString("display_name"));
		users.setAddress(rs.getString("address"));

		return users;
	}

}

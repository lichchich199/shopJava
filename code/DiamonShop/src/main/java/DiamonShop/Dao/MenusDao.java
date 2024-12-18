package DiamonShop.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import DiamonShop.Entity.MenusMapper;
import DiamonShop.Entity.Menus;

@Repository
public class MenusDao extends BaseDao{
	public List<Menus> getDataMenus() {
		List<Menus> list = new ArrayList<Menus>();
		
		String sql = "SELECT * FROM menus";
		list = _jdbcTemplate.query(sql, new MenusMapper());
		
		return list;
	}

}

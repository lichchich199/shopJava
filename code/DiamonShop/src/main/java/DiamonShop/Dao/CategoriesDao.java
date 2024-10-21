package DiamonShop.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import DiamonShop.Entity.Categories;
import DiamonShop.Entity.CategoriesMapper;

@Repository
public class CategoriesDao extends BaseDao{
	public List<Categories> getDataCategories() {
		List<Categories> list = new ArrayList<Categories>();
		
		String sql = "SELECT * FROM categories";
		list = _jdbcTemplate.query(sql, new CategoriesMapper());
		
		return list;
	}
}

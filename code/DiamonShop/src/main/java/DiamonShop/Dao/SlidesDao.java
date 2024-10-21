package DiamonShop.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import DiamonShop.Entity.SlicesMapper;
import DiamonShop.Entity.Slides;

@Repository
public class SlidesDao extends BaseDao{
	public List<Slides> getDataSlices() {
		List<Slides> list = new ArrayList<Slides>();
		
		String sql = "SELECT * FROM slides";
		list = _jdbcTemplate.query(sql, new SlicesMapper());
		
		return list;
	}
}

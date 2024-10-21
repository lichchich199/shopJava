package DiamonShop.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class SlicesMapper implements RowMapper<Slides>{

	public Slides mapRow(ResultSet rs, int rowNum) throws SQLException {
		Slides slices = new Slides();
		
		slices.setId(rs.getInt("id"));
		slices.setImg(rs.getString("img"));
		slices.setCaption(rs.getString("caption"));
		slices.setContent(rs.getString("content"));
		return slices;
	}

}

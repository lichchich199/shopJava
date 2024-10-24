package DiamonShop.Dto;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ProductsDtoMapper implements RowMapper<ProductsDto>{

	public ProductsDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		ProductsDto productsDto = new ProductsDto();
		
		productsDto.setIdProduct((rs.getLong("id_product")));
		
		productsDto.setIdCategory(rs.getInt("id_category"));
		productsDto.setSizes(rs.getString("sizes"));
		productsDto.setNameProduct(rs.getString("name_product"));
		productsDto.setPrice(rs.getDouble("price"));
		productsDto.setSale(rs.getInt("sale"));
		productsDto.setTitle(rs.getString("title"));
		productsDto.setHighlight(rs.getBoolean("highlight"));
		productsDto.setNewProduct(rs.getBoolean("new_product"));
		productsDto.setDetails(rs.getString("details"));
		productsDto.setCreatedAt(rs.getDate("created_at"));
		productsDto.setUpdatedAt(rs.getDate("updated_at"));
		productsDto.setIdColor(rs.getInt("id_color"));
		productsDto.setNameColor(rs.getString("name_color"));
		productsDto.setCodeColor(rs.getString("code_color"));
		productsDto.setImg(rs.getString("img"));
		
		return productsDto;
	}

}

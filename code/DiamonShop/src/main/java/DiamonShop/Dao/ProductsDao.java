package DiamonShop.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import DiamonShop.Dto.ProductsDto;
import DiamonShop.Dto.ProductsDtoMapper;

@Repository
public class ProductsDao extends BaseDao {
	private final int LIMIT = 9;
	
	
	private StringBuilder sql() {
		StringBuilder sqlStringBuilder = new StringBuilder();

		sqlStringBuilder.append("SELECT ");
		sqlStringBuilder.append("p.id as id_product, ");
		sqlStringBuilder.append("p.id_category, ");
		sqlStringBuilder.append("p.sizes, ");
		sqlStringBuilder.append("p.name as name_product, ");
		sqlStringBuilder.append("p.price, ");
		sqlStringBuilder.append("p.sale, ");
		sqlStringBuilder.append("p.title, ");
		sqlStringBuilder.append("p.highlight, ");
		sqlStringBuilder.append("p.new_product, ");
		sqlStringBuilder.append("p.details, ");
		sqlStringBuilder.append("p.created_at, ");
		sqlStringBuilder.append("p.updated_at, ");
		sqlStringBuilder.append("c.id as id_color, ");
		sqlStringBuilder.append("c.name as name_color, ");
		sqlStringBuilder.append("c.code as code_color, ");
		sqlStringBuilder.append("c.img ");
		sqlStringBuilder.append("from products p ");
		sqlStringBuilder.append("INNER JOIN colors c ON p.id = c.id_product ");
		return sqlStringBuilder;
	}

	private String sqlGetDataProducts(boolean isNewProduct, boolean isHighlightProduct) {
		StringBuilder sqlStringBuilder = sql();

		sqlStringBuilder.append("WHERE 1 = 1 ");
		
		if(isNewProduct) {
			sqlStringBuilder.append("AND p.new_product = TRUE ");
		}
		
		if(isHighlightProduct) {
			sqlStringBuilder.append("AND p.highlight = TRUE ");
		}

		sqlStringBuilder.append("ORDER BY RAND() ");
		sqlStringBuilder.append("LIMIT " + LIMIT);

		return sqlStringBuilder.toString();
	}
	
	private String sqlGetProductsByID(String idCategory) {
		StringBuilder sqlStringBuilder = sql();

		sqlStringBuilder.append("WHERE p.id_category = " + idCategory);

		return sqlStringBuilder.toString();
	}
	
	private String sqlGetProductsForPagination(String idCategory, int limit, int offSet) {
		StringBuilder sqlStringBuilder = sql();
		
		sqlStringBuilder.append("WHERE p.id_category = " + idCategory);
		sqlStringBuilder.append(" LIMIT " + limit);
		sqlStringBuilder.append(" OFFSET " + offSet);
		
		return sqlStringBuilder.toString();
	}


	public List<ProductsDto> getDataProducts(boolean isNewProduct, boolean isHighlightProduct) {
		List<ProductsDto> list = new ArrayList<ProductsDto>();

		list = _jdbcTemplate.query(sqlGetDataProducts(isNewProduct, isHighlightProduct), new ProductsDtoMapper());

		return list;
	}
	
	public List<ProductsDto> getDataProductsByIdCategory(String idCategory) {
		List<ProductsDto> list = new ArrayList<ProductsDto>();

		list = _jdbcTemplate.query(sqlGetProductsByID(idCategory), new ProductsDtoMapper());
		
		return list;
	}
	
	public List<ProductsDto> getDataProductsForPagination(String idCategory, int limit, int offSet) {
		List<ProductsDto> list = new ArrayList<ProductsDto>();

		list = _jdbcTemplate.query(sqlGetProductsForPagination(idCategory, limit, offSet), new ProductsDtoMapper());
		
		return list;
	}
	
	public ProductsDto getProductByID(String productId) {
		List<ProductsDto> productsDto = new ArrayList<ProductsDto>();

		productsDto = _jdbcTemplate.query(sqlGetDataProductByID(productId), new ProductsDtoMapper());

		return productsDto.isEmpty() ? null : productsDto.get(0);
	}

	private String sqlGetDataProductByID(String productId) {
		StringBuilder sqlStringBuilder = sql();
		
		sqlStringBuilder.append("WHERE p.id = " + productId);
		sqlStringBuilder.append(" LIMIT " + 1);
		return sqlStringBuilder.toString();
	}
	
	
	


	
	
	
}

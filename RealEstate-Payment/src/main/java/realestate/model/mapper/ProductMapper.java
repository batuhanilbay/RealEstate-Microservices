
package realestate.model.mapper;

import realestate.dto.ProductDto;
import realestate.model.Product;


public class ProductMapper {
	

	
	public static Product dtoToEntity(ProductDto productDto) {
		
	
		
		
		return Product.builder().id(productDto.getId())
				.status(productDto.getStatus())
				.userId(productDto.getUserId())
				.dayOfCounter(productDto.getDayOfCounter())
				.buyDate(productDto.getBuyDate())
				.build();
	}
	
	public static ProductDto entityToDto(Product product) {
		
		
		return ProductDto.builder()
				.id(product.getId())
				.status(product.getStatus())
				.userId(product.getUserId())
				.dayOfCounter(product.getDayOfCounter())
				.buyDate(product.getBuyDate())
				.build();
		
	}

}

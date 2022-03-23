package realestate.model.mapper;



import realestate.dto.ProductDto;
import realestate.model.concretes.Product;

public class ProductMapper {
	
	
	public static Product dtoToEntity(ProductDto productDto) {
		


		
		return Product.builder()
				
				.buyDate(productDto.getBuyDate())
				.expiredDate(productDto.getExpiredDate())
				.numberOfQuantityAdvert(productDto.getNumberOfQuantityAdvert())
				.dayOfCounter(productDto.getDayOfCounter())
				.userId(productDto.getUserId())
				.build();
	
	}

	public static ProductDto entityToDto(Product product) {

		
		
		return ProductDto.builder()
			
			.buyDate(product.getBuyDate())
			.expiredDate(product.getExpiredDate())
			.numberOfQuantityAdvert(product.getNumberOfQuantityAdvert())
			.dayOfCounter(product.getDayOfCounter())
			.userId(product.getUserId())
			.build();
		
	}


}

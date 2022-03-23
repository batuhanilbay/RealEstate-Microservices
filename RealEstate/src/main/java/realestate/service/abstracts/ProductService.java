package realestate.service.abstracts;

import java.util.List;
import realestate.dto.PaymentDto;
import realestate.dto.ProductDto;
import realestate.dto.response.ProductsByUserIdResponse;

public interface ProductService {
	
	//For CRUD operations interface methods for Product

	List<ProductDto> findAll();
	ProductDto findById( Long productId);
	ProductDto save( ProductDto productDto);
	void deleteById(Long productId);
	ProductsByUserIdResponse getProductByUserId(Long userId);
	PaymentDto preparePaymentOperation(Long userId);
}

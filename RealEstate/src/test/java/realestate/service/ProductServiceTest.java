package realestate.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import realestate.dto.AdvertDto;
import realestate.dto.ProductDto;
import realestate.model.concretes.Advert;
import realestate.model.concretes.Product;
import realestate.repository.ProductRepository;
import realestate.repository.UserRepository;
import realestate.service.abstracts.ProductService;
import realestate.service.concretes.ProductServiceImpl;

@SpringBootTest
public class ProductServiceTest {
	
	
	private Product product;
	private ProductDto productDto;
	private List<Product> productList;
	@Mock
	private ModelMapper modelMapper;
	@Mock
	private ProductRepository productRepository;
	@Mock
	private UserRepository userRepository;
	@Mock 
	private ProductServiceImpl productServiceImpl;
	@Mock 
	private ProductService service;
	
	@BeforeEach
	public void setup() {
		
		product = new Product();
		product.setId(1L);
		product.setNumberOfQuantityAdvert(30);
		product.setUserId(3L);
		
		productList = new ArrayList<>();
		productDto = modelMapper.map(product, ProductDto.class);
		productList.add(product);
	}
	
	@Test()
	@DisplayName("Get ALL Products Unit Test")
	public void get_all_products_test() {
		Mockito
		.when(productRepository.findAll())
		.thenReturn(productList);
		
		List<ProductDto> getFoundProducts = productServiceImpl.findAll();
		assertNotNull(getFoundProducts);

		assertThat(getFoundProducts.size()).isNotZero();
		
		
	}
	
	@Test()
	public void get_product_by_id_test() {
	

		Mockito
			.when(productRepository.getById(product.getId())).thenReturn(product);
			
			productDto = productServiceImpl.findById(product.getId());
			
			assertEquals(productDto.getId(),"1L");
		
	}
	
	@Test() 
	public void delete_product_test() {
		
		Product deleteWithProductId = new Product();
		deleteWithProductId.setId(1L);
	
		when(productRepository.findById(deleteWithProductId.getId())).thenReturn(null);
		
		service.deleteById(deleteWithProductId.getId());
		verify(productRepository).deleteById(deleteWithProductId.getId());
		
	}
	
	@Test()
	public void save_product_test() {
		

		  Product product = new Product();
		  product.setId(2L);
		 

	     doReturn(product).when(productRepository).save(product);
	      
	     ProductDto returnProduct = modelMapper.map(product,ProductDto.class);
	     productServiceImpl.save(returnProduct);
	     
	     // Assert the PRODUCT response 
	     Assertions.assertNotNull(returnProduct, "The saved Product should not be null");
	
		
	}
	
	

}

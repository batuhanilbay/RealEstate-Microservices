package realestate.service.concretes;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import realestate.client.PaymentClientFeign;
import realestate.dto.PaymentDto;
import realestate.dto.ProductDto;
import realestate.dto.UserDto;
import realestate.dto.response.ProductsByUserIdResponse;
import realestate.model.concretes.Product;
import realestate.model.concretes.User;
import realestate.repository.ProductRepository;
import realestate.repository.UserRepository;
import realestate.service.abstracts.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	
	private ProductRepository productRepository;
	private ModelMapper modelMapper;
	private PaymentClientFeign paymentClientFeign;
	private UserRepository userRepository;
	
	@Autowired(required = true)
	public ProductServiceImpl(ProductRepository productRepository,
								ModelMapper modelMapper, 
								PaymentClientFeign paymentClientFeign, 
								UserRepository userRepository) {		
		this.productRepository = productRepository;
		this.modelMapper = modelMapper;
		this.paymentClientFeign = paymentClientFeign;
		this.userRepository = userRepository;
		
	}
	
	
	//For All get Products
	@Override
	public List<ProductDto> findAll() {
		List<Product> products = productRepository.findAll();
		return products.stream().map(prd -> modelMapper.map(prd, ProductDto.class)).collect(Collectors.toList());
		
	}
					
	//For get Product by ProductId	
	@Override
	public ProductDto findById(Long productId) {
		
		Optional<Product> isProduct = productRepository.findById(productId);
			
		return isProduct.map(prd->modelMapper.map(prd, ProductDto.class)).orElse(null);
	}
	
	
	//For Create Product
	@Override
	public ProductDto save(ProductDto productDto) {
	
		Optional<User> okUser = userRepository.findById(productDto.getUserId());
		
		if(okUser.isPresent()) {
				Optional<Product> isOptionalProduct = Optional.ofNullable(productRepository.getProductsByUserId(productDto.getUserId()));
				
				if(!isOptionalProduct.isPresent()) {
					preparePaymentOperation(productDto.getUserId());
					Calendar c1= Calendar.getInstance();
					productDto.setBuyDate(c1.getTime());
					c1.add(Calendar.DATE, 30);
					productDto.setExpiredDate(c1.getTime());
					productDto.setNumberOfQuantityAdvert(10);
					Product product = modelMapper.map(productDto, Product.class);
					return modelMapper.map(productRepository.save(product),ProductDto.class);
					
				}
				
				//Burada eğer bir kullanıcı birden fazla product almak isterse üzerine ekleniyor. Miktar güncelleniyor. 
				
				else {
					preparePaymentOperation(isOptionalProduct.get().getUserId());
					
					Calendar c1= Calendar.getInstance();
					isOptionalProduct.get().setBuyDate(c1.getTime());
					c1.add(Calendar.DATE, 30);
					isOptionalProduct.get().setExpiredDate(c1.getTime());
					isOptionalProduct.get().setNumberOfQuantityAdvert(isOptionalProduct.get().getNumberOfQuantityAdvert()+10);
					
					return modelMapper.map(productRepository.save(isOptionalProduct.get()),ProductDto.class);
				}
				
				
		
		}
	
		return null;
	
	}
	
	//For delete Product by productId
	@Override
	public void deleteById(Long productId) {
		productRepository.deleteById(productId);
	}

	//The control of between Product and User
	@Override
	public ProductsByUserIdResponse getProductByUserId(Long userId) {
		
		User okUser = userRepository.findById(userId).orElse(null);
		UserDto userDto = modelMapper.map(okUser, UserDto.class);
		Product product = productRepository.getProductsByUserId(userId);
		ProductDto productDto = modelMapper.map(product, ProductDto.class);
		ProductsByUserIdResponse response = new ProductsByUserIdResponse();
		response.setProduct(productDto);
		response.setUserDto(userDto);
	
		return response;
	}

	
	//Payment operation control 
	@Override
	public PaymentDto preparePaymentOperation(Long userId) {
		
		User getUser = userRepository.findById(userId).orElse(null);
		UserDto userDto = modelMapper.map(getUser, UserDto.class);

		PaymentDto paymentDto = new PaymentDto();
		
		paymentDto.setUserId(userDto.getId());
		paymentDto.setIsPaid(true);
		paymentDto.getTransferType();
		
		
		paymentClientFeign.createPayment(paymentDto);

		
		return paymentDto;
		
	}


	
	
	
	
}

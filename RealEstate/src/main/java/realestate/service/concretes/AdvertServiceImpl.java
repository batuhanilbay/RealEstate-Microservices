package realestate.service.concretes;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import realestate.dto.AdvertDto;
import realestate.dto.UserDto;
import realestate.dto.response.AdvertsByUserIdResponse;
import realestate.model.concretes.Advert;
import realestate.model.concretes.Product;
import realestate.model.concretes.User;
import realestate.model.enums.StatusType;
import realestate.queue.QueueService;
import realestate.repository.AdvertRepository;
import realestate.repository.ProductRepository;
import realestate.repository.UserRepository;
import realestate.service.abstracts.AdvertService;


@Service
public class AdvertServiceImpl implements AdvertService{

	private AdvertRepository advertRepository;
	private UserRepository userRepository;
	private ProductRepository productRepository;
	private QueueService queue;
	private ModelMapper modelMapper;
	
	@Autowired(required = true)
	public AdvertServiceImpl(AdvertRepository advertRepository,
								UserRepository userRepository,
								ProductRepository productRepository,
								QueueService queue,
								ModelMapper modelMapper) {
		
		this.advertRepository = advertRepository;
		this.userRepository = userRepository;
		this.productRepository = productRepository;
		this.queue = queue;
		this.modelMapper =modelMapper;
		
	}
	
	
	

	//Create Advert Scenarios
	@Override
	public AdvertDto saveAdvert(AdvertDto advertDto) {
		
		Optional<User> isUser = userRepository.findById(advertDto.getUserId());
		Optional<Product> isProduct = Optional.ofNullable(productRepository.getProductsByUserId(advertDto.getUserId()));
		//InventoryService inventory = new InventoryService();
		InventoryService inventory = new InventoryService();
		inventory.setMessage("Ödeme alındı");
		//Kullanıcı var ürün yok ise advert varsayılan olarak işaretlenerek kaydedilir.
		if(isUser.isPresent() && isProduct.isPresent()) {
			
			Product product = productRepository.getProductsByUserId(advertDto.getUserId());
			int productQuantity = product.getNumberOfQuantityAdvert();
			Date nowDate = new Date();
		
			if(productQuantity > 0 && nowDate.getTime() < product.getExpiredDate().getTime()) {
				Advert advert = modelMapper.map(advertDto, Advert.class);
				
				queue.sendMessage(inventory);
				advert.setStatusType(StatusType.IN_REVIEW);
				if(inventory.getMessage() != null) {
					advert.setStatusType(StatusType.ACTIVE);
				}
				product.setNumberOfQuantityAdvert(--productQuantity);
				productRepository.save(product);
				return modelMapper.map(advertRepository.save(advert),AdvertDto.class);	
			}
		
			else {
				return null;
			}
	
	}

	else {
		return null;
	}
	}
	

	//Get all Adverts
	@Override
	public List<AdvertDto> getAllAdverts() {
		List<Advert> adverts = advertRepository.findAll();
		return adverts.stream().map(adv -> modelMapper.map(adv, AdvertDto.class)).collect(Collectors.toList());
	}

	@Override
	public AdvertDto getAdvertById(Long advertId) {
		
		Optional<Advert> isAdvert = advertRepository.findById(advertId);
		return isAdvert.map(adv->modelMapper.map(adv, AdvertDto.class)).orElse(null);
		
	}

	//Delete operation with AdvertId
	@Override
	public void deleteAdvert(Long advertId) {
		advertRepository.deleteById(advertId);

	}


	//Relationship between The Advert and The User
	@Override
	public AdvertsByUserIdResponse getAdvertByUserId(Long userId) {
	
		User okUser = userRepository.findById(userId).orElse(null);
		UserDto userDto = modelMapper.map(okUser, UserDto.class);
		Collection<Advert> adverts = advertRepository.getAdvertsByUserId(userId);
		List<AdvertDto> advertDtoList = adverts.stream().map(adv -> modelMapper.map(adv, AdvertDto.class)).collect(Collectors.toList());
		AdvertsByUserIdResponse response = new AdvertsByUserIdResponse();
		response.setAdverts(advertDtoList);
		response.setUserDto(userDto);
		return response;
		

	}
	

	
}







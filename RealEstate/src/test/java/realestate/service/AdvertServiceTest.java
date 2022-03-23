package realestate.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import realestate.dto.AdvertDto;
import realestate.dto.UserDto;
import realestate.model.concretes.Advert;
import realestate.model.concretes.User;
import realestate.model.enums.StatusType;
import realestate.repository.AdvertRepository;
import realestate.repository.ProductRepository;
import realestate.repository.UserRepository;
import realestate.service.concretes.AdvertServiceImpl;

@SpringBootTest
@ExtendWith(MockitoExtension.class)

public class AdvertServiceTest {
	
	
	

	private static final StatusType IN_REVIEW = null;
	private Advert advert;
	private User user;
	private List<User> userList;
	private List<Advert> advertList;
	private UserDto userDto;
	private AdvertDto advertDto;
	
	@Mock
	private ModelMapper modelMapper;
	@Mock
	private AdvertRepository advertRepository;
	@Mock
	private AdvertServiceTest advertService;
	@Mock
	private UserRepository userRepository;
	@Mock
	private ProductRepository productRepository;
	@InjectMocks
	private AdvertServiceImpl advertServiceImpl;


	@BeforeEach
	public void setup() {
		advert = new Advert();
		advert.setId(1L);
		advert.setTitle("FOR RENT");
		advert.setContent("test-content");
		advert.setUserId(1L);
		advert.setStatusType(StatusType.IN_REVIEW);
		
		advertList = new ArrayList<>();
		advertDto = modelMapper.map(advert, AdvertDto.class);
		advertList.add(advert);
		
		user = new User();
		user.setId(5L);
		user.setUsername("admin");
		user.setEmail("hepsiemlak@gm.com");
		
		userList = new ArrayList<>();
		userDto = modelMapper.map(user, UserDto.class);
		userList.add(user);
		
	}
	
	
	@Test()
	@DisplayName("Get ALL Adverts Unit Test")
	public void get_all_advert_test() {
		Mockito
		.when(advertRepository.findAll())
		.thenReturn(advertList);
		
		List<AdvertDto> getFoundAdverts = advertServiceImpl.getAllAdverts();
		assertNotNull(getFoundAdverts);

		assertThat(getFoundAdverts.size()).isNotZero();
		
	}
	

	@Test()
	public void get_advert_by_id_test() {
	
		Mockito
		.when(advertRepository.getById(advert.getId())).thenReturn(advert);
		
		AdvertDto getAdvert = advertServiceImpl.getAdvertById(advert.getId());
		
		assertEquals(getAdvert.getId(),1L);

	}
	




	@Test()
	@DisplayName("Test without USER")
	public void save_advert_without_user_test() {
		
	
		  Advert advert = new Advert();
		  advert.setId(2L);
		  advert.setTitle("For Sale");
		  advert.setContent("Test-content");
		  
	      doReturn(advert).when(advertRepository).save(advert);
	      
	  
	     AdvertDto returnAdvert = modelMapper.map(advert,AdvertDto.class);
	     advertServiceImpl.saveAdvert(returnAdvert);
	     
	     // Assert the advert response without user
	     Assertions.assertNotNull(returnAdvert, "The saved advert should not be null");
	   
	}
	
	
	
	@Test()
	@DisplayName("Testing with the ADVERT-USER")
	public void save_advert_with_user_test() {
		
		AdvertDto advertDto = prepareAdvertDto();

		Optional<User> user = Optional.of(prepareUser());
		Mockito
		.when(advertRepository.getAdvertsByUserId(advertDto.getUserId()));
		
		Mockito
		.when(advertRepository.save(any()))
		.thenReturn(advert);
	

		AdvertDto advertDtoResponse = advertServiceImpl.saveAdvert(advertDto);
		assertEquals("FOR RENT", advertDtoResponse.getTitle());
	
		
	}
		

	
	@Test() 
	public void delete_advert_test() {
		
		Advert deleteAdvert = new Advert();
		deleteAdvert.setId(1L);
		deleteAdvert.setTitle("Deleted Title");
		deleteAdvert.setContent("Deleted Content");

		when(advertRepository.findById(deleteAdvert.getId())).thenReturn(null);
		
		advertServiceImpl.deleteAdvert(deleteAdvert.getId());
		verify(advertRepository).deleteById(deleteAdvert.getId());
	}
	
	@Test()
	public void update_advert_test() {
		
		Advert firstAdvert = new Advert();
		firstAdvert.setTitle("ANTALYAADAN BATUHAN BEYE OPSİYONLANDI");
		firstAdvert.setContent("SATILDI");
		firstAdvert = modelMapper.map(advertDto,Advert.class);		
		// Mockito.verify(userServiceImpl, Mockito.times(1)).updateUser(userDto);
		
		
		
	}
	
	
	private AdvertDto prepareAdvertDto() {
		AdvertDto request = new AdvertDto();
		request.setUserId(5L);
		request.setTitle("FOR RENT");
		return request;
	}
	
	private User prepareUser() {
		User user = new User();
		user.setId(5L);
		user.setEmail("mail");
		user.setPassword("123");
		return user;
	}
	
	


}

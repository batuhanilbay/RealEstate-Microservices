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
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import realestate.dto.ProductDto;
import realestate.dto.UserDto;
import realestate.model.concretes.Product;
import realestate.model.concretes.User;
import realestate.model.enums.UserType;
import realestate.repository.UserRepository;
import realestate.service.abstracts.UserService;
import realestate.service.concretes.UserServiceImpl;




@SpringBootTest
public class UserServiceTest {
	
	
	private static final UserType CORPORATE=null;
	@Mock
	private User user;
	private List<User> userList;
	@Mock
	private UserDto userDto;
	@Mock
	private ModelMapper modelMapper;
	
	
	
	@Mock
	private UserRepository userRepository;
	@Mock
	private UserService service;
	@InjectMocks
	private UserServiceImpl userServiceImpl;


	@BeforeEach
	public void setup() {
		user = new User();
		user.setId(1L);
		user.setEmail("test@gmail.com");
		user.setPassword("password");
		user.setUsername("username");
		//user = modelMapper.map(userDto, User.class);
		userList = new ArrayList<>();
		userDto = modelMapper.map(user, UserDto.class);
		userList.add(user);
	}
	
	
	@Test()
	@DisplayName("Get ALL Users Unit Test")
	public void get_all_users_test() {
		Mockito
		.when(userRepository.findAll())
		.thenReturn(userList);
		
		List<UserDto> getFoundUsers = userServiceImpl.getAllUsers();
		assertNotNull(getFoundUsers);

		assertThat(getFoundUsers.size()).isNotZero();
	
		
	}
	

	@Test()
	public void get_user_by_id_test() {
	

		Mockito
			.when(userRepository.getById(user.getId())).thenReturn(user);
			
			userDto = userServiceImpl.getUserById(user.getId());
			
			assertEquals(userDto.getId(),"1L");
		
	}
	
	@Test()
	public void save_user_test() {
		
		  User user = new User();
		  user.setId(2L);
		  user.setEmail("email.com");
		 

	     doReturn(user).when(userRepository).save(user);
	      
	     UserDto returnUser = modelMapper.map(user,UserDto.class);
	     userServiceImpl.saveUser(returnUser);
	     
	     // Assert the USER response 
	     Assertions.assertNotNull(returnUser, "The saved USER should not be null");
	
		
		
	}
	
	@Test() 
	public void delete_user_test() {
		
		User deleteUser = new User();
		deleteUser.setId(1L);
		deleteUser.setPassword("password");
		deleteUser.setUsername("hepsiemlak");
		deleteUser.setUserType(CORPORATE);
		
		when(userRepository.findById(deleteUser.getId())).thenReturn(null);
		
		userServiceImpl.deleteUser(deleteUser.getId());
		verify(userRepository).deleteById(deleteUser.getId());
		
	}
	
	@Test()
	public void update_user_test() {
		
		User firstUser = new User();
		firstUser.setUsername("hepsi");
		firstUser.setEmail("patika@");
		firstUser = modelMapper.map(userDto,User.class);		
				
		
		
	}

	
	
}


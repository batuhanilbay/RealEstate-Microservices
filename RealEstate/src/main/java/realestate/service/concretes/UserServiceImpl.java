package realestate.service.concretes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import realestate.dto.UserDto;
import realestate.model.concretes.User;
import realestate.repository.UserRepository;
import realestate.service.abstracts.UserService;

@Service
public class UserServiceImpl implements UserService {


	private UserRepository userRepository;
	private ModelMapper modelMapper;
	
	@Autowired(required = true)
	public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
		this.userRepository = userRepository;
		this.modelMapper = modelMapper;

	}

	//For Create User
	@Override
	public UserDto saveUser(UserDto userDto) {
		User user = modelMapper.map(userDto, User.class);
		if(user!=null) {
			
			return modelMapper.map(userRepository.save(user),UserDto.class);
		}
		else {
			return null;
		}
		
	}

	//For All get Users
	@Override
	public List<UserDto> getAllUsers() {
		List<User> users = userRepository.findAll();
		return users.stream().map(usr -> modelMapper.map(usr, UserDto.class)).collect(Collectors.toList());
	}
	//For get User by UserId
	@Override
	public UserDto  getUserById(Long userId) {
		Optional<User> isUser = userRepository.findById(userId);	
		return isUser.map(usr->modelMapper.map(usr, UserDto.class)).orElse(null);
	
	}
	
	@Override
	public UserDto updateUser(UserDto userDto) {

		User user = modelMapper.map(userDto, User.class);;
		user.setUsername(userDto.getUserName());
		user.setEmail(userDto.getEmail());
		return modelMapper.map(userRepository.save(user),UserDto.class);
	
	}
	
	//For delete User by UserId
	@Override
	public void deleteUser(Long userId) {
		userRepository.deleteById(userId);
	}


}




















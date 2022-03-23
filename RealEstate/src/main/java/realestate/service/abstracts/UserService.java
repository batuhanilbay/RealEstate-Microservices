package realestate.service.abstracts;

import java.util.List;
import realestate.dto.UserDto;


public interface UserService {

	//For CRUD operations interface methods for User.

	 UserDto saveUser(UserDto userDto);
	 List<UserDto> getAllUsers();
	 UserDto getUserById(Long userId);
	 void deleteUser(Long userId);
	 UserDto updateUser(UserDto userDto);


}

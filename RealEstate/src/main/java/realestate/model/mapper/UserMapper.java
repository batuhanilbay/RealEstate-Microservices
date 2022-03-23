package realestate.model.mapper;

import realestate.dto.UserDto;
import realestate.model.concretes.User;

public class UserMapper {
	
	
	public static User dtoToEntity(UserDto userDto) {
		
		
		return User.builder()
				
				.email(userDto.getEmail())
				.username(userDto.getUserName())
				.id(userDto.getId())
				.password(userDto.getPassword())
				.userType(userDto.getUserType())
				.build();
				//.products(userDto.getProducts())
				
			
	
	}

	public static UserDto entityToDto(User user) {
	
	
		return UserDto.builder()
		
			.email(user.getEmail())
			.id(user.getId())
			.userName(user.getUsername())
			.userType(user.getUserType())
			.password(user.getPassword())
			.build();
		
	}

}

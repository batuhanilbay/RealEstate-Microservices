package realestate.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import realestate.model.enums.UserType;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {


	private Long id;
	private String userName;
	private String email;
	private String password;
	private UserType userType;

	
}

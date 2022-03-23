package realestate.dto.response;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import realestate.dto.AdvertDto;
import realestate.dto.UserDto;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdvertsByUserIdResponse {

	//It is used to create relationship between The Advert and The User.
	
	private UserDto userDto;
	
	private List<AdvertDto> adverts;
	
	
	
	
}

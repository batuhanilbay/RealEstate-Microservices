package realestate.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import realestate.dto.ProductDto;
import realestate.dto.UserDto;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductsByUserIdResponse {
	
	//It is used to create relationship between The Product and The User.
	
	
	private UserDto userDto;
	
	private ProductDto product;

}

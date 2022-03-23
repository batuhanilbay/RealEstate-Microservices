package realestate.dto.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import realestate.dto.ProductDto;
import realestate.dto.UserDto;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentResponseControl {
	
	//Payment check control 
	
	private UserDto userDto;
	
	private ProductDto productDto;
	

}

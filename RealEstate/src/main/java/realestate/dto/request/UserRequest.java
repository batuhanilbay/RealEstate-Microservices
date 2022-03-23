package realestate.dto.request;

import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import realestate.model.enums.UserType;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)

public class UserRequest extends BaseRequest{

	private String userName;
	private String mail;
	private UserType userType;
	private Set<ProductRequest> products;
	
}

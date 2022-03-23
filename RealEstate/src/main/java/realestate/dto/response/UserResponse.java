package realestate.dto.response;

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

public class UserResponse extends BaseResponse {

	private String userName;
	private String mail;
	private UserType userType;
	private Set<ProductResponse> products;






}

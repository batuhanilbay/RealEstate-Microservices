package realestate.dto.response;

import java.util.Date;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)

public class ProductResponse extends BaseResponse{

	@JsonFormat(pattern="dd-MM-yyyy")
	private Date  buyDate ;
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date expiredDate ;
	private int dayOfCounter=30;
	private int numberOfQuantity=10;
	private UserResponse user;
	private Long advertId;
	private Set<UserResponse> users;
}

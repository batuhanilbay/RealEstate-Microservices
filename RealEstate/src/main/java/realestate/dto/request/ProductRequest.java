package realestate.dto.request;

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

public class ProductRequest extends BaseRequest{


	@JsonFormat(pattern="dd-MM-yyyy")
	private Date  buyDate ;
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date  expiredDate ;
	private int dayOfCounter;
	private int numberOfQuantity;
	private Long advertId;
	private Set<UserRequest> user;
	


}

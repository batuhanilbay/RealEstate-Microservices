package realestate.dto.response;

import java.util.List;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import realestate.model.enums.TransferType;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentResponse {
	
	
	private Long id;
	private Long userId;
	private Boolean isPaid;
	@Enumerated(EnumType.STRING)
	private TransferType transferType;
	private List<UserResponse> userResponse;

}

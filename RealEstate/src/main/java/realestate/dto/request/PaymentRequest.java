package realestate.dto.request;

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
public class PaymentRequest {
	
	private Long id;
	private Long userId;
	private Boolean isPaid;
	@Enumerated(EnumType.STRING)
	private TransferType transferType;
	private List<UserRequest> userRequests;

}

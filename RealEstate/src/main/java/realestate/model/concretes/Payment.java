package realestate.model.concretes;

import java.util.List;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import realestate.dto.UserDto;
import realestate.model.enums.TransferType;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payment {

	private Long id;
	private Long userId;
	private Boolean isPaid;
	@Enumerated(EnumType.STRING)
	private TransferType transferType;
	private List<UserDto> userDto;
	
}

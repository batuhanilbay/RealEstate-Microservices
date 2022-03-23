package realestate.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import realestate.model.enums.HouseType;
import realestate.model.enums.PropertyType;
import realestate.model.enums.StatusType;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AdvertResponse extends BaseResponse{

	private String title;
	private String content;
	private Long price;
	private boolean isActive;
	private StatusType statusType;
	private HouseType houseType;
	private PropertyType propertyType;
	private Long userId;
	private Long productId;
	



}

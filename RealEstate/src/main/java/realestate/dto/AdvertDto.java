package realestate.dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import realestate.model.enums.HouseType;
import realestate.model.enums.PropertyType;
import realestate.model.enums.StatusType;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdvertDto {
	
	
	
	
	private Long id;
	private String title;
	private String content;
	private Date createDate;
	private HouseType houseType;
	private PropertyType propertyType;
	private StatusType statusType;
	private Long price;
	private Long userId;


}

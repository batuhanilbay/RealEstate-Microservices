package realestate.dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto {
	
	private Long id;
	private Date  buyDate;
	private Date  expiredDate;
	private int dayOfCounter;
	private int numberOfQuantityAdvert;
	private Long userId;
	
	
}

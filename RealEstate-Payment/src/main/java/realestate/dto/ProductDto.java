package realestate.dto;

import java.time.LocalDate;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
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
	private Long userId;
	private Date  buyDate;
	private Date  expiredDate;
	private int dayOfCounter;
	private int numberOfQuantityAdvert;
	private Boolean status;

	public ProductDto(boolean status) {
		this.status = status;
		
	}
	
}

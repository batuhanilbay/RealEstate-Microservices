package realestate.service.abstracts;

import java.util.List;
import realestate.dto.AdvertDto;
import realestate.dto.response.AdvertsByUserIdResponse;

public interface AdvertService {

	//For CRUD operations interface methods for Advert
	AdvertDto saveAdvert(AdvertDto advertDto);
	List<AdvertDto> getAllAdverts();
	AdvertDto getAdvertById(Long advertId);
	void deleteAdvert(Long advertId);
	AdvertsByUserIdResponse getAdvertByUserId(Long userId);
	

}

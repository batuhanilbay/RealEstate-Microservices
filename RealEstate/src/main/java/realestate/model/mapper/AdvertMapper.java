package realestate.model.mapper;


import java.util.Date;

import realestate.dto.AdvertDto;
import realestate.model.concretes.Advert;

public class AdvertMapper {
	
	
	public static Advert dtoToEntity(AdvertDto advertDto) {
		
		Date nowDate = new Date();
		
		return Advert.builder()
				.id(advertDto.getId())
				.title(advertDto.getTitle())
				.content(advertDto.getContent())
				.price(advertDto.getPrice())
				.statusType(advertDto.getStatusType())
				.propertyType(advertDto.getPropertyType())
				.houseType(advertDto.getHouseType())
				.createDate(nowDate)
				.userId(advertDto.getUserId())
				
				
				
				.build();
	
	}

	public static AdvertDto entityToDto(Advert advert) {
	
		Date nowDate = new Date();
		
		return AdvertDto.builder()
			.id(advert.getId())
			.title(advert.getTitle())
			.content(advert.getContent())
			.price(advert.getPrice())
			.statusType(advert.getStatusType())
			.propertyType(advert.getPropertyType())
			.houseType(advert.getHouseType())
			.createDate(nowDate)
			.userId(advert.getUserId())
			
			.build();
		
	}
	



}

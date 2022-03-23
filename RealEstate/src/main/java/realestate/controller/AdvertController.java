package realestate.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import realestate.dto.AdvertDto;
import realestate.dto.response.AdvertsByUserIdResponse;
import realestate.service.abstracts.AdvertService;


@RestController

public class AdvertController {
	
		@Autowired(required=true)
		private AdvertService advertService;
	

		//Get All Adverts
		@GetMapping(value = "/adverts")
		public ResponseEntity<List<AdvertDto>> getAllAdverts(){
			return ResponseEntity.ok().body(advertService.getAllAdverts());
	
		}

		//Get Advert By AdvertId
		@GetMapping(value = "/adverts",params = "advertId")
		public ResponseEntity<AdvertDto> getAdvertById(@RequestParam("advertId") Long advertId){
			
			AdvertDto advertDto = advertService.getAdvertById(advertId);
			return ResponseEntity.ok().body(advertService.getAdvertById(advertDto.getId()));
	
		}
		
		//Get Advert By UserId
		@GetMapping(value="/adverts",params = "userId")
		public AdvertsByUserIdResponse getAdvertsByUserId(@RequestParam("userId") Long userId ) {
			return advertService.getAdvertByUserId(userId);
		}

		//Create Advert
		@PostMapping(value = "/adverts")
		public ResponseEntity<AdvertDto> addAdvert(@RequestBody AdvertDto advertDto){	
			AdvertDto advert = advertService.saveAdvert(advertDto);
			return new ResponseEntity<>(advert,HttpStatus.OK);
		}

		//Delete Advert by advertId
		@DeleteMapping(value = "/adverts/{advertId}")
		public ResponseEntity<?> deleteAdvertById(@PathVariable Long advertId) {
			advertService.deleteAdvert(advertId);
			return new ResponseEntity<>("The Advert " + advertId + " has been deleted...",HttpStatus.OK);
		}


}

package realestate.client;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import realestate.dto.PaymentDto;

//For SYNCHRONOUS communication with PAYMENTSERVICE

@FeignClient(value="realestate-payment",url="http://localhost:8081")
public interface PaymentClient {

	@GetMapping(value = "/payments")
	List<PaymentDto> getAllPayments();
	
	@GetMapping(value="/payments",params = "userId")
	PaymentDto findByUserId(@RequestParam("userId") Long userId);

	@PostMapping(value = "/payments")
	ResponseEntity<PaymentDto> createPayment(@RequestBody PaymentDto paymentDto);

}
	


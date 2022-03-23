package realestate.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;
import realestate.dto.PaymentDto;
import realestate.model.Payment;
import realestate.service.abstracts.PaymentService;


@RestController
@RequiredArgsConstructor
public class PaymentController {
	
	@Autowired
	private  PaymentService paymentService;

	@GetMapping(value="/payments")
	public ResponseEntity<List<PaymentDto>> getAllPayments(){
		return ResponseEntity.ok(paymentService.getAllPayments());
		
	}
	
	
	@GetMapping(value="/payments",params = "paymentId")
	public ResponseEntity<PaymentDto> getByPaymentId(@RequestParam("id")  Long paymentId){
		
		return ResponseEntity.ok(paymentService.findPaymentById(paymentId));
		
	}
	
	@PostMapping(value="/payments")
	public ResponseEntity<Payment> createPayment(@RequestBody Payment payment){
		return new ResponseEntity<>(paymentService.savePaymentOperation(payment),HttpStatus.OK);
		
	}
	
	
	@GetMapping(value="/payments",params = "userId")
	public PaymentDto findByUserId(@RequestParam("userId") Long userId){
		return paymentService.findByUserId(userId);
		
	}
		
}
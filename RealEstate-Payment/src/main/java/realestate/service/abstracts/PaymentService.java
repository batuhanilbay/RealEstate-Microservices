package realestate.service.abstracts;


import java.util.List;
import realestate.dto.PaymentDto;
import realestate.model.Payment;

public interface PaymentService {

	/*PaymentResponse savePaymentOperation(PaymentRequest paymentRequest);
	List<PaymentResponse> getAllPayment();*/
	Payment savePaymentOperation(Payment payment);
	List<PaymentDto> getAllPayments();
	PaymentDto findPaymentById(Long id);
	//List<PaymentDto> findByUserId(Long userId);
	PaymentDto findByUserId(Long userId);
	
	
}

package realestate.model.mapper;

import realestate.dto.PaymentDto;
import realestate.model.Payment;

public class PaymentMapper {
	
	
	
	public static Payment dtoToEntity(PaymentDto paymentDto) {
		

	
			return Payment.builder().id(paymentDto.getId())
					.isPaid(paymentDto.getIsPaid())
					.userId(paymentDto.getUserId())
					.transferType(paymentDto.getTransferType())
					
					.build();
			
	
				
	
	}
	
	public static PaymentDto entityToDto(Payment payment) {
		
		return PaymentDto.builder().id(payment.getId())
				.transferType(payment.getTransferType())
				.isPaid(payment.getIsPaid())
				.userId(payment.getUserId())
				.build();
		
	}

}

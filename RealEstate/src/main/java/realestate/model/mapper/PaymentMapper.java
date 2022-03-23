package realestate.model.mapper;

import realestate.dto.PaymentDto;
import realestate.model.concretes.Payment;

public class PaymentMapper {
	
	

	public static Payment dtoToEntity(PaymentDto paymentDto) {
	
			return Payment.builder()
					.id(paymentDto.getId())
					.isPaid(paymentDto.getIsPaid())
					.userId(paymentDto.getUserId())
					.transferType(paymentDto.getTransferType())
					.build();

	}
	
	public static PaymentDto entityToDto(Payment payment) {
		
		return PaymentDto.builder()
				.id(payment.getId())
				.isPaid(payment.getIsPaid())
				.userId(payment.getUserId())
				.transferType(payment.getTransferType())
				.build();
		
	}


}

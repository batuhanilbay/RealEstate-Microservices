package realestate.service.concretes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import realestate.dto.PaymentDto;
import realestate.logger.FileLogger;
import realestate.model.Payment;
import realestate.repo.PaymentRepository;
import realestate.service.abstracts.PaymentService;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
	
	@Autowired
	private  PaymentRepository paymentRepository;
	@Autowired
	private  ModelMapper modelMapper;
	@Autowired
	private FileLogger fileLogger;
	
	public PaymentServiceImpl(PaymentRepository paymentRepository,ModelMapper modelMapper,FileLogger fileLogger) {
		this.paymentRepository = paymentRepository;
		this.modelMapper = modelMapper;
		this.fileLogger = fileLogger;
	}
	
	
	
	@Override
	public Payment savePaymentOperation(Payment payment) {
		fileLogger.writeFolderTxt("ÖDEME KAYDI: " + payment.toString());
		return paymentRepository.save(payment);
		
	}

	@Override
	public List<PaymentDto> getAllPayments() {
		List<Payment> payments = paymentRepository.findAll();
		return payments.stream().map(payment -> modelMapper.map(payment, PaymentDto.class)).collect(Collectors.toList());
	}

	@Override
	public PaymentDto findPaymentById(Long id) {
		Optional<Payment> payment  = paymentRepository.findById(id);
		
		return payment.map(paymentId -> modelMapper.map(paymentId,PaymentDto.class)).orElseThrow();
	}

	@Override
	public PaymentDto findByUserId(Long userId) {
		Optional<Payment> payment = paymentRepository.getPaymentsByUserId(userId);
	
		if(payment != null) {
			return payment.map(paymentId -> modelMapper.map(paymentId,PaymentDto.class)).orElseThrow();
		}
		else {
			return null;

		}
	}



	



}


/*

private final PaymentRepository paymentRepository;
private final PaymentBaseService paymentBaseService;

@Autowired(required = true)
public PaymentServiceImpl(PaymentRepository paymentRepository, PaymentBaseService paymentBaseService) {
	super();
	this.paymentRepository = paymentRepository;
	this.paymentBaseService = paymentBaseService;
}


@Override
public PaymentResponse savePaymentOperation(PaymentRequest paymentRequest) {
	
	
	Payment payment = paymentRepository.savePayment(paymentBaseService.convertToPayment(paymentRequest));
	log.info("Ücret alındı: " + payment.toString());
	return paymentBaseService.convertToPaymentResponse(payment);
	
	
}



@Override
public List<PaymentResponse> getAllPayment() {
	List<PaymentResponse> paymentResponses = new ArrayList<>();
	for (Payment payment : paymentRepository.findAllPayment()) {
		paymentResponses.add(paymentBaseService.convertToPaymentResponse(payment));
	}
	return paymentResponses;
}
*/
package realestate.client;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import lombok.extern.slf4j.Slf4j;
import realestate.dto.PaymentDto;
import realestate.logger.FileLogger;


@Service
@Slf4j
public class PaymentClientFeign {
	
	
	private PaymentClient paymentClient;
	private FileLogger fileLogger;
	
	@Autowired(required = true)
	public PaymentClientFeign(PaymentClient paymentClient, FileLogger fileLogger) {
		this.paymentClient = paymentClient;
		this.fileLogger = fileLogger;
	}

	@HystrixCommand(fallbackMethod = "defaultSavePayment")
	public ResponseEntity<PaymentDto> createPayment(PaymentDto paymentDto) {
		return paymentClient.createPayment(paymentDto);
	}
	
	@HystrixCommand(fallbackMethod = "getPayment")
	public PaymentDto findByUserId(Long userId){
		return paymentClient.findByUserId(userId);
	}

	
	private ResponseEntity<PaymentDto> defaultSavePayment(PaymentDto paymentDto){
		//Eğer bir sıkıntı çıkarsa burada dosyaya kayıt altına alınır.
		fileLogger.writeFolderTxt(paymentDto.toString());
		log.info("Payment Service time out, default method already called");
		return new ResponseEntity<>(HttpStatus.REQUEST_TIMEOUT);
	}
	
	

}

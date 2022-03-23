package realestate.advice;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import lombok.extern.slf4j.Slf4j;
import realestate.exception.PasswordNotValidException;
import realestate.exception.RealEstateException;
import realestate.exception.UserNotFoundException;


@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorResponse> handle(UserNotFoundException exception) {
		log.error("User not found exception occured." + exception.getMessage());
		ErrorResponse response = new ErrorResponse(exception.getMessage(), new Date());
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(PasswordNotValidException.class)
	public ResponseEntity<ErrorResponse> handle(PasswordNotValidException exception) {
		log.error("User password not valid exception occured." + exception.getMessage());
		ErrorResponse response = new ErrorResponse(exception.getMessage(), new Date());
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(RealEstateException.class)
	public ResponseEntity<ErrorResponse> handle(RealEstateException exception) {
		log.error("General RealEstate exception occured." + exception.getMessage());
		ErrorResponse response = new ErrorResponse(exception.getMessage(), new Date());
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<ErrorResponse> handle(NullPointerException exception) {
		log.error("NullPointerException exception occured." + exception.getMessage());
		ErrorResponse response = new ErrorResponse("yolunda gitmeyen işler oldu.", new Date());
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

}

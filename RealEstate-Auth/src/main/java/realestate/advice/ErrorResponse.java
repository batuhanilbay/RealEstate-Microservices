package realestate.advice;



import java.util.Date;
import org.springframework.http.HttpStatus;
import lombok.Getter;

@Getter
public class ErrorResponse {
	
	
	private HttpStatus httpStatus;
	private String message;
	private Date date;

	public ErrorResponse(HttpStatus httpStatus, String message, Date date) {
		super();
		this.httpStatus = httpStatus;
		this.message = message;
		this.date = date;
	}

	public ErrorResponse(String message, Date date) {
		super();
		this.message = message;
		this.date = date;
		this.httpStatus = HttpStatus.BAD_REQUEST;
	}

}

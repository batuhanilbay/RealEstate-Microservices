package realestate.exception;

import lombok.Getter;

@Getter
public class RealEstateException extends RuntimeException {
	
	private String message;

	public RealEstateException(String message) {
		this.message = message;
	}

}

package realestate.exception;

public class RealEstateException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	private String message;

	public RealEstateException(String message) {
		this.message = message;
	}


}

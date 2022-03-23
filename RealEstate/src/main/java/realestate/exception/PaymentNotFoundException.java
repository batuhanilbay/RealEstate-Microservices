package realestate.exception;

public class PaymentNotFoundException extends RealEstateException {
	

	private static final long serialVersionUID = 1L;

	public PaymentNotFoundException(String message) {
		super(message);
	}

}

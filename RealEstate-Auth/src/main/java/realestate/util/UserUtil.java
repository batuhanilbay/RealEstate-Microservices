package realestate.util;

import org.springframework.stereotype.Component;

public class UserUtil {
	
	
	private UserUtil() { }

	public static boolean isValidPassword(String password, String password2) {
		return password.equals(password2);
	}

}

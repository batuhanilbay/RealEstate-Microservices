package realestate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import realestate.dto.AuthRequest;
import realestate.dto.AuthResponse;
import realestate.entity.User;
import realestate.exception.PasswordNotValidException;
import realestate.exception.UserNotFoundException;
import realestate.repository.AuthRepository;
import realestate.util.JwtUtil;
import realestate.util.UserUtil;




@Slf4j
@Service
public class AuthService {
	
	
	private AuthRepository authRepository;
	private JwtUtil jwtUtil;
	
	@Autowired
	public AuthService(AuthRepository authRepository,JwtUtil jwtUtil) {
		this.authRepository = authRepository;
		this.jwtUtil = jwtUtil;
		
	}

	public AuthResponse getToken(AuthRequest request) throws PasswordNotValidException {
		User user = authRepository.findByEmail(request.getEmail());
				//.orElseThrow(() -> new UserNotFoundException("User not found"));


		if (!UserUtil.isValidPassword(user.getPassword(), request.getPassword())) {
			log.error("User's password not valid " + request.getEmail());
			throw new PasswordNotValidException("User's password not valid");
		}

		return new AuthResponse(jwtUtil.generateToken(user));
	}
	
	
	

}

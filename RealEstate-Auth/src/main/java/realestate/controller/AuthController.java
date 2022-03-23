package realestate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;
import realestate.dto.AuthRequest;
import realestate.dto.AuthResponse;
import realestate.service.AuthService;

@RestController
public final class AuthController {
	
	
	private AuthService authService;
	
	@Autowired
	public AuthController(AuthService authService) {
		this.authService = authService;
	}

	@PostMapping(value = "/auth")
	public ResponseEntity<AuthResponse> getToken(@RequestBody AuthRequest request) {
		
		return new ResponseEntity<>(authService.getToken(request),HttpStatus.OK);
	}
	
	

}

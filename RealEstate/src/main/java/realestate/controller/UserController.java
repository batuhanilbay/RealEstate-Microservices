package realestate.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import realestate.dto.UserDto;
import realestate.service.abstracts.UserService;


@RestController
public class UserController {

	@Autowired
	private UserService userService;

	
	//Get All Users
	@GetMapping(value = "/users")
	public ResponseEntity<List<UserDto>> getAllUsers(){
		return ResponseEntity.ok().body(userService.getAllUsers());
	}

	//Get User By UserId
	@GetMapping(value = "/users/{userId}")
	public ResponseEntity<UserDto> getUserById(@PathVariable Long userId){
		UserDto userDto = userService.getUserById(userId);
		return ResponseEntity.ok().body(userService.getUserById(userDto.getId()));
	}

	//Create User
	@PostMapping(value = "/users")
	public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto){
		UserDto user = userService.saveUser(userDto);
		return new ResponseEntity<>(user,HttpStatus.OK);
	}

	//Delete User by userId
	@DeleteMapping(value = "/users/{userId}")
	public ResponseEntity<?> deleteUserById(@PathVariable Long userId) {
		userService.deleteUser(userId);
		return new ResponseEntity<>("The User " + userId + " has been deleted...",HttpStatus.OK);
	}


}

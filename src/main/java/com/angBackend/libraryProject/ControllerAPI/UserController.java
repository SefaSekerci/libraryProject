package com.angBackend.libraryProject.ControllerAPI;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.angBackend.libraryProject.ControllerAPI.Base.ControllerEntities;
import com.angBackend.libraryProject.Entities.UserInf.Users;
import com.angBackend.libraryProject.Service.Services.UserService;

import lombok.Getter;
import lombok.Setter;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user")
public class UserController implements ControllerEntities<Users> {

	@Getter
	@Setter
	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@Override
	@PostMapping("/add")
	public ResponseEntity<Users> add(@RequestBody Users t) {
		userService.save(t);
		return new ResponseEntity<Users>(t, HttpStatus.OK);
	}

	@Override
	@GetMapping("/users")
	public ResponseEntity<List<Users>> getList() {
		List<Users> users = userService.getList();
		return new ResponseEntity<List<Users>>(users, HttpStatus.OK);
	}

	@Override
	@GetMapping("/{id}")
	public ResponseEntity<Users> getById(@PathVariable("id") Long id) {
		return new ResponseEntity<Users>(userService.getRecordbyId(id), HttpStatus.OK);
	}

	@Override
	@PutMapping("/update/{id}")
	public ResponseEntity<Users> updatebyId(@RequestBody Users user, @PathVariable("id") Long id) {
		user.setUserid(id);
		Users userv = userService.update(user);
		return new ResponseEntity<Users>(userv, HttpStatus.OK);
	}

	@Override
	@PostMapping("/delete/{id}")
	public ResponseEntity<String> deleteById(@PathVariable("id") Long id) {
		Users user = userService.getRecordbyId(id);
		userService.delete(user);
		return new ResponseEntity<String>("Basarili", HttpStatus.OK);
	}

}

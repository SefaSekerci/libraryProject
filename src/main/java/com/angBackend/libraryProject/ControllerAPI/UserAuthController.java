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
import com.angBackend.libraryProject.Entities.UserInf.UserAuth;
import com.angBackend.libraryProject.Service.Services.UserAuthService;

import lombok.Getter;
import lombok.Setter;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/userauth")
public class UserAuthController implements ControllerEntities<UserAuth> {

	@Getter
	@Setter
	private UserAuthService userauthService;

	@Autowired
	public UserAuthController(UserAuthService userauthService) {
		this.userauthService = userauthService;
	}

	@Override
	@PostMapping("/add")
	public ResponseEntity<UserAuth> add(@RequestBody UserAuth t) {
		userauthService.save(t);
		return new ResponseEntity<UserAuth>(t, HttpStatus.OK);
	}

	@Override
	@GetMapping("/userauths")
	public ResponseEntity<List<UserAuth>> getList() {
		List<UserAuth> userAuths = userauthService.getList();
		return new ResponseEntity<List<UserAuth>>(userAuths, HttpStatus.OK);
	}

	@Override
	@GetMapping("/{id}")
	public ResponseEntity<UserAuth> getById(@PathVariable("id") Long id) {
		return new ResponseEntity<UserAuth>(userauthService.getRecordbyId(id), HttpStatus.OK);
	}

	@Override
	@PostMapping("/delete/{id}")
	public ResponseEntity<String> deleteById(@PathVariable("id") Long id) {
		userauthService.delete(userauthService.getRecordbyId(id));
		return new ResponseEntity<String>("Basarili", HttpStatus.OK);
	}

	@Override
	@PutMapping("/update/{id}")
	public ResponseEntity<UserAuth> updatebyId(@RequestBody UserAuth t, @PathVariable("id") Long id) {
		return new ResponseEntity<UserAuth>(userauthService.update(t), HttpStatus.OK);
	}

}

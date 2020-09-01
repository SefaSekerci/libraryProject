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
import com.angBackend.libraryProject.Entities.UserInf.RoleUser;
import com.angBackend.libraryProject.Service.Services.RoleUserService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/roleuser")
public class RoleUserController implements ControllerEntities<RoleUser> {

	private final RoleUserService roleuserService;

	@Autowired
	public RoleUserController(RoleUserService roleuserService) {
		this.roleuserService = roleuserService;
	}

	@Override
	@PostMapping("/add")
	public ResponseEntity<RoleUser> add(@RequestBody RoleUser t) {
		roleuserService.save(t);
		return new ResponseEntity<RoleUser>(t, HttpStatus.OK);
	}

	@Override
	@GetMapping("/roleusers")
	public ResponseEntity<List<RoleUser>> getList() {
		List<RoleUser> roleUserlist = roleuserService.getList();
		return new ResponseEntity<List<RoleUser>>(roleUserlist, HttpStatus.OK);
	}

	@Override
	@GetMapping("/{id}")
	public ResponseEntity<RoleUser> getById(@PathVariable("id") Long id) {
		return new ResponseEntity<RoleUser>(roleuserService.getRecordbyId(id), HttpStatus.OK);
	}

	@Override
	@PostMapping("/delete/{id}")
	public ResponseEntity<String> deleteById(@PathVariable("id") Long id) {
		roleuserService.delete(roleuserService.getRecordbyId(id));
		return new ResponseEntity<String>("Basarili", HttpStatus.OK);
	}

	@Override
	@PutMapping("/update/{id}")
	public ResponseEntity<RoleUser> updatebyId(@RequestBody RoleUser t, @PathVariable("id") Long id) {
		return new ResponseEntity<RoleUser>(roleuserService.update(t), HttpStatus.OK);
	}

}

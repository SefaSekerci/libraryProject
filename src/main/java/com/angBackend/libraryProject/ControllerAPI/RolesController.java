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
import com.angBackend.libraryProject.Entities.UserInf.Roles;
import com.angBackend.libraryProject.Service.Services.RolesService;

import lombok.Getter;
import lombok.Setter;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/role")
public class RolesController implements ControllerEntities<Roles> {

	@Getter
	@Setter
	private RolesService rolesService;

	@Autowired
	public RolesController(RolesService rolesService) {
		this.rolesService = rolesService;
	}

	@Override
	@PostMapping("/add")
	public ResponseEntity<Roles> add(@RequestBody Roles t) {
		rolesService.save(t);
		return new ResponseEntity<Roles>(t, HttpStatus.OK);
	}

	@Override
	@GetMapping("/roles")
	public ResponseEntity<List<Roles>> getList() {
		List<Roles> roleList = rolesService.getList();
		return new ResponseEntity<List<Roles>>(roleList, HttpStatus.OK);
	}

	@Override
	@GetMapping("/{id}")
	public ResponseEntity<Roles> getById(@PathVariable("id") Long id) {
		return new ResponseEntity<Roles>(rolesService.getRecordbyId(id), HttpStatus.OK);
	}

	@Override
	@PostMapping("/delete/{id}")
	public ResponseEntity<String> deleteById(@PathVariable("id") Long id) {
		rolesService.delete(rolesService.getRecordbyId(id));
		return new ResponseEntity<String>("Basarili", HttpStatus.OK);
	}

	@Override
	@PutMapping("/update/{id}")
	public ResponseEntity<Roles> updatebyId(@RequestBody Roles t, @PathVariable("id") Long id) {
		return new ResponseEntity<Roles>(rolesService.update(t), HttpStatus.OK);
	}

}

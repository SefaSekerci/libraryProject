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
import com.angBackend.libraryProject.Entities.MemberInf.MemberAuth;
import com.angBackend.libraryProject.Service.Services.MemberAuthService;

import lombok.Getter;
import lombok.Setter;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/memberAuth")
public class MemberAuthController implements ControllerEntities<MemberAuth> {

	@Getter
	@Setter
	private MemberAuthService memberAuthService;

	@Autowired
	public MemberAuthController(MemberAuthService memberAuthService) {
		this.memberAuthService = memberAuthService;
	}

	@Override
	@PostMapping("/add")
	public ResponseEntity<MemberAuth> add(@RequestBody MemberAuth t) {
		memberAuthService.save(t);
		return new ResponseEntity<MemberAuth>(t, HttpStatus.OK);
	}

	@Override
	@GetMapping("/memberauths")
	public ResponseEntity<List<MemberAuth>> getList() {
		List<MemberAuth> lentBooks = memberAuthService.getList();
		return new ResponseEntity<List<MemberAuth>>(lentBooks, HttpStatus.OK);
	}

	@Override
	@GetMapping("/{id}")
	public ResponseEntity<MemberAuth> getById(@PathVariable("id") Long id) {
		return new ResponseEntity<MemberAuth>(memberAuthService.getRecordbyId(id), HttpStatus.OK);
	}

	@Override
	@PostMapping("/delete/{id}")
	public ResponseEntity<String> deleteById(@PathVariable("id") Long id) {
		memberAuthService.delete(memberAuthService.getRecordbyId(id));
		return new ResponseEntity<String>("Basarili", HttpStatus.OK);
	}

	@Override
	@PutMapping("/update/{id}")
	public ResponseEntity<MemberAuth> updatebyId(@RequestBody MemberAuth t, @PathVariable("id") Long id) {
		return new ResponseEntity<MemberAuth>(memberAuthService.update(t), HttpStatus.OK);
	}

}

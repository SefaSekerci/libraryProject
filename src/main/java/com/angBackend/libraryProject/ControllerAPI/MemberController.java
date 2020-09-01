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
import com.angBackend.libraryProject.Entities.MemberInf.Members;
import com.angBackend.libraryProject.Service.Services.MemberService;

import lombok.Getter;
import lombok.Setter;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/member")
public class MemberController implements ControllerEntities<Members> {

	@Getter
	@Setter
	private MemberService memberService;

	@Autowired
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}

	@Override
	@PostMapping("/add")
	public ResponseEntity<Members> add(@RequestBody Members t) {
		memberService.save(t);
		return new ResponseEntity<Members>(t, HttpStatus.OK);
	}

	@Override
	@GetMapping("/members")
	public ResponseEntity<List<Members>> getList() {
		List<Members> membersList = memberService.getList();
		return new ResponseEntity<List<Members>>(membersList, HttpStatus.OK);
	}

	@Override
	@GetMapping("/{id}")
	public ResponseEntity<Members> getById(@PathVariable("id") Long id) {
		return new ResponseEntity<Members>(memberService.getRecordbyId(id), HttpStatus.OK);
	}

	@Override
	@PostMapping("/delete/{id}")
	public ResponseEntity<String> deleteById(@PathVariable("id") Long id) {
		memberService.delete(memberService.getRecordbyId(id));
		return new ResponseEntity<String>("Basarili", HttpStatus.OK);
	}

	@Override
	@PutMapping("/update/{id}")
	public ResponseEntity<Members> updatebyId(@RequestBody Members t, @PathVariable("id") Long id) {
		return new ResponseEntity<Members>(memberService.update(t), HttpStatus.OK);
	}

}

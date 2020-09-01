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
import com.angBackend.libraryProject.Entities.BooksInf.LentBooks;
import com.angBackend.libraryProject.Service.Services.LentBookService;

import lombok.Getter;
import lombok.Setter;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/lentbook")
public class LentController implements ControllerEntities<LentBooks> {

	@Getter
	@Setter
	private LentBookService lentbookService;

	@Autowired
	public LentController(LentBookService lentbookService) {
		this.lentbookService = lentbookService;
	}

	@Override
	@PostMapping("/add")
	public ResponseEntity<LentBooks> add(@RequestBody LentBooks t) {
		lentbookService.save(t);
		return new ResponseEntity<LentBooks>(t, HttpStatus.OK);
	}

	@Override
	@GetMapping("/lentbooks")
	public ResponseEntity<List<LentBooks>> getList() {
		List<LentBooks> lentBooks = lentbookService.getList();
		return new ResponseEntity<List<LentBooks>>(lentBooks, HttpStatus.OK);
	}

	@Override
	@GetMapping("/{id}")
	public ResponseEntity<LentBooks> getById(@PathVariable("id") Long id) {
		return new ResponseEntity<LentBooks>(lentbookService.getRecordbyId(id), HttpStatus.OK);
	}

	@Override
	@PostMapping("/delete/{id}")
	public ResponseEntity<String> deleteById(@PathVariable("id") Long id) {
		lentbookService.delete(lentbookService.getRecordbyId(id));
		return new ResponseEntity<String>("Basarili", HttpStatus.OK);
	}

	@Override
	@PutMapping("/update/{id}")
	public ResponseEntity<LentBooks> updatebyId(@RequestBody LentBooks t, @PathVariable("id") Long id) {
		return new ResponseEntity<LentBooks>(lentbookService.update(t), HttpStatus.OK);
	}

}

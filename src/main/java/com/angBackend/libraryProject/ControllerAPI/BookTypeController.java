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
import com.angBackend.libraryProject.Entities.BooksInf.BookType;
import com.angBackend.libraryProject.Service.Services.BookTypeService;

import lombok.Getter;
import lombok.Setter;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/booktype")
public class BookTypeController implements ControllerEntities<BookType> {

	@Getter
	@Setter
	private BookTypeService booktypeService;

	@Autowired
	public BookTypeController(BookTypeService booktypeService) {
		this.booktypeService = booktypeService;
	}

	@Override
	@PostMapping("/add")
	public ResponseEntity<BookType> add(@RequestBody BookType t) {
		booktypeService.save(t);
		return new ResponseEntity<BookType>(t, HttpStatus.OK);
	}

	@Override
	@GetMapping("/booktypes")
	public ResponseEntity<List<BookType>> getList() {
		List<BookType> bookTypes = booktypeService.getList();
		return new ResponseEntity<List<BookType>>(bookTypes, HttpStatus.OK);
	}

	@Override
	@GetMapping("/{id}")
	public ResponseEntity<BookType> getById(@PathVariable("id") Long id) {
		return new ResponseEntity<BookType>(booktypeService.getRecordbyId(id), HttpStatus.OK);
	}

	@Override
	@PostMapping("/delete/{id}")
	public ResponseEntity<String> deleteById(@PathVariable("id") Long id) {
		booktypeService.delete(booktypeService.getRecordbyId(id));
		return new ResponseEntity<String>("Basarili", HttpStatus.OK);
	}

	@Override
	@PutMapping("/update/{id}")
	public ResponseEntity<BookType> updatebyId(@RequestBody BookType t, @PathVariable("id") Long id) {
		return new ResponseEntity<BookType>(booktypeService.update(t), HttpStatus.OK);
	}

}

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
import com.angBackend.libraryProject.Entities.BooksInf.Books;
import com.angBackend.libraryProject.Service.Services.BookService;

import lombok.Getter;
import lombok.Setter;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/book")
public class BookController implements ControllerEntities<Books> {

	@Getter
	@Setter
	private BookService bookService;

	@Autowired
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}

	@Override
	@PostMapping("/add")
	public ResponseEntity<Books> add(@RequestBody Books t) {
		bookService.save(t);
		return new ResponseEntity<Books>(t, HttpStatus.OK);
	}

	@Override
	@GetMapping("/books")
	public ResponseEntity<List<Books>> getList() {
		List<Books> books = bookService.getList();
		return new ResponseEntity<List<Books>>(books, HttpStatus.OK);
	}

	@Override
	@GetMapping("/{id}")
	public ResponseEntity<Books> getById(@PathVariable("id") Long id) {
		return new ResponseEntity<Books>(bookService.getRecordbyId(id), HttpStatus.OK);
	}

	@Override
	@PostMapping("/delete/{id}")
	public ResponseEntity<String> deleteById(@PathVariable("id") Long id) {
		bookService.delete(bookService.getRecordbyId(id));
		return new ResponseEntity<String>("Basarili", HttpStatus.OK);
	}

	@Override
	@PutMapping("/update/{id}")
	public ResponseEntity<Books> updatebyId(@RequestBody Books book, @PathVariable("id") Long id) {
		return new ResponseEntity<Books>(bookService.update(book), HttpStatus.OK);
	}

}

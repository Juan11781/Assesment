package assesment.walmart.controller;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import assesment.walmart.dto.BookDTO;
import assesment.walmart.entity.Book;
import assesment.walmart.service.BookService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@RestController()
@RequestMapping("/library")
public class BookController {
	@Autowired
	private BookService bookService;
	
	@GetMapping("/getAll")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(bookService.getAll());
	}
	
	@GetMapping("/getByIsbn")
	public ResponseEntity<?> getAll(@RequestParam @NotBlank(message="ISBN can not be null") String isbn){
		Optional<Book> book = bookService.findByIsbn(isbn);	
		if(book.isPresent()) {
			return ResponseEntity.ok(book.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/getByAuthor")
	public ResponseEntity<?>getByAuthorName(@Valid @RequestParam("author") @NotBlank(message="Author  cannot be null") String author){
		return ResponseEntity.ok(bookService.getByAuthorName(author));
		
	}

	@GetMapping("/getByDate")
	public ResponseEntity<?>getAfterPublishedDate(@RequestParam @NotNull(message="Published Date cannot be null")  @DateTimeFormat(pattern="dd/MM/yyyy")Date publishedDate){
		
		return ResponseEntity.ok(bookService.getByAfterPublishedDate(publishedDate));
	}
	
	@PostMapping("/create")
	public ResponseEntity<?>createBook(@Valid @RequestBody BookDTO bookDTO){//BindingResult validationErrors){
		
		try {	
			return ResponseEntity.status(HttpStatus.CREATED).body(bookService.save(bookDTO));
		}catch(Exception ex ) {
			return ResponseEntity.badRequest().
					  body(Collections.singletonMap("error", ex.getMessage()));
		}
		
	}
	
	
	
	
}

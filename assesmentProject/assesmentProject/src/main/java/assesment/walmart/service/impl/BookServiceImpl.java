package assesment.walmart.service.impl;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import assesment.walmart.dto.BookDTO;
import assesment.walmart.entity.Book;
import assesment.walmart.repository.BookRepository;
import assesment.walmart.service.BookService;

@Service
public class BookServiceImpl implements BookService{
	
	@Autowired
	private BookRepository bookRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Book> getAll() {
		return (List<Book>)bookRepository.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Optional<Book>findByIsbn(String isbn){
		return bookRepository.findByIsbn(isbn);
	}

	@Override
	@Transactional
	public Book save(BookDTO bookDTO) throws Exception {
		
		Date currenDate = new Date();    
		if(bookDTO.getPublishedDate().after(currenDate)) {
			throw new Exception("PublishedDate cannot greater than curren date");
		}
		
		if(existByIsbn(bookDTO.getIsbn())) {
			throw new Exception("Isbn it must be unique already exist in database");
		}
		
		ModelMapper modelMapper = new ModelMapper();
		Book book = modelMapper.map(bookDTO, Book.class);
		return bookRepository.save(book);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Book> getByAuthorName(String autor) {
		return bookRepository.getByAuthorName(autor);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Book> getByAfterPublishedDate(Date publishedDate) {
		return bookRepository.getAfterDate(publishedDate);
	}

	@Override
	@Transactional(readOnly = true)
	public Boolean existByIsbn(String isbn) {
	
		return bookRepository.existsByIsbn(isbn);
	}
}

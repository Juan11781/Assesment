package assesment.walmart.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import assesment.walmart.dto.BookDTO;
import assesment.walmart.entity.Book;

public interface BookService {
	
	public List<Book>getAll();
	public Optional<Book>findByIsbn(String isbn);
	public Boolean existByIsbn(String isbn);
	public Book save(BookDTO book) throws Exception ;
	public List<Book>getByAuthorName(String autor);
	public List<Book>getByAfterPublishedDate(Date publishedDate);
}

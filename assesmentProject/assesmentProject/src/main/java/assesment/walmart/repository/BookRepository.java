package assesment.walmart.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import assesment.walmart.dto.BookDTO;
import assesment.walmart.entity.Book;

public interface BookRepository extends CrudRepository<Book,Long> {
	
	public Optional<Book> findByIsbn(String isbn);
	
	@Query("select b from Book b where b.autorName = ?1")
	public List<Book>getByAuthorName(String author);
	
	@Query("select b from Book b where b.publishedDate > ?1")
	public List<Book>getAfterDate(Date publishedDate);
	
	
	public boolean existsByIsbn(String isbn);
	

}

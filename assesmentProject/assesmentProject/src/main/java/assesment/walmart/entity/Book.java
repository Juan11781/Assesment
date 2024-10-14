package assesment.walmart.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;


@Entity
@Table(name="book")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message="Title is required")
	private String title;
	@NotBlank(message="ISBN is required")
	@Column(name="isbn",unique=true)
	private String isbn;
	@NotBlank(message="autor's name is required")
	private String autorName;
	//@NotEmpty(message="published date is required")
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern="dd/MM/yyyy", timezone="America/Mexico_City")
	private Date publishedDate;
	
	
	

	/**
	 * @param id
	 * @param title
	 * @param isbn
	 * @param autorName
	 */

	
	/**
	 * 
	 */
	public Book() {
		super();
	}


	



	/**
	 * @param id
	 * @param title
	 * @param isbn
	 * @param autorName
	 * @param publishedDate
	 */
	





	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getAutorName() {
		return autorName;
	}
	public void setAutorName(String autorName) {
		this.autorName = autorName;
	}

	public Date getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}

}

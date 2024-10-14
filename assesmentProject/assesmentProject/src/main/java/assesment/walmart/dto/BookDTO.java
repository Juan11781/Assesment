package assesment.walmart.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class BookDTO {
	
	
	@NotEmpty(message="The title is required")
	private String title;
	@NotEmpty(message="The isb is required")
	private String isbn;
	@NotEmpty(message="Author name is required")
	private String autorName;
	@NotNull(message="publishedDate is required")
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern="dd/MM/yyyy", timezone="America/Mexico_City")
	private Date publishedDate;

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

package com.angBackend.libraryProject.Entities.BooksInf;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.angBackend.libraryProject.Entities.BaseEntitiy;


@Entity
@Table(name = "books")
public class Books extends BaseEntitiy {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "bookid")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_seq")
	@SequenceGenerator(sequenceName = "SEQ_BOOK", allocationSize = 1, name = "book_seq", initialValue = 2000)
	private Long bookid;

	@Column(name = "name")
	private String name;

	@Column(name = "publicationdate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date publicationDate;

	@Column(name = "author")
	private String author;

	@Column(name = "company")
	private String company;

	public Long getBookid() {
		return bookid;
	}

	public void setBookid(Long bookid) {
		this.bookid = bookid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

}

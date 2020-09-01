package com.angBackend.libraryProject.Entities.BooksInf;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.angBackend.libraryProject.Entities.BaseEntitiy;

@Entity
@Table(name = "booktype")
public class BookType extends BaseEntitiy {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "booktypeid")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "booktype_seq")
	@SequenceGenerator(sequenceName = "SEQ_BOOKTYPE", allocationSize = 1, name = "booktype_seq", initialValue = 20000)
	private Long booktypeid;

	@Column(name = "bookid")
	private Long bookid;

	@Column(name = "type")
	private String type;

	public Long getBooktypeid() {
		return booktypeid;
	}

	public void setBooktypeid(Long booktypeid) {
		this.booktypeid = booktypeid;
	}

	public Long getBookid() {
		return bookid;
	}

	public void setBookid(Long bookid) {
		this.bookid = bookid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}

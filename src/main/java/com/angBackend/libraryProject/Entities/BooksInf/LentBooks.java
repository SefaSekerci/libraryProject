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
@Table(name = "lentbooks")
public class LentBooks extends BaseEntitiy {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "lentid")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lent_seq")
	@SequenceGenerator(sequenceName = "SEQ_LENT", allocationSize = 1, name = "lent_seq", initialValue = 200000)
	private Long lentid;

	@Column(name = "memberid")
	private Long memberid;

	@Column(name = "bookid")
	private Long bookid;

	@Column(name = "lentdate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lentDate;

	@Column(name = "expiredate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date expireDate;

	public Long getLentid() {
		return lentid;
	}

	public void setLentid(Long lentid) {
		this.lentid = lentid;
	}

	public Long getMemberid() {
		return memberid;
	}

	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}

	public Long getBookid() {
		return bookid;
	}

	public void setBookid(Long bookid) {
		this.bookid = bookid;
	}

	public Date getLentDate() {
		return lentDate;
	}

	public void setLentDate(Date lentDate) {
		this.lentDate = lentDate;
	}

	public Date getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

}

package com.angBackend.libraryProject.Entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.UpdateTimestamp;

@MappedSuperclass
public abstract class BaseEntitiy implements Serializable, IEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "datecreated")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;

	@Column(name = "dateupdated")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateUpdated;

	@Column(name = "createuserid")
	private Long createUserid;

	@Column(name = "updateuserid")
	private Long updateUserid;

	@Column(name = "status")
	private Boolean status;

	public BaseEntitiy() {
	}

	public BaseEntitiy(Date dateCreated, Date dateUpdated, Long createUserid, Long updateUserid, Boolean status) {
		super();
		this.dateCreated = dateCreated;
		this.dateUpdated = dateUpdated;
		this.createUserid = createUserid;
		this.updateUserid = updateUserid;
		this.status = status;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateUpdated() {
		return dateUpdated;
	}

	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	public Long getCreateUserid() {
		return createUserid;
	}

	public void setCreateUserid(Long createUserid) {
		this.createUserid = createUserid;
	}

	public Long getUpdateUserid() {
		return updateUserid;
	}

	public void setUpdateUserid(Long updateUserid) {
		this.updateUserid = updateUserid;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

}

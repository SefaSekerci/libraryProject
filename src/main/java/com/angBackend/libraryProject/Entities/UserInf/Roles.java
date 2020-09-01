package com.angBackend.libraryProject.Entities.UserInf;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.angBackend.libraryProject.Entities.BaseEntitiy;

@Entity
@Table(name = "roles")
public class Roles extends BaseEntitiy {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "roleid")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_seq")
	@SequenceGenerator(sequenceName = "SEQ_ROLE", allocationSize = 1, name = "role_seq", initialValue = 1000)
	private Long roleid;

	@Column(name = "code")
	private String code;

	@Column(name = "description")
	private String description;

	public Long getRoleid() {
		return roleid;
	}

	public void setRoleid(Long roleid) {
		this.roleid = roleid;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}

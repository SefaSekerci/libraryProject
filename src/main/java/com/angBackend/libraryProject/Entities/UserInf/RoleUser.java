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
@Table(name = "roleuser")
public class RoleUser extends BaseEntitiy {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "roleuserid")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "roleuser_seq")
	@SequenceGenerator(sequenceName = "SEQ_ROLEUSER", allocationSize = 1, name = "roleuser_seq", initialValue = 10000)
	private Long roleuserId;

	@Column(name = "userid")
	private Long userid;

	@Column(name = "roleid")
	private Long roleid;

	public Long getRoleuserId() {
		return roleuserId;
	}

	public void setRoleuserId(Long roleuserId) {
		this.roleuserId = roleuserId;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public Long getRoleid() {
		return roleid;
	}

	public void setRoleid(Long roleid) {
		this.roleid = roleid;
	}

}

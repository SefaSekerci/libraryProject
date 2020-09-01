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
@Table(name = "userauth")
public class UserAuth extends BaseEntitiy {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "userauthid")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "auth_seq")
	@SequenceGenerator(sequenceName = "SEQ_AUTH", allocationSize = 1, name = "auth_seq", initialValue = 100)
	private Long userauthId;

	@Column(name = "userid")
	private Long userid;

	@Column(name = "username", unique = true)
	private String username;

	@Column(name = "password")
	private String password;

	public Long getUserauthId() {
		return userauthId;
	}

	public void setUserauthId(Long userauthId) {
		this.userauthId = userauthId;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}

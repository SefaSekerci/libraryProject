package com.angBackend.libraryProject.Entities.MemberInf;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.angBackend.libraryProject.Entities.BaseEntitiy;

@Entity
@Table(name = "memberauth")
public class MemberAuth extends BaseEntitiy {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "memberauthId")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "memberauth_seq")
	@SequenceGenerator(sequenceName = "SEQ_MEMBERAUTH", allocationSize = 1, name = "memberauth_seq", initialValue = 200)
	private Long memberauthId;

	@Column(name = "memberId")
	private Long memberId;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	public Long getMemberauthId() {
		return memberauthId;
	}

	public void setMemberauthId(Long memberauthId) {
		this.memberauthId = memberauthId;
	}

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
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

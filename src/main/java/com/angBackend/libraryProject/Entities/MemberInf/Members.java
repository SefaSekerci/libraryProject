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
@Table(name = "members")
public class Members extends BaseEntitiy {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "memberid")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_seq")
	@SequenceGenerator(sequenceName = "SEQ_MEMBER", allocationSize = 1, name = "member_seq", initialValue = 100000)
	private Long memberid;

	@Column(name = "name")
	private String name;

	@Column(name = "surname")
	private String surname;

	@Column(name = "gender", length = 1)
	private String gender;

	@Column(name = "adress")
	private String adress;

	@Column(name = "phone")
	private String phone;
	
	@Column(name = "email")
	private String email;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getMemberid() {
		return memberid;
	}

	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}

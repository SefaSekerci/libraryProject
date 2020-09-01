package com.angBackend.libraryProject.Entities.UserInf;

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
@Table(name = "users")
public class Users extends BaseEntitiy {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "userid")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
	@SequenceGenerator(sequenceName = "SEQ_USER", allocationSize = 1, name = "user_seq", initialValue = 10)
	private Long userid;

	@Column(name = "name", length = 25)
	private String name;

	@Column(name = "surname", length = 40)
	private String surname;

	@Column(name = "birthdate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date birthDate;

	@Column(name = "memberdate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date memberDate;

	@Column(name = "identificationno")
	private String identificationno;

	@Column(name = "nationality")
	private String nationality;

	@Column(name = "gender", length = 1)
	private String gender;

	@Column(name = "phone")
	private String phone;

	@Column(name = "adress")
	private String adress;

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
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

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Date getMemberDate() {
		return memberDate;
	}

	public void setMemberDate(Date memberDate) {
		this.memberDate = memberDate;
	}

	public String getIdentificationno() {
		return identificationno;
	}

	public void setIdentificationno(String identificationno) {
		this.identificationno = identificationno;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public Users() {
	}

	public Users(Long userid, String name, String surname, Date birthDate, Date memberDate, String identificationno,
			String nationality, String gender, String phone, String adress) {
		super();
		this.userid = userid;
		this.name = name;
		this.surname = surname;
		this.birthDate = birthDate;
		this.memberDate = memberDate;
		this.identificationno = identificationno;
		this.nationality = nationality;
		this.gender = gender;
		this.phone = phone;
		this.adress = adress;
	}

}

package com.app.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

@Entity
@Table(name = "employees")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotBlank(message="First Name must not be blank")
	@Size(min=3, message="First Name must be at least 3 characters long")
	@Column(nullable = false)
	private String firstName;
	
	@NotBlank(message="Last Name must not be blank")
	@Size(min=3, message="Last Name must be at least 3 characters long")
	@Column(nullable = false)
	private String lastName;
	
//	@NotBlank(message="Age must not be blank")
	@Positive(message="Enter your correct Age")
	@Column(nullable = false)
	private int age;
	
	@NotBlank(message="Gender must not be blank")
	@Column(nullable = false)
	private String gender;
	
//	@NotBlank(message="Joining Date must not be blank")
//	@Size(min=3, message="Joining Date must be at least 3 characters long")
	@Column(nullable = false)
//	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
//	private LocalDate joiningDate;
	private Date joiningDate;
	
	@Column(nullable = true)
//	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
//	private LocalDate retiringDate;
	private Date retiringDate;

	@NotBlank(message="EMail must not be blank")
	@Email(message = "Please provide a valid EMail address" )
	@Column(nullable = false,unique = true)
	private String email;

	@NotBlank(message="Department must not be blank")
	@Size(min=3, message="Department must be at least 3 characters long")
	@Column(nullable = false)
	private String dept;
	
	public Employee() {
		super();
	}

	public Employee(Long id, String firstName, String lastName, int age, String gender, Date joiningDate,
			Date retiringDate, String email, String dept) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.joiningDate = joiningDate;
		this.retiringDate = retiringDate;
		this.email = email;
		this.dept = dept;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	public Date getRetiringDate() {
		return retiringDate;
	}

	public void setRetiringDate(Date retiringDate) {
		this.retiringDate = retiringDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age
				+ ", gender=" + gender + ", joiningDate=" + joiningDate + ", retiringDate=" + retiringDate + ", email="
				+ email + ", dept=" + dept + "]";
	}

}

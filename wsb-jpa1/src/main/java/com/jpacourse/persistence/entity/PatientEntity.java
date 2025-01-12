package com.jpacourse.persistence.entity;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "PATIENT")
public class PatientEntity {

	@Version
	@Column(nullable = false)
	private Integer version;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String firstName;

	@Column(nullable = false)
	private String lastName;

	@Column(nullable = false)
	private String telephoneNumber;

	@Column(nullable = true)
	private String email;

	@Column(nullable = false)
	private String patientNumber;

	@Column(nullable = false)
	private LocalDate dateOfBirth;

	// Jadnostronna od strony rodzica
	@OneToOne
	@JoinColumn(name = "address_id")
	private AddressEntity address;

	// Dwustronna
	@OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
	private List<VisitEntity> visits;

	@Column(nullable = false)
	private boolean isMale;

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

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPatientNumber() {
		return patientNumber;
	}

	public void setPatientNumber(String patientNumber) {
		this.patientNumber = patientNumber;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public AddressEntity getAddress() {return address;}

	public void setAddress(AddressEntity address) { this.address = address;}

	public List<VisitEntity> getVisits(){return visits;}

	public void setVisits(List<VisitEntity> visits) {this.visits = visits;}

	public boolean getIsMale(){return isMale;}

	public void setIsMale(boolean isMale) {this.isMale = isMale;}

	public Integer getVersion() {return version;}

	public void setVersion(Integer version) {this.version = version;}
}

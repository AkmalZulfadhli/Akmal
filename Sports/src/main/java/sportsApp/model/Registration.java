package sportsApp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Registration")
public class Registration {

	
	@Id
	private int id;
	@NotNull
	
	@Column(columnDefinition="char(60)", unique=true )
	private String name;
	@NotNull
	
	@Column(columnDefinition="char(9)", unique=true )
	private String icNumber;
	@NotNull
	
	@Column(columnDefinition="char(30)", unique=true )
	private String sports;
	@NotNull
	
	@Column(columnDefinition="char(50)")
	private String email;
	@NotNull
	
	
	public Registration() {}

	public Registration(int id, @NotNull String name, @NotNull String icNumber, @NotNull String sports, @NotNull String email ) {
		this.id = id;
		this.name = name;
		this.icNumber = icNumber;
		this.sports = sports;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIcNumber() {
		return icNumber;
	}

	public void setIcNumber(String icNumber) {
		this.icNumber = icNumber;
	}

	public String getSports() {
		return sports;
	}

	public void setSports(String sports) {
		this.sports = sports;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


}


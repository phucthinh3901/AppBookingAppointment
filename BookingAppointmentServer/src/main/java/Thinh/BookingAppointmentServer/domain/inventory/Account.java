package Thinh.BookingAppointmentServer.domain.inventory;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import Thinh.BookingAppointmentServer.framework.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "account")
@Setter@Getter
public class Account extends BaseEntity{

	@Column(name = "password")
	private String password;
	
	@Column(name = "is_Active")
	private Boolean isActive;
		
	@JsonIgnore
	@OneToMany(mappedBy = "account")
	private List<Patient> patients;
	
	@JsonIgnore
	@OneToMany(mappedBy = "id.account")
	private List<Assign> assigns;
	
}

package Thinh.BookingAppointmentServer.domain.inventory;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@SuppressWarnings("serial")
@Embeddable
@Data
public class AssignId implements Serializable{

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "role_id",nullable = false)
	private Role role;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "Interface_id", nullable = false)
	private Interface interf;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "account_id", nullable = false)
	private Account account;
	
}

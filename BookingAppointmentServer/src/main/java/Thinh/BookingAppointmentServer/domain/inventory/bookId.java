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
public class bookId implements Serializable{

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "Schedule_id", nullable = false)
	private Schedule schedule;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "patient_id", nullable = false)
	private Patient patient;
}

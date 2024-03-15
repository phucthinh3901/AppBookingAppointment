package Thinh.BookingAppointmentServer.domain.inventory;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "assign")
public class Assign {

	@EmbeddedId
	private AssignId id;
}

package Thinh.BookingAppointmentServer.domain.inventory;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "book")
@Getter @Setter
public class Book {
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "is_Active")
	private Boolean isActive;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "disease_id")
	private Disease disease;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "package_id")
	private Package pack;
	
	@EmbeddedId
	private bookId id;
	
	
}

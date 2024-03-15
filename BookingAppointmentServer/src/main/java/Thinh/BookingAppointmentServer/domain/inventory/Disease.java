package Thinh.BookingAppointmentServer.domain.inventory;

import java.util.List;

import Thinh.BookingAppointmentServer.framework.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "disease")
@Getter @Setter
public class Disease extends BaseEntity{

	@Column(name = "disease_name")
	private String diseaseName;
	
	@Column(name = "is_Active")
	private Boolean isActive;
	
	@OneToMany(mappedBy = "disease")
	private List<Book> books; 
}

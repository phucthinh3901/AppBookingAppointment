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
@Table(name = "Interface")
@Setter @Getter
public class Interface extends BaseEntity{

	@Column(name = "interface_name")
	private String name;
	
	@JsonIgnore
	@OneToMany(mappedBy = "id.interf")
	private List<Assign> assigns;
	
}

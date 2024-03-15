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
@Table(name = "role")
@Getter @Setter
public class Role extends BaseEntity{
	
	@Column(name ="role_name")
	private String roleName;
	
	@JsonIgnore
	@OneToMany(mappedBy = "id.role")
	private List<Assign> assigns;
	
	
}

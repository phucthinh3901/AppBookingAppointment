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
@Table(name = "department")
@Getter @Setter
public class Department extends BaseEntity{
	
	@Column(name = "department_name")
	private String departmentName;
	
	@Column(name = "is_active")
	private Boolean isActive;
	
	@OneToMany(mappedBy = "department")
	private List<Doctor> doctor;
}

package Thinh.BookingAppointmentServer.domain.dto;

import lombok.Data;

@Data
public class DepartmentDto {
	private String departmentName;
	
	private Integer id;
	
	private Boolean isActive;
}

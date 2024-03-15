package Thinh.BookingAppointmentServer.Service;

import java.util.List;

import Thinh.BookingAppointmentServer.domain.dto.DepartmentDto;
import Thinh.BookingAppointmentServer.domain.payload.request.DepartmentRequest;
import Thinh.BookingAppointmentServer.domain.payload.response.ApiResponse;

public interface DepartmentService {

	List<DepartmentDto> createOrUpdate(DepartmentRequest departmentRequest);

	List<DepartmentDto> getDepartment();

	DepartmentDto getDepartmentById(Integer id);

	DepartmentDto getDepartmentByName(String name);

	ApiResponse checkDuplicateName(String name);
}

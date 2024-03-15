package Thinh.BookingAppointmentServer.Service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Thinh.BookingAppointmentServer.Service.DepartmentService;
import Thinh.BookingAppointmentServer.domain.dto.DepartmentDto;
import Thinh.BookingAppointmentServer.domain.inventory.Department;
import Thinh.BookingAppointmentServer.domain.payload.request.DepartmentRequest;
import Thinh.BookingAppointmentServer.domain.payload.response.ApiResponse;
import Thinh.BookingAppointmentServer.repository.DepartmentRepository;


@Service
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
	DepartmentRepository departmentRepository;
	
	@Override
	public List<DepartmentDto> createOrUpdate(DepartmentRequest departmentRequest) {
		
		Department department = null;
		
		List<DepartmentDto> result = new ArrayList<DepartmentDto>();
		if(departmentRequest.getId() == null) {
			department = new Department();
		}else {
			department = departmentRepository.findDepartmentAndIsActive(departmentRequest.getId());
		}
		department.setDepartmentName(departmentRequest.getDepartmentName());
		department.setIsActive(true);
		departmentRepository.save(department);
		
		result = getDepartment();
		
		return result;
	}

	@Override
	public List<DepartmentDto> getDepartment() {
		
		List<Department> departments = departmentRepository.findListDepartmentAndIsActive();
		List<DepartmentDto> result = new ArrayList<DepartmentDto>();
		DepartmentDto dto = null;
		for(Department department : departments) {
			dto = new DepartmentDto();
			dto.setDepartmentName(department.getDepartmentName());
			dto.setId(department.getId());
			dto.setIsActive(department.getIsActive());
			result.add(dto);
		}
		
		return result;
	}

	@Override
	public DepartmentDto getDepartmentById(Integer id) {
		
		DepartmentDto dto = null;		
		Department department = departmentRepository.findById(id).orElse(null);
		dto = new DepartmentDto();
		dto.setDepartmentName(department.getDepartmentName());
		dto.setId(id);
		dto.setIsActive(department.getIsActive());
		
		return dto;
	}

	@Override
	public DepartmentDto getDepartmentByName(String name) {
		DepartmentDto dto = null;		
		Department department = departmentRepository.findDepartmentByName(name);
		
		dto = new DepartmentDto();
		dto.setDepartmentName(department.getDepartmentName());
		dto.setId(department.getId());
		dto.setIsActive(department.getIsActive());
		
		return dto;
		
	}

	@Override
	public ApiResponse checkDuplicateName(String name) {
		ApiResponse apiResponse = new ApiResponse();
		Department department = departmentRepository.findDepartmentByName(name);
		if(department == null) {
			apiResponse.setMessage("The data existed in system");
			apiResponse.setSuccess(false);
		}
		else {
			apiResponse.setMessage("The name accepted");
			apiResponse.setSuccess(true);
		}
		return apiResponse;
	}
	
	
}

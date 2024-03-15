package Thinh.BookingAppointmentServer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Thinh.BookingAppointmentServer.Service.DepartmentService;
import Thinh.BookingAppointmentServer.common.Constants;
import Thinh.BookingAppointmentServer.domain.dto.DepartmentDto;
import Thinh.BookingAppointmentServer.domain.payload.request.DepartmentRequest;
import Thinh.BookingAppointmentServer.domain.payload.response.ApiResponse;

@RestController
@CrossOrigin
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	DepartmentService departmentService;
	
	@PostMapping("/createOrUpdate")
	private ResponseEntity<ApiResponse> saveDepartment(@RequestBody DepartmentRequest departmentRequest){
		final List<DepartmentDto> result = departmentService.createOrUpdate(departmentRequest);
		return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse(true,result,Constants.CREATE_SUCCESS_MSG));
	}
	@GetMapping("/{id}")
	private ResponseEntity<ApiResponse> getDepartmentById(@PathVariable Integer id){
		final DepartmentDto result = departmentService.getDepartmentById(id);
		return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse(true, result,"The information of Department"));
	}
	@GetMapping()
	private ResponseEntity<ApiResponse> getDepartmentByName(@RequestParam String name){
		final DepartmentDto result = departmentService.getDepartmentByName(name);
		return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse(true, result,"The information of Department"));
	}
	@PostMapping("/checkDuplicateName")
	private ResponseEntity<ApiResponse> checkDuplicateName(@RequestParam String name){
		final ApiResponse result = departmentService.checkDuplicateName(name);
		return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse(true, result,Constants.NOT_FOUND_MSG));
	}
}

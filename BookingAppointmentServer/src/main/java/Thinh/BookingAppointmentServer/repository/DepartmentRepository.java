package Thinh.BookingAppointmentServer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import Thinh.BookingAppointmentServer.domain.inventory.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer>{

	@Query("From Department d where d.isActive = true and d.id = :id")
	Department findDepartmentAndIsActive(@Param("id") Integer id);
	
	@Query("From Department d where d.departmentName = :name")
	Department findDepartmentByName(@Param("name") String name);
	
	@Query("From Department d where d.isActive = true")
	List<Department> findListDepartmentAndIsActive();
	
		
}

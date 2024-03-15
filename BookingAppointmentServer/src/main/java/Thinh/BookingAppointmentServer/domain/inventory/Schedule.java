package Thinh.BookingAppointmentServer.domain.inventory;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import Thinh.BookingAppointmentServer.framework.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "schedule")
public class Schedule extends BaseEntity{

	@Column(name = "Addressed")
	private String addressed;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Column(name="createAt")
	private Date createAtCheckUp;
	
	@Column(name = "hours")
	private String hoursCheckUp;
	
	@Column(name = "number_CheckUp")
	private Integer numberCheckUp;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "doctor_id")
	private Doctor doctor;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "staff_id")
	private Staff staff;
	
	@JsonIgnore
	@OneToMany(mappedBy = "id.schedule")
	private List<Book> books;
	

}

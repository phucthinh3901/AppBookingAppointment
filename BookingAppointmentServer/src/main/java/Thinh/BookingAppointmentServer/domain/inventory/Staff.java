package Thinh.BookingAppointmentServer.domain.inventory;

import java.util.Date;
import java.util.List;

import Thinh.BookingAppointmentServer.framework.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Table(name = "staff")
@Setter@Getter
@Entity
public class Staff extends BaseEntity{

	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "sex")
	private Boolean isSex;
	
	@Column(name = "birthOfDate")
	private Date birthOfDate;
	
	@Column(name = "Cmnd")
	private String Cmnd;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "Addressed")
	private String addressed;
	
	@Column(name = "image")
	private String image;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "account_id")
	private Account account;

	@OneToMany(mappedBy = "staff")
	private List<Schedule> schedules;
}

package Thinh.BookingAppointmentServer.domain.inventory;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import Thinh.BookingAppointmentServer.framework.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "package")
@Getter @Setter
public class Package extends BaseEntity{

	@Column(name = "Packege_name")
	private String PackegeName;
	
	@Column(name = "Packege_price")
	private Double PackegePrice;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Column(name="from_At")
	private Date fromAt;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Column(name="to_At")
	private Date toAt;
	
	@OneToMany(mappedBy = "pack")
	private List<Book> books;
}

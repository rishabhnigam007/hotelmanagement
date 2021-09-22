package hotelmanagement.entity;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
@Entity
@Table(name = "booking")
public class BookingEntity 
{
	public BookingEntity() {}	
	public BookingEntity(Date bookdate, int noOfrooms) {
		super();
		this.bookdate = bookdate;
		this.noOfrooms = noOfrooms;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long bookid;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date bookdate;
	@Column(nullable = false)
	private int noOfrooms;
	@Column(columnDefinition = "int default 0")
	private int hit;
	
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private UserEntity u;
	
}
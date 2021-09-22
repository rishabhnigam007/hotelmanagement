package hotelmanagement.entity;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "user")
public class UserEntity 
{
	public UserEntity() {}
	public UserEntity(String fname, String lname, String gender, String email, String password, String cpassword,
			List<BookingEntity> book) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.gender = gender;
		this.email = email;
		this.password = password;
		this.cpassword = cpassword;
		this.book = book;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long uid;
	@Column(nullable=false)
	private String fname;
	@Column(nullable=false)
	private String lname;
	@Column(nullable=false)
	private String gender;
	
	//@Unique(value = UserEntity.class, property = "email")
	//@Unique(service = UserEntity.class, fieldName = "email", message = "{email.unique.violation}")
	@Column(length = 30,nullable = false,columnDefinition = "")
	private String email;

	@Column(nullable = false,length = 30)
	private String password;
	@Column(nullable = false,length = 30)
	private String cpassword;
	
	@OneToMany(mappedBy = "u" ,fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private List<BookingEntity> book=new ArrayList<BookingEntity>();
}
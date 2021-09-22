package hotelmanagement.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class UserLoginRequest
{
	
	//private long uid;
	@NotEmpty(message = "first name cant be null")
	@NotEmpty(message = "first name cant be empty")
	private String fname;
	
	@NotEmpty(message = "last name cant be null")
	@NotEmpty(message = "last name cant be empty")
	private String lname;
	
	@NotEmpty(message = "password cant be empty")
	@NotBlank(message = "Password cant be null")
	private String password;	
}

package hotelmanagement.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class UserCreateRequest 
{
	
	@NotEmpty(message = "First Name Cant be Empty")
	@NotBlank(message = "First Name Cant be Null")
	private String fname;
	@NotEmpty(message = "Last Name Cant be Empty")
	@NotBlank(message = "Last Name Cant be Null")
	private String lname;
	@NotEmpty(message = "Gender Cant be Empty")
	@NotBlank(message = "Gender Cant be Null")
	private String gender;
	@NotEmpty(message = "Email Name Cant be Empty")
	@NotBlank(message = "Email Cant be Null")
	private String email;
	@NotEmpty(message = "Password Name Cant be Empty")
	@NotBlank(message = "Password Cant be Null")
	private String password;
	@NotEmpty(message = "Confirm Password Cant be Empty")
	@NotBlank(message = "Confirm Password Cant be Null")
	private String cpassword;
}
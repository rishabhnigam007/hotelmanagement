package hotelmanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PasswordNotMatchController 
{
	@ExceptionHandler(value =PasswordNotMatchException.class)
	public ResponseEntity<Object> exception(PasswordNotMatchException exception) 
	{
		return new ResponseEntity<>("Confirm Password Not Match with Password", HttpStatus.NOT_FOUND);
	}
}
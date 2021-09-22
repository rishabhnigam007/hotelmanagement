package hotelmanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserDetailMendatoryController
{
	@ExceptionHandler(value =UserDetailMendatoryException.class)
	public ResponseEntity<Object> exception(UserDetailMendatoryException exception) 
	{
		return new ResponseEntity<>("fill correct User Details", HttpStatus.NOT_FOUND);
	} 
}
package hotelmanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmailAlreadyExistController
{
	@ExceptionHandler(value =EmailAlreadyExistException.class)
	public ResponseEntity<Object> exception(EmailAlreadyExistException exception) 
	{
		return new ResponseEntity<>("Email already Exist please insert new email", HttpStatus.NOT_FOUND);
	}
}
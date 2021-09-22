package hotelmanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UpdateExceptionController 
{
	@ExceptionHandler(value = UpdateException.class)
	public ResponseEntity<Object> exception(UpdateException exception)
	{
		return new ResponseEntity<>("Can't Update More Than Twice",HttpStatus.NOT_FOUND);
	}
}
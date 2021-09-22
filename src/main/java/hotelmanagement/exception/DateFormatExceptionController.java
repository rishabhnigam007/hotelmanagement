package hotelmanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DateFormatExceptionController 
{
	@ExceptionHandler(value =DateFormatException.class)
	public ResponseEntity<Object> exception(DateFormatException exception) 
	{
		return new ResponseEntity<>("Only Future Date can be Reserved", HttpStatus.NOT_FOUND);
	}
}
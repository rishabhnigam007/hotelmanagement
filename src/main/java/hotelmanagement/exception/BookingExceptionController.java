package hotelmanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BookingExceptionController 
{
	@ExceptionHandler(value =BookingNotfoundException.class)
	public ResponseEntity<Object> exception(BookingNotfoundException exception) 
	{
		return new ResponseEntity<>("Booking not found", HttpStatus.NOT_FOUND);
	}
}
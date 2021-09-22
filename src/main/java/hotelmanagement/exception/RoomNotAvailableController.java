package hotelmanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RoomNotAvailableController
{
	@ExceptionHandler(value =RoomNotAvailableException.class)
	public ResponseEntity<Object> exception(RoomNotAvailableException exception) 
	{
		return new ResponseEntity<>("Room Not available for given date", HttpStatus.NOT_FOUND);
	}
}
package hotelmanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RoomBookingController
{
	@ExceptionHandler(value =RoomLimitExceedException.class)
	public ResponseEntity<Object> exception(RoomLimitExceedException exception) 
	{
		return new ResponseEntity<>("Room limit exceed", HttpStatus.NOT_FOUND);
	}
}
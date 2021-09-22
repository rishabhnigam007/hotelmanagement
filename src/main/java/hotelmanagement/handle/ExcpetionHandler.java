package hotelmanagement.handle;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExcpetionHandler extends ResponseEntityExceptionHandler
{
	@ExceptionHandler(value = Exception.class)
	public final ResponseEntity<Object> exception(Exception ex)
	{
//		ErrorMessage em=new ErrorMessage(ex.getMessage(),"require right details");
		return new ResponseEntity<>("please input valid entry",HttpStatus.BAD_REQUEST);
		/* "please input valid entry" */
	}
}
//@Setter
//@Getter
//@ToString
//class ErrorMessage
//{
//	private String message;
//	private String details;
//	ErrorMessage(){}
//	public ErrorMessage(String message, String details) {
//		super();
//		this.message = message;
//		this.details = details;
//	}	
//}
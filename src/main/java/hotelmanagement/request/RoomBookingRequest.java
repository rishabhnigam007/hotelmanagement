package hotelmanagement.request;


import java.util.Date;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoomBookingRequest 
{	
	private long userId;
	
	//@Temporal(TemporalType.TIMESTAMP)
	private Date bookDate;
	
	@NotNull
	private int noOfRooms;
	
	private long bookId;
	private int hit;
}
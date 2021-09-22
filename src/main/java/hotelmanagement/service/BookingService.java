package hotelmanagement.service;

import hotelmanagement.entity.BookingEntity;
import hotelmanagement.request.RoomBookingRequest;

public interface BookingService
{
	public BookingEntity bookings(RoomBookingRequest br);
//	public void updateBooking(Booking b);
	public void deleteBooking(long bookid);
	
	public int isDeleteBooking(long bookid);
	
	public BookingEntity updateBooking(RoomBookingRequest bo);
	
}

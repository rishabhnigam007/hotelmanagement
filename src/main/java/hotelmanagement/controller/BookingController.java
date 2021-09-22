package hotelmanagement.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import hotelmanagement.entity.BookingEntity;
import hotelmanagement.exception.BookingNotfoundException;
import hotelmanagement.request.RoomBookingRequest;
import hotelmanagement.service.BookingService;

@RestController
public class BookingController 
{
	@Autowired(required = true)
	private BookingService bcr;
	
		@RequestMapping(value = "/booking" ,method = RequestMethod.POST)
		public ResponseEntity<Object> bookings(@Valid @RequestBody RoomBookingRequest br)
		{
			BookingEntity b=bcr.bookings(br);
			return new ResponseEntity<>("Booking is created successfully with bookid = "+b.getBookid()+" for uid = "+br.getUserId(),HttpStatus.CREATED);
		}
		
		@RequestMapping(value = "/cancelbooking/{bookid}", method = RequestMethod.DELETE)
		public ResponseEntity<Object> deleteBooking(@PathVariable("bookid") long bookid)
		{
			int del =bcr.isDeleteBooking(bookid);
			if(del>0)
			{
				bcr.deleteBooking(bookid);
				return new ResponseEntity<>("Booking is deleted successfully bookid ="+bookid,HttpStatus.OK);
			}
			else
			{
				throw new BookingNotfoundException();
			}
		}
		
		@RequestMapping(value = "/updatebooking" ,method = RequestMethod.POST)
		public ResponseEntity<Object> updateBooking(@Valid @RequestBody RoomBookingRequest br)
		{
			BookingEntity b=bcr.updateBooking(br);
			return new ResponseEntity<>("Booking is updated successfully with bookid = "+b.getBookid()+" for uid = "+br.getUserId(),HttpStatus.CREATED);
		}
}
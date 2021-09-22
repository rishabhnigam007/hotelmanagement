package hotelmanagement.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hotelmanagement.entity.BookingEntity;
import hotelmanagement.exception.DateFormatException;
import hotelmanagement.exception.RoomLimitExceedException;
import hotelmanagement.exception.RoomNotAvailableException;
import hotelmanagement.exception.UpdateException;
import hotelmanagement.repository.BookingRepository;
import hotelmanagement.repository.UserRepository;
import hotelmanagement.request.RoomBookingRequest;
import hotelmanagement.service.BookingService;

@Service
public class BookingServiceImpl implements BookingService 
{
	@Autowired
	private BookingRepository br;
	@Autowired
	private UserRepository u;
	@Override
	public BookingEntity bookings(RoomBookingRequest bo) 
	{
		BookingEntity b = new BookingEntity();
		if(bo.getBookDate()!=null && bo.getBookDate().after(new Date()))
		{
			b.setBookdate(bo.getBookDate());
		}
		else
		{
			throw new DateFormatException();
		}
		if(bo.getNoOfRooms()!=0 && bo.getNoOfRooms()<4)
		{
			//b.setNoOfrooms(bo.getNoOfRooms());
			
			// main login here check particular date and total no of rooms if less than equal to 3 then ok otherwise throw exception
			Integer counter=br.isCount(bo.getBookDate()); 
			if(counter==null)
			{
				counter=0;
			}
			Integer check=3-counter;
			if(bo.getNoOfRooms()<=check)
			{
				b.setNoOfrooms(bo.getNoOfRooms());
			}
			else
			{
				throw new RoomNotAvailableException();
			}			
		}
		else
		{
			throw new RoomLimitExceedException();
		}
		b.setU(u.findById(bo.getUserId()).get());
		return br.save(b);
	}

	@Override
	public void deleteBooking(long bookid) 
	{
		br.del(bookid);
	}
	@Override
	public int isDeleteBooking(long bookid) 
	{
		return br.isDeleteBooking(bookid);
	}

	@Override
	public BookingEntity updateBooking(RoomBookingRequest bo)
	{	
		BookingEntity b=br.findById(bo.getBookId()).get();
		int hits=b.getHit();
		if(hits<2)
		{
			b.setHit(hits+1);
		}
		else
		{
			throw new UpdateException();
		}
		
//		b.setBookdate(bo.getBookDate());
//		b.setNoOfrooms(bo.getNoOfRooms());
//		b.setU(u.findById(bo.getUserId()).get());
		
		if(bo.getBookDate()!=null && bo.getBookDate().after(new Date()))
		{
			b.setBookdate(bo.getBookDate());
		}
		else
		{
			throw new DateFormatException();
		}
		if(bo.getNoOfRooms()!=0 && bo.getNoOfRooms()<4)
		{
			//b.setNoOfrooms(bo.getNoOfRooms());
			
			// main login here check particular date and total no of rooms if less than equal to 3 then ok otherwise throw exception
			Integer counter=br.isCount(bo.getBookDate()); 
			if(counter==null)
			{
				counter=0;
			}
			Integer check=3-(counter-bo.getNoOfRooms());
			//if(bo.getNoOfRooms()<=Math.abs(check-bo.getNoOfRooms()))
			if(bo.getNoOfRooms()<=check)
			{
				b.setNoOfrooms(bo.getNoOfRooms());
			}
			else
			{
				throw new RoomNotAvailableException();
			}			
		}
		else
		{
			throw new RoomLimitExceedException();
		}
		b.setU(u.findById(bo.getUserId()).get());
		return br.saveAndFlush(b);
	}

}
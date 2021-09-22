package hotelmanagement.service;

import hotelmanagement.entity.BookingEntity;
import hotelmanagement.entity.UserEntity;

public interface RoomBookService 
{

	int islogin(UserEntity u, BookingEntity b);

}

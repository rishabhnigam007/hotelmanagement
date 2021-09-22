package hotelmanagement.service;

import hotelmanagement.entity.UserEntity;
import hotelmanagement.request.UserCreateRequest;

public interface UserService
{
//	public UserEntity createUser(UserEntity reg);
//	public void deleteUser(long uid,String password);
	public int isUserExists(String fname,String lname,String password);
	public UserEntity register(UserCreateRequest reg);
	
}
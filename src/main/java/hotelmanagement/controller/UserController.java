package hotelmanagement.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import hotelmanagement.entity.UserEntity;
import hotelmanagement.exception.UserNotfoundException;
import hotelmanagement.request.UserCreateRequest;
import hotelmanagement.request.UserLoginRequest;
import hotelmanagement.service.UserService;

@RestController
public class UserController 
{
	@Autowired(required=true)
	private UserService rc;
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<Object> register(@Valid @RequestBody UserCreateRequest reg)
	{
		//reg=rc.createUser(reg);
		UserEntity ue=rc.register(reg);
		return new ResponseEntity<>("User is created successfully with uid = "+ue.getUid(),HttpStatus.CREATED);
	}
		
//	@RequestMapping(value = "/delete/{uid}/{password}", method = RequestMethod.DELETE)
//	public ResponseEntity<Object> deleteUser(@PathVariable("uid") long uid, @PathVariable("password") String password)
//	{
//		int isUserExist =rc.isUserDelete(uid,password);
//		if(isUserExist>0)
//		{
//			rc.deleteUser(uid,password);
//			return new ResponseEntity<>("user is deleted successfully uid ="+uid,HttpStatus.OK);
//		}
//		else
//		{
//			throw new UserNotfoundException();
//		}
//	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<Object> isUserExists(@Valid @RequestBody UserLoginRequest ulr)
	{
		int isUserExist =rc.isUserExists(ulr.getFname(),ulr.getLname(),ulr.getPassword());
		if(isUserExist>0)
		{
			return new ResponseEntity<>("user successfully login with fname "+ulr.getFname(),HttpStatus.OK);
		}
		else
		{
			throw new UserNotfoundException();
		}
	}
}

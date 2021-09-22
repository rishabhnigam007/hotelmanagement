package hotelmanagement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hotelmanagement.entity.UserEntity;
import hotelmanagement.exception.EmailAlreadyExistException;
import hotelmanagement.exception.PasswordNotMatchException;
import hotelmanagement.repository.UserRepository;
import hotelmanagement.request.UserCreateRequest;
import hotelmanagement.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository rr;

	@Override
	public UserEntity register(UserCreateRequest reg) 
	{
		UserEntity u = new UserEntity();
		u.setFname(reg.getFname());
		u.setLname(reg.getLname());
		u.setGender(reg.getGender());
		if ((rr.findByEmail(reg.getEmail())) < 1) {
			u.setEmail(reg.getEmail());
		} else {
			throw new EmailAlreadyExistException();
		}
		if (reg.getPassword().equals(reg.getCpassword())) {
			u.setPassword(reg.getPassword());
			u.setCpassword(reg.getCpassword());
		} else {
			throw new PasswordNotMatchException();
		}
		return rr.save(u);
	}

	@Override
	public int isUserExists(String fname, String lname, String password) {
		return rr.existsById(fname, lname, password);
	}

}

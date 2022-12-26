package com.axis.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axis.model.User;
import com.axis.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public User saveUser(User user) {
		
		return userRepo.save(user);
	}

	@Override
	public List<User> getAllUser() {
		
		return userRepo.findAll();
	}

	@Override
	public User getUserById(Integer id) {
		
		return userRepo.findById(id).get();
	}

	@Override
	public String deleteUser(Integer id) {
		
		User user=userRepo.findById(id).get();
		if(user!=null)
		{
			userRepo.delete(user);
			return "User Deleted Successfully";
		}
		return "Something wrong on server";
	}

	@Override
	public User editUser(User u, Integer id) {
		
		User oldUser=userRepo.findById(id).get();
		oldUser.setUserName(u.getUserName());
		oldUser.setRole(u.getRole());
		
		return userRepo.save(oldUser);
	}
	

}

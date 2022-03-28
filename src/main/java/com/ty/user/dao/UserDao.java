package com.ty.user.dao;

import com.ty.user.dto.User;

public class UserDao {
	public User validateUser(String email,String password) {
			//logic
		//EMF
		//EM
		
		User user = new User();
		user.setName("prakash");
		user.setEmail("prakash@234");
		
		if(email.equals("admin") && password.equals("admin")) {
			return user;
		}else {
			return null;
		}
	}
}

package com.example.demo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class Myuserdetailsservice implements UserDetailsService {

	@Autowired
	UserModelReposistory userModelReposistory;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println(" Load User " + username );
		Optional<UserModel> user = userModelReposistory.findUserModelByusername(username);
		user.orElseThrow(() -> new UsernameNotFoundException(" User Name not Found"));
		return user.map(MyUserDetail::new).get();
	}
}

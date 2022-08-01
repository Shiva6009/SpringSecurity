package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserDetailsService userDetailsService;

	@Autowired
	Jwtclass jwtclass;

	@GetMapping("/test")
	public String home() {
		System.out.println(" Inside Home Controller");
		return ("<h1> Hello World </h1>");
	}

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public AuthenticateResponse authenticate(@RequestBody AuthenticateRequest authenticaterequest)
			throws Exception {

		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticaterequest.getUsername(), authenticaterequest.getPassword()));
		} catch (BadCredentialsException e) {
			throw new Exception("Incorrect Username or Password " + e);
		}
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticaterequest.getUsername());
		final String jwt = jwtclass.generateToken(userDetails);
		return (new AuthenticateResponse(jwt));

	}
}

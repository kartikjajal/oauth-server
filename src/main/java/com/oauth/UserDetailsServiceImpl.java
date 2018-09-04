package com.oauth;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private AppUserRepository appUserRepository;
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		System.out.println("Get user for : "+username);
		AppUser appUser = appUserRepository.findByAppUserByUsername(username);
		
		List<GrantedAuthority> grantedAuthorities=new ArrayList<>();
		if(null!=appUser.getAppRoles()) {
			for(AppRole appRole: appUser.getAppRoles()) {
				grantedAuthorities.add(new SimpleGrantedAuthority(appRole.getRoleName()));
			}
		}	
		
		UserDetails userDetails = null;
		if(null!=appUser) {
			 userDetails = new User(username,appUser.getPassword(),grantedAuthorities);	
		}				
		return userDetails;
	}
}

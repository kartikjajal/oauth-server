package com.oauth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AppUserRepository extends JpaRepository<AppUser, Integer>{

	@Query("SELECT app_user_data FROM AppUser app_user_data WHERE app_user_data.userName=?1")
	AppUser findByAppUserByUsername(String userName);
	
}

package com.realestate.repositories;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.realestate.models.Client;


public interface ClientRepository extends JpaRepository<Client, Integer>{

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "INSERT INTO `client`VALUES (:id, :email, :password, :username, :name, :last_name, :birthdate, :gender, :phone, "
					+ ":blocked, :profile_pic, :key_confirm)", nativeQuery= true)
	public int client_subscribe(@Param("id")int id,
								 @Param("email") String email,
								 @Param("gender") String gender,
								 @Param("birthdate") Date birthdate, 
								 @Param("blocked") int blocked, 
								 @Param("name") String name, 
								 @Param("password") String password, 
								 @Param("last_name") String lastname, 
								 @Param("profile_pic") String profile_pic, 
								 @Param("phone") String phone, 
								 @Param("username") String username,
								 @Param("key_confirm") String key_confirm);

	
}

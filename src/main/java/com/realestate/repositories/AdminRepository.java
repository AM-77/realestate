package com.realestate.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.realestate.models.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer>{

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "INSERT INTO `admin`(`id`, `email`, `password`, `name`, `last_name`, `phone`, `profile_pic`) VALUES"
			+ " ( :id, :email, :password, :name, :last_name, :phone, :profile_pic)", nativeQuery= true)
	public int admin_subscribe(@Param("id")int id, @Param("email")String email, @Param("phone")String phone, 
							    @Param("name")String name, @Param("password")String password, 
								@Param("last_name")String last_name, @Param("profile_pic")String profile_pic);


}

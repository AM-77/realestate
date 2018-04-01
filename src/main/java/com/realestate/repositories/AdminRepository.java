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
	
	@Query(value="SELECT * FROM admin WHERE email= :email  LIMIT 1", nativeQuery=true)
	public Admin get_admin_by_email(@Param("email") String email);

	@Query(value="SELECT * FROM admin WHERE email= :email AND password= :password  LIMIT 1", nativeQuery=true)
    public Admin get_admin_by_email_and_password(@Param("email")String email, @Param("password")String password);

	@Query(value="SELECT * FROM admin WHERE id= :id  LIMIT 1", nativeQuery=true)
	public Admin get_admin_by_id(@Param("id") int user_id);

}

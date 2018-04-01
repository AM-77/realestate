package com.realestate.repositories;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.realestate.models.Agent;


public interface AgentRepository extends JpaRepository<Agent, Integer>{

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "INSERT INTO `agent`VALUES ( :id, :email, :password, :username, :name, :last_name, :birthdate, :gender, :blocked, :locale, "
					+ ":profile_pic, :cv, :phone, :key_confirm)", nativeQuery= true)
	public int agent_subscribe(@Param("id")int id, @Param("email")String email, @Param("gender")String gender, @Param("birthdate")Date birthdate, 
								@Param("blocked")int blocked, @Param("name")String name, @Param("password")String password, 
								@Param("last_name")String last_name, @Param("profile_pic")String profile_pic, @Param("phone")String phone, 
								@Param("username")String username, @Param("cv")String cv, @Param("locale")String locale,  @Param("key_confirm")String key_confirm);

}

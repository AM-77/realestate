package com.realestate.repositories;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.realestate.models.Operator;


public interface OperatorRepository extends JpaRepository<Operator, Integer>{

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "INSERT INTO `operator` VALUES ( :id, :email, :password, :username, :name, :last_name, :birthdate, :gender, :blocked, :locale, "
			+ ":profile_pic, :cv, :phone, :key_confirm)", nativeQuery= true)
	public int operator_subscribe(@Param("id")int id, @Param("email")String email, @Param("gender")String gender, @Param("birthdate")Date birthdate, 
								@Param("blocked")int blocked, @Param("name")String name, @Param("password")String password, 
								@Param("last_name")String last_name, @Param("profile_pic")String profile_pic, @Param("phone")String phone, 
								@Param("username")String username, @Param("cv")String cv, @Param("locale")String locale, @Param("key_confirm")String key_confirm);

	
	@Query(value="SELECT * FROM operator WHERE email= :email  LIMIT 1", nativeQuery=true)
	public Operator get_operator_by_email(@Param("email") String email);

	@Query(value="SELECT * FROM operator WHERE email= :email AND password= :password  LIMIT 1", nativeQuery=true)
	public Operator get_operator_by_email_and_password(@Param("email")String email, @Param("password")String password);


	@Query(value="SELECT * FROM operator WHERE id= :id  LIMIT 1", nativeQuery=true)
	public Operator get_operator_by_id(@Param("id")int user_id);

	@Query(value="SELECT COUNT(*) FROM operator ", nativeQuery=true)
	public int nbr_account();

	@Query(value="SELECT * FROM operator WHERE blocked = 2 ", nativeQuery=true)
	public List<Operator> get_operator_subscribe_demand();
	
}

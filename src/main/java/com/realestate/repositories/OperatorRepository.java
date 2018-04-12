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

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value="DELETE FROM `operator` WHERE `id` = :id ", nativeQuery=true)
	public int remove_an_op(@Param("id")int id);

	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value="UPDATE `operator` SET `blocked` = '0' WHERE `id` = :id ;", nativeQuery=true)
	public int confirm_an_op(@Param("id")int id);


	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value="UPDATE `operator` SET `blocked` = '1' WHERE `email` = :email ;", nativeQuery=true)
	public int block_an_op(@Param("email")String email);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value="UPDATE `operator` SET `blocked` = '0' WHERE `email` = :email ;", nativeQuery=true)
	public int deblock_an_op(@Param("email")String email);


	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value="DELETE FROM `operator` WHERE `email` = :email ", nativeQuery=true)
	public int remove_an_op(@Param("email")String email);


	@Query(value="SELECT * FROM operator WHERE confirm_key= :confirm_key  LIMIT 1", nativeQuery=true)
	public Operator get_operator_by_confirmation_key(@Param("confirm_key") String confirm_key);


	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value="UPDATE `operator` SET `email` = :email , `username` = :username, `name` = :name, `last_name` = :last_name, `phone` = :phone, `phone` = :birthdate WHERE id = :id  ", nativeQuery=true)
	public int update_operator_profile(@Param("id")int id, @Param("username")String username, @Param("name")String name, @Param("last_name")String last_name, @Param("email")String email, @Param("phone")String phone, @Param("birthdate")Date birthdate);
	
}

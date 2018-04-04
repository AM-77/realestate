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

	@Query(value="SELECT * FROM client WHERE email= :email  LIMIT 1", nativeQuery=true)
	public Client get_client_by_email(@Param("email") String email);

	@Query(value="SELECT * FROM client WHERE email= :email AND password= :password  LIMIT 1", nativeQuery=true)
	public Client get_client_by_email_and_password(@Param("email")String email,@Param("password")String password);


	@Query(value="SELECT * FROM client WHERE id=:id_client LIMIT 1", nativeQuery=true)
	public Client get_client_by_id(@Param("id_client")int id_client);

	@Query(value="SELECT * FROM client WHERE id = (SELECT id_client FROM appointement WHERE appointement.id = :id_appointement LIMIT 1)", nativeQuery=true)
	public Client get_client_by_appointement_id(@Param("id_appointement")int id_appointement);


	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "DELETE FROM `client` WHERE email = :email", nativeQuery=true)
	public int remove_client_by_email(@Param("email")String email);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "UPDATE `client` SET `blocked` = '1' WHERE email = :email", nativeQuery=true)
	public int block_client_by_email(@Param("email")String email);


	@Query(value="SELECT * FROM client WHERE email = :email AND username= 'added_by_operator' LIMIT 1 ", nativeQuery=true)
	public Client is_finished_subscribe(@Param("email")String email);


	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "UPDATE `client` SET password = :password , username = :username , name = :name , last_name = :last_name , birthdate = :birthdate , gender = :gender , phone = :phone , blocked = :blocked , profile_pic = :profile_pic  WHERE email = :email", nativeQuery= true)
	public int client_finish_subscribe(@Param("email") String email,@Param("gender") String gender,
								 @Param("birthdate") Date birthdate, @Param("blocked") int blocked, @Param("name") String name, 
								 @Param("password") String password, @Param("last_name") String lastname, 
								 @Param("profile_pic") String profile_pic, @Param("phone") String phone, 
								 @Param("username") String username);
	
	
	@Query(value="SELECT COUNT(*) FROM client ", nativeQuery=true)
	public int nbr_account();
	
	@Query(value="SELECT * FROM client WHERE confirm_key = :confirm_key LIMIT 1 ", nativeQuery=true)
	public Client get_client_by_confirmation_key(@Param("confirm_key") String confirm_key);

	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value="UPDATE `client` SET  `username` = :username, `name` = :name, `last_name` = :last_name, `phone` = :phone, `birthdate` = :birthdate WHERE id = :id  ", nativeQuery=true)
	public int update_client_profile(@Param("id")int id, @Param("username")String username, @Param("name")String name, @Param("last_name")String last_name, @Param("phone")String phone, @Param("birthdate")Date birthdate);

}

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

	@Query(value="SELECT * FROM agent WHERE email= :email AND blocked=0 LIMIT 1", nativeQuery=true)
	public Agent get_agent_by_email(@Param("email") String email);

	@Query(value="SELECT * FROM agent WHERE email= :email AND password= :password LIMIT 1", nativeQuery=true)
	public Agent get_agent_by_email_and_password(@Param("email")String email, @Param("password")String password);

	@Query(value="SELECT * FROM agent WHERE locale=:locale AND blocked=0 ", nativeQuery=true)
	public List<Agent> get_agents_by_locale(@Param("locale")int locale);

	
	@Query(value="SELECT * FROM agent WHERE id=:id LIMIT 1", nativeQuery=true)
	public Agent get_agent_by_id(@Param("id")int id_agent);

	@Query(value="SELECT * FROM agent WHERE id = (SELECT id_agent FROM appointement WHERE appointement.id = :id_appointement LIMIT 1)", nativeQuery=true)
	public Agent get_agent_by_appointement_id(@Param("id_appointement")int id_appointement);

	@Query(value="SELECT COUNT(*) FROM agent ", nativeQuery=true)
	public int nbr_account();

	@Query(value="SELECT * FROM agent WHERE blocked = '2'; ", nativeQuery=true)
	public List<Agent> get_agent_subscribe_demand();

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value="DELETE FROM `agent` WHERE `id` = :id ", nativeQuery=true)
	public int remove_an_agent(@Param("id")int id);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value="UPDATE `agent` SET `blocked` = '0' WHERE `id` = :id ;", nativeQuery=true)
	public int confirm_an_agent(@Param("id")int id);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value="UPDATE `agent` SET `blocked` = '1' WHERE `email` = :email ;", nativeQuery=true)
	public int block_an_agent(@Param("email")String email);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value="UPDATE `agent` SET `blocked` = '0' WHERE `email` = :email ;", nativeQuery=true)
	public int deblock_an_agent(@Param("email")String email);

}

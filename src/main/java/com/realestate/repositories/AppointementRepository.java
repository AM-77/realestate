package com.realestate.repositories;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.realestate.models.Appointement;

public interface AppointementRepository extends JpaRepository<Appointement, Integer> {
	
	@Query(value="SELECT * FROM appointement WHERE date=:date AND first_half='1' AND id_lodgement=:id_lodgement AND canceled='0'  LIMIT 1", nativeQuery=true)
	public Appointement is_avail_date_first_half(@Param("date") Date date, @Param("id_lodgement") int id_lodgement);
	
	@Query(value="SELECT * FROM appointement WHERE date=:date AND second_half='1' AND id_lodgement=:id_lodgement AND canceled='0'  LIMIT 1", nativeQuery=true)
	public Appointement is_avail_date_second_half(@Param("date") Date date, @Param("id_lodgement") int id_lodgement);

	@Query(value="SELECT * FROM appointement WHERE date=:date AND id_agent=:id_agent AND first_half='1' AND canceled='0' LIMIT 1", nativeQuery=true)
	public Appointement is_avail_agent_first_half(@Param("date") Date date, @Param("id_agent") int id_agent);
	
	@Query(value="SELECT * FROM appointement WHERE date=:date AND id_agent=:id_agent AND second_half='1' AND canceled='0'  LIMIT 1", nativeQuery=true)
	public Appointement is_avail_agent_second_half(@Param("date") Date date, @Param("id_agent") int id_gent);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value="INSERT INTO `appointement` VALUES (NULL, :date, :first_half, :second_half, :id_agent, :id_lodgement, :id_client, '0', '0', '', '0' , '')", nativeQuery=true)
	public int add(@Param("date") Date date,
							 @Param("first_half") int first_half, 
							 @Param("second_half") int second_half, 
							 @Param("id_lodgement") int id_lodgement,
							 @Param("id_agent") int id_agent,
							 @Param("id_client") int id_client
							 );

	@Query(value="SELECT * FROM appointement WHERE id_lodgement=:id_lodgement AND canceled='0' LIMIT 15", nativeQuery=true)
	public List<Appointement> get_Appointements_by_id_lodgement(@Param("id_lodgement") int id_lodgement);

	@Query(value="SELECT * FROM appointement WHERE id_client=:id_client ORDER BY date DESC  LIMIT 100", nativeQuery=true)
	public List<Appointement> get_Appointements_by_id_client(@Param("id_client")int id);

	@Query(value="SELECT * FROM appointement WHERE (date=:date AND id_lodgement=:id_lodg AND first_half='1'  AND canceled='0' ) LIMIT 1", nativeQuery=true)
	public Appointement is_avail_lodgement_by_id_date_first_half(@Param("date")Date date, @Param("id_lodg")int id_lodg);
	
	@Query(value="SELECT * FROM appointement WHERE (date=:date AND id_lodgement=:id_lodg AND second_half='1' AND canceled='0') LIMIT 1", nativeQuery=true)
	public Appointement is_avail_lodgement_by_id_date_second_half(@Param("date")Date date, @Param("id_lodg")int id_lodg);

	@Query(value="SELECT * FROM appointement WHERE id_client= :id AND id= :id_appoi AND canceled='0' ", nativeQuery=true)
	public Appointement existe_appoi_by_id_client(@Param("id")int id, @Param("id_appoi")int id_appoi);

	@Query(value="SELECT * FROM appointement WHERE id=:id_appointement LIMIT 1", nativeQuery=true)
	public Appointement get_appointements_by_id(@Param("id_appointement")int id_appointement);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value="UPDATE appointement SET client_confirm ='1' WHERE id = :id_appointement", nativeQuery=true)
	public int client_confirm_appointement(@Param("id_appointement")int id_appointement);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value="UPDATE appointement SET canceled ='1', canceler = 'client' WHERE id = :id_appointement", nativeQuery=true)
	public int client_cancel_appointement(@Param("id_appointement")int id_appointement);

	@Query(value="SELECT canceled FROM appointement WHERE id=:id_appointement LIMIT 1", nativeQuery=true)
	public int get_canceled_value( @Param("id_appointement")int id_appointement);

	@Query(value="SELECT * FROM appointement WHERE id_agent=:id_agent ORDER BY date DESC  LIMIT 100", nativeQuery=true)
	public List<Appointement> get_Appointements_by_id_agent(@Param("id_agent")int id_agent);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value="UPDATE appointement SET canceled ='1' , canceler = 'agent' WHERE id = :id_appointement", nativeQuery=true)
	public int agent_cancel_appointement(@Param("id_appointement")int id_appointement);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value="UPDATE appointement SET agent_confirm ='1' WHERE id = :id_appointement", nativeQuery=true)
	public int agent_confirm_appointement(@Param("id_appointement")int id_appointement);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value="UPDATE `appointement` SET `review` = :review WHERE id = :id_appointement", nativeQuery=true)
	public int save_review(@Param("id_appointement")int id_appointement, @Param("review")String review);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value="UPDATE `appointement` SET `review` = :review WHERE id = :id_appointement", nativeQuery=true)
	public int change_review(@Param("id_appointement")int id_appointement, @Param("review")String review);

	@Query(value="SELECT * FROM appointement WHERE id_agent= :id AND id= :id_appoi AND canceled='0' ", nativeQuery=true)
	public Appointement existe_appoi_by_id_agent(@Param("id")int id, @Param("id_appoi")int id_appoi);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value="UPDATE appointement SET canceled ='1', canceler = 'sold' WHERE id = :id_appointement", nativeQuery=true)
	public void sold_cancel_appointement(@Param("id_appointement")int id);
	
	
}

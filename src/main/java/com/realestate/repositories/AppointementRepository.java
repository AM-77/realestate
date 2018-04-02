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
	
}

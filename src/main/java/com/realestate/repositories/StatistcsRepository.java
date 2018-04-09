package com.realestate.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.realestate.models.Statistcs;

public interface StatistcsRepository extends JpaRepository<Statistcs, Integer>{

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "INSERT INTO `statistcs` VALUES (NULL, :id_visitor , :type_visitor , CURRENT_TIMESTAMP);", nativeQuery= true)
	public int add_statistc(@Param("id_visitor")int id_reporter, @Param("type_visitor")String type_visitor);
	
	@Query(value = "SELECT COUNT(*) FROM statistcs", nativeQuery= true)
	public int get_nbr_all_website_visites();
	
	@Query(value = "SELECT COUNT(*) FROM statistcs WHERE type_visitor = :type_visitor ", nativeQuery= true)
	public int nbr_visite_by_type(@Param("type_visitor")String type_visitor);

	@Query(value = "SELECT COUNT(*) FROM statistcs WHERE ( type_visitor = :type_visitor AND ( date BETWEEN :start_month AND :end_month ))", nativeQuery= true)
	public int visites_website_by_mounths(@Param("type_visitor") String type_visitor,@Param("start_month") String start_month, @Param("end_month") String end_month);

}

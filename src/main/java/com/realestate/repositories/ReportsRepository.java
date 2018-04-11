package com.realestate.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.realestate.models.Reports;

public interface ReportsRepository extends JpaRepository<Reports, Integer>{

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "INSERT INTO reports VALUES (NULL, :id_appoi, :reporter, :report, CURRENT_TIMESTAMP , 0);", nativeQuery= true)
	public int add_report(@Param("reporter")String reporter, @Param("id_appoi")int id_appoi, @Param("report")String report);

	@Query(value="SELECT * FROM reports WHERE id_appointement in (SELECT id FROM appointement WHERE id_lodgement in (SELECT id FROM lodgement WHERE locale = :locale))", nativeQuery=true)
	public List<Reports> get_reports_by_locale(@Param("locale")int locale);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "UPDATE `reports` SET `v_operator` = '1' WHERE `v_operator` != '1'", nativeQuery= true)
	public void set_viewed_reports(int id_operator);

	@Query(value="SELECT COUNT(*) FROM reports ", nativeQuery=true)
	public int nbr_appointement_reported();

	@Query(value="SELECT COUNT(*) FROM reports WHERE repoter = :user ", nativeQuery=true)
	public int nbr_appointement_reported(@Param("user") String user);

}

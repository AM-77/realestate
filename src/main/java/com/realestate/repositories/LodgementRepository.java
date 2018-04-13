package com.realestate.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.realestate.models.Lodgement;


public interface LodgementRepository extends JpaRepository<Lodgement, Integer>{

	@Query(value="SELECT * FROM lodgement WHERE surface BETWEEN :min_surface AND :max_surface "
												+ "AND address= :address "
												+ "AND type= :type "
												+ "AND price BETWEEN :min_price AND :max_price "
												+ "AND floor BETWEEN :min_floor AND :max_floor "
												+ "AND sold = 0 ", nativeQuery=true)
	public List<Lodgement> get_lodgements_by_address_price_surface_type_and_floor(	@Param("address")String address, 
																				@Param("min_price")double min_price,
																				@Param("max_price")double max_price, 
																				@Param("min_surface")double min_surface, 
																				@Param("max_surface")double max_surface,
																				@Param("min_floor")int min_floor,
																				@Param("max_floor")int max_floor,
																				@Param("type")String type);

	@Query(value="SELECT * FROM lodgement WHERE surface BETWEEN :min_surface AND :max_surface "
												+ "AND address= :address "
												+ "AND price BETWEEN :min_price AND :max_price "
												+ "AND floor BETWEEN :min_floor AND :max_floor "
												+ "AND sold = 0 ", nativeQuery=true)
	public List<Lodgement> get_lodgements_by_address_price_surface_and_floor(@Param("address")String address, 
																		@Param("min_price")double min_price,
																		@Param("max_price")double max_price, 
																		@Param("min_surface")double min_surface, 
																		@Param("max_surface")double max_surface,
																		@Param("min_floor")int min_floor,
																		@Param("max_floor")int max_floor);

	
}

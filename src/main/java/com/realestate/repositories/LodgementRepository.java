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

	@Query(value="SELECT * FROM lodgement WHERE surface BETWEEN :min_surface AND :max_surface "
												+ "AND type= :type "
												+ "AND price BETWEEN :min_price AND :max_price "
												+ "AND floor BETWEEN :min_floor AND :max_floor "
												+ "AND sold = 0 ", nativeQuery=true)
	public List<Lodgement> get_lodgements_by_price_surface_type_and_floor(	@Param("min_price")double min_price, 
																		@Param("max_price")double max_price,
																		@Param("min_surface")double min_surface, 
																		@Param("max_surface")double max_surface, 
																		@Param("min_floor")int min_floor,
																		@Param("max_floor")int max_floor,
																		@Param("type")String type);

	@Query(value="SELECT * FROM lodgement WHERE surface BETWEEN :min_surface AND :max_surface "
												+ "AND price BETWEEN :min_price AND :max_price "
												+ "AND floor BETWEEN :min_floor AND :max_floor "
												+ "AND sold = 0 ", nativeQuery=true)
	public List<Lodgement> get_lodgements_by_price_surface_and_floor(@Param("min_price")double min_price, 
																@Param("max_price")double max_price, 
																@Param("min_surface")double min_surface,
																@Param("max_surface")double max_surface,
																@Param("min_floor")int min_floor,
																@Param("max_floor")int max_floor);

	@Query(value="SELECT * FROM lodgement WHERE id = :id_lodgement LIMIT 1", nativeQuery=true)
	public Lodgement get_lodgements_by_id(@Param("id_lodgement")int lodgement_id);

	@Query(value="SELECT * FROM lodgement WHERE id = (SELECT id_lodgement FROM appointement WHERE appointement.id = :id_appointement LIMIT 1)", nativeQuery=true)
	public Lodgement get_lodgement_by_appointement_id(@Param("id_appointement")int id_appointement);
	
	@Query(value="SELECT * FROM lodgement WHERE id = (SELECT id_lodgement FROM appointement WHERE appointement.id = :id_appointement LIMIT 1)", nativeQuery=true)
	public Lodgement get_lodgement_by_appointement_all_id(@Param("id_appointement")int id_appointement);
	
	
	

	@Query(value="SELECT * FROM lodgement WHERE surface BETWEEN :min_surface AND :max_surface "
												+ "AND address= :address "
												+ "AND type= :type "
												+ "AND floor= :floor "
												+ "AND price BETWEEN :min_price "
												+ "AND :max_price "
												+ "AND sold = 0 ", nativeQuery=true)
	public List<Lodgement> get_lodgements_by_address_price_surface_and_type_and_floor(	@Param("address")String address, 
																				@Param("min_price")double min_price,
																				@Param("max_price")double max_price, 
																				@Param("min_surface")double min_surface, 
																				@Param("max_surface")double max_surface, 
																				@Param("type")String type,
																				@Param("floor")int floor);

	@Query(value="SELECT * FROM lodgement WHERE surface BETWEEN :min_surface AND :max_surface "
												+ "AND address= :address "
												+ "AND floor= :floor "
												+ "AND price BETWEEN :min_price "
												+ "AND :max_price "
												+ "AND sold = 0 ", nativeQuery=true)
	public List<Lodgement> get_lodgements_by_address_price_and_surface_and_floor(@Param("address")String address, 
																		@Param("min_price")double min_price,
																		@Param("max_price")double max_price, 
																		@Param("min_surface")double min_surface, 
																		@Param("max_surface")double max_surface,
																		@Param("floor")int floor);

	@Query(value="SELECT * FROM lodgement WHERE surface BETWEEN :min_surface AND :max_surface "
																		 + " AND type= :type "
																		 + " AND floor= :floor "
																		 + " AND price BETWEEN :min_price "
																		 + " AND :max_price "
																		 + "AND sold = 0 ", nativeQuery=true)
	public List<Lodgement> get_lodgements_by_price_surface_and_type_and_floor(	@Param("min_price")double min_price, 
																		@Param("max_price")double max_price,
																		@Param("min_surface")double min_surface, 
																		@Param("max_surface")double max_surface, 
																		@Param("type")String type,
																		@Param("floor")int floor);

	@Query(value="SELECT * FROM lodgement WHERE surface BETWEEN :min_surface AND :max_surface "
																		 + " AND floor= :floor "
																	     + " AND price BETWEEN :min_price "
																	     + " AND :max_price "
																	     + "AND sold = 0 ", nativeQuery=true)
	public List<Lodgement> get_lodgements_by_price_and_surface_and_floor(@Param("min_price")double min_price, 
																@Param("max_price")double max_price, 
																@Param("min_surface")double min_surface,
																@Param("max_surface")double max_surface,
																@Param("floor")int floor);
	
	
	
	@Query(value = "SELECT * FROM lodgement WHERE ( address = :address ) AND ( type = :type ) AND  ( surface BETWEEN :min_surface AND :max_surface ) AND ( price BETWEEN :min_price AND :max_price ) AND ( floor BETWEEN :min_floor AND :max_floor ) AND sold = 0  LIMIT 1", nativeQuery= true)
	public Lodgement search_wish(@Param("address") String address, 
								  @Param("type") String type, 
								  @Param("max_surface") double max_surface, 
								  @Param("min_surface") double min_surface, 
								  @Param("max_price") double max_price,
								  @Param("min_price") double min_price, 
								  @Param("max_floor") int max_floor, 
								  @Param("min_floor") int min_floor);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "INSERT INTO `lodgement`  VALUES (NULL, :locale, :address , :surface, :type, :floor, :price, :pics, '0')", nativeQuery= true)
	public int add_lodgement(@Param("locale")int locale, @Param("address")String address, @Param("type")String type, @Param("price")double price, @Param("surface")double surface, @Param("floor")int floor, @Param("pics")String pics);

	@Query(value="SELECT max(id) FROM lodgement", nativeQuery=true)
	public int getLastId();

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "UPDATE `lodgement` SET  sold = 1  WHERE id = :id ", nativeQuery= true)
	public int remove_lodgement(@Param("id")int id);
	
}
